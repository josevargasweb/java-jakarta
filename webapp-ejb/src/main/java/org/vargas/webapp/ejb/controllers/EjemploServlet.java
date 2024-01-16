package org.vargas.webapp.ejb.controllers;

import java.io.IOException;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.vargas.webapp.ejb.models.Producto;
// import org.vargas.webapp.ejb.service.ServiceEjb;
import org.vargas.webapp.ejb.service.ServiceEjbLocal;

// import jakarta.ejb.EJB;
// import jakarta.inject.Inject;
// import jakarta.mail.Service;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class EjemploServlet extends HttpServlet{

  // @Inject
  // private ServiceEjbLocal service;
  
  // @Inject
  // private ServiceEjbLocal service2;

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ServiceEjbLocal service = null;
    ServiceEjbLocal service2 = null;

    try {
      InitialContext ctx = new InitialContext();
      service = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.vargas.webapp.ejb.service.ServiceEjbLocal");
      service2 = (ServiceEjbLocal) ctx.lookup("java:global/webapp-ejb/ServiceEjb!org.vargas.webapp.ejb.service.ServiceEjbLocal");
    } catch (NamingException e) {
      e.printStackTrace();
    }

    Producto p = service.crear(new Producto("uvas"));
    System.out.println("nuevo producto creado: "+p);
     List<Producto> productos = service.listar();

    System.out.println("service si es igual a service2: "+service.equals(service2));
    req.setAttribute("listar", productos);
    req.setAttribute("saludo", service.saludar("Jose"));
    req.setAttribute("saludo2", service2.saludar("Vanne"));
    getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
  }
  
}
