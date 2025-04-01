package com.ecodeup.jdbc;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConexion {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/login_db";
        String usuario = "root";
        String contraseña = "admin";

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println(" Conexión exitosa a MySQL");
            conexion.close();
        } catch (SQLException e) {
            System.out.println(" Error de conexión: " + e.getMessage());
        }
    }
}
