package view;

import controller.EncomendaController;
import controller.ClienteController;
import model.Produto;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class FazerEncomendaView extends JFrame {

    private EncomendaController encomendaController;
    private ClienteController clienteController;

    public FazerEncomendaView() {
        encomendaController = new EncomendaController();
        clienteController = new ClienteController();

        setTitle("Fazer Encomenda");
        setSize(600, 500);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Selecione os Produtos");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel cpfLabel = new JLabel("Digite o CPF do cliente:");
        JTextField cpfField = new JTextField(15);
        JPanel cpfPanel = new JPanel();
        cpfPanel.add(cpfLabel);
        cpfPanel.add(cpfField);

        List<Produto> produtos = encomendaController.getProdutosDisponiveis();
        JPanel panelProdutos = new JPanel(new GridLayout(produtos.size(), 3));

        for (Produto produto : produtos) {
            JLabel produtoLabel = new JLabel(produto.getNome());
            JTextField quantidadeField = new JTextField("1", 5);

            panelProdutos.add(produtoLabel);
            panelProdutos.add(quantidadeField);

            produto.setQuantidade(Integer.parseInt(quantidadeField.getText()));
        }

        JButton botaoConfirmar = new JButton("Confirmar Encomenda");
        JButton botaoVoltar = new JButton("Voltar");

        estilizarBotao(botaoConfirmar);
        estilizarBotao(botaoVoltar);

        botaoConfirmar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = cpfField.getText().trim();
                if (cpf.isEmpty()) {
                    JOptionPane.showMessageDialog(FazerEncomendaView.this, "Por favor, insira o CPF do cliente.");
                    return;
                }

                Cliente cliente = clienteController.buscarClientePorCPF(cpf);
                if (cliente == null) {
                    JOptionPane.showMessageDialog(FazerEncomendaView.this, "Cliente não encontrado para o CPF informado.");
                    return;
                }

                List<Produto> produtosSelecionados = getProdutosSelecionados(produtos);
                int idCliente = clienteController.buscarIdPorCPF(cpf);
                int idLocal = 1;

                if (encomendaController.criarEncomenda(idCliente, produtosSelecionados, idLocal)) {
                    JOptionPane.showMessageDialog(FazerEncomendaView.this, "Encomenda realizada com sucesso!");
                    dispose();
                    new MenuView();
                } else {
                    JOptionPane.showMessageDialog(FazerEncomendaView.this, "Erro ao realizar a encomenda.");
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuView();
            }
        });

        add(titulo);
        add(cpfPanel);
        add(panelProdutos);
        add(botaoConfirmar);
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

    private List<Produto> getProdutosSelecionados(List<Produto> produtos) {
        for (Produto produto : produtos) {
            JTextField quantidadeField = new JTextField(String.valueOf(produto.getQuantidade()));
            try {
                int quantidade = Integer.parseInt(quantidadeField.getText());
                produto.setQuantidade(quantidade);
            } catch (NumberFormatException ex) {
                produto.setQuantidade(0);
            }
        }
        return produtos;
    }

    public static void main(String[] args) {
        new FazerEncomendaView();
    }
}
