package com.example.application.ui;

import javax.swing.*;

public class MainApp {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Gerenciamento de Faculdade");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(600, 400);

            JTabbedPane tabbedPane = new JTabbedPane();
            tabbedPane.addTab("Professor", new ProfessorPanel());
            tabbedPane.addTab("Aluno", new AlunoPanel());
            tabbedPane.addTab("Matéria", new MateriaPanel());
            tabbedPane.addTab("Turma", new TurmaPanel());
            tabbedPane.addTab("Presença", new PresencaPanel());
            tabbedPane.addTab("Consulta de Presença", new ConsultaPresencaPanel());

            frame.add(tabbedPane);
            frame.setVisible(true);
        });
    }
}
