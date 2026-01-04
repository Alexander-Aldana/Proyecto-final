package com.devsenir.jaldana.service;
import com.devsenir.jaldana.model.Rol;
import com.devsenir.jaldana.model.User;


public class UsuarioService {

    private User[] usuarios;
    private int contador;

    public UsuarioService() {
        usuarios = new User[50];
        contador = 0;
    }

    public boolean crearUsuario(User admin, User nuevo) {
        if (admin.getRol() != Rol.ADMINISTRADOR) return false;

        if (buscarPorUsername(nuevo.getUsername()) != null) return false;

        usuarios[contador++] = nuevo;
        admin.registrarAccion("Creó usuario " + nuevo.getUsername());
        return true;
    }

    public User buscarPorId(int id) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == id) {
                return usuarios[i];
            }
        }
        return null;
    }

    public User buscarPorUsername(String username) {
        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getUsername().equals(username)) {
                return usuarios[i];
            }
        }
        return null;
    }

    public boolean eliminarUsuario(User admin, int id) {
        if (admin.getRol() != Rol.ADMINISTRADOR) return false;

        for (int i = 0; i < contador; i++) {
            if (usuarios[i].getId() == id) {
                usuarios[i] = usuarios[contador - 1];
                usuarios[--contador] = null;
                admin.registrarAccion("Eliminó usuario con ID " + id);
                return true;
            }
        }
        return false;
    }
}