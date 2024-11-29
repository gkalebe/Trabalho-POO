package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciamentoView {

    public void exibirTelaGerenciamento() {

        JFrame telaGerenciamento = new JFrame("Gerenciamento");
        telaGerenciamento.setSize(400, 300);
        telaGerenciamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel painelGerenciamento = new JPanel(new GridLayout(5, 1, 10, 10));
        painelGerenciamento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));


        JButton botaoStatus = new JButton("Status da Encomenda");
        JButton botaoAlterarEndereco = new JButton("Alterar Endereço");
        JButton botaoCadastrarProduto = new JButton("Cadastrar Produto");

        JButton botaoVoltar = new JButton("Voltar");


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


        painelGerenciamento.add(botaoStatus);
        painelGerenciamento.add(botaoAlterarEndereco);
        painelGerenciamento.add(botaoCadastrarProduto);
        painelGerenciamento.add(botaoVoltar);

        telaGerenciamento.add(painelGerenciamento);


        telaGerenciamento.setLocationRelativeTo(null);
        telaGerenciamento.setVisible(true);
    }

    public static void main(String[] args) {
        new GerenciamentoView().exibirTelaGerenciamento();
    }
}
