package ar.edu.ungs.prog2.ticketek;
public abstract class sede {
    private String nombre;
    private String direccion;
    private int capacidadMaxima; 
    public String getNombre() {
        return nombre;
    }
    public sede(String nombre, String direccion, int capacidadMaxima) {
    }
    public String getDireccion() {
        return direccion;
    }

    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }
    public int Consultarvarlorentrada(int precioBase, String Platea){
        return precioBase;
        
    }
}
