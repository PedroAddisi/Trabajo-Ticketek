package ar.edu.ungs.prog2.ticketek;

import java.util.Random;

public class IEntrada {
    private String nombreEspectaculo;
    private String  fecha;
    private String email;
    private String contrasenia;
    private int  cantidadEntradas;
public IEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,int codigodeentrada, int codidodeentrada) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.email = email;
        this.contrasenia = contrasenia;
        codidodeentrada=Generarcodigodeentrada();
   }
   private int Generarcodigodeentrada() {   
    Random random = new Random();
        return random.nextInt(9000) + 1000;
}
   public double precio(){

        return 0.0;
   }
   public String getNombreEspectaculo() {
    return nombreEspectaculo;
}

public void setNombreEspectaculo(String nombreEspectaculo) {
    this.nombreEspectaculo = nombreEspectaculo;
}

public String getFecha() {
    return fecha;
}

public void setFecha(String fecha) {
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

   public String ubicacion(){
    return null;
   }
@Override
public String toString() {
    return "IEntrada [nombreEspectaculo=" + nombreEspectaculo + ", fecha=" + fecha + ", email=" + email
            + ", contrasenia=" + contrasenia + ", cantidadEntradas=" + cantidadEntradas + "]";
}

}
