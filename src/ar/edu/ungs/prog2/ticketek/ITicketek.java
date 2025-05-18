package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class ITicketek {
 HashMap <String, Usuario> listaUsuarios = new HashMap<>();
    LinkedList<Espectaculo> Listaespectaculos = new LinkedList<>();
    LinkedList<sede>Listasede = new LinkedList<>();
    HashMap <Integer, IEntrada> listaEntradas = new HashMap<>();
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
   public void registrarUsuario(String email, String nombre, String apellido, String contrasenia){
        Usuario usuario = new Usuario(email, nombre, apellido, contrasenia);
    if (listaUsuarios.containsKey(usuario.getEmail())){
      throw new RuntimeException(" Emial Ya registrado");// agregar mas exception de tipo de datos;
    }
    else{
    listaUsuarios.put(email, usuario);
  }

    }
    public void registrarEspectaculo(String nombre){
        Espectaculo espectaculo = new Espectaculo(nombre);
        if (Listaespectaculos.contains(espectaculo.getNombre())) {// aca ver puede ser que tire error al compilar
        throw new RuntimeException("Espectaculo ya registrada"); 
        } 
        else{
        Listaespectaculos.add(espectaculo);  
    }
    }
    public  void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
        for (Espectaculo espectaculo : Listaespectaculos) {
        if (espectaculo.getNombre()==funcion.getNombreEspectaculo()) {
            espectaculo.cargarfunciones(funcion); 
        }
        else{
        throw new RuntimeException("Digo algo");// Aca tengo que agregar mas exeptions 
        }
    }
    }
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas){//para estadios
        List <IEntrada> entradascompradas= new ArrayList<>();
        if (listaUsuarios.get(email).getContraseña() == contrasenia) {// seria asi ver el tema de los datos de entrada. ver de pasar los parametros dados.
            for (int i = 0; i >= cantidadEntradas; i++) {
                IEntrada entrada= new IEntrada();
                listaUsuarios.get(email).agregarentrada(entrada);
                entradascompradas.add(entrada);
            }
        }
        else{
            throw new RuntimeException("Contraseña incorrecta");
        }
        return entradascompradas; 
        }
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos){
        return null;
        
    }
    
    public String listarFunciones(String nombreEspectaculo){
        if (Listaespectaculos.contains(nombreEspectaculo)) {
            for (Espectaculo espectaculo : Listaespectaculos) {
               espectaculo.listaFunciones.toString();  
            }
            return "funciones de "+nombreEspectaculo;
            //Ahora tengo que entrar a la lista de espectaculos. entrar a las funciones y tirar el tostring
            
        }
        else{
            throw new RuntimeException("Espectaculo no encontrado");
        }
    }
    public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo){
        return null;
        
    }
    public  List<IEntrada> listarEntradasFuturas(String email, String contrasenia){
        if( listaUsuarios.get(email).getContraseña() == contrasenia){
            listaUsuarios.get(email).imprimirentradas();//hacer funcion que imprima las entradas del usuario;
                
            }
        }
        else{
            throw new RuntimeException("Contraseña incorrecta");
        }

    }

    public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia){
        if(listaUsuarios.get(email).getContraseña()==contrasenia){
            return listaUsuarios.get(email).getEntradas();
        }
        else{
            throw new RuntimeException("El usuario no tiene entradas compradas");
        }
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