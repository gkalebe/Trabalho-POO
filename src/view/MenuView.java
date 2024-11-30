package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuView extends JFrame {

    public MenuView() {
        setTitle("Menu do Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Bem-vindo ao Menu do Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton botaoAtualizarInformacoes = new JButton("Atualizar Informações");
        JButton botaoFazerEncomenda = new JButton("Fazer uma Encomenda");
        JButton botaoVisualizarStatus = new JButton("Visualizar Status da Encomenda");
        JButton botaoVoltar = new JButton("Voltar");

        estilizarBotao(botaoAtualizarInformacoes);
        estilizarBotao(botaoFazerEncomenda);
        estilizarBotao(botaoVisualizarStatus);
        estilizarBotao(botaoVoltar);

        botaoAtualizarInformacoes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new AtualizarInformacoesView();
            }
        });

        botaoFazerEncomenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FazerEncomendaView(); 
            }
        });

        botaoVisualizarStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new VisualizarStatusEncomendaView();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new ClienteView();
            }
        });

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titulo);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(botaoAtualizarInformacoes);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(botaoFazerEncomenda);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(botaoVisualizarStatus);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(botaoVoltar);

        setVisible(true);
    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(new Color(0, 128, 0));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main(String[] args) {
        new MenuView();
    }
}
