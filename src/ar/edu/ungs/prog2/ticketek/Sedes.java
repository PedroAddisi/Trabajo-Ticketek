package ar.edu.ungs.prog2.ticketek;
public abstract class Sedes {
    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima; 
    protected String Tiposede;
    public Sedes(String nombre, String direccion, int capacidadMaxima,String Tiposede) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.Tiposede = Tiposede;
    }

    public String getNombre() {
        return nombre;
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
    protected int quitarcapacidad(int i){
        this.capacidadMaxima=-i;
        return capacidadMaxima;
    }
    public void generarAsientos() {
    }
}
