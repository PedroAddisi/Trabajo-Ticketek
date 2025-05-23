package ar.edu.ungs.prog2.ticketek;
import java.util.HashMap;

public class Espectaculo {
    // Atributos
    private final String nombre;
    private final HashMap<String, Funcion> listaFunciones = new HashMap<>();

    // Constructor
    public Espectaculo(String nombre) {
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre;
    }

    // Devuelve el nombre del espectáculo
    public String getNombre() {
        return nombre;
    }

    // Devuelve la lista de funciones del espectáculo
    public HashMap<String, Funcion> getListaFunciones() {
        return new HashMap<>(listaFunciones); 
    }

    // Carga una función a la lista de funciones del espectáculo
    public void cargarFunciones(String fecha, Funcion funcion) {
        if (fecha == null || fecha.isEmpty()) throw new IllegalArgumentException("Fecha inválida");
        if (funcion == null) throw new IllegalArgumentException("Función inválida");
        listaFunciones.put(fecha, funcion);
    }

    @Override
    public String toString() {
        return "Espectaculo: " + nombre + ", Funciones: " + listaFunciones.size();
    }
}