package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciamentoView {

    public void exibirTelaGerenciamento() {

        JFrame telaGerenciamento = new JFrame("Gerenciamento");
        telaGerenciamento.setSize(600, 400);
        telaGerenciamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel painelGerenciamento = new JPanel();
        painelGerenciamento.setLayout(new BoxLayout(painelGerenciamento, BoxLayout.Y_AXIS));
        painelGerenciamento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JButton botaoStatus = new JButton("Status da Encomenda");
        JButton botaoAlterarEndereco = new JButton("Alterar Endereço");
        JButton botaoCadastrarProduto = new JButton("Cadastrar Produto");
        JButton botaoVoltar = new JButton("Voltar");

        estilizarBotao(botaoStatus);
        estilizarBotao(botaoAlterarEndereco);
        estilizarBotao(botaoCadastrarProduto);
        estilizarBotao(botaoVoltar);

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaGerenciamento.dispose();
                new LoginView();
            }
        });

        botaoCadastrarProduto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CadastrarProdutoView();
                telaGerenciamento.dispose();
            }
        });

        botaoAlterarEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AlterarEnderecoView();
                telaGerenciamento.dispose();
            }
        });

        botaoStatus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StatusEncomendaView();
                telaGerenciamento.dispose();
            }
        });

        painelGerenciamento.add(Box.createRigidArea(new Dimension(0, 20)));
        painelGerenciamento.add(botaoStatus);
        painelGerenciamento.add(Box.createRigidArea(new Dimension(0, 10)));
        painelGerenciamento.add(botaoAlterarEndereco);
        painelGerenciamento.add(Box.createRigidArea(new Dimension(0, 10)));
        painelGerenciamento.add(botaoCadastrarProduto);
        painelGerenciamento.add(Box.createRigidArea(new Dimension(0, 10)));
        painelGerenciamento.add(botaoVoltar);

        telaGerenciamento.add(painelGerenciamento);

        telaGerenciamento.setLocationRelativeTo(null);
        telaGerenciamento.setVisible(true);
    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(new Color(0, 128, 0));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main(String[] args) {
        new GerenciamentoView().exibirTelaGerenciamento();
    }
}
