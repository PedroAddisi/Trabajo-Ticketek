package ar.edu.ungs.prog2.ticketek;
import java.time.*;
import java.util.Random;

public class Entrada implements IEntrada {
    //
    private String nombreEspectaculo;
    private  LocalDate  fecha;
    private String email;
    private String contrasenia;
    private Integer codigodeentrada=Codigorandom();
    private String Sectorentrada;
    private double precio;
    //
    //
public Entrada(String nombreEspectaculo, LocalDate fecha, String email,String sectorentrada, double precio) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.email = email;
        this.Sectorentrada=sectorentrada;
        this.precio=precio;
   }
   //
   //
   public int Codigorandom() { //Genera un codigo random para la Entrada
    Random random = new Random();
        return random.nextInt(9000) + 1000;
}

   public double precio(){ //Devuelve el precio base de la entrada //Hacer que devuelva precio total
    return precio;
   }
   public String getNombreEspectaculo() {//Devuelve el nombre del espectaculo de la entrada
    return nombreEspectaculo;
}
public LocalDate getFecha() {//Devuelve la fecha de la entrada
    return fecha;
}
public String getEmail() {//Devuelve el email de la entrada
    return email;
}
public String getContrasenia() {//Devuelve la contraseña de la entrada
    return contrasenia;
}
public int getCodigodeentrada() {//Devuelve el codigo de entrada
        return codigodeentrada;
    }   
public String getSectorentrada() {//Devuelve el sector de la entrada
    return Sectorentrada;
}
@Override
public String toString() {//devuelve valores de la entrada en string
    return "Entrada [nombreEspectaculo=" + nombreEspectaculo + ", fecha=" + fecha + ", email=" + email
            + ", contrasenia=" + contrasenia + ", cantidadEntradas="  + "]";
}
@Override
public String ubicacion() {//Devuelve sector + asientos si tiene de la entrada
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'ubicacion'");
}
//
}
