package view;

import controller.EnderecoController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AlterarEnderecoView extends JFrame {

    private EnderecoController enderecoController;

    public AlterarEnderecoView() {
        enderecoController = new EnderecoController();

        setTitle("Alterar Endereço");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 2, 10, 10));

        JLabel labelCpf = new JLabel("CPF do Cliente:");
        JTextField campoCpf = new JTextField();

        JLabel labelNovoCep = new JLabel("CEP:");
        JTextField campoCep = new JTextField();

        JLabel labelNovaCidade = new JLabel("Cidade:");
        JTextField campoCidade = new JTextField();

        JLabel labelNovoEstado = new JLabel("Estado:");
        JTextField campoEstado = new JTextField();

        JButton botaoAlterar = new JButton("Alterar");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 0));
        painelBotoes.add(botaoAlterar);
        painelBotoes.add(botaoVoltar);

        add(labelCpf);
        add(campoCpf);
        add(labelNovoCep);
        add(campoCep);
        add(labelNovaCidade);
        add(campoCidade);
        add(labelNovoEstado);
        add(campoEstado);
        add(painelBotoes);
        add(mensagem);

        botaoAlterar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoCpf.getText();
                String cep = campoCep.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getText();

                if (cpf.isEmpty() || cep.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                    mensagem.setText("Preencha todos os campos!");
                    mensagem.setForeground(Color.RED);
                } else {
                    boolean sucesso = enderecoController.alterarEndereco(cpf, cep, cidade, estado);
                    if (sucesso) {
                        mensagem.setText("Endereço alterado com sucesso!");
                        mensagem.setForeground(Color.GREEN);
                    } else {
                        mensagem.setText("Erro ao alterar endereço.");
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
        new AlterarEnderecoView();
    }
}
