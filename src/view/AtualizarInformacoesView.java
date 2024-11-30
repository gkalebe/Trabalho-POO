package view;

import controller.ClienteController;
import model.Cliente;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AtualizarInformacoesView extends JFrame {

    private ClienteController clienteController;
    private JTextField campoCpf, campoCep, campoCidade, campoEstado, campoTelefone, campoEmail;
    private JLabel mensagem;

    public AtualizarInformacoesView() {
        clienteController = new ClienteController();

        setTitle("Atualizar Informações");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 550);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(8, 2, 10, 10));

        JLabel labelCpf = new JLabel("CPF:");
        campoCpf = new JTextField(15);

        JButton botaoBuscar = new JButton("Buscar");
        estilizarBotao(botaoBuscar);

        JLabel labelCep = new JLabel("CEP:");
        campoCep = new JTextField(15);

        JLabel labelCidade = new JLabel("Cidade:");
        campoCidade = new JTextField(15);

        JLabel labelEstado = new JLabel("Estado:");
        campoEstado = new JTextField(15);

        JLabel labelTelefone = new JLabel("Telefone:");
        campoTelefone = new JTextField(15);

        JLabel labelEmail = new JLabel("Email:");
        campoEmail = new JTextField(15);

        JButton botaoSalvar = new JButton("Salvar");
        JButton botaoCancelar = new JButton("Cancelar");
        JButton botaoVoltar = new JButton("Voltar");

        mensagem = new JLabel("", SwingConstants.CENTER);

        JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 0));
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoCancelar);
        painelBotoes.add(botaoVoltar);

        estilizarBotao(botaoSalvar);
        estilizarBotao(botaoCancelar);
        estilizarBotao(botaoVoltar);

        add(labelCpf);
        add(campoCpf);
        add(new JLabel());
        add(botaoBuscar);
        add(labelCep);
        add(campoCep);
        add(labelCidade);
        add(campoCidade);
        add(labelEstado);
        add(campoEstado);
        add(labelTelefone);
        add(campoTelefone);
        add(labelEmail);
        add(campoEmail);
        add(painelBotoes);
        add(mensagem);

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buscarCliente();
            }
        });

        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                salvarAlteracoes();
            }
        });

        botaoCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                limparCampos();
            }
        });

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new MenuView();
            }
        });

        setVisible(true);
    }

    private void buscarCliente() {
        String cpf = campoCpf.getText();
        if (cpf.isEmpty()) {
            mensagem.setText("Digite o CPF para buscar.");
            mensagem.setForeground(Color.RED);
            return;
        }

        Cliente cliente = clienteController.buscarClientePorCPF(cpf);
        if (cliente != null) {
            campoCep.setText(cliente.getCep());
            campoCidade.setText(cliente.getCidade());
            campoEstado.setText(cliente.getEstado());
            campoTelefone.setText(cliente.getTelefone());
            campoEmail.setText(cliente.getEmail());
            mensagem.setText("Informações carregadas com sucesso.");
            mensagem.setForeground(Color.GREEN);
        } else {
            mensagem.setText("Cliente não encontrado.");
            mensagem.setForeground(Color.RED);
        }
    }

    private void salvarAlteracoes() {
        String cpf = campoCpf.getText();
        String cep = campoCep.getText();
        String cidade = campoCidade.getText();
        String estado = campoEstado.getText();
        String telefone = campoTelefone.getText();
        String email = campoEmail.getText();

        if (cpf.isEmpty() || cep.isEmpty() || cidade.isEmpty() || estado.isEmpty() || telefone.isEmpty() || email.isEmpty()) {
            mensagem.setText("Preencha todos os campos.");
            mensagem.setForeground(Color.RED);
            return;
        }

        Cliente cliente = new Cliente(cpf, null, cep, cidade, estado, telefone, email);
        boolean sucesso = clienteController.atualizarCliente(cliente);

        if (sucesso) {
            mensagem.setText("Informações atualizadas com sucesso!");
            mensagem.setForeground(Color.GREEN);
        } else {
            mensagem.setText("Erro ao atualizar as informações.");
            mensagem.setForeground(Color.RED);
        }
    }

    private void limparCampos() {
        campoCep.setText("");
        campoCidade.setText("");
        campoEstado.setText("");
        campoTelefone.setText("");
        campoEmail.setText("");
        mensagem.setText("");
    }

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 16));
        botao.setBackground(new Color(0, 128, 0));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
    }

    public static void main(String[] args) {
        new AtualizarInformacoesView();
    }
}
