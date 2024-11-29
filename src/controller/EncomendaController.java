package controller;

import dao.EncomendaDAO;

public class EncomendaController {

    private EncomendaDAO encomendaDAO;

    public EncomendaController() {
        encomendaDAO = new EncomendaDAO();
    }

    // Método para alterar o status da encomenda com base no CPF
    public boolean alterarStatusEncomenda(String cpf, String novoStatus) {
        // Validação simples para garantir que o status seja válido
        if (novoStatus.equals("Solicitado") || novoStatus.equals("Cancelado") || novoStatus.equals("Enviado") || novoStatus.equals("Entregue")) {
            return encomendaDAO.atualizarStatusEncomenda(cpf, novoStatus);
        }
        return false; // Retorna false se o status for inválido
    }
}
