package com.example.application.ui;

import com.example.application.service.AlunoService;

import javax.swing.*;
import java.awt.*;

public class AlunoPanel extends JPanel {

    private AlunoService alunoService;
    private JTextField alunoNameField;
    private JTextField turmaIdField;

    public AlunoPanel() {
        alunoService = new AlunoService();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Cadastro de Aluno");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 20));
        titleLabel.setForeground(new Color(51, 153, 255));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(titleLabel, gbc);

        JLabel nameLabel = new JLabel("Nome do Aluno:");
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(nameLabel, gbc);

        alunoNameField = new JTextField(20);
        alunoNameField.setFont(new Font("Arial", Font.PLAIN, 14));
        alunoNameField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.gridy = 1;
        add(alunoNameField, gbc);

        JLabel turmaLabel = new JLabel("ID da Turma:");
        turmaLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(turmaLabel, gbc);

        turmaIdField = new JTextField(20);
        turmaIdField.setFont(new Font("Arial", Font.PLAIN, 14));
        turmaIdField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        gbc.gridx = 1;
        gbc.gridy = 2;
        add(turmaIdField, gbc);

        JButton registerButton = new JButton("Registrar");
        registerButton.setFont(new Font("Arial", Font.BOLD, 14));
        registerButton.setBackground(new Color(51, 153, 255));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.addActionListener(e -> {
            String nome = alunoNameField.getText();
            int turmaId;
            try {
                turmaId = Integer.parseInt(turmaIdField.getText());
                if (!nome.isEmpty()) {
                    alunoService.registrarAluno(nome, turmaId);
                    JOptionPane.showMessageDialog(this, "Aluno registrado com sucesso!");
                    alunoNameField.setText("");
                    turmaIdField.setText("");
                } else {
                    JOptionPane.showMessageDialog(this, "Por favor, insira o nome do aluno.");
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira um ID de turma válido.");
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(registerButton, gbc);
    }
}