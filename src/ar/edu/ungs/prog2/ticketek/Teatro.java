package ar.edu.ungs.prog2.ticketek;

public class Teatro extends sede {
    private int plateaComun = capacidadMaxima / 4;
    private int plateavip = capacidadMaxima / 4;
    private int plateaBaja = capacidadMaxima / 4;
    private int plateaAlta = capacidadMaxima / 4;

    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        super(nombre, direccion, capacidadMaxima);
        
    }
}
