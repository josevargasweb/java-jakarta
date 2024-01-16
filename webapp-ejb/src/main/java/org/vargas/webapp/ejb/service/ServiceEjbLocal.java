package org.vargas.webapp.ejb.service;

import java.util.List;

import org.vargas.webapp.ejb.models.Producto;

import jakarta.ejb.Local;

@Local
public interface ServiceEjbLocal {
  String saludar(String nombre);
  List<Producto> listar();
  Producto crear(Producto producto);
}
