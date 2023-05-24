package ar.org.centro8.curso.java.concesionario.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.concesionario.connectors.Connector;
import ar.org.centro8.curso.java.concesionario.entities.Facturas;
import ar.org.centro8.curso.java.concesionario.entities.facturas;


public class FacturasRepository {
    private Connection conn = Connector.getConnection();

    public void save(Facturas facturas) {
        if (facturas == null)
            return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into cursos (letra,numero,fecha,monto,codigocliente) values (?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, facturas.getLetra());
            ps.setInt(2, facturas.getNumero());
            ps.setString(3, facturas.getFecha().toString());
            ps.setDouble(4, facturas.getMonto());
            ps.setInt(5, facturas.getCodigocliente());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                facturas.setCodigocliente(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Facturas> getAll() {
        List<Facturas> list = new ArrayList();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from facturas")) {
            while (rs.next()) {
                list.add(new Facturas(
                        rs.getInt("letra"), 
                        rs.getInt("numero"), 
                        rs.getString("fecha"), 
                        rs.getInt("monto"),
                        rs.getInt("codigocliente")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Facturas getById(int codigocliente) {
        return getAll()
                .stream()
                .filter(c -> c.getCodigocliente() == codigocliente)
                .findFirst()
                .orElse(new Facturas());
    }

    /* public List<Facturas>getLikeNumero(int numero){
        if(numero==null) return new ArrayList();
        return getAll()
                    .stream()
                    .filter(c->c.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                    .toList();      
    } */

}
