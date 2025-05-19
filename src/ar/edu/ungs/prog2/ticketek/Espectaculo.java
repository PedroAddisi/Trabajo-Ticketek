package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Espectaculo {
    private String Nombre;
    public List<Funcion> listaFunciones = new ArrayList<>();
    public List<Funcion> getListaFunciones() {
        return listaFunciones;
    }
    public Espectaculo(String nombre2) {
    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public void cargarfunciones(Funcion funcion){
        listaFunciones.add(funcion);
    }
    @Override
    public String toString() {
        return "hola";
    }  
}