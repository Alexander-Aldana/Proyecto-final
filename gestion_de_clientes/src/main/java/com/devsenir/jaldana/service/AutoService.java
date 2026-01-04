package com.devsenir.jaldana.service;
import com.devsenir.jaldana.model.User;

public class AutoService {

    private UsuarioService usuarioService;
    public AutoService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    public User login(String username, String password) {
        User u = usuarioService.buscarPorUsername(username);
        if (u != null && u.validarPassword(password)) {
            u.registrarAccion("Inició sesión");
            return u;
        }
        return null;
    }
}