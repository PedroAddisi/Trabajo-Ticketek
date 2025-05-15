package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Ticketek {
    HashMap <String, Usuario> listaUsuarios = new HashMap<>();
    LinkedList<sede>    Listasede = new LinkedList<>();
   public void registrarSede(String nombre, String direccion, int capacidadMaxima){
   // sede Sede = new sede(nombre, direccion, capacidadMaxima);
   }
  public  void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional){

  }
   public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional){

   }
 
   public void registrarUsuario(String email, String nombre, String apellido, String contrasenia){
    Usuario usuario = new Usuario(email, nombre, apellido, contrasenia);
    listaUsuarios.put(email, usuario);

   }
   public void registrarEspectaculo(String nombre){

   }
  public  void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase){

   }
   public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas){
    return null;
    
   }
  public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos){
    return null;
    
  }
   
   public String listarFunciones(String nombreEspectaculo){
    return nombreEspectaculo;

   }
   public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo){
    return null;
    
   }
  public  List<IEntrada> listarEntradasFuturas(String email, String contrasenia){
    return null;
  }

   public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia){
    return null;
    
   }
  public  boolean anularEntrada(IEntrada entrada, String contrasenia){
    return false;
    
  }
  public IEntrada cambiarEntrada( IEntrada entrada, String contrasenia, String fecha, String sector, int asiento){
    return entrada;

   }
  public  IEntrada cambiarEntrada( IEntrada entrada, String contrasenia, String fecha){
    return entrada;
    
  }
  public  double costoEntrada(String nombreEspectaculo, String fecha){
    return 0;
  }

   public double costoEntrada(String nombreEspectaculo, String fecha, String sector){
    return 0;
    
   }
   public double totalRecaudado(String nombreEspectaculo){
    return 0;
    
   }
   public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede){
    return 0;
    
   }

}