package ar.edu.ungs.prog2.ticketek;
import java.time.*;
import java.util.Random;

public class Entrada implements IEntrada {
    private String nombreEspectaculo;
    private  LocalDate  fecha;
    private String email;
    private String contrasenia;
    private int  cantidadEntradas;
    private int codigodeentrada=Codigorandom();
    private String Sectorentrada;
    private double precio;
public Entrada(String nombreEspectaculo, LocalDate fecha, String email,String sectorentrada, double precio) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.email = email;
        this.Sectorentrada=sectorentrada;
        this.precio=precio;
   }
   public int Codigorandom() { 
    Random random = new Random();
        return random.nextInt(9000) + 1000;
}

   public double precio(){
    return precio;
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
public int getCodigodeentrada() {
        return codigodeentrada;
    }
    
public String getSectorentrada() {
    return Sectorentrada;
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
