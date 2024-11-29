package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class EncomendaView {
    // Estrutura de dados para armazenar encomendas (exemplo básico)
    private static HashMap<String, Encomenda> encomendas = new HashMap<>();

    // Exibir a tela de gerenciamento de encomendas
    public static void exibirTelaDeEncomenda(String cpfUsuario) {
        JFrame encomendaFrame = new JFrame("Gerenciar Encomenda");
        encomendaFrame.setSize(400, 300);
        encomendaFrame.setLayout(new GridLayout(7, 2));

        // Campos para alteração de status da encomenda
        JLabel labelStatus = new JLabel("Status:");
        String[] opcoesStatus = {"Em preparação", "Enviado", "Entregue"};
        JComboBox<String> comboStatus = new JComboBox<>(opcoesStatus);

        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoTrocarEndereco = new JButton("Trocar Endereço");
        JButton botaoSair = new JButton("Sair");
        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        encomendaFrame.add(new JLabel("Nome:"));
        encomendaFrame.add(new JLabel(cpfUsuario)); // Mostra o CPF do cliente logado
        encomendaFrame.add(labelStatus);
        encomendaFrame.add(comboStatus);
        encomendaFrame.add(botaoVoltar);
        encomendaFrame.add(botaoTrocarEndereco); // Botão para trocar o endereço
        encomendaFrame.add(botaoSair);
        encomendaFrame.add(mensagem);

        // Ação do botão voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encomendaFrame.dispose(); // Fecha a tela de encomendas
            }
        });

        // Ação do botão trocar endereço
        botaoTrocarEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Leva para a tela de troca de endereço
                exibirTelaDeTrocaEndereco(cpfUsuario);
            }
        });

        // Ação do botão sair
        botaoSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encomendaFrame.dispose(); // Fecha a tela de encomendas
            }
        });

        encomendaFrame.setVisible(true);
    }

    // Exibir tela para troca de endereço
    public static void exibirTelaDeTrocaEndereco(String cpfUsuario) {
        JFrame trocaEnderecoFrame = new JFrame("Trocar Endereço");
        trocaEnderecoFrame.setSize(400, 300);
        trocaEnderecoFrame.setLayout(new GridLayout(5, 2));

        JLabel labelCep = new JLabel("CEP:");
        JTextField campoCep = new JTextField();

        JLabel labelCidade = new JLabel("Cidade:");
        JTextField campoCidade = new JTextField();

        JLabel labelEstado = new JLabel("Estado:");
        JTextField campoEstado = new JTextField();

        JButton botaoSalvarEndereco = new JButton("Salvar Endereço");
        JButton botaoVoltar = new JButton("Voltar");

        trocaEnderecoFrame.add(labelCep);
        trocaEnderecoFrame.add(campoCep);
        trocaEnderecoFrame.add(labelCidade);
        trocaEnderecoFrame.add(campoCidade);
        trocaEnderecoFrame.add(labelEstado);
        trocaEnderecoFrame.add(campoEstado);
        trocaEnderecoFrame.add(botaoSalvarEndereco);
        trocaEnderecoFrame.add(botaoVoltar);

        JLabel mensagem = new JLabel("", SwingConstants.CENTER);
        trocaEnderecoFrame.add(mensagem);

        // Ação do botão salvar endereço
        botaoSalvarEndereco.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cep = campoCep.getText();
                String cidade = campoCidade.getText();
                String estado = campoEstado.getText();

                if (cep.isEmpty() || cidade.isEmpty() || estado.isEmpty()) {
                    mensagem.setText("Todos os campos são obrigatórios.");
                    mensagem.setForeground(Color.RED);
                } else {
                    // Atualiza o endereço da encomenda do cliente
                    Encomenda encomenda = encomendas.get(cpfUsuario);
                    if (encomenda != null) {
                        encomenda.setEndereco("CEP: " + cep + ", Cidade: " + cidade + ", Estado: " + estado);
                        mensagem.setText("Endereço atualizado com sucesso!");
                        mensagem.setForeground(Color.GREEN);
                    } else {
                        mensagem.setText("Encomenda não encontrada.");
                        mensagem.setForeground(Color.RED);
                    }
                }
            }
        });

        // Ação do botão voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trocaEnderecoFrame.dispose(); // Fecha a tela de troca de endereço
            }
        });

        trocaEnderecoFrame.setVisible(true);
    }

    // Classe representando uma encomenda
    static class Encomenda {
        private String nomeCliente;
        private String endereco;
        private String status;

        public Encomenda(String nomeCliente, String endereco, String status) {
            this.nomeCliente = nomeCliente;
            this.endereco = endereco;
            this.status = status;
        }

        public String getNomeCliente() {
            return nomeCliente;
        }

        public String getEndereco() {
            return endereco;
        }

        public void setEndereco(String endereco) {
            this.endereco = endereco;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}
