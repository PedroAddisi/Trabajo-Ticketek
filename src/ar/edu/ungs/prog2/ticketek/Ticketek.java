package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.chrono.ChronoLocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
Sedes sede = new Miniestadio(nombre,direccion,capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectores, capacidad, porcentajeAdicional);
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
public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase){
Verificardatosdefuncion1(nombreEspectaculo,sede,precioBase);
Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
verificarfechafuncion(fecha , sede);
CargarFuncion(funcion);
  }
private void verificarfechafuncion(String fecha, String sede) {
  for (Espectaculo espectaculo : Listaespectaculos) {
  for (Funcion funcion1 : espectaculo.listaFunciones) {
    if (funcion1.getFechastring().equals(fecha) && funcion1.getSede().equals(sede)) {// 
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
  if (nombreEspectaculo.length()<0 || email.length()<0 || cantidadEntradas <0) {// si la sede de funcion esta numerada
    throw new RuntimeException("error con algunos de los datos de espectaculo,usaurio o la funcion no trasncurre en un estadio ");
  }
  List <IEntrada> entradascompradas= new ArrayList<>(cantidadEntradas);
  AgregarentradaCampo(email,contrasenia,cantidadEntradas,nombreEspectaculo,fecha,entradascompradas);
    return entradascompradas; 
  }
  private double obtenerpreciodeentrada(String nombreEspectaculo, LocalDate fecha) {
    for (Espectaculo espectaculo : Listaespectaculos) {
    if (espectaculo.getNombre().equals(nombreEspectaculo)) {
      for (Funcion funcion : espectaculo.listaFunciones) {
        if (funcion.getFecha().equals(fecha)) {
          return funcion.getPrecioBase();
        }
      }
    }
  }
  throw new RuntimeException("Función no encontrada para ese espectáculo en esa fecha.");
  }
  private void AgregarentradaCampo(String email,String contrasenia, int cantidadEntradas, String nombreEspectaculo, String fecha, List<IEntrada> entradascompradas) {
  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
  LocalDate fechadate= LocalDate.parse(fecha, formatter);
  double precio = obtenerpreciodeentrada(nombreEspectaculo,fechadate);
    if (listaUsuarios.get(email).getContraseña().equals(contrasenia)) {
    for (int i = 0; i < cantidadEntradas; i++) {
      Entrada entrada= new Entrada(nombreEspectaculo , fechadate , email,"Campo", precio);
      entradascompradas.add(entrada);
      listaUsuarios.get(email).agregarentrada(entrada);
    }
  }
  else{
    throw new RuntimeException("Contraseña incorrecta");
    }
}
  @Override
public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,String sector, int[] asientos) {
   if (nombreEspectaculo.length()<0 || email.length()<0|| asientos==null) {// si la sede de funcion esta numerada
    throw new RuntimeException("error con algunos de los datos de espectaculo,usaurio o la funcion no trasncurre en un estadio ");
  }
  List <IEntrada> entradascompradas= new ArrayList<>();
  Agregarentradateatro(nombreEspectaculo,fecha,email,contrasenia,sector,asientos,entradascompradas);
  return entradascompradas;
}
  private void Agregarentradateatro(String nombreEspectaculo, String fecha, String email, String contrasenia,String sector, int[] asientos, List<IEntrada> entradascompradas) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
  LocalDate fechadate= LocalDate.parse(fecha, formatter);
    if (listaUsuarios.get(email).getContraseña().equals(contrasenia)) {
      for (int i = 0; i < asientos.length; i++) {
        Entrada entrada = new Entrada(nombreEspectaculo,fechadate, email, sector,0);
        listaUsuarios.get(email).agregarentrada(entrada);
        entradascompradas.add(entrada);
        //Falte el reservar sector.
      } 
    }
    else{
    throw new RuntimeException("Contraseña incorrecta");
    }
  }
  @Override
public String listarFunciones(String nombreEspectaculo) {
  for (Espectaculo espectaculo : Listaespectaculos) {
    if (espectaculo.getNombre() == nombreEspectaculo) {
      for (Funcion funcion : espectaculo.getListaFunciones()) {
        for (Sedes sede : Listasede) {
          if (sede.getNombre().equals(funcion.getSede())) {
            funcion.toString();
          }
          
        }
      }
    }
    else{
    return "El espectaculo no tiene funciones";
  }  
}
return "Funciones de" + nombreEspectaculo;
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
    if (entrada == null || contrasenia == null || !listaUsuarios.containsKey(entrada.getEmail())) {
        throw new RuntimeException("Datos inválidos");
    }
    Usuario usuario = listaUsuarios.get(entrada.getEmail());
    if (!usuario.getContraseña().equals(contrasenia)) {
        throw new RuntimeException("Contraseña incorrecta");
    }

    if (entrada.getFecha().isBefore(LocalDate.now())) {
        return false; // la entrada ya expiró
    }
    
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