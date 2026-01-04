package com.devsenir.jaldana.model;

public class User {

    private int id;
    private String nombreCompleto;
    private String username;
    private String password;
    private Rol rol;

    private UserHistorial[] historial;
    private int contadorAcciones;

    public User(int id, String nombreCompleto, String username, String password, Rol rol) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.username = username;
        this.password = password;
        this.rol = rol;
        this.historial = new UserHistorial[100];
        this.contadorAcciones = 0;
    }

    // Validación simple
    public boolean validarPassword(String password) {
        return this.password.equals(password);
    }

    public boolean cambiarPassword(String actual, String nueva) {
        if (validarPassword(actual)) {
            this.password = nueva;
            registrarAccion("Actualizó su contraseña");
            return true;
        }
        return false;
    }

    public void registrarAccion(String descripcion) {
        if (contadorAcciones < historial.length) {
            historial[contadorAcciones++] = new UserHistorial(descripcion);
        }
    }

    public void mostrarHistorial() {
        for (int i = 0; i < contadorAcciones; i++) {
            System.out.println(historial[i].getTime() + " - " + historial[i].getDescription());
        }
    }

    // Getters y setters necesarios
    public int getId() {
         return id; 
    }
    
    public String getUsername() { 
        return username; 
    }
    public Rol getRol() { 
        return rol; 
    }
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }
}

