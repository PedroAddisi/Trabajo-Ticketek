package ar.edu.ungs.prog2.ticketek;
public class Miniestadio  extends Sedes{
    private int plateaComun = capacidadMaxima / 4;
    private int plateavip = capacidadMaxima / 4;
    private int plateaBaja = capacidadMaxima / 4;
    private int plateaAlta = capacidadMaxima / 4;
    public Miniestadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional){
        super(nombre, direccion, capacidadMaxima);
        //TODO Auto-generated constructor stub
    }
}
