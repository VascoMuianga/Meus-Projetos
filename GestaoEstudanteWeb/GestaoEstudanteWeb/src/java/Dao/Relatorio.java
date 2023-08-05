/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *teste
 * @author V_Muianga
 */

public class Relatorio  {
    
    int ID;
    private int id;
    //private String nome;
    private int media;
    private String situacao;
    
    public Relatorio(int id, int media, String situacao) {
        this.id = id;
        //this.nome = nome;
        this.media = media;
        this.situacao = situacao;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }*/

    public int getMedia() {
        return media;
    }

    public void setMedia(int media) {
        this.media = media;
    }
    
    
    
    
    
}
