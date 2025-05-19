package ar.edu.ungs.prog2.ticketek;
import java.util.Random;
import java.time.*;

public class Entrada extends IEntrada {
    private String nombreEspectaculo;
    private  LocalDate  fecha;
    private String email;
    private String contrasenia;
    private int  cantidadEntradas;
    private int codigodeentrada=Generarcodigodeentrada();
public Entrada(String nombreEspectaculo, LocalDate fecha, String email) {
        this.nombreEspectaculo = nombreEspectaculo;
        this.fecha = fecha;
        this.email = email;
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
@Override
public String toString() {
    return "Entrada [nombreEspectaculo=" + nombreEspectaculo + ", fecha=" + fecha + ", email=" + email
            + ", contrasenia=" + contrasenia + ", cantidadEntradas=" + cantidadEntradas + "]";
}
}
