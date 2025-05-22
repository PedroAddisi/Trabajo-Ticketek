package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
public class Ticketek implements ITicketek{
  //Parametros Necesarios
HashMap <String, Usuario> listaUsuarios = new HashMap<>();
List <Espectaculo> Listaespectaculos = new ArrayList<>();
LinkedList<Sedes>Listasede = new LinkedList<>();
//
//Regristrar Sede
@Override
public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
if (capacidadMaxima < 0 || nombre.isEmpty() || direccion.isEmpty() ) {
  throw new RuntimeException("Error al colocar los datos de sede nombre direccion o entrada al registrar sede");
}
Sedes sede = new Estadio(nombre,direccion,capacidadMaxima,"Estadio");
Agregarsede(sede);
}
@Override
public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
if (capacidadMaxima < 0 || nombre.isEmpty() || direccion.isEmpty()) {
    throw new RuntimeException("Error al colocar los datos de sede nombre direccion o entrada al registrar sede");
}
Sedes sede = new Teatro(nombre,direccion,capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional,"Teatro");
Agregarsede(sede);
sede.generarAsientos();
}
@Override
public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila,int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
if (capacidadMaxima < 0 || nombre.isEmpty() || direccion.isEmpty()) {
  throw new RuntimeException("Error al colocar los datos de sede nombre direccion o entrada al registrar sede");
}
Sedes sede = new Miniestadio(nombre,direccion,capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectores, capacidad, porcentajeAdicional,"Miniestadio");
Agregarsede(sede);
sede.generarAsientos();
}
private void Agregarsede(Sedes sede1) {
for (Sedes sede2 : Listasede) {
  if (sede2.getNombre().equals(sede1.getNombre())) {
  throw new RuntimeException("Sede ya  registrada");
  } 
}
Listasede.add(sede1);
}
//
//Registrar Usuario
@Override
public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
if (contrasenia.isEmpty()|| nombre.isEmpty() || apellido.isEmpty() || email.isEmpty()) {
  throw new RuntimeException("Error al colocar los datos de usuario email, nombre, apellido o contrasenia al registrar usuario");
}
Usuario nuevousuario = new Usuario(email, nombre, apellido, contrasenia);
AgregarUsuario(email,nuevousuario);
}
private void AgregarUsuario(String email, Usuario usuario) {
if (listaUsuarios.containsKey(usuario.getEmail())){
  throw new RuntimeException("Emial Ya registrado");
}
listaUsuarios.put(email, usuario);
}
@Override
//
//Registrar Espectaculo
public void registrarEspectaculo(String nombre) {
Espectaculo espectaculo = new Espectaculo(nombre); 
AgregarEspectaculo(nombre,espectaculo);
}
private void AgregarEspectaculo(String nombre,Espectaculo espectaculo) {
for (Espectaculo espectaculo1 : Listaespectaculos) {
  if (espectaculo1.getNombre() == espectaculo.getNombre()) {
    throw new RuntimeException("Espectaculo ya registrado"); 
  }  
}
Listaespectaculos.add(espectaculo);
}
@Override
//
//Agregar Funcion
public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase){
Verificardatosdefuncion1(nombreEspectaculo,sede,precioBase);
Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
verificarfechafuncion(nombreEspectaculo ,fecha , sede, funcion);
AgregarSedeAfuncion(funcion , sede);
CargarFuncion(funcion);
  }
private void AgregarSedeAfuncion(Funcion funcion,String sede) {
  for (Sedes sede1 :Listasede) {
    if (sede1.nombre.equals(sede)) {
      funcion.getMapasede().put(sede, sede1);
    }
    }
  }
