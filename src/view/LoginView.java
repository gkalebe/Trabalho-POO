package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    public LoginView() {

        setTitle("Tela de Login - Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(5, 2));

        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField();

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoLogin = new JButton("Login");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(botaoLogin);
        add(mensagem);
        add(botaoVoltar); 

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                if ("admin".equals(usuario) && "123".equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mensagem.setForeground(Color.GREEN);

                    dispose();
                    new GerenciamentoView().exibirTelaGerenciamento();
                } else {
                    mensagem.setText("Usuário ou senha inválidos.");
                    mensagem.setForeground(Color.RED);
                }
            }
        });

        // Ação do botão "Voltar"
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MainMenu().setVisible(true); 
            }
        });

        setVisible(true); 
    }

    public static void main(String[] args) {
        new LoginView(); 
    }
}
