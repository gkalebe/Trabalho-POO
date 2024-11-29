package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainMenu extends JFrame {

    public MainMenu() {

        setTitle("Floricultura");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));


        JButton btnGerenciarClientes = new JButton("Gerenciamento");
        JButton btnClientes = new JButton("Clientes");

        panel.add(btnGerenciarClientes);
        panel.add(btnClientes);
       


        add(panel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
