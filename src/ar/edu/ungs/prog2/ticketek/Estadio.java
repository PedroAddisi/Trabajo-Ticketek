package ar.edu.ungs.prog2.ticketek;

public class Estadio extends Sedes {
    // Constructor
    public Estadio(String nombre, String direccion, int capacidadMaxima, String tipoSede) {
        super(nombre, direccion, capacidadMaxima, "Estadio");
    }

    private int capacidadSector = capacidadMaxima;

    // Devuelve capacidad de sector único
    public int getCapacidadSector() {
        return capacidadSector;
    }
}

