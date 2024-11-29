package controller;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {
    private ClienteDAO clienteDAO; // Instância do DAO para acessar dados do banco

    //Construtor que inicializa o ClienteDao
    public ClienteController(){
        // Aqui pode-se passar a conexão com o banco de dados
        this.clienteDAO = new ClienteDAO();
    }

    //Método para cadastrar um novo cliente
    public String cadastrarCliente(String nome, String CPF, String CEP, String Cidade, String Estado, String Telefone, String email, String Senha){
        
        //Cria uma instância do modelo Cliente com os dados recebidos
        Cliente cliente = new Cliente(nome, CPF, CEP, Cidade, Estado, Telefone, email, Senha);

        //Chama o método do ClienteDAO para salvar o cliente no banco
        boolean sucesso = clienteDAO.cadastrarCliente(cliente);

        //Retrona uma mensagem indicando o sucesso ou falha do cadastro
        if(sucesso){
            return "Cliente cadastrado com sucesso!";
        }else{
            return "Erro ao cadastrar cliente!";
        }
    }

}



