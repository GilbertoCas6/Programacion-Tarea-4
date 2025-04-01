package com.ecodeup.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ActualizarUsuarioUI extends JFrame {
    private JTextField txtNombre, txtApellido, txtTelefono, txtCorreo;
    private JPasswordField txtContrasena;
    private JButton btnActualizar, btnCancelar;
    private Usuario usuario;
    private UsuariosListUI usuariosListUI;

    public ActualizarUsuarioUI(Usuario usuario, UsuariosListUI usuariosListUI) {
        this.usuario = usuario;
        this.usuariosListUI = usuariosListUI;

        setTitle("Actualizar Usuario");
        setSize(500, 350);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());


        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(new GridBagLayout());

        JLabel lblNombre = new JLabel("Nombre:");
        txtNombre = new JTextField(usuario.getNombre());
        gbc.gridx = 0; gbc.gridy = 0; panel.add(lblNombre, gbc);
        gbc.gridx = 1; gbc.gridy = 0; gbc.gridwidth = 2; panel.add(txtNombre, gbc);

        JLabel lblApellido = new JLabel("Apellido:");
        txtApellido = new JTextField(usuario.getApellido());
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1; panel.add(lblApellido, gbc);
        gbc.gridx = 1; gbc.gridy = 1; gbc.gridwidth = 2; panel.add(txtApellido, gbc);

        JLabel lblTelefono = new JLabel("Teléfono:");
        txtTelefono = new JTextField(usuario.getTelefono());
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1; panel.add(lblTelefono, gbc);
        gbc.gridx = 1; gbc.gridy = 2; gbc.gridwidth = 2; panel.add(txtTelefono, gbc);

        JLabel lblCorreo = new JLabel("Correo:");
        txtCorreo = new JTextField(usuario.getCorreo());
        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 1; panel.add(lblCorreo, gbc);
        gbc.gridx = 1; gbc.gridy = 3; gbc.gridwidth = 2; panel.add(txtCorreo, gbc);

        JLabel lblContrasena = new JLabel("Contraseña:");
        txtContrasena = new JPasswordField();
        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 1; panel.add(lblContrasena, gbc);
        gbc.gridx = 1; gbc.gridy = 4; gbc.gridwidth = 2; panel.add(txtContrasena, gbc);

        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(39, 174, 96));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.CENTER;
        panel.add(btnActualizar, gbc);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFocusPainted(false);
        gbc.gridx = 0; gbc.gridy = 6; gbc.gridwidth = 3; gbc.fill = GridBagConstraints.CENTER;
        panel.add(btnCancelar, gbc);

        add(panel);

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String contrasena = new String(txtContrasena.getPassword());

                Usuario usuarioActualizado = new Usuario(nombre, apellido, usuario.getUsuario(), telefono, correo, contrasena);

                UsuarioDAO usuarioDAO = new UsuarioDAO();
                if (usuarioDAO.actualizarUsuario(usuarioActualizado)) {
                    JOptionPane.showMessageDialog(ActualizarUsuarioUI.this, "Usuario actualizado exitosamente.");

                    if (usuariosListUI != null) {
                        usuariosListUI.actualizarListaUsuarios();
                    }
                } else {
                    JOptionPane.showMessageDialog(ActualizarUsuarioUI.this, "Error al actualizar el usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        Usuario usuarioEjemplo = new Usuario("Juan", "Pérez", "juanp", "1234567890", "juanp@example.com", "password");
        SwingUtilities.invokeLater(() -> new ActualizarUsuarioUI(usuarioEjemplo, null).setVisible(true));
    }
}
