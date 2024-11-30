package controller;

import dao.EncomendaDAO;
import model.Encomenda;
import model.Produto;
import java.util.List;

public class EncomendaController {

    private EncomendaDAO encomendaDAO;
    private ProdutoController produtoController;

    public EncomendaController() {
        encomendaDAO = new EncomendaDAO();
        produtoController = new ProdutoController();
    }

    public boolean criarEncomenda(int idCliente, List<Produto> produtos, int idLocal) {
        Encomenda encomenda = new Encomenda();
        encomenda.setIdCliente(idCliente);
        encomenda.setDataEncomenda(new java.util.Date());
        encomenda.setDataEntrega(null); 
        encomenda.setIdLocal(idLocal);
        encomenda.setStatus("Pendente");
        encomenda.setProdutos(produtos);

        return encomendaDAO.salvarEncomenda(encomenda);
    }

    public boolean alterarStatusEncomenda(String cpf, String novoStatus) {
        if ("Solicitado".equals(novoStatus) || "Cancelado".equals(novoStatus) || "Enviado".equals(novoStatus) || "Entregue".equals(novoStatus)) {
            return encomendaDAO.atualizarStatusEncomenda(cpf, novoStatus);
        }
        return false;
    }

    public List<Produto> getProdutosDisponiveis() {
        return produtoController.getTodosProdutos();
    }

    public String buscarStatusEncomenda(String cpf) {
        return encomendaDAO.buscarStatusEncomenda(cpf);
    }
}