private void verificarfechafuncion(String nombreEspectaculo,String fecha, String sede, Funcion funcion) {
   for (Espectaculo espectaculo : Listaespectaculos) {
  for (Funcion funcion1 : espectaculo.listaFunciones) {
    if (funcion1.getFechastring().equals(fecha) && funcion1.getSede().equals(sede)) {// 
      throw new RuntimeException("Ya existe una funcion en esta fecha");
    }
  }
}
}
private void Verificardatosdefuncion1(String nombreespectaculo,String sede, double precioBase) {
  if(nombreespectaculo.isEmpty()){
    throw new RuntimeException ("Error al colocar datos de nombre ");
    }
    if (sede.isEmpty()) {
      throw new RuntimeException ("Error al colocar datos de sede");
    }
  if (precioBase < 0) {
    throw new RuntimeException ("Error al colocar datos de precio");
  }
}
private void CargarFuncion(Funcion funcion) {
for (Espectaculo espectaculo : Listaespectaculos) {
  if (espectaculo.getNombre().equals(funcion.getNombreEspectaculo())) {
    espectaculo.cargarfunciones(funcion); 
  }
}
}
//
//Vender Entradas
@Override
public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia,int cantidadEntradas) {
  if (nombreEspectaculo.isEmpty() || email.isEmpty() || cantidadEntradas < 0) {
    throw new RuntimeException("error con algunos de los datos de espectaculo,usaurio o la funcion no trasncurre en un estadio ");
  }
  List <IEntrada> entradascompradas= new ArrayList<>(cantidadEntradas);
  AgregarentradaCampo(email,contrasenia,cantidadEntradas,nombreEspectaculo,fecha,entradascompradas);
  DescontarcantdeentradasCampo(nombreEspectaculo,fecha,cantidadEntradas);
    return entradascompradas; 
  }
  private void DescontarcantdeentradasCampo(String nombreEspectaculo, String fecha, int cantidadEntradas) {
    for (Espectaculo espectaculo : Listaespectaculos) {
      for (Funcion funcion : espectaculo.listaFunciones) {
        for (int i = 0; i <cantidadEntradas; i++) {
          funcion.getMapasede().get(funcion.getSede()).capacidadMaxima =- 1;
          funcion.guardarrecaudado(cantidadEntradas,funcion.getSede()); 
        } 
      }
    }
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
    LocalDate fechadate= obtenerfecha(fecha);
  double precio = obtenerpreciodeentrada(nombreEspectaculo,fechadate);
    if (listaUsuarios.get(email).getContraseña().equals(contrasenia)) {
    for (int i = 0; i < cantidadEntradas; i++) {
      Entrada entrada= new Entrada(nombreEspectaculo , fechadate , email,"Campo", precio);
      entradascompradas.add(entrada);
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
  ReservaryCalcularcosto(nombreEspectaculo,fecha,email,contrasenia,sector,asientos);
  return entradascompradas;
}
  private void ReservaryCalcularcosto(String nombreEspectaculo, String fecha, String email, String contrasenia,String sector, int[] asientos) {
    LocalDate fechaDate=obtenerfecha(fecha);
     for (Espectaculo espectaculo : Listaespectaculos) {
    if (espectaculo.getNombre().equals(nombreEspectaculo)) {
      for (Funcion funcion : espectaculo.listaFunciones) {
        if (funcion.getFecha().equals(fechaDate)) {
          funcion.reservarasientos(asientos);
        }
      }
    }
  }
  }
  private void Agregarentradateatro(String nombreEspectaculo, String fecha, String email, String contrasenia,String sector, int[] asientos, List<IEntrada> entradascompradas) {
    LocalDate fechadate= obtenerfecha(fecha);
    if (listaUsuarios.get(email).getContraseña().equals(contrasenia)) {
      for (int i = 0; i < asientos.length; i++) {
        Entrada entrada = new Entrada(nombreEspectaculo,fechadate, email, sector,0);
        listaUsuarios.get(email).agregarentrada(entrada);
        entradascompradas.add(entrada);
      } 
    }
    else{
    throw new RuntimeException("Contraseña incorrecta");
    }
  }
  @Override
  //
  //Listar Funciones
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
//
//Listar Entradas Espectaculo
  @Override
  public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
    return null;
}
//
//Listar Entradas Futuras
  @Override
  public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
    return null;
  }
  //
  //Listar Entradas Usuario
  @Override
  public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
    return null;
  }
  //
  //Anular Entrada
  @Override
  public boolean anularEntrada(IEntrada entrada, String contrasenia) {
    return false;
  }
  //
  //Cambiar Entrada
  @Override
  public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
    return entrada;
  }
  @Override
  public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
    return entrada;
  }//
  //Costo Entrada
  @Override
  public double costoEntrada(String nombreEspectaculo, String fecha) {//En O(1)
    LocalDate fechDate= obtenerfecha(fecha);
    return obtenerpreciodeentrada(nombreEspectaculo,fechDate);
  }
  @Override
  public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {//En O(1)
    LocalDate fechaDate=obtenerfecha(fecha);
    double porcentajeAdicional=obtenerpreciodeentrada(nombreEspectaculo, fechaDate)*obtenerpreciosector(sector);
    return obtenerpreciodeentrada(nombreEspectaculo, fechaDate)+porcentajeAdicional;
  }
  //
  //Total Recaudado
  @Override
  public double totalRecaudado(String nombreEspectaculo) {
    return 0;
  }
  //
  //Total recaudado por sede
  @Override
  public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
    return 0;
    }
  //
  private LocalDate obtenerfecha(String fecha){
     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
  LocalDate fechadate= LocalDate.parse(fecha, formatter);
  return fechadate;
  }
  private double obtenerpreciosector(String sector) {
  String normalizado = sector.toLowerCase().replace("á", "a").replace("é", "e").replace("í", "i").replace("ó", "o").replace("ú", "u");

  switch (normalizado) {
      case "platea vip":
      case "vip":
          return 0.70;
      case "platea comun":
      case "comun":
          return 0.40;
      case "platea baja":
      case "baja":
          return 0.50;
      case "platea alta":
      case "alta":
           return 0.0;
      default:
          throw new RuntimeException("Sector inválido");
    }
  }
}