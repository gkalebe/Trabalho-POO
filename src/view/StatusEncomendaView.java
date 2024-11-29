package view;

import controller.EncomendaController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StatusEncomendaView extends JFrame {

    private EncomendaController encomendaController;

    public StatusEncomendaView() {

        encomendaController = new EncomendaController();

        
            setTitle("Alterar Status da Encomenda");
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setSize(400, 300);
            setLayout(new GridLayout(6, 2, 10, 10));

                // Campos para CPF do cliente e novo status
                JLabel labelCpf = new JLabel("CPF do Cliente:");
                JTextField campoCpf = new JTextField();

                    JLabel labelNovoStatus = new JLabel("Novo Status:");
                    String[] statusOpcoes = {"Solicitado", "Cancelado", "Enviado", "Entregue"};
                    JComboBox<String> comboStatus = new JComboBox<>(statusOpcoes);

                        JButton botaoAlterarStatus = new JButton("Alterar Status");
                        JButton botaoVoltar = new JButton("Voltar");
                        JLabel mensagem = new JLabel("", SwingConstants.CENTER);

        
                                add(labelCpf);
                                add(campoCpf);
                                add(labelNovoStatus);
                                add(comboStatus);
                                add(botaoAlterarStatus);
                                add(mensagem);
                                add(botaoVoltar);

                
                botaoAlterarStatus.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String cpf = campoCpf.getText();
                        String novoStatus = (String) comboStatus.getSelectedItem();

                        
                        if (cpf.isEmpty()) {
                            mensagem.setText("CPF é obrigatório!");
                            mensagem.setForeground(Color.RED);
                        } else {
                            boolean sucesso = encomendaController.alterarStatusEncomenda(cpf, novoStatus);
                            if (sucesso) {
                                mensagem.setText("Status da encomenda alterado com sucesso!");
                                mensagem.setForeground(Color.GREEN);
                            } else {
                                mensagem.setText("Erro ao alterar status.");
                                mensagem.setForeground(Color.RED);
                            }
                        }
                    }
                });

        // Ação do botão de voltar
        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela de alterar status
                new GerenciamentoView().exibirTelaGerenciamento(); // Volta para a tela de gerenciamento
            }
        });

        setVisible(true);
    }

    public static void main(String[] args) {
        new StatusEncomendaView(); // Criar e exibir a tela de alterar status
    }
}
