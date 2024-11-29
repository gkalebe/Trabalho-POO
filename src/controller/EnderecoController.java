package controller;

import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoController {

    private EnderecoDAO enderecoDAO;

    public EnderecoController() {
        enderecoDAO = new EnderecoDAO();
    }

    public boolean alterarEndereco(String cpf, String cep, String cidade, String estado) {
        Endereco endereco = new Endereco(cep, cidade, estado);
        return enderecoDAO.alterarEndereco(cpf, endereco);
    }
}
