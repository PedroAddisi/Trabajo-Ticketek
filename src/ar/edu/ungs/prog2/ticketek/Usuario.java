package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;

public class Usuario {
    private String Nombre;
    private String email;
    private String contraseña;
    private String apellido;
    private ArrayList <Entrada> Entradas;
    public Usuario(String email2, String nombre2, String apellido2, String contrasenia) {
    }
    public void usuariocomproentrada(int numerodeasiento, int codigoespectaculo, String sede){
    }
    public ArrayList<Entrada> verentradasproximas(){
        return Entradas;
        
    }
    public ArrayList<Entrada> vertodaslaseEntradas(){
        return Entradas;
        
    }
    public void anularentradas(int codigodeentrada){

    }
}
