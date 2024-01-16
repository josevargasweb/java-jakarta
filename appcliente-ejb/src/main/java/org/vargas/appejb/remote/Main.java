package org.vargas.appejb.remote;

import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.vargas.webapp.ejb.models.Producto;
import org.vargas.webapp.ejb.service.ServiceEjbRemote;

public class Main {
  public static void main(String[] args) {

    ServiceEjbRemote service = null;
    ServiceEjbRemote service2 = null;
    // final Properties env = new Properties();
    // env.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
    // env.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
    // env.put("jboss.naming.client.ejb.context", true);
    try {
      InitialContext ctx = new InitialContext();
      service = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote/ServiceEjb!org.vargas.webapp.ejb.service.ServiceEjbRemote?stateful");
      service2 = (ServiceEjbRemote) ctx.lookup("ejb:/appejb-remote/ServiceEjb!org.vargas.webapp.ejb.service.ServiceEjbRemote?stateful");

      String saludo = service.saludar("PEpito");
      String saludo2 = service2.saludar("Emmas");
      System.out.println(saludo);
      System.out.println(saludo2);

      Producto p = service.crear(new Producto("sandia"));
      System.out.println("nuevo producto: "+ p);

      service.listar().forEach(System.out::println);
    } catch (NamingException e) {
      e.printStackTrace();
    }
  }
}
