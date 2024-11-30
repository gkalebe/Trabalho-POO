package view;

import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CadastroClienteView {

    public static HashMap<String, Cliente> clientes = new HashMap<>();

    public static void exibirTelaDeCadastro() {
        JFrame cadastroFrame = new JFrame("Cadastro de Cliente");
        cadastroFrame.setSize(400, 400);
        cadastroFrame.setLayout(new GridLayout(9, 2, 10, 10));

        JLabel labelCPF = new JLabel("CPF:");
        JTextField campoCPF = new JTextField();

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JLabel labelCEP = new JLabel("CEP:");
        JTextField campoCEP = new JTextField();

        JLabel labelCidade = new JLabel("Cidade:");
        JTextField campoCidade = new JTextField();

        JLabel labelEstado = new JLabel("Estado:");
        JTextField campoEstado = new JTextField();

        JLabel labelTelefone = new JLabel("Telefone:");
        JTextField campoTelefone = new JTextField();

        JLabel labelEmail = new JLabel("Email:");
        JTextField campoEmail = new JTextField();

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        cadastroFrame.add(labelCPF);
        cadastroFrame.add(campoCPF);
        cadastroFrame.add(labelSenha);
        cadastroFrame.add(campoSenha);
        cadastroFrame.add(labelCEP);
        cadastroFrame.add(campoCEP);
        cadastroFrame.add(labelCidade);
        cadastroFrame.add(campoCidade);
        cadastroFrame.add(labelEstado);
        cadastroFrame.add(campoEstado);
        cadastroFrame.add(labelTelefone);
        cadastroFrame.add(campoTelefone);
        cadastroFrame.add(labelEmail);
        cadastroFrame.add(campoEmail);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoVoltar);
        cadastroFrame.add(painelBotoes);
        cadastroFrame.add(mensagem);

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoCPF.getText();
                String senha = new String(campoSenha.getPassword());
                String cep = campoCEP.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getText();
                String telefone = campoTelefone.getText();
                String email = campoEmail.getText();

                if (cpf.isEmpty() || senha.isEmpty() || cep.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                    mensagem.setText("Preencha todos os campos obrigatórios!");
                    mensagem.setForeground(Color.RED);
                } else {
                    Cliente cliente = new Cliente(cpf, senha, cep, cidade, estado, telefone, email);
                    clientes.put(cpf, cliente);
                    mensagem.setText("Cliente cadastrado com sucesso!");
                    mensagem.setForeground(Color.GREEN);
                }
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cadastroFrame.dispose();
            }
        });

        cadastroFrame.setVisible(true);
    }
}
