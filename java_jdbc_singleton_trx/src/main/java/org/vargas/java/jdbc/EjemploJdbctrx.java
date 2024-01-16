package org.vargas.java.jdbc;

import java.sql.*;
import java.util.Date;

import org.vargas.java.jdbc.modelo.Categoria;
import org.vargas.java.jdbc.modelo.Producto;
import org.vargas.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.vargas.java.jdbc.repositorio.Repositorio;
import org.vargas.java.jdbc.util.ConexionBaseDatos;

public class EjemploJdbctrx {
  public static void main(String[] args) throws SQLException {

    try(
     Connection conn = ConexionBaseDatos.getInstance();
    ) {
      if(conn.getAutoCommit()){
        conn.setAutoCommit(false);
      }
     try {
      Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
 
       
       System.out.println("============== buscar por id ============== ");
       System.out.println(repositorio.porId(2L));
       System.out.println("==============   insertar nuevo producto ============== ");
       Producto producto = new Producto();
       producto.setNombre("Teclado IBM mecánico");
       producto.setPrecio(1550);
       producto.setFechaRegistro(new Date());
       producto.setSku("abcd12347");
       Categoria categoria = new Categoria();
       categoria.setId(3L);
       producto.setIdCategoria(categoria);
       repositorio.guardar(producto);

       System.out.println("==============   Editar ============== ");
       producto = new Producto();
       producto.setId(6L);
       producto.setNombre("Teclado Corsair k95 mecánico");
       producto.setPrecio(1000);
       producto.setFechaRegistro(new Date());
       producto.setSku("abcd12348");
       categoria = new Categoria();
       categoria.setId(3L);
       producto.setIdCategoria(categoria);
       repositorio.guardar(producto);
      
      // System.out.println("============== Eliminar producto ============== ");
      //  repositorio.eliminar(4L);
       System.out.println("Producto guardado con exito");
        System.out.println("============== listar ============== ");
       repositorio.listar().forEach(System.out::println);

       conn.commit();
      } catch (Exception e) {
        conn.rollback();
        e.printStackTrace();
      }
    }
  }
}
