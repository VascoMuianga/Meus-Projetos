/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author V_Muianga
 */
public class Produto {

    protected String codigo;
    protected String nomeProduto;
    protected String preco;
    
    protected String stock;
    protected String armazem;
    protected String fornecedor;

    public Produto(String codigo, String nomeProduto, String preco, String stock, String armazem, String fornecedor) {
        this.codigo = codigo;
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        
        this.stock = stock;
        this.armazem = armazem;
        this.fornecedor = fornecedor;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String  preco) {
        this.preco = preco;
    }

    
    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getArmazem() {
        return armazem;
    }

    public void setArmazem(String armazem) {
        this.armazem = armazem;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    @Override
    public String toString() {
        return "Produtos [codigo=" + codigo + ", nomeProduto=" + nomeProduto + ", preco=" + preco + ", stock=" + stock + ", armazem=" + armazem + ", fornecedor=" + fornecedor + "]";
    }
    public String toString2() {
        return nomeProduto ;
    }
}
