package com.ecodeup.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistroUI extends JFrame {
    private JTextField txtNombre, txtApellido, txtUsuario, txtTelefono, txtCorreo;
    private JPasswordField txtContrasena, txtConfirmarContrasena;
    private JButton btnRegistrar, btnCancelar;

    public RegistroUI() {
        setTitle("Registro de Usuario");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Registro de Usuario");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        JLabel lblNombre = new JLabel("Nombre:");
        lblNombre.setForeground(new Color(33, 33, 33));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblNombre, gbc);

        txtNombre = new JTextField(15);
        txtNombre.setFont(new Font("Arial", Font.PLAIN, 16));
        txtNombre.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtNombre, gbc);
        JLabel lblApellido = new JLabel("Apellido:");
        lblApellido.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblApellido, gbc);

        txtApellido = new JTextField(15);
        txtApellido.setFont(new Font("Arial", Font.PLAIN, 16));
        txtApellido.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtApellido, gbc);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtUsuario, gbc);

        JLabel lblTelefono = new JLabel("Teléfono:");
        lblTelefono.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 4;
        panel.add(lblTelefono, gbc);

        txtTelefono = new JTextField(15);
        txtTelefono.setFont(new Font("Arial", Font.PLAIN, 16));
        txtTelefono.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtTelefono, gbc);


        JLabel lblCorreo = new JLabel("Correo:");
        lblCorreo.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 5;
        panel.add(lblCorreo, gbc);

        txtCorreo = new JTextField(15);
        txtCorreo.setFont(new Font("Arial", Font.PLAIN, 16));
        txtCorreo.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtCorreo, gbc);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 6;
        panel.add(lblContrasena, gbc);

        txtContrasena = new JPasswordField(15);
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        txtContrasena.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtContrasena, gbc);

        JLabel lblConfirmarContrasena = new JLabel("Confirmar Contraseña:");
        lblConfirmarContrasena.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 7;
        panel.add(lblConfirmarContrasena, gbc);

        txtConfirmarContrasena = new JPasswordField(15);
        txtConfirmarContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        txtConfirmarContrasena.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtConfirmarContrasena, gbc);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBackground(new Color(39, 174, 96));
        btnRegistrar.setForeground(Color.WHITE);
        btnRegistrar.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrar.setFocusPainted(false);
        btnRegistrar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnRegistrar.setOpaque(true);
        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        panel.add(btnRegistrar, gbc);

        btnCancelar = new JButton("Cancelar");
        btnCancelar.setBackground(new Color(231, 76, 60));
        btnCancelar.setForeground(Color.WHITE);
        btnCancelar.setFont(new Font("Arial", Font.BOLD, 14));
        btnCancelar.setFocusPainted(false);
        btnCancelar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnCancelar.setOpaque(true);
        gbc.gridy = 9;
        panel.add(btnCancelar, gbc);

        add(panel, BorderLayout.CENTER);

        btnRegistrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtNombre.getText();
                String apellido = txtApellido.getText();
                String usuario = txtUsuario.getText();
                String telefono = txtTelefono.getText();
                String correo = txtCorreo.getText();
                String contrasena = new String(txtContrasena.getPassword());
                String confirmarContrasena = new String(txtConfirmarContrasena.getPassword());

                if (nombre.isEmpty() || apellido.isEmpty() || usuario.isEmpty() || telefono.isEmpty() || correo.isEmpty() || contrasena.isEmpty() || confirmarContrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(RegistroUI.this, "Esta dejando campos vacios y todos los campos son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
                } else if (!contrasena.equals(confirmarContrasena)) {
                    JOptionPane.showMessageDialog(RegistroUI.this, "Las contraseñas no coinciden.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    Usuario usuarioNuevo = new Usuario(nombre, apellido, usuario, telefono, correo, contrasena);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    if (usuarioDAO.registrarUsuario(usuarioNuevo)) {
                        JOptionPane.showMessageDialog(RegistroUI.this, "Registro exitoso");
                        dispose();
                    } else {
                        JOptionPane.showMessageDialog(RegistroUI.this, "Error al registrar usuario", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnCancelar.addActionListener(e -> dispose());
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistroUI().setVisible(true));
    }
}
