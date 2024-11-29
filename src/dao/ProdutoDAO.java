package dao;

import model.Produto;
import util.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProdutoDAO {

    public boolean salvarProduto(Produto produto) {
            String sql = "INSERT INTO produto (nome, tipo, preco) VALUES (?, ?, ?)";

        try (Connection conn = Banco.getConexao();
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getTipo());
            stmt.setDouble(3, produto.getPreco());


                    int rowsAffected = stmt.executeUpdate();
                    return rowsAffected > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}