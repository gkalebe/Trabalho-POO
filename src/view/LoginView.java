package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    public LoginView() {
        // Configuração básica do frame
        setTitle("Tela de Login - Gerenciamento");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new GridLayout(5, 2)); // Ajuste para acomodar o novo botão

        // Campos para o nome de usuário e senha
        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField campoUsuario = new JTextField();

        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField campoSenha = new JPasswordField();

        JButton botaoLogin = new JButton("Login");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        // Adicionando os componentes ao frame
        add(labelUsuario);
        add(campoUsuario);
        add(labelSenha);
        add(campoSenha);
        add(botaoLogin);
        add(mensagem);
        add(botaoVoltar); // Adicionando o botão "Voltar"

        // Ação do botão de login
        botaoLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = campoUsuario.getText();
                String senha = new String(campoSenha.getPassword());

                // Validação simples de login
                if ("admin".equals(usuario) && "123".equals(senha)) {
                    mensagem.setText("Login bem-sucedido!");
                    mensagem.setForeground(Color.GREEN);
                    // Fechar a janela de login
                    dispose(); // Fecha a janela de login
                    // Exibir a tela de gerenciamento após login bem-sucedido
                    exibirTelaGerenciamento();
                } else {
                    mensagem.setText("Usuário ou senha inválidos.");
                    mensagem.setForeground(Color.RED);
                }
            }
        });

        // Ação do botão de voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Fechar a janela de login
                setVisible(false); // Apenas oculta a janela de login
                
                // Criar e exibir o MainMenu novamente
                new MainMenu().setVisible(true); // Exibe o menu principal
            }
        });

        setVisible(true);
    }

    // Método para exibir a tela de gerenciamento após o login bem-sucedido
    private void exibirTelaGerenciamento() {
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
        telaGerenciamento.setLocationRelativeTo(null); // Centraliza a janela
        telaGerenciamento.setVisible(true);
    }

    public static void main(String[] args) {
        new LoginView(); // Criar e exibir a tela de login
    }
}
