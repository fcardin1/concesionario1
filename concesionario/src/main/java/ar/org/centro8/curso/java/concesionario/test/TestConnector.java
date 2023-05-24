package ar.org.centro8.curso.java.concesionario.test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import ar.org.centro8.curso.java.concesionario.connectors.Connector;

public class TestConnector {
    public static void main(String[] args) {
        try (Connection conn=Connector.getConnection()){
            ResultSet rs=conn.createStatement().executeQuery("select version()");
            if(rs.next()) System.out.println(rs.getString(1));
            else System.out.println("No se pudo conectar a la Base!");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("No se pudo conectar a la Base!");
        }
    }
}