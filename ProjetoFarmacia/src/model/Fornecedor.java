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
public class Fornecedor {

    String codigo, nome, nuit;

    public Fornecedor(String codigo, String nome, String nuit) {

        this.codigo = codigo;
        this.nome = nome;
        this.nuit = nuit;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNuit() {
        return nuit;
    }

    public void setNuit(String nuit) {
        this.nuit = nuit;
    }

    @Override
    public String toString() {
        return "Fornecedores [codigo=" + codigo + ", nome=" + nome + ", nuit=" + nuit + "]";
    }
    public String toString2() {
        return nome;
    }
}
