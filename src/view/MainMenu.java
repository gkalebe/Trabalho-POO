package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {

    public MainMenu() {
        setTitle("Floricultura");
        setSize(500, 300); 
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS)); 

        
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        
        JButton btnGerenciarClientes = new JButton("Gerenciamento");
        JButton btnClientes = new JButton("Clientes");
        JButton btnEncerrarPrograma = new JButton("Encerrar Programa");

       
        estilizarBotao(btnGerenciarClientes);
        estilizarBotao(btnClientes);
        estilizarBotao(btnEncerrarPrograma);

        
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


        panel.add(Box.createRigidArea(new Dimension(0, 50)));
        panel.add(btnGerenciarClientes);
        panel.add(Box.createRigidArea(new Dimension(0, 05)));
        panel.add(btnClientes);
        panel.add(Box.createRigidArea(new Dimension(0, 05))); 
        panel.add(btnEncerrarPrograma);

        
        add(panel);

        
        setVisible(true);
    }

    private void estilizarBotao(JButton botao) {
        // Estilizando os botões
        botao.setFont(new Font("Arial", Font.BOLD, 20)); 
        botao.setBackground(new Color(0, 128, 0)); 
        botao.setForeground(Color.WHITE); 
        botao.setFocusPainted(false); 
        botao.setAlignmentX(Component.CENTER_ALIGNMENT); 
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainMenu().setVisible(true));
    }
}
