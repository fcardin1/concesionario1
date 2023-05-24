package ar.org.centro8.curso.java.concesionario.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.concesionario.connectors.Connector;
import ar.org.centro8.curso.java.concesionario.entities.Clientes;


public class ClientesRepository {
    private Connection conn = Connector.getConnection();

    public void save(Clientes Clientes) {
        if (Clientes == null)
            return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into cursos (codigo,nombre,apellido,dni) values (?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, Clientes.getCodigo());
            ps.setString(2, Clientes.getNombre());
            ps.setString(3, Clientes.getApellido());
            ps.setInt(4, Clientes.getDni());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                Clientes.setCodigo(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Clientes> getAll() {
        List<Clientes> list = new ArrayList();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from clientes")) {
            while (rs.next()) {
                list.add(new Clientes(
                        rs.getInt("codigo"), 
                        rs.getString("nombre"), 
                        rs.getString("apellido"), 
                        rs.getInt("dni")
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Clientes getById(int id) {
        return getAll()
                .stream()
                .filter(c -> c.getCodigo() == id)
                .findFirst()
                .orElse(new Clientes());
    }

    public List<Clientes>getLikeNombre(String nombre){
        if(nombre==null) return new ArrayList();
        return getAll()
                    .stream()
                    .filter(c->c.getNombre().toLowerCase().contains(nombre.toLowerCase()))
                    .toList();      
    }

}