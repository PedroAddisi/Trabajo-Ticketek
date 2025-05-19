package ar.edu.ungs.prog2.ticketek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Usuario {
    private String Nombre;
    private String Email;
    private String Contraseña;
    private String Apellido;
   // private List <Entrada> Entradas;//Cambiarlo por lo de abajo..
    private HashMap <Integer, IEntrada> entradas = new HashMap<>();
    public HashMap<Integer, IEntrada> getEntradas() {
        return entradas;
    }
    public Usuario(String Email, String Nombre, String Apellido, String Contraseña) {
        Email=this.Email;
        Nombre=this.Nombre;
        Apellido=this.Apellido;
        Contraseña=this.Contraseña;
    }
    public void agregarentrada(Entrada entrada){
        entradas.put(entrada.getCodigodeentrada(),entrada);    
         }    
    public String getNombre() {
        return Nombre;
    }
    public String getEmail() {
        return Email;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public String getApellido() {
        return Apellido;
    }
}

