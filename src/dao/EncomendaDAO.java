package dao;

import util.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EncomendaDAO {

    // Atualiza o status da encomenda para o cliente com o CPF fornecido
    public boolean atualizarStatusEncomenda(String cpf, String novoStatus) {
        String sqlBuscaCliente = "SELECT id_cliente FROM cliente WHERE cpf = ?";
        String sqlAtualizaStatus = "UPDATE encomenda SET status = ? WHERE id_cliente = ? AND status != 'Entregue'";

        try (Connection conn = Banco.getConexao();
             PreparedStatement stmtBuscaCliente = conn.prepareStatement(sqlBuscaCliente)) {

            // Busca o id_cliente pelo CPF
            stmtBuscaCliente.setString(1, cpf);
            ResultSet rs = stmtBuscaCliente.executeQuery();

            if (rs.next()) {
                int idCliente = rs.getInt("id_cliente");

                // Atualiza o status da encomenda para o cliente
                try (PreparedStatement stmtAtualizaStatus = conn.prepareStatement(sqlAtualizaStatus)) {
                    stmtAtualizaStatus.setString(1, novoStatus);
                    stmtAtualizaStatus.setInt(2, idCliente);

                    int rowsAffected = stmtAtualizaStatus.executeUpdate();
                    return rowsAffected > 0; // Retorna true se o status foi atualizado
                }
            } else {
                System.out.println("Cliente não encontrado com o CPF: " + cpf);
                return false; // Cliente não encontrado
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
