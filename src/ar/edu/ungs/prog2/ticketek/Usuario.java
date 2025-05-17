package ar.edu.ungs.prog2.ticketek;

import java.time.*;
import java.util.ArrayList;

public class Usuario {
    private String Nombre;
    private String Email;
    private String Contraseña;
    private String Apellido;
    private ArrayList <Entrada> Entradas;
    public Usuario(String Email, String Nombre, String Apellido, String Contraseña) {
        Email=this.Email;
        Nombre=this.Nombre;
        Apellido=this.Apellido;
        Contraseña=this.Contraseña;

    }
    public void usuariocomproentrada(int numerodeasiento, int codigoespectaculo, String sede){
    }
    public void verentradasproximas() throws Exception {
        for (Entrada entrada : Entradas) {
            LocalDate fechaactual  = LocalDate.now();
            if (entrada.getFecha().isAfter(fechaactual)) {
                System.out.print(entrada);
            }
            else{
                throw new Exception("No se encontraron entradas posteirores a la fecha actual");    
                   }     
        }      
    }
    public void vertodaslaseEntradas() throws Exception{
            if (Entradas.isEmpty()){
                throw new Exception("No se encontraron entradas posteirores a la fecha actual");
            } 
            else{
                 for (Entrada entrada : Entradas) {
                    System.out.print(entrada);
            }
         }    
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
    public ArrayList<Entrada> getEntradas() {
        return Entradas;
    }
    public void setEntradas(ArrayList<Entrada> entradas) {
        Entradas = entradas;
    }
}

