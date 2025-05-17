package ar.edu.ungs.prog2.ticketek;
public class Funcion {
   private String nombreEspectaculo;
    private String fecha;
    private sede sede;
    private double precioBase;
    public Funcion(String nombreEspectaculo2, String fecha2, String sede2, double precioBase2) {
        //TODO Auto-generated constructor stub
    }
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }
    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }
    public String getFecha() {
        return fecha;
    }
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    public ar.edu.ungs.prog2.ticketek.sede getSede() {
        return sede;
    }
    public void setSede(ar.edu.ungs.prog2.ticketek.sede sede) {
        this.sede = sede;
    }
    public double getPrecioBase() {
        return precioBase;
    }
    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }
}
