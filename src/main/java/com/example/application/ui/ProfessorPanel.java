package com.example.application.ui;

import com.example.application.service.ProfessorService;

import javax.swing.*;
import java.awt.*;

public class ProfessorPanel extends JPanel {

    private ProfessorService professorService;
    private JTextField professorNameField;

    public ProfessorPanel() {
        professorService = new ProfessorService();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Cadastro de Professor");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 153, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        JLabel nameLabel = new JLabel("Nome do Professor:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);

        professorNameField = new JTextField(20);
        professorNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        professorNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(professorNameField, gbc);

        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(51, 153, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(e -> {
            String nome = professorNameField.getText();
            if (!nome.isEmpty()) {
                professorService.registrarProfessor(nome);
                JOptionPane.showMessageDialog(this, "Professor registrado com sucesso!");
                professorNameField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, insira o nome do professor.");
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);
    }
}