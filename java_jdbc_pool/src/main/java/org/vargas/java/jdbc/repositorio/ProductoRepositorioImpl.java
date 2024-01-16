package org.vargas.java.jdbc.repositorio;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.vargas.java.jdbc.modelo.Categoria;
import org.vargas.java.jdbc.modelo.Producto;
import org.vargas.java.jdbc.util.ConexionBaseDatos;

public class ProductoRepositorioImpl implements Repositorio<Producto> {

  private Connection getConnection() throws SQLException {
    return ConexionBaseDatos.getConnection();
  }

  @Override
  public List<Producto> listar() {
    List<Producto> productos = new ArrayList<>();

    try (
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p "+
        "INNER JOIN categorias as c ON (p.id_categoria = c.id)");) {
      while (rs.next()) {
        Producto p = crearProducto(rs);
        productos.add(p);
      }
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    }

    return productos;
  }

  @Override
  public Producto porId(Long id) {
    Producto producto = null;
    try (
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("SELECT p.*, c.nombre as categoria FROM productos as p " + 
            "INNER JOIN categorias as c ON (p.id_categoria = c.id) WHERE p.id = ?");) {
      stmt.setLong(1, id);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          producto = crearProducto(rs);
        }
      }
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    }
    return producto;
  }



  @Override
  public void guardar(Producto producto) {
    String sql;
    if(!Objects.isNull(producto.getId()) && producto.getId()> 0){
      sql = "UPDATE productos SET nombre=?, precio=? WHERE id=?";
    }else{
      sql = "INSERT INTO productos(nombre, precio, fecha, id_categoria) VALUES(?,?,?,?)";
    }

    try (
      Connection conn = getConnection();
      PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, producto.getNombre());
      stmt.setLong(2, producto.getPrecio());
      
      if (!Objects.isNull(producto.getId()) && producto.getId() > 0) {
        stmt.setLong(3, producto.getId().longValue());
    } else {
        stmt.setDate(3, new Date(producto.getFechaRegistro().getTime()));
    }

    stmt.setLong(4, producto.getIdCategoria().getId());

      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    }
  }

  @Override
  public void eliminar(Long id) {
    try (
        Connection conn = getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM productos WHERE id = ?")) {
      stmt.setLong(1, id);
      stmt.executeUpdate();
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    }
  }

    private Producto crearProducto(ResultSet rs) throws SQLException {
    Producto p = new Producto();
    p.setId(rs.getLong("id"));
    p.setNombre(rs.getString("nombre"));
    p.setPrecio(rs.getInt("precio"));
    p.setFechaRegistro(rs.getDate("fecha"));
    Categoria categoria = new Categoria();
    categoria.setId(rs.getLong("id_categoria"));
    categoria.setNombre(rs.getString("categoria"));
    p.setIdCategoria(categoria);
    return p;
  }

}
