package ar.edu.ungs.prog2.ticketek;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public abstract class Sedes {
    // Atributos
    protected int asientosPorFila;
    protected String[] sectores;
    protected int[] capacidad;
    protected int[] porcentajeAdicional;
    protected double consumicion;
    protected String nombre;
    protected String direccion;
    protected int capacidadMaxima;
    protected String tipoSede;
    protected Map<String, List<Integer>> asientosPorSector = new LinkedHashMap<>();

    // Constructor
    public Sedes(String nombre, String direccion, int capacidadMaxima, String tipoSede) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.capacidadMaxima = capacidadMaxima;
        this.tipoSede = tipoSede;
    }

    // Devuelve el nombre de la sede
    public String getNombre() {
        return nombre;
    }

    // Devuelve la dirección de la sede
    public String getDireccion() {
        return direccion;
    }

    // Devuelve la capacidad máxima de la sede
    public int getCapacidadMaxima() {
        return capacidadMaxima;
    }

    // Devuelve el costo de la consumición
    public double getConsumición() {
        return consumicion;
    }

    // Consulta el valor de la entrada
    public int consultarValorEntrada(int precioBase, String platea) {
        return precioBase;
    }

    // Devuelve los sectores de la sede
    public String[] getSectores() {
        return sectores;
    }

    // Devuelve la capacidad de la sede
    public int[] getCapacidad() {
        return capacidad;
    }

    // Devuelve el porcentaje adicional de la sede
    public int[] getPorcentajeAdicional() {
        return porcentajeAdicional;
    }

    // Retorna los asientos por sector
    public Map<String, List<Integer>> getAsientosPorSector() {
        return asientosPorSector;
    }

    // Devuelve el tipo de sede
    public String getTipoSede() {
        return tipoSede;
    }

    // Genera todos los asientos por sector (debe ser implementado por subclases si es necesario)
    public void generarAsientos() {
        // Implementación vacía por defecto ya que modifico el comportamiento en la subclase
    }
}
