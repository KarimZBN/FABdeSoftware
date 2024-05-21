package com.example.application.ui;

import com.example.application.service.TurmaService;

import javax.swing.*;
import java.awt.*;

public class TurmaPanel extends JPanel {

    private TurmaService turmaService;

    public TurmaPanel() {
        turmaService = new TurmaService();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Cadastro de Turma");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 153, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        JLabel infoLabel = new JLabel("Clique no botão abaixo para registrar uma nova turma:");
        infoLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(infoLabel, gbc);

        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(51, 153, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(e -> {
            turmaService.registrarTurma();
            JOptionPane.showMessageDialog(this, "Turma registrada com sucesso!");
        });

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);
    }
}