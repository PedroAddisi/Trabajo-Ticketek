package ar.edu.ungs.prog2.ticketek;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ITicketek {
 HashMap <String, Usuario> listaUsuarios = new HashMap<>();
    LinkedList<Espectaculo> Listaespectaculos = new LinkedList<>();
    LinkedList<sede>Listasede = new LinkedList<>();
    List<IEntrada> entrdas;
   public void registrarSede(String nombre, String direccion, int capacidadMaxima){
    sede sede = new Estadio(nombre,direccion,capacidadMaxima);
    if (Listasede.contains(sede)) {
      throw new RuntimeException("Estadio ya regitrado");// agregar mas exception de tipo de datos;
      
    }
    else{
      Listasede.add(sede);
    }
   }
  public  void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional){
    sede sede = new Teatro(nombre,direccion,capacidadMaxima, asientosPorFila, sectores, porcentajeAdicional, porcentajeAdicional);
    if (Listasede.contains(sede)) {
      throw new RuntimeException("Teatro ya regitrado");// agregar mas exception de tipo de datos;
      
    }
    else{
      Listasede.add(sede);
    }
  }
   public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional){
    sede sede = new Miniestadio(nombre,direccion,capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectores, porcentajeAdicional, porcentajeAdicional);
    if (Listasede.contains(sede)) {
      throw new RuntimeException("Miniestadio ya regitrado");// agregar mas exception de tipo de datos;
      
    }
    else{
      Listasede.add(sede);
    }
   }
   public void registrarUsuario(String email, String nombre, String apellido, int contrasenia){
        Usuario usuario = new Usuario(email, nombre, apellido, contrasenia);
    if (listaUsuarios.containsKey(usuario.getEmail())){
      throw new RuntimeException(" Emial Ya registrado");// agregar mas exception de tipo de datos;
    }
    else{
    listaUsuarios.put(email, usuario);
  }

    }/* 
    public void registrarEspectaculo(String nombre){
        if (Listaespectaculos.contains(nombre)) {// aca ver puede ser que tire error al compilar
        throw new RuntimeException("Espectaculo ya registrada"); 
        } 
        else{
        Espectaculo espectaculo = new Espectaculo(nombre);
        Listaespectaculos.add(espectaculo);  
    }
    }
    public  void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
        for (Espectaculo espectaculo : Listaespectaculos) {
        if (espectaculo.getNombre()==funcion.getNombreEspectaculo()) {
            espectaculo.cargarfunciones(funcion); 
        }
        throw new RuntimeException("Digo algo");// Aca tengo que agregar mas exeptions 
        }
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
        */
   public void registrarUsuario(String email, String nombre, String apellido, String string) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'registrarUsuario'");
   }
}