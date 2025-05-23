package ar.edu.ungs.prog2.ticketek;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;

public class Funcion {
    // Atributos
    private String nombreEspectaculo;
    private LocalDate fecha;
    private String sede;
    private HashMap<String, Sedes> mapSede = new HashMap<>();
    private double precioBase;
    private String fechaString;
    private int entradasVendidas = 0;
    private double totalRecaudado = 0;
    private int entradasVendidasVip = 0;
    private int entradasVendidasComun = 0;
    private int entradasVendidasAlta = 0;
    private int entradasVendidasBaja = 0;
    private String conteoSector = "";

    // Constructor
    public Funcion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        this.nombreEspectaculo = nombreEspectaculo;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate fecha1 = LocalDate.parse(fecha, formatter);
        this.fecha = fecha1;
        this.precioBase = precioBase;
        this.fechaString = fecha;
        this.sede = sede;
    }

    // Genera los asientos de las funciones en teatro y miniestadio
    public void generarAsientosFuncion() {
        if (!mapSede.get(sede).tipoSede.equals("Estadio")) {
            mapSede.get(sede).generarAsientos();
        }
    }

    // Getters
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getSede() {
        return sede;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public String getFechaString() {
        return fechaString;
    }

    public HashMap<String, Sedes> getMapSede() {
        return mapSede;
    }

    public int getEntradasVendidas() {
        return entradasVendidas;
    }

    public double getTotalRecaudado() {
        return totalRecaudado;
    }
    public String getConteoSector() {
        return conteoSector;
    }

    // Guarda lo recaudado en funciones en estadio
    public void guardarRecaudado(int cantidadEntradas, String sector) {
        if (mapSede.get(sede).tipoSede.equals("Estadio")) {
            for (int i = 0; i < cantidadEntradas; i++) {
                entradasVendidas++;
                totalRecaudado += precioBase;
            }
        }
    }

    // Guarda lo recaudado en funciones en miniestadios y teatros
    public void guardarRecaudadoTeatroYMini(int cantidadEntradas, String sector) {
        double recargo = recargoSectores(sector);
        double consumo = mapSede.get(sede).getConsumición();
        if (mapSede.get(sede).tipoSede.equals("Teatro")) {
            for (int i = 0; i < cantidadEntradas; i++) {
                entradasVendidas++;
                totalRecaudado += precioBase + precioBase * recargo;
            }
        }
        if (mapSede.get(sede).tipoSede.equals("Miniestadio")) {
            for (int i = 0; i < cantidadEntradas; i++) {
                entradasVendidas++;
                totalRecaudado += precioBase + precioBase * recargo + consumo;
            }
        }
    }

    // Reserva los asientos de una funcion con asientos
    public void reservarAsientos(int[] asientos, String sector) {
        for (int asiento : asientos) {
            mapSede.get(sede).asientosPorSector.get(sector).remove((Integer) asiento);
        }
        conteoDeCapacidad(asientos, sector);
    }

    // Libera los asientos de una función, agregándolos nuevamente al sector (O(1) por asiento)
    public void liberarAsientos(int[] asientos, String sector) {
        List<Integer> disponibles = mapSede.get(sede).asientosPorSector.get(sector);
        if (disponibles != null && asientos != null) {
            for (int asiento : asientos) {
                // O(1) si el asiento es igual a la posición en la lista:
                int index = asiento - 1;
                if (index >= 0 && index <= disponibles.size()) {
                    disponibles.add(index, asiento);
                } else {
                    disponibles.add(asiento);//Este seria el caso O(n) si el asiento no es igual a la posicion en la lista pero nunca pasaria por que no se modifica la lista de asientos
                }
            }
        }
    }

    // Actualiza el conteo de entradas vendidas por sector
    private String conteoDeCapacidad(int[] asientos, String sector) {
        String normalizado = sector.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");//Ignora tildes
        if (mapSede.get(sede).tipoSede.equals("Estadio")) {// Si es estadio
            conteoSector = "Campo " + entradasVendidas + "/" + mapSede.get(sede).capacidadMaxima;
            return conteoSector;
        }
        if (mapSede.get(sede).tipoSede.equals("Teatro") || mapSede.get(sede).tipoSede.equals("Miniestadio")) {// Si es teatro o miniestadio 
            if (normalizado.equals("vip") || normalizado.equals("platea vip")) {// Si es platea vip
                entradasVendidasVip += asientos.length;
            } else if (normalizado.equals("comun") || normalizado.equals("platea comun")) {// Si es platea comun
                entradasVendidasComun += asientos.length;
            } else if (normalizado.equals("baja") || normalizado.equals("platea baja")) {// Si es platea baja
                entradasVendidasBaja += asientos.length;
            } else if (normalizado.equals("alta") || normalizado.equals("platea alta")) {// Si es platea alta
                entradasVendidasAlta += asientos.length;
            }
            conteoSector = "VIP: " + entradasVendidasVip + "/" + mapSede.get(sede).getCapacidad()[0] +" | Comun: " + entradasVendidasComun + "/" + mapSede.get(sede).getCapacidad()[1] +" | Baja: " + entradasVendidasBaja + "/" + mapSede.get(sede).getCapacidad()[2] + " | Alta: " + entradasVendidasAlta + "/" + mapSede.get(sede).getCapacidad()[3];
        }
        return conteoSector;
    }
    @Override
    public String toString() {
        // Formato:  va a ser (FECHA) SEDE - VIP:  | Comun:  | Baja:  | Alta: 
        StringBuilder sb = new StringBuilder();
        sb.append(" - (").append(fechaString).append(") ").append(sede).append(" - ");//agrega la fecha y la sede
        Sedes sedeObj = mapSede.get(sede);
        if (sedeObj != null && (sedeObj.tipoSede.equals("Teatro") || sedeObj.tipoSede.equals("Miniestadio"))) {// Si es teatro o miniestadio
            String[] sectores = sedeObj.getSectores();// obtiene los sectores
            int[] capacidades = sedeObj.getCapacidad();// obtiene las capacidades
            int[] vendidas = new int[sectores.length];// obtiene las entradas vendidas
            for (int i = 0; i < sectores.length; i++) {
                String sec = sectores[i].toLowerCase();
                if (sec.contains("vip")) vendidas[i] = entradasVendidasVip;//Agrega las entradas vendidas por sector
                else if (sec.contains("comun")) vendidas[i] = entradasVendidasComun;
                else if (sec.contains("baja")) vendidas[i] = entradasVendidasBaja;
                else if (sec.contains("alta")) vendidas[i] = entradasVendidasAlta;
                else vendidas[i] = 0;
            }
            for (int i = 0; i < sectores.length; i++) {
                if (i > 0) sb.append(" | ");
                sb.append(sectores[i]).append(": ").append(vendidas[i]).append("/").append(capacidades[i]);// agrega las entradas vendidas por sector al stringBuilder
            }
        } else if (sedeObj != null && sedeObj.tipoSede.equals("Estadio")) {// Si es estadio
            sb.append("Campo ").append(entradasVendidas).append("/").append(sedeObj.getCapacidadMaxima());// agrega las entradas vendidas al stringBuilder para estadio con su capacidad Maxima
        } else {
            sb.append("-");
        }
        return sb.toString();
    }

    // Devuelve los valores de recargo sector en double
    public double recargoSectores(String sector) {
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

    public void agregarSede(Sedes s) {// Agrega una sede al mapa
        mapSede.put(s.getNombre(), s);
    }

}