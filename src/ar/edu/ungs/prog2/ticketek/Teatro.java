package ar.edu.ungs.prog2.ticketek;

public class Teatro extends sede {

    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        super(nombre, direccion, capacidadMaxima);
        
    }

    @Override
    protected void quitarcapacidad(String fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarcapacidad'");
    }

}
