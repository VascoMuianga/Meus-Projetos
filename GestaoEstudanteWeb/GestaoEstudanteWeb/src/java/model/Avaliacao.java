/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author V_Muianga
 */
@Entity
public class Avaliacao implements Serializable {
    @Id
    private String codigoAvaliacao;
    @Column
    private String nome;

    public Avaliacao() {
    }
    
    
    public void setCodigoAvaliacao(String codigoAvaliacao) {
        this.codigoAvaliacao = codigoAvaliacao;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoAvaliacao() {
        return codigoAvaliacao;
    }
    
}
