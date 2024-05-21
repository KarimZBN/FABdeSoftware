package com.example.application.ui;

import com.example.application.service.AlunoService;
import com.example.application.service.PresencaService;
import com.example.application.data.entity.Aluno;
import com.example.application.data.entity.Presenca;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class ConsultaPresencaPanel extends JPanel {

    private AlunoService alunoService;
    private PresencaService presencaService;
    private JTextField alunoNameField;
    private JTable presencaTable;
    private DefaultTableModel tableModel;

    public ConsultaPresencaPanel() {
        alunoService = new AlunoService();
        presencaService = new PresencaService();
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel titleLabel = new JLabel("Consulta de Presença");
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

        JButton searchButton = new JButton("Pesquisar");
        searchButton.setFont(new Font("Arial", Font.BOLD, 14));
        searchButton.setBackground(new Color(51, 153, 255));
        searchButton.setForeground(Color.WHITE);
        searchButton.setFocusPainted(false);
        searchButton.addActionListener(e -> {
            String nome = alunoNameField.getText();
            if (!nome.isEmpty()) {
                Aluno aluno = alunoService.findByName(nome);
                if (aluno != null) {
                    List<Presenca> presencas = presencaService.findByAlunoId(aluno.getId());
                    updateTable(presencas);
                } else {
                    JOptionPane.showMessageDialog(this, "Aluno não encontrado.");
                    tableModel.setRowCount(0); // Limpar tabela se aluno não encontrado
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, insira o nome do aluno.");
            }
        });

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        add(searchButton, gbc);

        // Tabela para exibir as presenças
        String[] columnNames = {"ID da Aula", "Presente"};
        tableModel = new DefaultTableModel(columnNames, 0);
        presencaTable = new JTable(tableModel);
        presencaTable.setFont(new Font("Arial", Font.PLAIN, 14));
        presencaTable.setRowHeight(20);
        presencaTable.setGridColor(Color.LIGHT_GRAY);
        JScrollPane scrollPane = new JScrollPane(presencaTable);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        add(scrollPane, gbc);
    }

    private void updateTable(List<Presenca> presencas) {
        tableModel.setRowCount(0); // Limpa a tabela
        for (Presenca presenca : presencas) {
            Object[] row = {presenca.getAulaId(), presenca.isPresente() ? "Sim" : "Não"};
            tableModel.addRow(row);
        }
    }
}