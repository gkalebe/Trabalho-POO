package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Banco {
    private static final String URL = "";
    private static final String USUARIO = "";
    private static final String SENHA = "";

        public static Connection getConexao() throws SQLException{
            return DriverManager.getConnection(URL, USUARIO, SENHA);
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
