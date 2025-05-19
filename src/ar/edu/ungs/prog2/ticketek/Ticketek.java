package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;

public class Ticketek implements ITicketek{
 HashMap <String, Usuario> listaUsuarios = new HashMap<>();
 List <Espectaculo> Listaespectaculos = new ArrayList<>();
    LinkedList<sede>Listasede = new LinkedList<>();
   public void registrarSede(String nombre, String direccion, int capacidadMaxima){// es para estadios
    if (capacidadMaxima < 0 || nombre.length() < 0 || direccion.length() <0 ) {
        throw new RuntimeException("Error al colocar los datos.");
    }
    sede sede = new Estadio(nombre,direccion,capacidadMaxima);
    if (Listasede.contains(sede)) {
      throw new RuntimeException("Estadio ya regitrado");
    }
    else{
      Listasede.add(sede);
    }
   }
  public  void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional){//Falta colocar el tema de filas y sectores
    if (capacidadMaxima < 0 || nombre.length() < 0 || direccion.length() <0 ) {
        throw new RuntimeException("Error al colocar los datos.");
    }
    sede sede = new Teatro(nombre,direccion,capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional);
    if (Listasede.contains(sede)) {
      throw new RuntimeException("Teatro ya regitrado");
      
    }
    else{
      Listasede.add(sede);
    }
  }
   public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional){//Falta colocar el tema de filas y sectores
    if (capacidadMaxima < 0 || nombre.length() < 0 || direccion.length() <0 ) {
        throw new RuntimeException("Error al colocar los datos.");
    }
    sede sede = new Miniestadio(nombre,direccion,capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectores, capacidad, porcentajeAdicional);
    if (Listasede.contains(sede)) {
      throw new RuntimeException("Miniestadio ya regitrado");
      
    }
    else{
      Listasede.add(sede);
    }
   }
   public void registrarUsuario(String email, String nombre, String apellido, String contrasenia){
    if (contrasenia.length() < 0 || nombre.length() < 0 || apellido.length() <0  || email.length()<0 ) {
        throw new RuntimeException("Error al colocar los datos.");
    }
    Usuario usuario = new Usuario(email, nombre, apellido, contrasenia);
    if (listaUsuarios.containsKey(usuario.getEmail())){
      throw new RuntimeException(" Emial Ya registrado");
    }
    listaUsuarios.put(email, usuario);
  }
    public void registrarEspectaculo(String nombre){
        if (nombre.length()<0) {
            throw new RuntimeException ("el nombre no puede ser vacio");
        }
        Espectaculo espectaculo = new Espectaculo(nombre);
        if (Listaespectaculos.contains(espectaculo.getNombre())) {
        throw new RuntimeException("Espectaculo ya registrada"); 
        } 
        else{
        Listaespectaculos.add(espectaculo);  
    }
    }
    public  void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
         LocalDate fechadate= LocalDate.parse(fecha, formatter);
        if (!Listaespectaculos.contains(nombreEspectaculo) || !Listasede.contains(sede) || precioBase < 0) {
            throw new RuntimeException ("Error al colocar datos");
        }
        Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
        for (Espectaculo espectaculo : Listaespectaculos) {
        if (espectaculo.getNombre()==funcion.getNombreEspectaculo()) {// aca debo cambiar por .date
            espectaculo.cargarfunciones(funcion); 
        }
        else{
        throw new RuntimeException("no se pudo encontrar espectaculo");
        }
    }
    }
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas){//para estadio
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
         LocalDate fechadate= LocalDate.parse(fecha, formatter);
               if (!Listaespectaculos.contains(nombreEspectaculo) || !listaUsuarios.containsKey(email)/*  si la sede de funcion esta numerada*/ ) {
            throw new RuntimeException("error con algunos de los datos de espectaculo,usaurio o la funcion no trasncurre en un estadio ");
        }
        List <IEntrada> entradascompradas= new ArrayList<>();
        if (listaUsuarios.get(email).getContraseña() == contrasenia) {
            for (int i = 0; i >= cantidadEntradas; i++) {
                Entrada entrada= new Entrada(nombreEspectaculo , fechadate , email,Generarcodigodeentrada());
                listaUsuarios.get(email).agregarentrada(entrada);
                entradascompradas.add(entrada);
            }
            for (Espectaculo espectaculo : Listaespectaculos) {
                if (espectaculo.getNombre() ==nombreEspectaculo) {
                    for (Funcion funcion : espectaculo.listaFunciones) {
                    funcion.getSede().cantidaddeentrdasvendidas(cantidadEntradas);
                    funcion.getSede().quitarcapacidad(cantidadEntradas);
                }               
                }    
            }
        }
        else{
            throw new RuntimeException("Contraseña incorrecta");
        }
        return entradascompradas; 
        }
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos){// agregar sector y entradas
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
         LocalDate fechadate= LocalDate.parse(fecha, formatter);
        if (!Listaespectaculos.contains(nombreEspectaculo) || !listaUsuarios.containsKey(email) /*si la sede de funcion esta numerada*/ ) {
            throw new RuntimeException("error con algunos de los datos de espectaculo,usaurio o la funcion trasncurre en un estadio ");
        }
        List <IEntrada> entradascompradas= new ArrayList<>();
        if (listaUsuarios.get(email).getContraseña() == contrasenia) {
                Entrada entrada= new Entrada(nombreEspectaculo, fechadate , email, Generarcodigodeentrada());
                listaUsuarios.get(email).agregarentrada(entrada);
                entradascompradas.add(entrada);
                //tengo que entrar a teatro o miniestadio agarrar y reservar la cantidad de asientos pedidas.
                //seria el quitar entrada de aca.
                return entradascompradas;
            }
        else{
            throw new RuntimeException("Contraseña incorrecta");
        }    
    }
    
    public String listarFunciones(String nombreEspectaculo){
        for (Espectaculo espectaculo : Listaespectaculos) {
            if (espectaculo.getNombre() == nombreEspectaculo) {
                for (Funcion funcion : espectaculo.getListaFunciones()) {
                 funcion.toString();   
                }
            }
            else{
                throw new RuntimeException("Espectaculo no encontrado");
            }  
        }
        return "Funciones de" + nombreEspectaculo;
    }
    public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo){
        if (nombreEspectaculo.length()<0) {
             throw new RuntimeException("El nombre del espectaculo no puede ser vacio");
        }
        List <IEntrada> entradasdelEspectaculo= new ArrayList<>();
        for (Entry<String, Usuario> usuario : listaUsuarios.entrySet()) { //el entry se utiliza para entrar al hashmap por medio foreach y el entry set lo hace posible
            for (Entrada entrada : usuario.getValue().getEntradas()) {/Ver recorrido de entradas
                if (entrada.getNombreEspectaculo()== nombreEspectaculo) {
                    entradasdelEspectaculo.add(entrada);
                }        
            }  
        }
        return entradasdelEspectaculo;
    }
    public  List<IEntrada> listarEntradasFuturas(String email, String contrasenia){
        List <IEntrada> entradasfuturas= new ArrayList<>();
        if( listaUsuarios.get(email).getContraseña() == contrasenia){
            for (Entrada entradas : listaUsuarios.get(email).getEntradas()) {/Ver recorrido de entradas
                if (entradas.getFecha().isAfter(LocalDate.now())) {
                    entradasfuturas.add(entradas);
                }
                else{
                throw new RuntimeException ("no tiene entradas futuras");
            } 
            }
            } 
        else{
            throw new RuntimeException("Contraseña incorrecta");
        }
        return entradasfuturas;
    }
    public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia){
        List <IEntrada> entradasTodas= new ArrayList<>();
        if(listaUsuarios.get(email).getContraseña()==contrasenia){
               for (Entrada entradas : listaUsuarios.get(email).getEntradas()) {/Ver recorrido de entradas
                    entradasTodas.add(entradas);
                }
        }
        else{
            throw new RuntimeException("El usuario no tiene entradas compradas");
        }
        return entradasTodas;
    }
    public  boolean anularEntrada(IEntrada entrada, String contrasenia){

        return false;
    }
    public IEntrada cambiarEntrada( IEntrada entrada, String contrasenia, String fecha, String sector, int asiento){//ver tema sector y asiento
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
         LocalDate fechadate= LocalDate.parse(fecha, formatter);
        return entrada;
    }
    public  IEntrada cambiarEntrada( IEntrada entrada, String contrasenia, String fecha){
        return entrada;
        
    }
    public  double costoEntrada(String nombreEspectaculo, String fecha){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
         LocalDate fechadate= LocalDate.parse(fecha, formatter);
        double costo =0;
        for (Espectaculo espectaculo : Listaespectaculos) {
            if (espectaculo.getNombre() == nombreEspectaculo) {
                for (Funcion funcion : espectaculo.listaFunciones) {
                    if (funcion.getFecha().equals(fechadate)) {
                        costo= funcion.getPrecioBase();
                    } 
                } 
            }
        }
        return costo;
         }

    public double costoEntrada(String nombreEspectaculo, String fecha, String sector){// ver tema sector
         DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
         LocalDate fechadate= LocalDate.parse(fecha, formatter);
        for (Espectaculo espectaculo : Listaespectaculos) {
            if (espectaculo.getNombre() == nombreEspectaculo) {
                for (Funcion funcion : espectaculo.listaFunciones) {
                    if (funcion.getFecha().equals(fechadate)) {
                        return funcion.getPrecioBase();//se debe sumar el cargo de sector 
                    } 
                } 
            }
        }    
     throw new RuntimeException ("Espectaculo no encontrado");
    }
    public double totalRecaudado(String nombreEspectaculo){
        Double preciototak =0.0;
        for (Entry<String, Usuario> usuario : listaUsuarios.entrySet()) { //el entry se utiliza para entrar al hashmap por medio foreach y el entry set lo hace posible
            for (Entrada entrada : usuario.getValue().getEntradas()) {//Ver recorrido de entradas
                if (entrada.getNombreEspectaculo() == nombreEspectaculo) {
                    preciototak =preciototak+ entrada.precio();
                    
                }   
    }
}
    return preciototak;
    }
    public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede){// era en o de 1 
        double totalrecaudado=0;
            for (Espectaculo espectaculo : Listaespectaculos) {
            for (Funcion funcion : espectaculo.listaFunciones) {
                if ((funcion.nombregetSede() == nombreSede)&& nombreSede == "Estadio" && funcion.getNombreEspectaculo() == nombreEspectaculo) {
                    totalrecaudado=+funcion.getSede().getCapacidad()*funcion.getPrecioBase();
                
            }
        }   
    }
    return totalrecaudado;
}
 public int Generarcodigodeentrada() {   
    Random random = new Random();
        return random.nextInt(9000) + 1000;
}
    }