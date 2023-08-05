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
public class Armazem {

    String codigo, nome;

    public Armazem(String codigo, String nome) {

        this.codigo = codigo;
        this.nome = nome;
    }

    public Armazem() {
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

    @Override
    public String toString() {
        return "Armazens [codigo=" + codigo + ", nome=" + nome + "]";
    }
    
     public String toString2() {
        return  nome;
    }

}
