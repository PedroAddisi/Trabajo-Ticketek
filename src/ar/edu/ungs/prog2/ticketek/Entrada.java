package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Entrada implements IEntrada {
    // Atributos
    private String nombreEspectaculo;
    private LocalDate fecha;
    private String email;
    private String contrasenia;
    private static int contador= 1000;
    private Integer codigoDeEntrada;
    private String sectorEntrada;
    private double precio;
    private int[] asientos;
    private String nombreSede;
    // Constructor
    public Entrada(String nombreEspectaculo, LocalDate fecha, String email, String nombreSede, String sectorEntrada, double precio, int[] asientos) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.email = email;
        this.nombreSede = nombreSede;
        this.sectorEntrada = sectorEntrada;
        this.precio = precio;
        this.codigoDeEntrada = ++contador;
        this.asientos = asientos;
    }

    // Devuelve el precio de la entrada
    public double precio() {
        if (sectorEntrada.equals("Campo")) {
            return precio;
        }
        return precio + precio * obtenerPrecioSector(sectorEntrada);
    }

    // Getters
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public int getCodigoDeEntrada() {
        return codigoDeEntrada;
    }

    public String getSectorEntrada() {
        return sectorEntrada;
    }
    public int[] getAsientos() {
        return asientos;
    }

    public String getFechaString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        return fecha.format(formatter);
    }

    @Override
    public String ubicacion() {

        if (sectorEntrada.equalsIgnoreCase("Campo")) {
            return "CAMPO";
        }
        // Si tiene asientos muestra el sector fila y asiento
        if (asientos != null && asientos.length == 2) {
            return String.format("%s f:%d a:%d", sectorEntrada, asientos[0], asientos[1]);
        }
        if (asientos != null && asientos.length > 0) {
            StringBuilder sb = new StringBuilder(sectorEntrada + " ");
            for (int i = 0; i < asientos.length; i++) {
                if (i > 0) sb.append(", ");
                sb.append("a:").append(asientos[i]);
            }
            return sb.toString();
        }
        // Si no hay asientos, solo el sector
        return sectorEntrada;
    }

    @Override
    public String toString() {
        String fechaStr = getFechaString();
        if (fecha.isBefore(LocalDate.now())) {//Coloca la p para entradas pasadas
            fechaStr += " P";
        }
        return String.format("%d - %s - %s - %s - %s",codigoDeEntrada,nombreEspectaculo,fechaStr,nombreSede,ubicacion());
    }

    private double obtenerPrecioSector(String sector) {// Devuelve el porcentaje adicional por sector
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
