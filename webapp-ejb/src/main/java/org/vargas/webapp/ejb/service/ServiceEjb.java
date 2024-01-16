package org.vargas.webapp.ejb.service;

import java.util.ArrayList;
import java.util.List;

import org.vargas.webapp.ejb.models.Producto;

import jakarta.ejb.Stateful;
// import jakarta.ejb.Stateless;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
@Stateful
public class ServiceEjb implements ServiceEjbLocal{

  private int contador = 0;
  public String saludar(String nombre){
    System.out.println("imprimiento dentro del ejb con instancia: "+ this);
    contador++;

    System.out.println("valor del contador en metodo saludar "+ contador);
    return "Hola que tal "+ nombre;
  }
  @Override
  public List<Producto> listar() {
    List<Producto> productos = new ArrayList<>();
    productos.add(new Producto("peras"));
    productos.add(new Producto("manzanas"));
    productos.add(new Producto("naranjas"));
    return productos;
  }
  @Override
  public Producto crear(Producto producto) {
    System.out.println("guardando nuevo producto"); 
    Producto p = new Producto();
    p.setNombre(producto.getNombre());
    return p;
  }

}
