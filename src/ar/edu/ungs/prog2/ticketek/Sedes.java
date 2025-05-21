package ar.edu.ungs.prog2.ticketek;
public abstract class Sedes {
    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima; 
    protected int capacidad;
    //Hacer Arraylist sectores y clase sectores.
    // crear clase sector para filas 
    public Sedes(String nombre, String direccion, int capacidadMaxima) {
        this.nombre = nombre;
        this.direccion= direccion;
        this.capacidadMaxima= capacidadMaxima;
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
    protected int cantidaddeentrdasvendidas(int i){
        this.capacidad=+i;;
        return capacidad ;
    }
    public int getCapacidad() {
        return capacidad;
    }
}
