package ar.edu.ungs.prog2.ticketek;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Sedes {
    //
    protected int asientosPorFila;
    protected String [] sectores;
    protected int[] capacidad;
   protected int[] porcentajeAdicional;
    protected double consumición;
    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima; 
    protected String Tiposede;
    //
    //
    public Sedes(String nombre, String direccion, int capacidadMaxima,String Tiposede) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.Tiposede = Tiposede;
    }
    //
    //
    public String getNombre() {//devuelve el nombre de la sede
        return nombre;
    }

    public String getDireccion() {//devuelve la direccion de la sede
        return direccion;
    }

    public int getCapacidadMaxima() {//devuelve la capacidad max de la sede
        return capacidadMaxima;
    }
    
    public double getConsumición() {//devuelve el costo de la consumicion
        return consumición;
    }

    public int Consultarvarlorentrada(int precioBase, String Platea){//consulta el valor de la entrada 
        return precioBase;
        
    }
     public String[] getSectores() {//devuelve los sectores de la sede
        return sectores;
    }

    public int[] getCapacidad() {//devuelve la capacidad de la sede
        return capacidad;
    }

    public int[] getPorcentajeAdicional() {//devuelve el porcentaje adicional de la sede
        return porcentajeAdicional;
    }
    protected Map<String, List<Integer>> asientosPorSector = new LinkedHashMap<>();//donde se guardan  lo asientos por sector
    public Map<String, List<Integer>> getAsientosPorSector() {//retorna los asientos por sector
        return asientosPorSector;
    }

    public void generarAsientos() {   //genera todos los asientos por sector

    }
}
