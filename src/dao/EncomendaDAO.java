package dao;

import model.Encomenda;
import util.Banco;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EncomendaDAO {

    public boolean salvarEncomenda(Encomenda encomenda) {
        String sql = "INSERT INTO encomenda (id_cliente, data_encomenda, data_entrega, id_local, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setInt(1, encomenda.getIdCliente());
            stmt.setDate(2, new java.sql.Date(encomenda.getDataEncomenda().getTime()));
            stmt.setDate(3, null); 
            stmt.setInt(4, encomenda.getIdLocal());
            stmt.setString(5, encomenda.getStatus());

            return stmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean atualizarStatusEncomenda(String cpf, String novoStatus) {
        String sqlBuscaCliente = "SELECT id_cliente FROM cliente WHERE cpf = ?";
        String sqlAtualizaStatus = "UPDATE encomenda SET status = ? WHERE id_cliente = ? AND status != 'Entregue'";

        try (Connection conn = Banco.getConexao();
             PreparedStatement stmtBuscaCliente = conn.prepareStatement(sqlBuscaCliente)) {

            stmtBuscaCliente.setString(1, cpf);
            ResultSet rs = stmtBuscaCliente.executeQuery();

            if (rs.next()) {
                int idCliente = rs.getInt("id_cliente");

                try (PreparedStatement stmtAtualizaStatus = conn.prepareStatement(sqlAtualizaStatus)) {
                    stmtAtualizaStatus.setString(1, novoStatus);
                    stmtAtualizaStatus.setInt(2, idCliente);

                    int rowsAffected = stmtAtualizaStatus.executeUpdate();
                    return rowsAffected > 0;
                }
            } else {
                System.out.println("Cliente não encontrado com o CPF: " + cpf);
                return false;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    public String buscarStatusEncomenda(String cpf) {
        String sql = "SELECT e.status FROM encomenda e INNER JOIN cliente c ON e.id_cliente = c.id_cliente WHERE c.cpf = ?";

        try (Connection conn = Banco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return rs.getString("status");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }
}
