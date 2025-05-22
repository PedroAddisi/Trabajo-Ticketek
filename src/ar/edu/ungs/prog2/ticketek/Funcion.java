package ar.edu.ungs.prog2.ticketek;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
public class Funcion {
    //
   private String nombreEspectaculo;
    private LocalDate fecha;
    private String sede;
    private HashMap<String,Sedes> Mapasede= new HashMap<>();
    private double precioBase;
    private String fechastring;
    private int Entradasvendidas=0;
    private double totalRecaudado =0;
    //
    //
    public Funcion(String nombreEspectaculo2, String fecha2, String sede2, double precioBase2) {
        this.nombreEspectaculo=nombreEspectaculo2;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate fecha1 = LocalDate.parse(fecha2, formatter);
        this.fecha=fecha1;
        this.precioBase=precioBase2;
        this.fechastring=fecha2;
        this.sede=sede2;
    }
    //
    //
    public void generarAsientosfuncion(){//Genera los asientos de las funciones en teatro y miniestadio
        if (!Mapasede.get(sede).Tiposede.equals("Estadio")) {
          Mapasede.get(sede).generarAsientos();  
        }
    }
    public String getNombreEspectaculo() {//Devuelve el nombre de la funcion que es igual al del espectaculo
        return nombreEspectaculo;
    }
    public  LocalDate getFecha() {//Devuelve la fecha de la funcion
        return fecha;
    }
    public String getSede() {//devuelve el nombre de la sede donde ocurre la funcion
        return sede;
    }
    public double getPrecioBase() {//devuelve el precio base de la funcion
        return precioBase;
    }
     public String getFechastring() {//devuelve la fecha de la funcion echa string
        return fechastring;
    }
      public HashMap<String, Sedes> getMapasede() {//Devuelve el Hash map de sedes donde ocurren las funciones
        return Mapasede;
    }
    
    public int getEntradasvendidas() {//devuelve la cantidad de entradas vendidas por funcion
        return Entradasvendidas;
    }
      public double getTotalRecaudado() {//devuelve lo total recaudado por funcion
          return totalRecaudado;
      }
    @Override
    public String toString() {
        return "( " + fechastring + " )"+ sede ;
}
    public void guardarrecaudado(int cantidadEntradas, String sector) {//Guarda lo recaudado en funciones en estadio
         if (Mapasede.get(sede).Tiposede.equals("Estadio")) {//pregunta si la sede de la funcion es Estadio
             for (int i = 0; i <cantidadEntradas; i++) {
            Entradasvendidas+=1;
            totalRecaudado+=precioBase; 
        }
    }
    }
    public void guardarrecaudadoteatroymini(int cantidadEntradas, String sector){//Guarda lo recaudado en funciones en miniestadios y teatros
        double recargo=recargosectores(sector);
        double consumo=Mapasede.get(sede).consumición;
        if (Mapasede.get(sede).Tiposede.equals("Teatro")) {//pregunta si la sede de la funcion es Teatro
            for (int i = 0; i <cantidadEntradas; i++) {
                Entradasvendidas+=1;
                totalRecaudado+=precioBase*recargo; 
            }
        }
        if (Mapasede.get(sede).Tiposede.equals("Miniestadio")) {//pregunta si la sede de la funcion es Miniestadio
            for (int i = 0; i <cantidadEntradas; i++) {
                Entradasvendidas+=1;
                totalRecaudado+=precioBase*recargo+consumo; 
            }
        }
       
}
    public void reservarasientos(int[] asientos, String sector) {//Reserva los asientos de una funcion con asientos
        for (int i = 0; i < asientos.length; i++) {
            Mapasede.get(sede).asientosPorSector.get(sector).remove(asientos[i]);
        }
    }
    public double recargosectores(String sector){// Devuelve los valores de recargo sector en double y modificas las palabras para no largar error con el init
     String normalizado = sector.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");

  switch (normalizado) {
      case "platea vip":
      case "vip":
          return 0.70;
      case "platea comun":
      case "comun":
          return 0.40;
      case "platea baja":
      case "baja":
          return 0.50;
      case "platea alta":
      case "alta":
           return 0.0;
      default:
          throw new RuntimeException("Sector inválido");
    }
  }
}