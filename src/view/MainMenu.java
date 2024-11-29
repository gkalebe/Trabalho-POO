package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Floricultura");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));

        JButton btnGerenciarClientes = new JButton("Gerenciamento");
        JButton btnClientes = new JButton("Clientes");
        JButton btnEncerrarPrograma = new JButton("Encerrar Programa");


        btnGerenciarClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginView().setVisible(true); 
                dispose(); 
            }
        });


        btnClientes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ClienteView(); 
                dispose();
            }
        });


        btnEncerrarPrograma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        panel.add(btnGerenciarClientes);
        panel.add(btnClientes);
        panel.add(btnEncerrarPrograma);

        add(panel);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true)); 
    }
}
