package ar.edu.ungs.prog2.ticketek;
import java.time.*;

public class Entrada implements IEntrada {
    private String nombreEspectaculo;
    private  LocalDate  fecha;
    private String email;
    private String contrasenia;
    private int  cantidadEntradas;
    private int codigodeentrada;

public Entrada(String nombreEspectaculo, LocalDate fecha, String email,int codigodeentrada) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.email = email;
        
   }
   public int getCodigodeentrada() {
    return codigodeentrada;
}
   public double precio(){
        return 0.0;
   }
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


public int getCantidadEntradas() {
    return cantidadEntradas;
}
@Override
public String toString() {
    return "Entrada [nombreEspectaculo=" + nombreEspectaculo + ", fecha=" + fecha + ", email=" + email
            + ", contrasenia=" + contrasenia + ", cantidadEntradas=" + cantidadEntradas + "]";
}
@Override
public String ubicacion() {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'ubicacion'");
}
}
