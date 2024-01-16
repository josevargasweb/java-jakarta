package org.vargas.webapp.ejb.service;

import java.util.List;

import org.vargas.webapp.ejb.models.Producto;

import jakarta.ejb.Remote;

@Remote
public interface ServiceEjbRemote {
  String saludar(String nombre);
  List<Producto> listar();
  Producto crear(Producto producto);
}
