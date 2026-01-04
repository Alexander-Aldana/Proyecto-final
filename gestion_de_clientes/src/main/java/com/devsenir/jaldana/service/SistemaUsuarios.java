package com.devsenir.jaldana.service;
import com.devsenir.jaldana.model.Rol;
import com.devsenir.jaldana.model.User;

public class SistemaUsuarios {

    private User[] usuarios;
    private int cantidad;

    public SistemaUsuarios() {
        usuarios = new User[50];
        cantidad = 0;
    }

    // Crear usuario (solo administrador)
    public boolean crearUsuario(User admin, User nuevo) {

        if (admin.getRol() != Rol.ADMINISTRADOR) {
            return false;
        }

        if (buscarPorUsername(nuevo.getUsername()) != null) {
            return false;
        }

        usuarios[cantidad] = nuevo;
        cantidad++;

        admin.registrarAccion("Creó el usuario " + nuevo.getUsername());
        return true;
    }

    // Buscar usuario por username
    public User buscarPorUsername(String username) {
        for (int i = 0; i < cantidad; i++) {
            if (usuarios[i].getUsername().equals(username)) {
                return usuarios[i];
            }
        }
        return null;
    }

    // Eliminar usuario (solo administrador)
    public boolean eliminarUsuario(User admin, int id) {

        if (admin.getRol() != Rol.ADMINISTRADOR) {
            return false;
        }

        for (int i = 0; i < cantidad; i++) {
            if (usuarios[i].getId() == id) {
                usuarios[i] = usuarios[cantidad - 1];
                usuarios[cantidad - 1] = null;
                cantidad--;

                admin.registrarAccion("Eliminó usuario con ID " + id);
                return true;
            }
        }
        return false;
    }
}
