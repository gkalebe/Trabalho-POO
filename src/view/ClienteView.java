package view;

import javax.swing.*;

import view.CadastroClienteView.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView {
    public static void main(String[] args) {

        Cliente cliente = new CadastroClienteView.Cliente("Cliente Teste", "cli", "123", "", "", "", "", "");
        CadastroClienteView.clientes.put("cli", cliente);
        
        JFrame frame = new JFrame("Sistema de Login Cliente");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLayout(new GridLayout(4, 2));

        // Campos para o CPF (usuário) e senha
        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField();

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoLogin = new JButton("Login");
        JButton botaoCadastrar = new JButton("Cadastrar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        frame.add(labelUsuario);
        frame.add(campoUsuario);
        frame.add(labelSenha);
        frame.add(campoSenha);
        frame.add(botaoLogin);
        frame.add(botaoCadastrar);
        frame.add(mensagem);

        
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
        
                // Verifica se o cliente existe no sistema
                if (CadastroClienteView.clientes.containsKey(cpf) && CadastroClienteView.clientes.get(cpf).getSenha().equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mensagem.setForeground(Color.GREEN);
        
                    // Abre a tela de encomenda e fecha o login
                    EncomendaView.exibirTelaDeEncomenda(cpf);
                } else {
                    mensagem.setText("Usuário ou senha inválidos.");
                    mensagem.setForeground(Color.RED);
                }
            }
        });
        

        
        botaoCadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CadastroClienteView.exibirTelaDeCadastro();
            }
        });

        frame.setVisible(true);
    }
}
