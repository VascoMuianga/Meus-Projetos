/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author V_Muianga
 */
@Entity
public class Realiza implements Serializable {

    @Id @GeneratedValue(strategy=GenerationType.AUTO)
    int id;
    @Column
    private int numeroMatricula;
    @Column
    private String codigoDisciplina;
    @Column
    private String codigoAvalicao;

    @Column
    private double nota;

    ////////////////////////////////////////////////////////////////
    public int getNumeroMatricula() {
        return numeroMatricula;
    }

    public void setNumeroMatricula(int numeroMatricula) {
        this.numeroMatricula = numeroMatricula;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getCodigoAvalicao() {
        return codigoAvalicao;
    }

    public void setCodigoAvalicao(String codigoAvalicao) {
        this.codigoAvalicao = codigoAvalicao;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

}
/*<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC "-//Hibernate/Hibernate Configuration DTD 3.0//EN" "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd">
<hibernate-configuration>
  <session-factory>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQLDialect</property>
    <property name="hibernate.connection.driver_class">com.mysql.jdbc.Driver</property>
    <property name="hibernate.connection.url">jdbc:mysql://localhost:3306/gestaoestudante?zeroDateTimeBehavior=convertToNull</property>
    <property name="hibernate.connection.username">root</property>
    <property name="connection.pool_size">1</property>
    <property name="hibernate.show_sql">true</property>
    <property name="hibernate.format_sql">true</property>
    <property name="current_session_context_class">thread</property>
    <property name="hibernate.dialect">org.hibernate.dialect.MySQL5InnoDBDialect</property>
    <!-- Desabilite o cache de segundo nível -->
    <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>
    <!-- Desabilite o cache de segundo nível -->
    <property name="cache.provider_class">org.hibernate.cache.NoCacheProvider</property>
    <!-- Elimine e recrie o esquema de banco de dados na inicialização -->
    <property name="hbm2ddl.auto">update</property>
    <mapping class="Model.Estudante"/>
    <mapping class="Model.Disciplina"/>
    <mapping class="Model.Avaliacao"/>
    <mapping class="Model.Realiza"/>
  </session-factory>
</hibernate-configuration>
*/