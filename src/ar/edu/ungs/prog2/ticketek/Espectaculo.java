package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Espectaculo {
    private String Nombre;
    public List<Funcion> listaFunciones = new ArrayList<>();
    public Espectaculo(String nombre2) {
        this.Nombre=nombre2;
    }
    public String getNombre() {
        return Nombre;
    }
    public List<Funcion> getListaFunciones() {
        return listaFunciones;
    }
    public void cargarfunciones(Funcion funcion){
        listaFunciones.add(funcion);
}
    @Override
    public String toString() {
        return "hola";
    }  
}