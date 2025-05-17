package ar.edu.ungs.prog2.ticketek;
import java.time.*;

public class Entrada {
    private String nombreEspectaculo;
    private LocalDate  fecha;
    private String email;
    private String contrasenia;
    private int  cantidadEntradas;
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }
    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getContrasenia() {
        return contrasenia;
    }
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    public int getCantidadEntradas() {
        return cantidadEntradas;
    }
    public void setCantidadEntradas(int cantidadEntradas) {
        this.cantidadEntradas = cantidadEntradas;
    }

}
