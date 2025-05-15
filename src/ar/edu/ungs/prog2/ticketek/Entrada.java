package ar.edu.ungs.prog2.ticketek;
import java.time.LocalDateTime;

public class Entrada {
    private String nombreEspectaculo;
    private LocalDateTime  fecha;
    private String email;
    private String contrasenia;
    private int  cantidadEntradas;
    public String getNombreEspectaculo() {
        return nombreEspectaculo;
    }
    public void setNombreEspectaculo(String nombreEspectaculo) {
        this.nombreEspectaculo = nombreEspectaculo;
    }
    public LocalDateTime getFecha() {
        return fecha;
    }
    public void setFecha(LocalDateTime fecha) {
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
