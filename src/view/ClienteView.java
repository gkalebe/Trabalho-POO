package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.MainMenu;

public class ClienteView extends JFrame {

    public ClienteView() {
        setTitle("Login Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(4, 2));

        // Campos para o CPF (usuário) e senha
        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField();

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoLogin = new JButton("Login");
        JButton botaoCadastrar = new JButton("Cadastrar");

        JButton botaoVoltar = new JButton("Voltar");

        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(botaoLogin);
        add(botaoCadastrar);
        add(botaoVoltar);
        add(mensagem);

        // Ação do botão "Login"
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                if (CadastroClienteView.clientes.containsKey(cpf) && CadastroClienteView.clientes.get(cpf).getSenha().equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mensagem.setForeground(Color.GREEN);
                } else {
                    mensagem.setText("Usuário ou senha inválidos.");
                    mensagem.setForeground(Color.RED);
                }
            }
        });

        // Ação do botão "Cadastrar"
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroClienteView.exibirTelaDeCadastro();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu();
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new ClienteView();
    }
}
