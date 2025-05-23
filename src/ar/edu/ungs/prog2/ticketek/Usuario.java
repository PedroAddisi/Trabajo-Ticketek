package ar.edu.ungs.prog2.ticketek;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

public class Usuario {
    // Atributos
    private String nombre;
    private String email;
    private String contrasenia;
    private String apellido;
    private HashMap<Integer, IEntrada> entradas = new HashMap<>();
    // Constructor
    public Usuario(String email, String nombre, String apellido, String contrasenia) {
        if (email == null || email.isEmpty()) throw new IllegalArgumentException("Email inválido");
        if (nombre == null || nombre.isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        if (apellido == null || apellido.isEmpty()) throw new IllegalArgumentException("Apellido inválido");
        if (contrasenia == null || contrasenia.isEmpty()) throw new IllegalArgumentException("Contraseña inválida");
        this.email = email;
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }

    // Agrega una entrada al usuario
    public void agregarEntrada(Entrada entrada) {
        entradas.put(entrada.getCodigoDeEntrada(), entrada);
    }

    // Getters
    public HashMap<Integer, IEntrada> getEntradas() {
        return entradas;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public String getApellido() {
        return apellido;
    }

    public List<IEntrada> RecorrerentradasusuarioFuturas() {// Devuelve las entradas futuras del usuario
        List<IEntrada> entradasFuturas = new ArrayList<>();
        LocalDate hoy = LocalDate.now();
        for (IEntrada entrada : entradas.values()) {
            if (entrada instanceof Entrada) {
                Entrada e = (Entrada) entrada;
                if (e.getFecha().isAfter(hoy)) {
                    entradasFuturas.add(entrada);
                }
            }
        }
        return entradasFuturas;
    }
    public List<IEntrada> Recorrerentradasusuario() {// Devuelve todas las entradas del usuario
         return new ArrayList<>(entradas.values());
    }
}

