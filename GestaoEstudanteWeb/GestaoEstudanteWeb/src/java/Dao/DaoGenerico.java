/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import Model.Realiza;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author V_Muianga
 * @param <Entidade>
 */
public class DaoGenerico<Entidade> {

    
    
    //pegar a class filha
    private Class<Entidade> classe;

    public DaoGenerico() {

        this.classe = (Class<Entidade>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    ////////////////////
    //Salvar
    public void salvar(Entidade entidade) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {

            transacao = sessao.beginTransaction();

            sessao.save(entidade);
            transacao.commit();
        } catch (RuntimeException e) {

            if (transacao != null) {

                transacao.rollback();

            }
            throw e;

        } finally {
            sessao.close();
        }
    }

    //listar
    public List<Entidade> listar() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            Criteria consulta = sessao.createCriteria(classe);
            List<Entidade> resultado = consulta.list();

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }

    //buscar
    public List<Entidade> buscar(int id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = ("FROM Estudante WHERE numeroMatricula =" + id);
            Query consulta = sessao.createQuery(hql);
            List<Entidade> resultado = consulta.list();

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }
    //buscar
    public List<Entidade> buscarRealiza(int id ,String teste) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = ("FROM Realiza WHERE numeroMatricula ="+id+" AND codigoAvaliacao="+"'"+teste+"'");
           
            Query consulta = sessao.createQuery(hql);
            List<Entidade> resultado = consulta.list();

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }
    /////teste
    //buscar
    public List<Entidade> buscarRealizar(int id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = ("FROM Realiza WHERE numeroMatricula =" + id );
            Query consulta = sessao.createQuery(hql);
            List<Entidade> resultado = consulta.list();

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }

    //buscar Diciplina, Avaliacao, 

    public List<Entidade> buscarOutroD(String id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = ("FROM Disciplina WHERE codigoDisciplina=" + "'" + id + "'");
            Query consulta = sessao.createQuery(hql);
            List<Entidade> resultado = consulta.list();

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }

    ///buscar Diciplina, Avaliacao, 
    public List<Entidade> buscarOutroA(String id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = ("FROM Avaliacao WHERE codigoAvaliacao =" + "'" + id + "'");
            Query consulta = sessao.createQuery(hql);
            List<Entidade> resultado = consulta.list();;

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }

    //buscar Diciplina, Avaliacao, 
    public List<Entidade> buscarOutroR(int id) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        try {
            String hql = ("FROM Realiza WHERE numeroMatricula =" + id);
            Query consulta = sessao.createQuery(hql);
            List<Entidade> resultado = consulta.list();;

            return resultado;

        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }

    //Apagar
    public void apagar(Entidade entidade) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {

            transacao = sessao.beginTransaction();

            sessao.delete(entidade);
            transacao.commit();
        } catch (RuntimeException e) {

            if (transacao != null) {

                transacao.rollback();

            }
            throw e;

        } finally {
            sessao.close();
        }
    }

    //Editar
    public void editar(Entidade entidade) {

        Session sessao = HibernateUtil.getSessionFactory().openSession();
        Transaction transacao = null;

        try {

            transacao = sessao.beginTransaction();

            sessao.update(entidade);
            //entidade= (Entidade)sessao.load(Entidade.class, id);
            transacao.commit();
        } catch (RuntimeException e) {

            if (transacao != null) {

                transacao.rollback();

            }
            throw e;

        } finally {
            sessao.close();
        }
    }
    
        
}
