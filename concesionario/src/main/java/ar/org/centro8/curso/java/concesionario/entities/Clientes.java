package ar.org.centro8.curso.java.concesionario.entities;

public class Clientes {

    private int codigo;
    private String nombre;
    private String apellido;
    private int dni;

    public Clientes() {
    }

    public Clientes(String nombre, String apellido, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }

    public Clientes(int codigo, String nombre, String apellido, int dni) {

        this.codigo = codigo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;

    }

    @Override
    public String toString() {
        return "autos [codigo=" + codigo + ", nombre=" + nombre + ", apellido=" + apellido + ", dni=" + dni + "]";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

}
