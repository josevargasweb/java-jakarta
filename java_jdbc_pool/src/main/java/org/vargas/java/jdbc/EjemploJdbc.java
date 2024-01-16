package org.vargas.java.jdbc;

import java.util.Date;

import org.vargas.java.jdbc.modelo.Categoria;
import org.vargas.java.jdbc.modelo.Producto;
import org.vargas.java.jdbc.repositorio.ProductoRepositorioImpl;
import org.vargas.java.jdbc.repositorio.Repositorio;

public class EjemploJdbc {
  public static void main(String[] args) {
     Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
     System.out.println("============== listar ============== ");
     repositorio.listar().forEach(System.out::println);
     
     System.out.println("============== buscar por id ============== ");
     System.out.println(repositorio.porId(2L));
    //  System.out.println("==============   insertar nuevo producto ============== ");
    //  Producto producto = new Producto();
    //  producto.setId(5L);
    //  producto.setNombre("Teclado Corsair mecánico");
    //  producto.setPrecio(350);
    //  producto.setFechaRegistro(new Date());
    //  Categoria categoria = new Categoria();
    //  categoria.setId(3L);
    //  producto.setIdCategoria(categoria);
    //  repositorio.guardar(producto);
    
    // System.out.println("============== Eliminar producto ============== ");
    //  repositorio.eliminar(4L);
     System.out.println("Producto guardado con exito");
      System.out.println("============== listar ============== ");
     repositorio.listar().forEach(System.out::println);
  }
}
