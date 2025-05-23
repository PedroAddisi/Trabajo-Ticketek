package ar.edu.ungs.prog2.ticketek;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Ticketek implements ITicketek {

    // --- Atributos principales ---
    private HashMap<String, Usuario> listaUsuarios = new HashMap<>();
    private HashMap<String, Espectaculo> listaEspectaculos = new HashMap<>();
    private HashMap<String, Sedes> listaSedes = new HashMap<>();
    private HashMap<String, Double> recaudacionPorSedeYEspectaculo = new HashMap<>();

    // --- Métodos para registrar sedes ---
    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima) {
        Sedes sede = new Estadio(nombre, direccion, capacidadMaxima, "Estadio");
        agregarSede(nombre, sede);
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        Sedes sede = new Teatro(nombre, direccion, capacidadMaxima, asientosPorFila, sectores, capacidad, porcentajeAdicional, "Teatro");
        agregarSede(nombre, sede);
        sede.generarAsientos();
    }

    @Override
    public void registrarSede(String nombre, String direccion, int capacidadMaxima, int asientosPorFila, int cantidadPuestos, double precioConsumicion, String[] sectores, int[] capacidad, int[] porcentajeAdicional) {
        Sedes sede = new Miniestadio(nombre, direccion, capacidadMaxima, asientosPorFila, cantidadPuestos, precioConsumicion, sectores, capacidad, porcentajeAdicional, "Miniestadio");
        agregarSede(nombre, sede);
        sede.generarAsientos();
    }

    private void agregarSede(String nombre, Sedes sede) {
        if (listaSedes.containsKey(sede.getNombre())) {
            throw new RuntimeException("Sede ya registrada.");
        }
        listaSedes.put(nombre, sede);
    }

    // --- Métodos para registrar usuarios ---
    @Override
    public void registrarUsuario(String email, String nombre, String apellido, String contrasenia) {
        Usuario nuevoUsuario = new Usuario(email, nombre, apellido, contrasenia);
        agregarUsuario(email, nuevoUsuario);
    }

    private void agregarUsuario(String email, Usuario usuario) {
        if (listaUsuarios.containsKey(usuario.getEmail())) {
            throw new RuntimeException("Email ya registrado.");
        }
        listaUsuarios.put(email, usuario);
    }

    // --- Métodos para registrar espectáculos y funciones ---
    @Override
    public void registrarEspectaculo(String nombre) {
        Espectaculo espectaculo = new Espectaculo(nombre);
        agregarEspectaculo(nombre, espectaculo);
    }

    private void agregarEspectaculo(String nombre, Espectaculo espectaculo) {
        for (Espectaculo e : listaEspectaculos.values()) {
            if (e.getNombre().equals(espectaculo.getNombre())) {
                throw new RuntimeException("Espectáculo ya registrado.");
            }
        }
        listaEspectaculos.put(nombre, espectaculo);
    }

    @Override
    public void agregarFuncion(String nombreEspectaculo, String fecha, String sede, double precioBase) {
        Funcion funcion = new Funcion(nombreEspectaculo, fecha, sede, precioBase);
        verificarFechaFuncion(nombreEspectaculo, fecha, sede, funcion);
        agregarSedeAFuncion(funcion, sede);
        cargarFuncion(fecha, funcion);
    }

    private void agregarSedeAFuncion(Funcion funcion, String sede) {
        for (Sedes s : listaSedes.values()) {
            if (s.getNombre().equals(sede)) {
                funcion.agregarSede(s);
                return;
            }
        }
        throw new RuntimeException("Sede no registrada");
      }

    private void verificarFechaFuncion(String nombreEspectaculo, String fecha, String sede, Funcion funcion) {
        for (Espectaculo espectaculo : listaEspectaculos.values()) {
            if (espectaculo.getNombre().equals(nombreEspectaculo)) {
                for (Funcion f : espectaculo.getListaFunciones().values()) {
                    if (f.getFechaString().equals(fecha) && listaSedes.containsKey(sede)) {
                        throw new RuntimeException("Ya existe una funcion en esta fecha");
                    }
                }
            }
        }
    }
    private void cargarFuncion(String fecha,Funcion funcion) {
        for (Espectaculo espectaculo : listaEspectaculos.values()) {
            if (espectaculo.getNombre().equals(funcion.getNombreEspectaculo())) {
                espectaculo.cargarFunciones(fecha,funcion);
            }
        }
    }

    // --- Métodos de venta y recaudación ---
    // Vender Entradas
    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, int cantidadEntradas) {
        List<IEntrada> entradasCompradas = new ArrayList<>(cantidadEntradas);
        agregarEntradaCampo(email, contrasenia, cantidadEntradas, nombreEspectaculo, fecha, entradasCompradas);
        descontarCantDeEntradasCampo(nombreEspectaculo, fecha, cantidadEntradas);
        return entradasCompradas;
    }

    private void descontarCantDeEntradasCampo(String nombreEspectaculo, String fecha, int cantidadEntradas) {
        for (Espectaculo espectaculo : listaEspectaculos.values()) {
            for (Funcion funcion : espectaculo.getListaFunciones().values()) {
                for (int i = 0; i < cantidadEntradas; i++) {
                    funcion.getMapSede().get(funcion.getSede()).capacidadMaxima = -1;
                    funcion.guardarRecaudado(cantidadEntradas, funcion.getSede());
                }
            }
        }
    }
    private void agregarEntradaCampo(String email, String contrasenia, int cantidadEntradas, String nombreEspectaculo, String fecha, List<IEntrada> entradasCompradas) {
        LocalDate fechaDate = obtenerFecha(fecha);
        if (listaUsuarios.get(email).getContrasenia().equals(contrasenia)) {
          for (Espectaculo espectaculo : listaEspectaculos.values()) {
                if (espectaculo.getNombre().equals(nombreEspectaculo)) {
                    for (Funcion funcion : espectaculo.getListaFunciones().values()) {
                        if (funcion.getFecha().equals(fechaDate)) {
                           for (int i = 0; i < cantidadEntradas; i++) {
                Entrada entrada = new Entrada(nombreEspectaculo, fechaDate, email,funcion.getSede(),"Campo",funcion.getPrecioBase(),null);
                listaUsuarios.get(email).agregarEntrada(entrada);
                entradasCompradas.add(entrada);
                }
                        }
                    }
                }
            }
        } 
        else {
            throw new RuntimeException("Contraseña incorrecta");
        }
    }

    @Override
    public List<IEntrada> venderEntrada(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos) {
        List<IEntrada> entradasCompradas = new ArrayList<>();
        agregarEntradaTeatro(nombreEspectaculo, fecha, email, contrasenia, sector, asientos, entradasCompradas);
        reservar(nombreEspectaculo, fecha, email, contrasenia, sector, asientos);

        return entradasCompradas;
    }
        private void acumularRecaudacion(String nombreEspectaculo, String sede, double monto) {
        String clave = nombreEspectaculo + "|" + sede;// Crea una clave única para la combinación de espectaculo y sede
        recaudacionPorSedeYEspectaculo.put(clave, recaudacionPorSedeYEspectaculo.getOrDefault(clave, 0.0) + monto);// Acumula el monto recaudado
        }
    private void reservar(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos) {
        LocalDate fechaDate = obtenerFecha(fecha);
        for (Espectaculo espectaculo : listaEspectaculos.values()) {
            if (espectaculo.getNombre().equals(nombreEspectaculo)) {
                for (Funcion funcion : espectaculo.getListaFunciones().values()) {
                    if (funcion.getFecha().equals(fechaDate)) {
                        funcion.reservarAsientos(asientos, sector);
                        if (funcion.getMapSede().get(funcion.getSede()).getTipoSede().equals("Teatro") ||funcion.getMapSede().get(funcion.getSede()).getTipoSede().equals("Miniestadio")) {// Verifica si la sede es teatro o miniestadio
                          funcion.guardarRecaudadoTeatroYMini(asientos.length, sector);
                          double monto = 0;
                          if (funcion.getMapSede().get(funcion.getSede()).getTipoSede().equals("Teatro")) {// Verifica si la sede es teatro
                            double recargo = funcion.recargoSectores(sector);
                            monto = (funcion.getPrecioBase() + funcion.getPrecioBase() * recargo) * asientos.length;//calcula el monto total
                          } 
                          else if (funcion.getMapSede().get(funcion.getSede()).getTipoSede().equals("Miniestadio")) {// Verifica si la sede es miniestadio
                            double recargo = funcion.recargoSectores(sector);
                            double consumo = funcion.getMapSede().get(funcion.getSede()).getConsumición();
                            monto = (funcion.getPrecioBase() + funcion.getPrecioBase() * recargo + consumo) * asientos.length;// Calcula el monto total
                          }
                          acumularRecaudacion(nombreEspectaculo, funcion.getSede(), monto);
                    }
                }
            }
        }
      }
    }

    private void agregarEntradaTeatro(String nombreEspectaculo, String fecha, String email, String contrasenia, String sector, int[] asientos, List<IEntrada> entradasCompradas) {
    LocalDate fechaDate = obtenerFecha(fecha);
    if (listaUsuarios.get(email).getContrasenia().equals(contrasenia)) {
        Funcion funcion = listaEspectaculos.get(nombreEspectaculo).getListaFunciones().get(fecha);
        double precioBase = funcion.getPrecioBase();
        for (int i = 0; i < asientos.length; i++) {
            Entrada entrada = new Entrada(nombreEspectaculo, fechaDate, email,funcion.getSede(),sector, precioBase, asientos);
            listaUsuarios.get(email).agregarEntrada(entrada);
            entradasCompradas.add(entrada);
        }
    } else {
        throw new RuntimeException("Contraseña incorrecta");
    }
}

    // --- Métodos de consulta ---
    @Override
    //
    // Listar Funciones
    public String listarFunciones(String nombreEspectaculo) {
        StringBuilder funciones = new StringBuilder();
        boolean encontrado = false;
        for (Espectaculo espectaculo : listaEspectaculos.values()) {
            if (espectaculo.getNombre().equals(nombreEspectaculo)) {
                encontrado = true;
                for (Funcion funcion : espectaculo.getListaFunciones().values()) {
                    for (Sedes sede : listaSedes.values()) {
                        if (sede.getNombre().equals(funcion.getSede()) && funcion.getNombreEspectaculo().equals(nombreEspectaculo)) {// Verifica si la sede coincide con la función
                            funciones.append(funcion.toString()).append("\n");//se agrega entrer
                            funciones.toString();
                        }
                    }
                }
            }
        }
        if (!encontrado || funciones.length() == 0) {
            return "El espectaculo no tiene funciones";
        }
        return funciones.toString();
    }

    //
    // Listar Entradas Espectaculo
    @Override
    public List<IEntrada> listarEntradasEspectaculo(String nombreEspectaculo) {
      List<IEntrada> listaEntradas = new ArrayList<>();
      for (Usuario usuario : listaUsuarios.values()) {
            for (IEntrada entrada : usuario.getEntradas().values()) {
                if (entrada instanceof Entrada) {// Verifica si la entrada es una instancia de Entrada
                Entrada e = (Entrada) entrada;// Convierte la entrada a tipo Entrada para poder acceder a sus métodos
                if (e.getNombreEspectaculo().equals(nombreEspectaculo)) {
                  listaEntradas.add(e);
                }
                }
            }
      }
        return listaEntradas;
    }
    //
    // Listar Entradas Futuras
    @Override
    public List<IEntrada> listarEntradasFuturas(String email, String contrasenia) {
        if (listaUsuarios.get(email).getContrasenia().equals(contrasenia)) {
            return listaUsuarios.get(email).RecorrerentradasusuarioFuturas();
        }
        throw new RuntimeException("Contraseña incorrecta");
    }

    //
    // Listar Entradas Usuario
    @Override
    public List<IEntrada> listarTodasLasEntradasDelUsuario(String email, String contrasenia) {
      if (listaUsuarios.get(email).getContrasenia().equals(contrasenia)) {
          return listaUsuarios.get(email).Recorrerentradasusuario();
      }
      throw new RuntimeException("Contraseña incorrecta");
    }
    //
    // Anular Entrada
    @Override
    public boolean anularEntrada(IEntrada entrada, String contrasenia) {
    if (entrada == null) {
        throw new RuntimeException("Entrada no encontrada");
    }
    LocalDate hoy = LocalDate.now();
    if (entrada instanceof Entrada) {// Verifica si la entrada es una instancia de Entrada
        Entrada e = (Entrada) entrada;// Convierte la entrada a tipo Entrada para poder acceder a sus métodos
        Usuario usuario = listaUsuarios.get(e.getEmail());
        if (usuario.getContrasenia().equals(contrasenia)) {
            if (e.getFecha().isBefore(hoy)) {
                return false; 
            }
            if (!usuario.getEntradas().containsKey(e.getCodigoDeEntrada())) {
                throw new RuntimeException("Entrada no encontrada");
            }
             Funcion funcion = listaEspectaculos.get(e.getNombreEspectaculo()).getListaFunciones().get(e.getFechaString());// Obtiene la función por medio de los parametros dados
             funcion.liberarAsientos(e.getAsientos(), e.getSectorEntrada());// Libera los asientos
            usuario.getEntradas().remove(e.getCodigoDeEntrada());// Elimina la entrada del usuario
            return true;
        }
    }
    throw new RuntimeException("Contraseña incorrecta");
    }
    //
    // Cambiar Entrada
    @Override
    public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha, String sector, int asiento) {
      LocalDate fechadate=obtenerFecha(fecha);
        if (entrada == null) {
            throw new RuntimeException("Entrada no encontrada");
        }
        LocalDate hoy = LocalDate.now();
        if (entrada instanceof Entrada) {// Verifica si la entrada es una instancia de Entrada
            Entrada e = (Entrada) entrada;// Convierte la entrada a tipo Entrada para poder acceder a sus métodos
            Funcion funcion = listaEspectaculos.get(e.getNombreEspectaculo()).getListaFunciones().get(e.getFechaString());// Obtiene la función por medio de los parametros dados
            Entrada entradanueva=new Entrada(e.getNombreEspectaculo(),fechadate,e.getEmail(),funcion.getSede(),funcion.getMapSede().get(funcion.getSede()).getTipoSede(),e.precio(),null);// Crea una nueva entrada con la nueva fecha y los datos de la entrada a cambiar
            Usuario usuario = listaUsuarios.get(e.getEmail());
            if (usuario.getContrasenia().equals(contrasenia)) {
                if (e.getFecha().isBefore(hoy)) {
                    return null; 
                }
                if (!usuario.getEntradas().containsKey(e.getCodigoDeEntrada())) {
                    throw new RuntimeException("Entrada no encontrada");
                }
                funcion.reservarAsientos(e.getAsientos(), sector);
                funcion.liberarAsientos(e.getAsientos(), e.getSectorEntrada());// Libera los asientos de la entrada anterior
                return entradanueva;
            }
        }
        throw new RuntimeException("Contraseña incorrecta");
    }

    @Override
    public IEntrada cambiarEntrada(IEntrada entrada, String contrasenia, String fecha) {
     LocalDate fechadate=obtenerFecha(fecha);
        if (entrada == null) {
            throw new RuntimeException("Entrada no encontrada");
        }
        LocalDate hoy = LocalDate.now();
        if (entrada instanceof Entrada) {// Verifica si la entrada es una instancia de Entrada
            Entrada e = (Entrada) entrada;// Convierte la entrada a tipo Entrada para poder acceder a sus métodos
            Funcion funcion = listaEspectaculos.get(e.getNombreEspectaculo()).getListaFunciones().get(e.getFechaString());// Obtiene la función por medio de los parametros dados
            Entrada entradanueva=new Entrada(e.getNombreEspectaculo(),fechadate,e.getEmail(),funcion.getSede(),"Campo",e.precio(),null);// Crea una nueva entrada con la nueva fecha y los datos de la entrada a cambiar
            Usuario usuario = listaUsuarios.get(e.getEmail());
            if (usuario.getContrasenia().equals(contrasenia)) {
                if (e.getFecha().isBefore(hoy)) {
                    return null; 
                }
                if (!usuario.getEntradas().containsKey(e.getCodigoDeEntrada())) {
                    throw new RuntimeException("Entrada no encontrada");
                }
                return entradanueva;
            }
        }
        throw new RuntimeException("Contraseña incorrecta");
    }
    //
    // Costo Entrada
    @Override
    public double costoEntrada(String nombreEspectaculo, String fecha) {
        return listaEspectaculos.get(nombreEspectaculo).getListaFunciones().get(fecha).getPrecioBase();// Devuelve el precio base de la función ya que es campo
    }

    @Override
    public double costoEntrada(String nombreEspectaculo, String fecha, String sector) {
        Funcion funcion = listaEspectaculos.get(nombreEspectaculo).getListaFunciones().get(fecha);// Obtiene la función por medio de los parametros dados
        double precioBase = funcion.getPrecioBase();
        double recargo = funcion.recargoSectores(sector);
        double total = precioBase + precioBase * recargo;
        Sedes sede = funcion.getMapSede().get(funcion.getSede());
        if (sede != null && "Miniestadio".equals(sede.getTipoSede())) {
            total += sede.getConsumición();
        }
        return total;
    }

    //
    // Total Recaudado
    @Override
    public double totalRecaudado(String nombreEspectaculo) {
        double totalRecaudado = 0;
        for (Espectaculo espectaculo : listaEspectaculos.values()) {
            if (espectaculo.getNombre().equals(nombreEspectaculo)) {
                for (Funcion funcion : espectaculo.getListaFunciones().values()) {// Recorre las funciones del espectaculo
                    totalRecaudado += funcion.getTotalRecaudado();
                }
            }
        }
        return totalRecaudado;
    }
    @Override
    public double totalRecaudadoPorSede(String nombreEspectaculo, String nombreSede) {
        String clave = nombreEspectaculo + "|" + nombreSede;// Crea una clave única para la combinación de espectaculo y sede
        return recaudacionPorSedeYEspectaculo.getOrDefault(clave, 0.0);// Devuelve lo recaudado o 0 si no existe
    }

    //
    private LocalDate obtenerFecha(String fecha) {// Convierte la fecha de String a LocalDate
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        LocalDate fechaDate = LocalDate.parse(fecha, formatter);
        return fechaDate;
    }
}