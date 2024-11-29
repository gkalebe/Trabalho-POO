package view;

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
        cadastroFrame.setLayout(new GridLayout(10, 2, 10, 10)); // Ajustado para um layout mais espaçado

        // Labels e campos
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

        JButton botaoSalvar = new JButton("Salvar/Atualizar");
        JButton botaoExcluir = new JButton("Excluir");
        JButton botaoVoltar = new JButton("Voltar");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        // Adicionando componentes no frame
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
        cadastroFrame.add(botaoSalvar);
        cadastroFrame.add(botaoExcluir);
        cadastroFrame.add(botaoVoltar);
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

                if (cpf.isEmpty() || senha.isEmpty() || nome.isEmpty()) {
                    mensagem.setText("Nome, CPF e senha são obrigatórios!");
                    mensagem.setForeground(Color.RED);
                } else {
                    Cliente cliente = new Cliente(nome, cpf, senha, cep, cidade, estado, telefone, email);
                    clientes.put(cpf, cliente);
                    mensagem.setText("Cliente salvo/atualizado com sucesso!");
                    mensagem.setForeground(Color.GREEN);
                }
            }
        });

       
        botaoExcluir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoCPF.getText();

                if (clientes.containsKey(cpf)) {
                    clientes.remove(cpf);
                    mensagem.setText("Cliente excluído com sucesso!");
                    mensagem.setForeground(Color.GREEN);
                } else {
                    mensagem.setText("Cliente não encontrado!");
                    mensagem.setForeground(Color.RED);
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
        cadastroFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    
    static class Cliente {
        private String nome;
        private String cpf;
        private String senha;
        private String cep;
        private String cidade;
        private String estado;
        private String telefone;
        private String email;

        public Cliente(String nome, String cpf, String senha, String cep, String cidade, String estado, String telefone, String email) {
            this.nome = nome;
            this.cpf = cpf;
            this.senha = senha;
            this.cep = cep;
            this.cidade = cidade;
            this.estado = estado;
            this.telefone = telefone;
            this.email = email;
        }

        public String getNome() {
            return nome;
        }

        public String getCpf() {
            return cpf;
        }

        public String getSenha() {
            return senha;
        }

        public String getCep() {
            return cep;
        }

        public String getCidade() {
            return cidade;
        }

        public String getEstado() {
            return estado;
        }

        public String getTelefone() {
            return telefone;
        }

        public String getEmail() {
            return email;
        }
    }

    public static void main(String[] args) {
        // Chama a função de exibição da tela de cadastro ao iniciar o programa
        exibirTelaDeCadastro();
    }
}
