package dao;

import model.Cliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    private class Connection connection;

    //Construtor que inicializa a conexão com o banco
    public ClienteDAO(){
        //Inicializar a conexão com o banco
        this.connection = ConnectionFactory.getConexao();
    }

    //Método para cadastrar cliente no banco de dados
    public boolean cadastrarCliente(Cliente cliente){
        String sql = "INSERT INTO cliente (nome, CPF, CEP, Cidade, Estado, email, Senha) VALUES (?,?,?,?,?,?,?)";

        try (PreparedStatement stmt = connection.PreparedStatement(sql)){
            //Definir os valore para o query
            stmt.setString(1, cliente.getNome());
            stmt.setString(, sql);
        }
    }
    
}
