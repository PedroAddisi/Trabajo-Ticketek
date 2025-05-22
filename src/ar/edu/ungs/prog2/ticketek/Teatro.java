package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Teatro extends Sedes {
    //
     private int asientosPorFila=30;
    private String [] sectores={"Platea VIP", "Platea Común", "Platea Baja", "Platea Alta"};
    private int[] capacidad={100, 200, 300, 400};
    private int[] porcentajeAdicional ={70, 40, 50, 0};
    //
    //
    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional, String Tiposede) {
        super(nombre, direccion, capacidadMaxima, Tiposede);
        this.asientosPorFila=asientosPorFila;
        this.sectores=sectores;
        this.capacidad=capacidad;
        this.porcentajeAdicional=porcentajeAdicional;
        this.Tiposede="Teatro";
    }   
    //
    //
    public int getAsientosPorFila() {//Devuelve cantidad de asientos por fila
        return asientosPorFila;
    }
    @Override
    public String[] getSectores() {//devuelve el precio de la consumision
        return sectores;
    }
    @Override
    public int[] getPorcentajeAdicional() {//devuelve el porcentaje adicional por sector 
        return porcentajeAdicional;
    }
    @Override
    public int[] getCapacidad() { //devuelve la capacidad por sectores
        return capacidad;
    }
    @Override
    public void generarAsientos() {//genera los asientos para el miniestadio sin rpetir numeros pero respetando la cantidad de asientos por fila
        int numeroAsiento = 1;

        for (int i = 0; i < sectores.length; i++) {
            String sector = sectores[i];
            int cantidad = capacidad[i];

            List<Integer> asientos = new ArrayList<>();

            for (int j = 0; j < cantidad; j++) {
                asientos.add(numeroAsiento++);
            }

            asientosPorSector.put(sector, asientos);
        }
    }
}

