package ar.edu.ungs.prog2.ticketek;
public class Estadio extends sede{
    String Tiposede ="Estadio";
    public Estadio(String nombre, String direccion, int capacidadMaxima) {
        super(nombre, direccion, capacidadMaxima);
    }
    @Override
    protected void quitarcapacidad(String fecha) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'quitarcapacidad'");
    }
}
