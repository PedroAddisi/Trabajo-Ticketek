package ar.edu.ungs.prog2.ticketek;
public abstract class sede {
    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima; 
    public String getNombre() {
        return nombre;
    }
    public sede(String nombre, String direccion, int capacidadMaxima) {
        nombre = this.nombre;
        direccion = this.direccion;
        capacidadMaxima = this.capacidadMaxima;
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
    protected abstract void quitarcapacidad(String fecha);
}
