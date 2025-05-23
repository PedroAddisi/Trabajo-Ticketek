package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Miniestadio extends Sedes {
    // Atributos
    private int asientosPorFila = 25;
    private String[] sectores = {"Platea VIP", "Platea Común", "Platea Baja", "Platea Alta"};
    private int[] capacidad = {50, 100, 150, 200};
    private int[] porcentajeAdicional = {70, 40, 50, 0};
    private int cantidadPuestos;
    private double consumicion;

    // Constructor
    public Miniestadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional, String tipoSede) {
        super(nombre, direccion, capacidadMaxima, "Miniestadio");
        if (asientosPorFila <= 0) throw new IllegalArgumentException("Asientos por fila inválido");
        if (cantidadPuestos < 0) throw new IllegalArgumentException("Cantidad de puestos inválida");
        if (precioConsumicion < 0) throw new IllegalArgumentException("Precio de consumición inválido");
        this.asientosPorFila = asientosPorFila;
        this.sectores = sectores;
        this.capacidad = capacidad;
        this.porcentajeAdicional = porcentajeAdicional;
        this.cantidadPuestos = cantidadPuestos;
        this.consumicion = precioConsumicion;
    }

    // Devuelve cantidad de asientos por fila
    public int getAsientosPorFila() {
        return asientosPorFila;
    }

    @Override
    public double getConsumición() {
        return consumicion;
    }

    @Override
    public String[] getSectores() {
        return sectores;
    }

    @Override
    public int[] getCapacidad() {
        return capacidad;
    }

    @Override
    public int[] getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    // Devuelve cantidad de puestos
    public int getCantidadPuestos() {
        return cantidadPuestos;
    }

    // Devuelve el precio de una consumición
    public double getPrecioConsumicion() {
        return consumicion;
    }

    @Override
    public void generarAsientos() {
        // Genera los asientos para el miniestadio sin repetir números pero respetando la cantidad de asientos por fila
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