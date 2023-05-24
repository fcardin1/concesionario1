package ar.org.centro8.curso.java.concesionario.connectors;

import java.sql.Connection;
import java.sql.DriverManager;

public final class Connector {
    private static String driver="org.mariadb.jdbc.Driver";
    private static String url="jdbc:mariadb://localhost:3306/concesionario";
    private static String user="root";
    private static String pass="";
    // private static String url="jdbc:mariadb://db4free.net:3306/basegeneral";
    // private static String user="basegeneral";
    // private static String pass="basegeneral";
    private static Connection conn;
    private Connector(){}

    public static synchronized Connection getConnection(){
        try {
            if(conn==null || conn.isClosed()) 
                conn=DriverManager.getConnection(url, user, pass);
        } catch (Exception e) {
            System.out.println("***************************************");
            System.out.println(e);
            System.out.println("***************************************");
        }
        return conn;
    }

}