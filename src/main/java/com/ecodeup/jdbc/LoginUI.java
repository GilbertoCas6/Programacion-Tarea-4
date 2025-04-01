package com.ecodeup.jdbc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginUI extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtContrasena;
    private JButton btnLogin, btnRegistrarse;

    public LoginUI() {
        setTitle("Login de Usuario");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel lblTitulo = new JLabel("Login");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 28));
        lblTitulo.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(lblTitulo, gbc);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setForeground(new Color(33, 33, 33));
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        panel.add(lblUsuario, gbc);

        txtUsuario = new JTextField(15);
        txtUsuario.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsuario.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtUsuario, gbc);

        JLabel lblContrasena = new JLabel("Contraseña:");
        lblContrasena.setForeground(new Color(33, 33, 33));
        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(lblContrasena, gbc);

        txtContrasena = new JPasswordField(15);
        txtContrasena.setFont(new Font("Arial", Font.PLAIN, 16));
        txtContrasena.setBorder(BorderFactory.createLineBorder(new Color(200, 200, 200), 1));
        gbc.gridx = 1;
        panel.add(txtContrasena, gbc);

        btnLogin = new JButton("Iniciar sesión");
        btnLogin.setBackground(new Color(52, 152, 219));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnLogin.setOpaque(true);
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        panel.add(btnLogin, gbc);

        btnRegistrarse = new JButton("Registrarse");
        btnRegistrarse.setBackground(new Color(231, 76, 60));
        btnRegistrarse.setForeground(Color.WHITE);
        btnRegistrarse.setFont(new Font("Arial", Font.BOLD, 14));
        btnRegistrarse.setFocusPainted(false);
        btnRegistrarse.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnRegistrarse.setOpaque(true);
        gbc.gridy = 4;
        panel.add(btnRegistrarse, gbc);

        add(panel, BorderLayout.CENTER);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = txtUsuario.getText();
                String contrasena = new String(txtContrasena.getPassword());

                if (usuario.isEmpty() || contrasena.isEmpty()) {
                    JOptionPane.showMessageDialog(LoginUI.this, "Dejo un campo vacio, debe ingresar su usuario y contraseña. Si no está registrado, debe registrarse.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    if (usuarioDAO.verificarUsuario(usuario, contrasena)) {
                        JOptionPane.showMessageDialog(LoginUI.this, "Login exitoso!");
                        dispose();
                        new UsuariosListUI().setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(LoginUI.this, "Credenciales incorrectas", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        btnRegistrarse.addActionListener(e -> {
            dispose();
            new RegistroUI().setVisible(true);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LoginUI().setVisible(true));
    }
}
