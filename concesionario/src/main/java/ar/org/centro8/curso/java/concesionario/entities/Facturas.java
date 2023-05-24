package ar.org.centro8.curso.java.concesionario.entities;

public class Facturas {

    private int letra;
    private int numero;
    private String fecha;
    private double monto;
    private int codigocliente;

    public Facturas(){

    }
    

    
    public Facturas(int letra, int numero, String fecha, double monto, int codigocliente) {
        this.letra = letra;
        this.numero = numero;
        this.fecha = fecha;
        this.monto = monto;
        this.codigocliente = codigocliente;
    }


    @Override
    public String toString() {
        return "Facturas [letra=" + letra + ", numero=" + numero + ", fecha=" + fecha + ", monto=" + monto
                + ", codigocliente=" + codigocliente + "]";
    }


    public int getLetra() {
        return letra;
    }


    public void setLetra(int letra) {
        this.letra = letra;
    }


    public int getNumero() {
        return numero;
    }


    public void setNumero(int numero) {
        this.numero = numero;
    }


    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public double getMonto() {
        return monto;
    }


    public void setMonto(double monto) {
        this.monto = monto;
    }


    public int getCodigocliente() {
        return codigocliente;
    }


    public void setCodigocliente(int codigocliente) {
        this.codigocliente = codigocliente;
    }

    
        
}
