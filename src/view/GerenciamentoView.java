package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GerenciamentoView {

    public void exibirTelaGerenciamento() {
        // Criando a tela de gerenciamento (simples)
        JFrame telaGerenciamento = new JFrame("Tela de Gerenciamento");
        telaGerenciamento.setSize(400, 300);
        telaGerenciamento.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Adicionando conteúdo simples à tela de gerenciamento
        JPanel painelGerenciamento = new JPanel(new GridLayout(5, 1, 10, 10)); // Ajuste no grid layout para acomodar 5 itens
        painelGerenciamento.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Botões de gerenciamento
        JButton botaoStatus = new JButton("Status da Encomenda");
        JButton botaoAlterarEndereco = new JButton("Alterar Endereço");
        JButton botaoCadastrarProduto = new JButton("Cadastrar Produto");

        // Botão Voltar para a tela de login
        JButton botaoVoltar = new JButton("Voltar");
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                telaGerenciamento.dispose(); // Fecha a tela de gerenciamento
                new LoginView(); // Cria uma nova instância da tela de login
            }
        });

        // Adicionando os botões ao painel de gerenciamento
        painelGerenciamento.add(botaoStatus);
        painelGerenciamento.add(botaoAlterarEndereco);
        painelGerenciamento.add(botaoCadastrarProduto);
        painelGerenciamento.add(botaoVoltar); // Adicionando o botão Voltar

        // Adicionando o painel à tela de gerenciamento
        telaGerenciamento.add(painelGerenciamento);

        // Tornando a tela visível
        telaGerenciamento.setLocationRelativeTo(null); // Centraliza a janela na tela
        telaGerenciamento.setVisible(true);
    }

    public static void main(String[] args) {
        // Criar uma instância e exibir a tela de gerenciamento
        new GerenciamentoView().exibirTelaGerenciamento();
    }
}
