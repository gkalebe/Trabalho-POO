package view;

import controller.ProdutoController;
import view.MainMenu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CadastrarProdutoView extends JFrame {

    private ProdutoController produtoController;

    public CadastrarProdutoView() {
        produtoController = new ProdutoController();

        
        setTitle("Cadastrar Produto");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLayout(new GridLayout(5, 2, 10, 10));

        
        JLabel labelNome = new JLabel("Nome do Produto:");
        JTextField campoNome = new JTextField();

        JLabel labelTipo = new JLabel("Tipo:");
        JTextField campoTipo = new JTextField();

        JLabel labelPreco = new JLabel("Preço:");
        JTextField campoPreco = new JTextField();

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        
        add(labelNome);
        add(campoNome);
        add(labelTipo);
        add(campoTipo);
        add(labelPreco);
        add(campoPreco);
        add(botaoSalvar);
        add(mensagem);
        add(botaoVoltar);

        
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nome = campoNome.getText();
                String tipo = campoTipo.getText();
                String precoText = campoPreco.getText();

                
                if (nome.isEmpty() || precoText.isEmpty()) {
                    mensagem.setText("Preencha todos os campos!");
                    mensagem.setForeground(Color.RED);
                } else {
                    try {
                        double preco = Double.parseDouble(precoText);
                        boolean sucesso = produtoController.cadastrarProduto(nome, tipo, preco);
                        if (sucesso) {
                            mensagem.setText("Produto cadastrado com sucesso!");
                            mensagem.setForeground(Color.GREEN);
                        } else {
                            mensagem.setText("Erro ao cadastrar produto.");
                            mensagem.setForeground(Color.RED);
                        }
                    } catch (NumberFormatException ex) {
                        mensagem.setText("Preço inválido.");
                        mensagem.setForeground(Color.RED);
                    }
                }
            }
        });


        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new GerenciamentoView().exibirTelaGerenciamento();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new CadastrarProdutoView();
    }
}
