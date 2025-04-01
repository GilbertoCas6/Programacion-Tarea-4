package com.ecodeup.jdbc;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class UsuariosListUI extends JFrame {
    private JTable tablaUsuarios;
    private JButton btnCerrarSesion, btnActualizar, btnEliminar;

    public UsuariosListUI() {
        setTitle("Lista de Usuarios");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setLayout(new BorderLayout());

        JLabel lblTitulo = new JLabel("Usuarios Registrados");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 22));
        lblTitulo.setForeground(new Color(33, 33, 33));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblTitulo, BorderLayout.NORTH);


        String[] columnNames = {"Nombre", "Apellido", "Usuario", "Teléfono", "Correo"};
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        tablaUsuarios = new JTable(model);
        tablaUsuarios.setBackground(new Color(52, 152, 219));
        tablaUsuarios.setForeground(Color.WHITE);
        tablaUsuarios.setSelectionBackground(new Color(41, 128, 185));

        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBackground(new Color(245, 245, 245));
        panel.add(scrollPane, BorderLayout.CENTER);


        JPanel panelBotones = new JPanel();
        panelBotones.setBackground(new Color(245, 245, 245));


        btnActualizar = new JButton("Actualizar");
        btnActualizar.setBackground(new Color(39, 174, 96));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFont(new Font("Arial", Font.BOLD, 14));
        btnActualizar.setFocusPainted(false);
        btnActualizar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnActualizar.setOpaque(true);
        panelBotones.add(btnActualizar);


        btnEliminar = new JButton("Eliminar");
        btnEliminar.setBackground(new Color(231, 76, 60));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFont(new Font("Arial", Font.BOLD, 14));
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnEliminar.setOpaque(true);
        panelBotones.add(btnEliminar);

        btnCerrarSesion = new JButton("Cerrar sesión");
        btnCerrarSesion.setBackground(new Color(231, 76, 60));
        btnCerrarSesion.setForeground(Color.WHITE);
        btnCerrarSesion.setFont(new Font("Arial", Font.BOLD, 14));
        btnCerrarSesion.setFocusPainted(false);
        btnCerrarSesion.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        btnCerrarSesion.setOpaque(true);
        panelBotones.add(btnCerrarSesion);

        panel.add(panelBotones, BorderLayout.SOUTH);

        add(panel, BorderLayout.CENTER);

        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();

        for (Usuario usuario : listaUsuarios) {
            Object[] row = {usuario.getNombre(), usuario.getApellido(), usuario.getUsuario(), usuario.getTelefono(), usuario.getCorreo()};
            model.addRow(row);
        }

        btnCerrarSesion.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginUI().setVisible(true);
            }
        });

        btnActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaUsuarios.getSelectedRow();
                if (selectedRow >= 0) {
                    String usuario = (String) model.getValueAt(selectedRow, 2);
                    UsuarioDAO usuarioDAO = new UsuarioDAO();
                    Usuario usuarioAActualizar = usuarioDAO.obtenerUsuarioPorUsuario(usuario);

                    if (usuarioAActualizar != null) {

                        new ActualizarUsuarioUI(usuarioAActualizar, UsuariosListUI.this).setVisible(true);
                    } else {
                        JOptionPane.showMessageDialog(UsuariosListUI.this, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(UsuariosListUI.this, "Debe seleccionar un usuario para actualizar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tablaUsuarios.getSelectedRow();
                if (selectedRow >= 0) {
                    String usuario = (String) model.getValueAt(selectedRow, 2);
                    int confirm = JOptionPane.showConfirmDialog(UsuariosListUI.this,
                            "¿Está seguro de eliminar al usuario " + usuario + "?",
                            "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

                    if (confirm == JOptionPane.YES_OPTION) {
                        UsuarioDAO usuarioDAO = new UsuarioDAO();
                        if (usuarioDAO.eliminarUsuario(usuario)) {
                            JOptionPane.showMessageDialog(UsuariosListUI.this, "Usuario eliminado.");
                            actualizarListaUsuarios();
                        } else {
                            JOptionPane.showMessageDialog(UsuariosListUI.this, "Error al eliminar usuario.", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(UsuariosListUI.this, "Debe seleccionar un usuario para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    public void actualizarListaUsuarios() {
        DefaultTableModel model = (DefaultTableModel) tablaUsuarios.getModel();
        model.setRowCount(0);
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> listaUsuarios = usuarioDAO.obtenerUsuarios();

        for (Usuario usuario : listaUsuarios) {
            Object[] row = {usuario.getNombre(), usuario.getApellido(), usuario.getUsuario(), usuario.getTelefono(), usuario.getCorreo()};
            model.addRow(row);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UsuariosListUI().setVisible(true));
    }
}
