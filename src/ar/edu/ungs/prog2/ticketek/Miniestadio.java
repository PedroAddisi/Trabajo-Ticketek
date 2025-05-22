package ar.edu.ungs.prog2.ticketek;
public class Miniestadio  extends Sedes{
    private int asientosPorFila;
    private String [] sectores;
    private int[] capacidad;
    private int[] porcentajeAdicional;
    private int cantidadPuestos;
    private double precioConsumicion;
    public Miniestadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        super(nombre, direccion, capacidadMaxima);
        this.asientosPorFila=asientosPorFila;
        this.sectores=sectores;
        this.capacidad=capacidad;
        this.porcentajeAdicional=porcentajeAdicional;
        this.cantidadPuestos=cantidadPuestos;
        this.precioConsumicion=precioConsumicion;
    }
    private String Tiposede ="Miniestadio";
    public String getTiposede() {
        return Tiposede;
    }
    
    public int getAsientosPorFila() {
        return asientosPorFila;
    }

    public String[] getSectores() {
        return sectores;
    }

    public int[] getPorcentajeAdicional() {
        return porcentajeAdicional;
    }
    public int[] getCapacidad() {
        return capacidad;
    }

    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    public double getPrecioConsumicion() {
        return precioConsumicion;
    }
}
