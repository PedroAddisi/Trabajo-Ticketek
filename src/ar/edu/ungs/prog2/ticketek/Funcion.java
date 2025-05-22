package ar.edu.ungs.prog2.ticketek;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;

public class Funcion {
   private String nombreEspectaculo;
    private LocalDate fecha;
    private String sede;
    private HashMap<String,Sedes> Mapasede= new HashMap<>();
    private double precioBase;
    private String fechastring;
    private Sector sector;
    private int Entradasvendidas=0;
    private int totalRecaudado =0;
    public Funcion(String nombreEspectaculo2, String fecha2, String sede2, double precioBase2) {
        this.nombreEspectaculo=nombreEspectaculo2;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate fecha1 = LocalDate.parse(fecha2, formatter);
        this.fecha=fecha1;
        this.precioBase=precioBase2;
        this.fechastring=fecha2;
        this.sede=sede2;
    }
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }
    public  LocalDate getFecha() {
        return fecha;
    }
    public String getSede() {
        return sede;
    }
    public double getPrecioBase() {
        return precioBase;
    }
     public String getFechastring() {
        return fechastring;
    }
      public HashMap<String, Sedes> getMapasede() {
        return Mapasede;
    }
    @Override
    public String toString() {
        return "( " + fechastring + " )"+ sede + sector.getNombre();
}
    public void guardarrecaudado(int cantidadEntradas, String sede2) {//Agregar sector.
        if (Mapasede.get(sede2).Tiposede.equals("Estadio")) {
             for (int i = 0; i <cantidadEntradas; i++) {
            Entradasvendidas+=1;
            totalRecaudado+=precioBase; 
        }
        }
    }
    public void reservarasientos(int[] asientos) {//Ver

    }
}