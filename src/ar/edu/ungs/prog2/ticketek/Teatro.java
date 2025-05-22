package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Teatro extends Sedes {
     int asientosPorFila=30;
     String [] sectores={"Platea VIP", "Platea Común", "Platea Baja", "Platea Alta"};
     int[] capacidad={100, 200, 300, 400};
    int[] porcentajeAdicional ={70, 40, 50, 0};
    public Teatro(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional, String Tiposede) {
        super(nombre, direccion, capacidadMaxima, Tiposede);
        this.asientosPorFila=asientosPorFila;
        this.sectores=sectores;
        this.capacidad=capacidad;
        this.porcentajeAdicional=porcentajeAdicional;
        this.Tiposede="Teatro";
    }   
    public int getAsientosPorFila() {
        return asientosPorFila;
    }

    public String[] getSectores() {
        return sectores;
    }
    public int[] getPorcentajeAdicional() {
        return porcentajeAdicional;
    }
    public int[] getCapacidad() {
        return capacidad;
    }
    private Map<String, List<String>> asientosPorSector = new LinkedHashMap<>();
    public Map<String, List<String>> getAsientosPorSector() {
        return asientosPorSector;
    }
    @Override
    public void generarAsientos() {
        for(int s = 0; s < sectores.length; s++) {
            String sector = sectores[s];
            int totalAsientos = capacidad[s];
            int totalFilas = (int) Math.ceil((double) totalAsientos / asientosPorFila);//Calcula cantidad de filas que necesito para arriba 

            List<String> asientos = new ArrayList<>();
            int asientoActual = 1;

            for (int fila = 0; fila < totalFilas; fila++) {
                char letraFila = (char) ('A' + fila); // Fila A, B, C...
                for (int i = 1; i <= asientosPorFila && asientoActual <= totalAsientos; i++) {
                    String codigo = letraFila + String.valueOf(i);
                    asientos.add(codigo);
                    asientoActual++;
                }
            }

            asientosPorSector.put(sector, asientos);
        }
    }

    }
