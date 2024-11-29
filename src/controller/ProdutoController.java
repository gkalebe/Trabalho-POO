package controller;


import dao.ProdutoDAO;
import model.Produto;

public class ProdutoController {
    private ProdutoDAO produtoDAO;

        public ProdutoController(){
            produtoDAO = new Produto();
        }

                public boolean  cadastrarProduto(String nome, String tipo, double preco){
                    Produto produto = new Produto(nome, tipo, preco);
                        return produtoDAO.salvarProduto(produto);
                }
}
