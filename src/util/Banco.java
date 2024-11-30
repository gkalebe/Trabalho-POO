package util;

import dao.ClienteDAO;
import model.Cliente;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Banco {
    private static final String URL = "jdbc:mysql://localhost:3306/bancopoo";
    private static final String USUARIO = "usuario";
    private static final String SENHA = "senha123";

        public static Connection getConexao() throws SQLException{
            try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                return DriverManager.getConnection(URL, USUARIO, SENHA);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("Driver JDBC não encontrado.", e);
            }
        }

            public static void fecharConexao(Connection conexao){
                if (conexao != null){
                    try{
                        conexao.close();
                        }catch (SQLException e){
                            e.printStackTrace();
                        }
                }
            }

}
