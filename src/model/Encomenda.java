package model;

import java.util.Date;
import java.util.List;

public class Encomenda {

    private int idEncomenda;
    private int idCliente;
    private Date dataEncomenda;
    private Date dataEntrega;
    private int idLocal;
    private String status;
    private List<Produto> produtos;

    public Encomenda() {}

    public Encomenda(int idEncomenda, int idCliente, Date dataEncomenda, Date dataEntrega, int idLocal, String status) {
        this.idEncomenda = idEncomenda;
        this.idCliente = idCliente;
        this.dataEncomenda = dataEncomenda;
        this.dataEntrega = dataEntrega;
        this.idLocal = idLocal;
        this.status = status;
    }

    public int getIdEncomenda() {
        return idEncomenda;
    }

    public void setIdEncomenda(int idEncomenda) {
        this.idEncomenda = idEncomenda;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getDataEncomenda() {
        return dataEncomenda;
    }

    public void setDataEncomenda(Date dataEncomenda) {
        this.dataEncomenda = dataEncomenda;
    }

    public Date getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(Date dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    public int getIdLocal() {
        return idLocal;
    }

    public void setIdLocal(int idLocal) {
        this.idLocal = idLocal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }
}
