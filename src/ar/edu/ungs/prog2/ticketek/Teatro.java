package ar.edu.ungs.prog2.ticketek;

public class Teatro extends Sedes {
    private int asientosPorFila;
    private String [] sectores;
    private int[] capacidad;
    private int[] porcentajeAdicional;
    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        super(nombre, direccion, capacidadMaxima);
        this.asientosPorFila=asientosPorFila;
        this.sectores=sectores;
        this.capacidad=capacidad;
        this.porcentajeAdicional=porcentajeAdicional;
    }
    private String Tiposede ="Teatro";
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
    }
