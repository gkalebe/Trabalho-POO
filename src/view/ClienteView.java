package view;

import dao.ClienteDAO;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ClienteView extends JFrame {

    public ClienteView() {
        setTitle("Login Cliente");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel titulo = new JLabel("Login do Cliente");
        titulo.setFont(new Font("Arial", Font.BOLD, 18));
        titulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel labelUsuario = new JLabel("Usuário (CPF):");
        JTextField campoUsuario = new JTextField(15);
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField(15);

        JButton botaoLogin = new JButton("Login");
        JButton botaoCadastrar = new JButton("Cadastrar");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        estilizarBotao(botaoLogin);
        estilizarBotao(botaoCadastrar);
        estilizarBotao(botaoVoltar);

        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());
                ClienteDAO clienteDAO = new ClienteDAO();

                System.out.println("Tentando login para CPF: " + cpf);

                Cliente cliente = clienteDAO.buscarPorCPF(cpf);
                if (cliente != null && cliente.getSenha().equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mensagem.setForeground(Color.GREEN);
                    System.out.println("Login bem-sucedido para CPF: " + cpf);
                    dispose();
                    new MenuView();
                } else {
                    mensagem.setText("Usuário ou senha inválidos.");
                    mensagem.setForeground(Color.RED);
                    System.err.println("Login falhou para CPF: " + cpf);
                }
            }
        });

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

        JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
        painelFormulario.setMaximumSize(new Dimension(300, 100));
        painelFormulario.add(labelUsuario);
        painelFormulario.add(campoUsuario);
        painelFormulario.add(labelSenha);
        painelFormulario.add(campoSenha);
        painelFormulario.add(mensagem);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        painelBotoes.add(botaoLogin);
        painelBotoes.add(botaoCadastrar);
        painelBotoes.add(botaoVoltar);

        add(Box.createRigidArea(new Dimension(0, 20)));
        add(titulo);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(painelFormulario);
        add(Box.createRigidArea(new Dimension(0, 10)));
        add(painelBotoes);

        setVisible(true);
    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(new Color(0, 128, 0));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
    }

    public static void main(String[] args) {
        new ClienteView();
    }
}
