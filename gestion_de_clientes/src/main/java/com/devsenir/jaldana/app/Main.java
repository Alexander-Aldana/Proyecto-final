package com.devsenir.jaldana.app;
import com.devsenir.jaldana.model.Rol;
import com.devsenir.jaldana.model.User;
import com.devsenir.jaldana.service.Loggin;
import com.devsenir.jaldana.service.SistemaUsuarios;

public class Main {
    public static void main(String[] args) {

        SistemaUsuarios sistema = new SistemaUsuarios();
        Loggin auth = new Loggin(sistema);

        User admin = new User(
            1,
            "Administrador General",
            "admin",
            "1234",
            Rol.ADMINISTRADOR
        );

        User usuario = new User(
            2,
            "Juan Perez",
            "juan",
            "abcd",
            Rol.ESTANDAR
        );

        sistema.crearUsuario(admin, admin);
        sistema.crearUsuario(admin, usuario);

        User login = auth.login("juan", "abcd");

        if (login != null) {
            System.out.println("Login exitoso");
            login.mostrarHistorial();
        } else {
            System.out.println("Login fallido");
        }
    }
}