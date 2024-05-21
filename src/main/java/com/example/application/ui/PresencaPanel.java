package com.example.application.ui;

import com.example.application.service.PresencaService;

import javax.swing.*;
import java.awt.*;

public class PresencaPanel extends JPanel {

    private PresencaService presencaService;
    private JTextField alunoIdField;
    private JTextField aulaIdField;
    private JCheckBox presenteCheckBox;

    public PresencaPanel() {
        presencaService = new PresencaService();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Registro de Presença");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 153, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        JLabel alunoIdLabel = new JLabel("ID do Aluno:");
        alunoIdLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(alunoIdLabel, gbc);

        alunoIdField = new JTextField(20);
        alunoIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        alunoIdField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(alunoIdField, gbc);

        JLabel aulaIdLabel = new JLabel("ID da Aula:");
        aulaIdLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(aulaIdLabel, gbc);

        aulaIdField = new JTextField(20);
        aulaIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        aulaIdField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(aulaIdField, gbc);

        JLabel presenteLabel = new JLabel("Presente:");
        presenteLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(presenteLabel, gbc);

        presenteCheckBox = new JCheckBox();
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.WEST;
        add(presenteCheckBox, gbc);

        JButton registerButton = new JButton("Registrar Presença");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(51, 153, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(e -> {
            int alunoId;
            int aulaId;
            try {
                alunoId = Integer.parseInt(alunoIdField.getText());
                aulaId = Integer.parseInt(aulaIdField.getText());
                boolean presente = presenteCheckBox.isSelected();
                presencaService.registrarPresenca(alunoId, aulaId, presente);
                JOptionPane.showMessageDialog(this, "Presença registrada com sucesso!");
                alunoIdField.setText("");
                aulaIdField.setText("");
                presenteCheckBox.setSelected(false);
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira IDs válidos.");
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);
    }
}