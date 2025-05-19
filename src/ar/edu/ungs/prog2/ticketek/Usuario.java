package ar.edu.ungs.prog2.ticketek;
import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String Nombre;
    private String Email;
    private String Contraseña;
    private String Apellido;
    private List <IEntrada> Entradas;
    public Usuario(String Email, String Nombre, String Apellido, String Contraseña) {
        Email=this.Email;
        Nombre=this.Nombre;
        Apellido=this.Apellido;
        Contraseña=this.Contraseña;
    }
    public void usuariocomproentrada(int numerodeasiento, int codigoespectaculo, String sede){
    }
    public void verentradasproximas()  {
        }      
    public void vertodaslaseEntradas(){
         }
    public void agregarentrada(Entrada entrada){
        Entradas.add(entrada);    
         }    
    public void anularentradas(int codigodeentrada){

    }
    public String getNombre() {
        return Nombre;
    }
    public void setNombre(String nombre) {
        Nombre = nombre;
    }
    public String getEmail() {
        return Email;
    }
    public void setEmail(String email) {
        Email = email;
    }
    public String getContraseña() {
        return Contraseña;
    }
    public void setContraseña(String contraseña) {
        Contraseña = contraseña;
    }
    public String getApellido() {
        return Apellido;
    }
    public void setApellido(String apellido) {
        Apellido = apellido;
    }
    public List<IEntrada> getEntradas() {
        return Entradas;
    }
    public void setEntradas(ArrayList<IEntrada> entradas) {
        Entradas = entradas;
    }
}

