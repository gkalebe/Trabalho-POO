package controller;

import dao.EncomendaDAO;

public class EncomendaController {

    private EncomendaDAO encomendaDAO;

    public EncomendaController() {
        encomendaDAO = new EncomendaDAO();
    }

    
    public boolean alterarStatusEncomenda(String cpf, String novoStatus) {
        
        if (novoStatus.equals("Solicitado") || novoStatus.equals("Cancelado") || novoStatus.equals("Enviado") || novoStatus.equals("Entregue")) {
            return encomendaDAO.atualizarStatusEncomenda(cpf, novoStatus);
        }
        return false;
    }
}
