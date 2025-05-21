package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
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
LinkedList<Sedes>Listasede = new LinkedList<>();
@Override
public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
if (capacidadMaxima < 0 || nombre.length() < 0 || direccion.length() <0 ) {
  throw new RuntimeException("Error al colocar los datos de sede nombre direccion o entrada");
}
Sedes sede = new Estadio(nombre,direccion,capacidadMaxima);
Agregarsede(sede);
}
@Override
public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
if (capacidadMaxima < 0 || nombre.length() < 0 || direccion.length() <0 ) {
    throw new RuntimeException("Error al colocar los datos de sede nombre direccion o entrada");

}
Sedes sede = new Teatro(nombre,direccion,capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional);
Agregarsede(sede);
}
@Override
public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
if (capacidadMaxima < 0 || nombre.length() < 0 || direccion.length() <0 ) {//falta tema asientos y filas
  throw new RuntimeException("Error al colocar los datos de sede nombre direccion o entrada");

}
Sedes sede = new Teatro(nombre,direccion,capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional);
Agregarsede(sede);
}
private void Agregarsede(Sedes sede1) {
for (Sedes sede2 : Listasede) {
  if (sede2.getNombre().equals(sede1.getNombre())) {
  throw new RuntimeException("Sede ya  registrada");
  }
  else{ 

  }  
}
Listasede.add(sede1);
}
@Override
public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
if (contrasenia.length() < 0 || nombre.length() < 0 || apellido.length() <0  || email.length()<0 ) {
  throw new RuntimeException("Error al colocar los datos de usuario email, nombre, apellido o contrasenia");
}
Usuario nuevousuario = new Usuario(email, nombre, apellido, contrasenia);
AgregarUsuario(email,nuevousuario);
}
private void AgregarUsuario(String email, Usuario usuario) {
if (listaUsuarios.containsKey(usuario.getEmail())){
  throw new RuntimeException(" Emial Ya registrado");
}
  listaUsuarios.put(email, usuario);
}
@Override
public void registrarEspectaculo(String nombre) {
  for (Espectaculo espectaculo : Listaespectaculos) {
    if (espectaculo.getNombre().equals(nombre)) {
      throw new RuntimeException ("el espectaculo ya esta registrado");
    }
  }
Espectaculo espectaculo = new Espectaculo(nombre); 
AgregarEspectaculo(nombre,espectaculo);
}
private void AgregarEspectaculo(String nombre,Espectaculo espectaculo) {
for (Espectaculo espectaculo1 : Listaespectaculos) {
  if (espectaculo1.getNombre() == espectaculo.getNombre()) {
    throw new RuntimeException("Espectaculo ya registrada"); 
  } 
  else{
  }  
}
Listaespectaculos.add(espectaculo);
}
@Override
public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
Verificardatosdefuncion1(nombreEspectaculo,sede,precioBase);
Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
verificarfechafuncion(fecha);
CargarFuncion(funcion);
  }
private void verificarfechafuncion(String fecha) {
  for (Espectaculo espectaculo : Listaespectaculos) {
  for (Funcion funcion1 : espectaculo.listaFunciones) {
    if (funcion1.getFechaString().equals(fecha)) {
      throw new RuntimeException("Ya existe una funcion en esta fehca");
    }
  }
}
}
private void Verificardatosdefuncion1(String nombreespectaculo,String sede, double precioBase) {
  if(nombreespectaculo.length()<0){
    throw new RuntimeException ("Error al colocar datos");
    }
    if (sede.length()<0) {
      throw new RuntimeException ("Error al colocar datos");
    }
  if (precioBase< 0) {
    throw new RuntimeException ("Error al colocar datos");
  }
}
private void CargarFuncion(Funcion funcion) {
for (Espectaculo espectaculo : Listaespectaculos) {
  if (espectaculo.getNombre().equals(funcion.getNombreEspectaculo())) {
    espectaculo.cargarfunciones(funcion); 
  }
  else{
  }
}
}
@Override
public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,int cantidadEntradas) {
        return null;
    // TODO Auto-generated method stub

  }
  @Override
  public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,
      String sector, int[] asientos) {
        return null;
    // TODO Auto-generated method stub
  }
  @Override
  public String listarFunciones(String nombreEspectaculo) {
    return nombreEspectaculo;
    // TODO Auto-generated method stub
  }
  @Override
  public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
    return null;
  }
  @Override
  public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
    return null;
  }
  @Override
  public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
    return null;
  }
  @Override
  public boolean anularEntrada(IEntrada entrada, String contrasenia) {
    return false;
    // TODO Auto-generated method stub
  }
  @Override
  public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
    return entrada;
    // TODO Auto-generated method stub
  }
  @Override
  public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
    return entrada;
    // TODO Auto-generated method stub
  }
  @Override
  public double costoEntrada(String nombreEspectaculo, String fecha) {
    return 0;
  }
  @Override
  public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
    return 0;
    // TODO Auto-generated method stub
  }
  @Override
  public double totalRecaudado(String nombreEspectaculo) {
    return 0;
    // TODO Auto-generated method stub
  }
  @Override
  public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
    return 0;
    // TODO Auto-generated method stub);
  }
}