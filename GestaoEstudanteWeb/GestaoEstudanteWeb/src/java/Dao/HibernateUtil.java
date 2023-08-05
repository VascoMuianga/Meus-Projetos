package Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author DSI
 */
public class HibernateUtil {

   private static SessionFactory sessionFactory = Criar();
   
   private static SessionFactory Criar(){
   
       try{
           
           Configuration configuracao = new Configuration().configure();
           
           ServiceRegistry registro = new StandardServiceRegistryBuilder().applySettings(configuracao.getProperties()).build();
           
           SessionFactory fabrica = configuracao.buildSessionFactory(registro);
           
           return fabrica;
       }catch(Throwable e){
       
           System.err.println("Erro ao criar a fabrica de sessao: " +e);
           throw new ExceptionInInitializerError(e);
       }
   
   }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*public static final SessionFactory sessionFactory;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
