package ar.org.centro8.curso.java.concesionario.entities;

public class Autos {

    private int codigo;
    private String marca;
    private String modelo;
    private double precio;
    private int codigocliente;

    public Autos() {

    }

    public Autos(String marca, String modelo, double precio, int codigocliente) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.codigocliente = codigocliente;
    }

    public Autos(int codigo, String marca, String modelo, double precio, int codigocliente) {
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.codigocliente = codigocliente;
    }

    @Override
    public String toString() {
        return "Autos [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + precio
                + ", codigocliente=" + codigocliente + "]";
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getCodigocliente() {
        return codigocliente;
    }

    public void setCodigocliente(int codigocliente) {
        this.codigocliente = codigocliente;
    }

}
