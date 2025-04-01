package com.ecodeup.jdbc;

public class Login {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        String username = "juan123";
        String password = "12345";

        if (usuarioDAO.verificarUsuario(username, password)) {
            System.out.println("Login exitoso");
        } else {
            System.out.println("Credenciales incorrectas");
        }
    }
}

