package dao;

import model.Produto;
import util.Banco;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {

    public boolean salvarProduto(Produto produto) {
        String sql = "INSERT INTO produto (nome, tipo, preco, quantidade) VALUES (?, ?, ?, ?)";
        
        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade()); 

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public Produto buscarProdutoPorId(int idProduto) {
        String sql = "SELECT * FROM produto WHERE id_produto = ?";
        
        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, idProduto);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Produto(
                    rs.getString("nome"),
                    rs.getString("tipo"),
                    rs.getDouble("preco"),
                    rs.getInt("quantidade")
                );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public boolean atualizarProduto(Produto produto) {
        String sql = "UPDATE produto SET nome = ?, tipo = ?, preco = ?, quantidade = ? WHERE id_produto = ?";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setDouble(3, produto.getPreco());
            stmt.setInt(4, produto.getQuantidade());  
            stmt.setInt(5, produto.getIdProduto());

            return stmt.executeUpdate() > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public List<Produto> buscarTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produto";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("nome"),
                        rs.getString("tipo"),
                        rs.getDouble("preco"),
                        rs.getInt("quantidade") 
                );
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return produtos;
    }
}
