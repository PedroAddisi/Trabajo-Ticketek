package ar.edu.ungs.prog2.ticketek;
public class Estadio extends Sedes{

    public Estadio(String nombre, String direccion, int capacidadMaxima,String Tiposede) {
        super(nombre, direccion, capacidadMaxima,Tiposede);
        Tiposede="Estadio";
    }
    private int capacidadsector=capacidadMaxima;
    public int getCapacidadsector() {// devuelve capacidad de sector unico
        return capacidadsector;
    }
}

