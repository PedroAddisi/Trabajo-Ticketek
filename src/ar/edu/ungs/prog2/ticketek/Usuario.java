package ar.edu.ungs.prog2.ticketek;
import java.util.HashMap;
public class Usuario {
    private String Nombre;
    private String Email;
    private String Contraseña;
    private String Apellido;
    private HashMap <Integer, IEntrada> entradas = new HashMap<>();
    public HashMap<Integer, IEntrada> getEntradas() {
        return entradas;
    }
    public Usuario(String Email, String Nombre, String Apellido, String Contraseña) {
        this.Email=Email;
        this.Nombre=Nombre;
        this.Apellido=Apellido;
        this.Contraseña=Contraseña;


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

