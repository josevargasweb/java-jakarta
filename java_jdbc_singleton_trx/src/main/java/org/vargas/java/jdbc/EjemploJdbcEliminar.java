package org.vargas.java.jdbc;

import java.sql.*;
import java.util.Date;

import org.vargas.java.jdbc.modelo.Categoria;
import org.vargas.java.jdbc.modelo.Producto;
import org.vargas.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.vargas.java.jdbc.repositorio.Repositorio;
import org.vargas.java.jdbc.util.ConexionBaseDatos;

public class EjemploJdbcEliminar {
  public static void main(String[] args) {

    try(
     Connection conn = ConexionBaseDatos.getInstance();
    ) {

     Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
     System.out.println("============== listar ============== ");
     repositorio.listar().forEach(System.out::println);
     
     System.out.println("============== buscar por id ============== ");
     System.out.println(repositorio.porId(2L));
    System.out.println("============== Eliminar producto ============== ");
     repositorio.eliminar(4L);
     System.out.println("Producto guardado con exito");
      System.out.println("============== listar ============== ");
     repositorio.listar().forEach(System.out::println);
    } catch (SQLException e) {
      e.printStackTrace(System.out);
    }
  }
}
