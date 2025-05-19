package ar.edu.ungs.prog2.ticketek;
public class Miniestadio  extends sede{

    public Miniestadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional){
        super(nombre, direccion, capacidadMaxima);
        //TODO Auto-generated constructor stub
    }

    @Override
    protected void quitarcapacidad(String fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarcapacidad'");
    }

}
