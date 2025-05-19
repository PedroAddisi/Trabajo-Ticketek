package ar.edu.ungs.prog2.ticketek;

import java.time.*;
import java.time.format.DateTimeFormatter;

public class Funcion {
   private String nombreEspectaculo;
    private LocalDate fecha;
    private sede sede;
    private double precioBase;
    public Funcion(String nombreEspectaculo2, String fecha2, String sede2, double precioBase2) {
    }
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }
    public  LocalDate getFecha() {
        return fecha;
    }
    public  String getFechaString() {
        DateTimeFormatter Cambiador= DateTimeFormatter.ofPattern("dd/mm/yyyy");
        String fechaString =fecha.format(Cambiador);
        return fechaString;

    }
    public ar.edu.ungs.prog2.ticketek.sede getSede() {
        return sede;
    }
     public String nombregetSede() {
        return sede.getNombre();
    }
    public double getPrecioBase() {
        return precioBase;
    }
    @Override
    public String toString() {
        return "{" + fecha + "}"+ "{"+ sede + "}" + "{" +/* Entradas Vendidas*/  "}" +"{" + sede.getCapacidadMaxima() + "}";
    }
}