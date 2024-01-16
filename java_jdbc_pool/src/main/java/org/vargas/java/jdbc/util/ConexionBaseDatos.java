package org.vargas.java.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;

public class ConexionBaseDatos {
  private static String url = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
  private static String user = "root";
  private static String password = "testprueba";
  //conexion a la base de datos por datasource
  private static BasicDataSource pool;


  public static BasicDataSource getInstance() throws SQLException{
    if(pool == null){
        pool = new BasicDataSource();
        pool.setUrl(url);
        pool.setUsername(user);
        pool.setPassword(password);
        pool.setInitialSize(3);
        pool.setMinIdle(3);
        pool.setMaxIdle(8);
        pool.setMaxTotal(8);
    }
    return pool;
  }

  //obtenemos la conexion por pool devolviendo una conexion hasta llegar al maximo de conexiones permitidas
  public static Connection getConnection() throws SQLException {
    return getInstance().getConnection();
  }

}
