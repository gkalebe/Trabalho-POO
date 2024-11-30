package view;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CadastroClienteView {

    public static void exibirTelaDeCadastro() {
        JFrame cadastroFrame = new JFrame("Cadastro de Cliente");
        cadastroFrame.setSize(400, 450);
        cadastroFrame.setLayout(new GridLayout(10, 2, 10, 10));

        JLabel labelNome = new JLabel("Nome:");
        JTextField campoNome = new JTextField();

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

        cadastroFrame.add(labelNome);
        cadastroFrame.add(campoNome);
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
                String nome = campoNome.getText();
                String cpf = campoCPF.getText();
                String senha = new String(campoSenha.getPassword());
                String cep = campoCEP.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getText();
                String telefone = campoTelefone.getText();
                String email = campoEmail.getText();

                // Logs para depuração
                System.out.println("Tentativa de cadastro do cliente com CPF: " + cpf);

                if (nome.isEmpty() || cpf.isEmpty() || senha.isEmpty() || cep.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                    mensagem.setText("Preencha todos os campos obrigatórios!");
                    mensagem.setForeground(Color.RED);
                    System.err.println("Falha no cadastro: Campos obrigatórios não preenchidos.");
                } else {
                    Cliente cliente = new Cliente(nome, cpf, senha, cep, cidade, estado, telefone, email);

                    // Salvando no banco de dados
                    ClienteDAO clienteDAO = new ClienteDAO();
                    if (clienteDAO.salvar(cliente)) {
                        mensagem.setText("Cliente cadastrado com sucesso!");
                        mensagem.setForeground(Color.GREEN);
                        System.out.println("Cliente cadastrado com sucesso no banco de dados.");
                    } else {
                        mensagem.setText("Erro ao cadastrar o cliente.");
                        mensagem.setForeground(Color.RED);
                        System.err.println("Erro ao salvar cliente no banco de dados.");
                    }
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
