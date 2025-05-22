package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.List;

public class Miniestadio  extends Sedes{
    //
    private int asientosPorFila=25;
    private String [] sectores={"Platea VIP", "Platea Común", "Platea Baja", "Platea Alta"};
    private int[] capacidad={50, 100, 150, 200};
    private int[] porcentajeAdicional={70, 40, 50, 0};
    private int cantidadPuestos;
    private double precioConsumicion;
    //
    //
    public Miniestadio(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional,String Tiposede) {
        super(nombre, direccion, capacidadMaxima,Tiposede);
        this.asientosPorFila=asientosPorFila;
        this.sectores=sectores;
        this.capacidad=capacidad;
        this.porcentajeAdicional=porcentajeAdicional;
        this.cantidadPuestos=cantidadPuestos;
        this.precioConsumicion=precioConsumicion;
        this.Tiposede="Miniestadio";
    }
    //
    ///
    public int getAsientosPorFila() {//Devuelve cantidad de asientos por fila
        return asientosPorFila;
    }
    @Override
    public double getConsumición() {//devuelve el precio de la consumision
        return precioConsumicion;
    }
    @Override
    public String[] getSectores() {//devuelve los sectores
        return sectores;
    }
    @Override
    public int[] getPorcentajeAdicional() {//devuelve el porcentaje de sector
        return porcentajeAdicional;
    }
    @Override
    public int[] getCapacidad() {//devuelve la capacidad de los sectores
        return capacidad;
    }

    public int getCantidadPuestos() {//devuelve cantidad de puestos
        return cantidadPuestos;
    }

    public double getPrecioConsumicion() {//devuelve el precio de una consumicion
        return precioConsumicion;
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