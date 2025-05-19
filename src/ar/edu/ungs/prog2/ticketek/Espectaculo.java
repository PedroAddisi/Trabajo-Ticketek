package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;

public class Espectaculo {
    private String Nombre;
    HashMap <sede, String> listaFunciones = new HashMap<>();
    public Espectaculo(String nombre2) {
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void cargarfunciones(Funcion funcion){
        listaFunciones.put(funcion.getSede(),funcion.getFecha());
    }
    @Override
    public String toString() {
        return "hola";
    }  
}