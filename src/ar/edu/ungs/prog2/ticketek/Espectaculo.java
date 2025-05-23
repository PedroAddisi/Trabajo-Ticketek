package ar.edu.ungs.prog2.ticketek;
import java.util.HashMap;

public class Espectaculo {
    // Atributos
    private String nombre;
    private HashMap<String,Funcion> listaFunciones = new HashMap<>();

    // Constructor
    public Espectaculo(String nombre) {
        this.nombre = nombre;
    }

    // Devuelve el nombre del espectáculo
    public String getNombre() {
        return nombre;
    }

    // Devuelve la lista de funciones del espectáculo
    public HashMap<String, Funcion> getListaFunciones() {
        return listaFunciones;
    }

    // Carga una función a la lista de funciones del espectáculo
    public void cargarFunciones(String fecha,Funcion funcion) {
        listaFunciones.put(fecha,funcion);
    }

    @Override
    public String toString() {
        return "Espectaculo: " + nombre + ", Funciones: " + listaFunciones.size();
    }
}