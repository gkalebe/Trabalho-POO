package view;

import controller.EncomendaController;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VisualizarStatusEncomendaView extends JFrame {

    private EncomendaController encomendaController;

    public VisualizarStatusEncomendaView() {
        encomendaController = new EncomendaController();

        setTitle("Visualizar Status da Encomenda");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        JLabel labelCpf = new JLabel("Informe o CPF:");
        JTextField campoCpf = new JTextField(15);
        JButton botaoBuscar = new JButton("Buscar Status");
        JLabel labelStatus = new JLabel("Status: ", SwingConstants.CENTER);
        JButton botaoVoltar = new JButton("Voltar");

        estilizarBotao(botaoBuscar);
        estilizarBotao(botaoVoltar);

        JPanel panelInputs = new JPanel();
        panelInputs.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelInputs.add(labelCpf);
        panelInputs.add(campoCpf);
        panelInputs.add(botaoBuscar);

        JPanel panelStatus = new JPanel();
        panelStatus.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        panelStatus.add(labelStatus);

        add(panelInputs);
        add(panelStatus);
        add(Box.createRigidArea(new Dimension(0, 20)));
        add(botaoVoltar);

        botaoBuscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpf = campoCpf.getText();
                String status = encomendaController.buscarStatusEncomenda(cpf);

                if (status != null) {
                    labelStatus.setText("Status: " + status);
                } else {
                    labelStatus.setText("Encomenda não encontrada.");
                }
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

    private void estilizarBotao(JButton botao) {
        botao.setFont(new Font("Arial", Font.BOLD, 14));
        botao.setBackground(new Color(0, 128, 0));
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public static void main(String[] args) {
        new VisualizarStatusEncomendaView();
    }
}
