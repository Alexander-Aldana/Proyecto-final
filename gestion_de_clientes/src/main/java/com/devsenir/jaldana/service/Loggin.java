package com.devsenir.jaldana.service;

import com.devsenir.jaldana.model.User;

public class Loggin {

    private SistemaUsuarios sistema;

    public Loggin(SistemaUsuarios sistema) {
        this.sistema = sistema;
    }

    public User login(String username, String password) {

        User u = sistema.buscarPorUsername(username);

        if (u != null && u.validarPassword(password)) {
            u.registrarAccion("Inició sesión");
            return u;
        }

        return null;
    }
}
