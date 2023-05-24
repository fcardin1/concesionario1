package ar.org.centro8.curso.java.concesionario.repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import ar.org.centro8.curso.java.concesionario.connectors.Connector;
import ar.org.centro8.curso.java.concesionario.entities.Autos;

public class AutosRepository {
    private Connection conn = Connector.getConnection();
    
    public void save(Autos Autos) {
        if (Autos == null) return;
        try (PreparedStatement ps = conn.prepareStatement(
                "insert into alumnos (codigo, marca, modelo, precio, codigocliente) values (?,?,?,?,?)",
                PreparedStatement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, Autos.getCodigo());        
            ps.setString(2, Autos.getMarca());
            ps.setString(3, Autos.getModelo());
            ps.setDouble(4, Autos.getPrecio());
            ps.setInt(5, Autos.getCodigocliente());
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next())
                Autos.setCodigo(rs.getInt(1));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Autos> getAll() {
        List<Autos> list = new ArrayList();
        try (ResultSet rs = conn.createStatement().executeQuery("select * from autos")) {
            while (rs.next()) {
                list.add(new Autos(
                        rs.getInt("codigo"),            
                        rs.getString("marca"),     
                        rs.getString("modelo"),   
                        rs.getDouble("precio"),          
                        rs.getInt("codigocliente")        
                ));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }

    public Autos getById(int codigo) {
        return getAll()
                .stream()
                .filter(a -> a.getCodigo() == codigo)
                .findFirst()
                .orElse(new Autos());
    }

    public List<Autos>getLikeApellido(String marca){
        if(marca ==null) return new ArrayList();
        return getAll()
                    .stream()
                    .filter(a->a.getMarca().toLowerCase().contains(marca.toLowerCase()))
                    .toList(); 
    }
}