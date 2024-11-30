package controller;

import dao.ClienteDAO;
import model.Cliente;

public class ClienteController {

    private ClienteDAO clienteDAO;

    public ClienteController() {
        clienteDAO = new ClienteDAO();
    }

    public boolean cadastrarCliente(Cliente cliente) {
        boolean sucesso = clienteDAO.salvar(cliente);
        if (sucesso) {
            System.out.println("Cliente cadastrado com sucesso: " + cliente);
        } else {
            System.err.println("Erro ao cadastrar cliente.");
        }
        return sucesso;
    }

    public Cliente buscarClientePorCPF(String cpf) {
        Cliente cliente = clienteDAO.buscarPorCPF(cpf);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente);
        } else {
            System.err.println("Cliente não encontrado com o CPF: " + cpf);
        }
        return cliente;
    }

    public boolean atualizarCliente(Cliente cliente) {
        boolean sucesso = clienteDAO.atualizar(cliente);
        if (sucesso) {
            System.out.println("Cliente atualizado com sucesso: " + cliente);
        } else {
            System.err.println("Erro ao atualizar cliente.");
        }
        return sucesso;
    }
}
