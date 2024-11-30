package controller;

import dao.ProdutoDAO;
import model.Produto;
import java.util.List;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

    public ProdutoController() {
        produtoDAO = new ProdutoDAO();
    }

    public boolean cadastrarProduto(String nome, String tipo, double preco, int quantidade) {
        Produto produto = new Produto(nome, tipo, preco, quantidade);
        return produtoDAO.salvarProduto(produto);
    }

    public List<Produto> getTodosProdutos() {
        return produtoDAO.buscarTodosProdutos();
    }

    public boolean atualizarQuantidadeProduto(int idProduto, int novaQuantidade) {
        Produto produto = produtoDAO.buscarProdutoPorId(idProduto);
        if (produto != null) {
            produto.setQuantidade(novaQuantidade);
            return produtoDAO.atualizarProduto(produto);
        }
        return false;
    }
}
