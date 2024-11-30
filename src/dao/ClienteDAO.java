package dao;

import model.model.Cliente;
import model.model.Cliente;
import util.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public boolean salvar(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, cpf, senha, cep, cidade, estado, telefone, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getCpf());
            stmt.setString(2, cliente.getSenha());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());
            stmt.setString(6, cliente.getTelefone());
            stmt.setString(7, cliente.getEmail());

            return stmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Erro ao salvar cliente: " + ex.getMessage());
            return false;
        }
    }

    public Cliente buscarPorCPF(String cpf) {
        System.out.println("Iniciando busca no banco para CPF: " + cpf);
        String sql = "SELECT * FROM cliente WHERE cpf = ?";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cpf);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                System.out.println("Cliente encontrado para CPF: " + cpf);
                return new Cliente(
                        rs.getString("cpf"),
                        rs.getString("senha"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
            } else {
                System.err.println("Nenhum cliente encontrado para CPF: " + cpf);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao buscar cliente por CPF: " + ex.getMessage());
        }

        return null;
    }


    public boolean atualizar(Cliente cliente) {
        String sql = "UPDATE cliente SET nome = ?, senha = ?, cep = ?, cidade = ?, estado = ?, telefone = ?, email = ? WHERE cpf = ?";

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql)) {

            stmt.setString(1, cliente.getSenha());
            stmt.setString(2, cliente.getCep());
            stmt.setString(3, cliente.getCidade());
            stmt.setString(4, cliente.getEstado());
            stmt.setString(5, cliente.getTelefone());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getCpf());

            return stmt.executeUpdate() > 0;

        } catch (SQLException ex) {
            System.err.println("Erro ao atualizar cliente: " + ex.getMessage());
            return false;
        }
    }

    public List<Cliente> listarTodos() {
        String sql = "SELECT cpf, senha, cep, cidade, estado, telefone, email FROM cliente";
        List<Cliente> clientes = new ArrayList<>();

        try (Connection conexao = Banco.getConexao();
             PreparedStatement stmt = conexao.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Cliente cliente = new Cliente(
                        rs.getString("cpf"),
                        rs.getString("senha"),
                        rs.getString("cep"),
                        rs.getString("cidade"),
                        rs.getString("estado"),
                        rs.getString("telefone"),
                        rs.getString("email")
                );
                clientes.add(cliente);
            }

        } catch (SQLException ex) {
            System.err.println("Erro ao listar clientes: " + ex.getMessage());
        }

        return clientes;
    }
}
