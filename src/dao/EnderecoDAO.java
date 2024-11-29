package dao;

import model.Endereco;
import util.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EnderecoDAO {

    public boolean alterarEndereco(String cpf, Endereco endereco) {
        String sql = "UPDATE cliente SET cep = ?, cidade = ?, estado = ? WHERE cpf = ?";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, endereco.getCep());
            stmt.setString(2, endereco.getCidade());
            stmt.setString(3, endereco.getEstado());
            stmt.setString(4, cpf);

            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }
}
