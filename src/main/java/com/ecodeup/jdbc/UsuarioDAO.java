package com.ecodeup.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

public class UsuarioDAO {

    public Connection obtenerConexion() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/login_db";
        String usuario = "root";
        String contraseña = "admin";

        return DriverManager.getConnection(url, usuario, contraseña);
    }

    public boolean registrarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (nombre, apellido, usuario, telefono, correo, contraseña) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getUsuario());
            ps.setString(4, usuario.getTelefono());
            ps.setString(5, usuario.getCorreo());
            ps.setString(6, usuario.getContrasena());

            int filasAfectadas = ps.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            System.out.println("Error al registrar usuario: " + e.getMessage());
            return false;
        }
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> listaUsuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios";

        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql);
             var rs = ps.executeQuery()) {

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String usuario = rs.getString("usuario");
                String telefono = rs.getString("telefono");
                String correo = rs.getString("correo");
                String contrasena = rs.getString("contraseña");

                Usuario usuarioObj = new Usuario(nombre, apellido, usuario, telefono, correo, contrasena);
                listaUsuarios.add(usuarioObj);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaUsuarios;
    }

    public Usuario obtenerUsuarioPorUsuario(String usuario) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ?";
        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);
            var rs = ps.executeQuery();

            if (rs.next()) {
                return new Usuario(
                        rs.getString("nombre"),
                        rs.getString("apellido"),
                        rs.getString("usuario"),
                        rs.getString("telefono"),
                        rs.getString("correo"),
                        rs.getString("contraseña")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean eliminarUsuario(String usuario) {
        String sql = "DELETE FROM usuarios WHERE usuario = ?";
        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean actualizarUsuario(Usuario usuario) {
        String sql = "UPDATE usuarios SET nombre = ?, apellido = ?, telefono = ?, correo = ?, contraseña = ? WHERE usuario = ?";
        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario.getNombre());
            ps.setString(2, usuario.getApellido());
            ps.setString(3, usuario.getTelefono());
            ps.setString(4, usuario.getCorreo());
            ps.setString(5, usuario.getContrasena());
            ps.setString(6, usuario.getUsuario());

            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean verificarUsuario(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE usuario = ? AND contraseña = ?";

        try (Connection conexion = obtenerConexion();
             PreparedStatement ps = conexion.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            var rs = ps.executeQuery();
            return rs.next();

        } catch (SQLException e) {
            System.out.println("Error al verificar usuario: " + e.getMessage());
            return false;
        }
    }

}
