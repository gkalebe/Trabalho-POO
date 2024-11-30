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
        setLayout(new FlowLayout());

        JLabel labelCpf = new JLabel("Informe o CPF:");
        JTextField campoCpf = new JTextField(15);
        JButton botaoBuscar = new JButton("Buscar Status");
        JLabel labelStatus = new JLabel("Status: ");
        
        add(labelCpf);
        add(campoCpf);
        add(botaoBuscar);
        add(labelStatus);

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

        setVisible(true);
    }

    public static void main(String[] args) {
        new VisualizarStatusEncomendaView();
    }
}
