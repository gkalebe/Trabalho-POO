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

        // Botões do menu
        JButton btnClientes = new JButton("Gerenciar Clientes");
        JButton btnProdutos = new JButton("Gerenciar Produtos");
        JButton btnEncomendas = new JButton("Gerenciar Encomendas");
        JButton btnLocaisEntrega = new JButton("Gerenciar Locais de Entrega");

        panel.add(btnClientes);
        panel.add(btnProdutos);
        panel.add(btnEncomendas);
        panel.add(btnLocaisEntrega);


        add(panel);
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
