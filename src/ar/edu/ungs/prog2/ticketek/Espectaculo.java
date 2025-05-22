package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;
public class Espectaculo {
    //
    private String Nombre;
    public List<Funcion> listaFunciones = new ArrayList<>();
    //
    public Espectaculo(String nombre2) {
        this.Nombre=nombre2;
    }
    //
    //
    public String getNombre() {//Devuelve el nombre del espectaculo
        return Nombre;
    }
    public List<Funcion> getListaFunciones() {// devuelve la lista de funciones del espectaculo
        return listaFunciones;
    }
    public void cargarfunciones(Funcion funcion){// carga una funcion a la lista de espectaculos
        listaFunciones.add(funcion);
}
    @Override
    public String toString() {
        return "hola";
    } 
    // 
}