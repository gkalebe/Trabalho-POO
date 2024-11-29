package dao;

import model.Cliente;´
import util.Banco;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {
    
    private Connection connection;

    //Construtor que inicializa a conexão com o banco
    public ClienteDAO() throws SQLException {
        // Inicializar a conexão com o banco e propagar a exceção
        this.connection = Banco.getConexao();
    }

    //Método para cadastrar cliente no banco de dados
    public boolean cadastrarCliente(Cliente cliente) {
        String sql = "INSERT INTO cliente (nome, CPF, CEP, Cidade, Estado, email, Senha) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            // Definir os valores para o query
            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getCep());
            stmt.setString(4, cliente.getCidade());
            stmt.setString(5, cliente.getEstado());
            stmt.setString(6, cliente.getEmail());
            stmt.setString(7, cliente.getSenha());
            
            // Executar a atualização no banco de dados
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace(); // Imprimir o erro de SQL
            return false;
        }
    }
}
