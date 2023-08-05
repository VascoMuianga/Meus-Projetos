package Dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Model.Realiza;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author V_Muianga
 */
public class RelatorioDao{

    public static ArrayList<Relatorio> dispensa;
    public static ArrayList<Relatorio> aprovado;
    public static ArrayList<Relatorio> reprovado;
    public static ArrayList<Relatorio> excluido;
    public static ArrayList<Relatorio> melhor;
    public static ArrayList<Relatorio> pior;
    public static ArrayList<Relatorio> admitido;
    ;
     //public static ArrayList<Relatorio> relatorio;
    /**
     * *
     * Media de cada estudante para poder gerar relatorio
     * @return 
     */
    public static List<Relatorio> calcularMedia() {

        Session sessao = HibernateUtil.getSessionFactory().openSession();

        
        List<Relatorio>relatorio=new ArrayList();
        int id;
        try {
            String hql = ("FROM Realiza ");//WHERE numeroMatricula ="+id);
            Query consulta = sessao.createQuery(hql);
            List<Realiza> resultado = consulta.list();

            /**
             * *
             * 1-vamos percorrer toda lista resultados 2-pegar id 3-comprar id
             * recuperado no 2 e comparar com id na posicao 4-depois pegar as
             * notas com aquele id e somar 5-calcular media
             */
            for (int i = 0; i < resultado.size(); i++) {

                List<Realiza> notas = new ArrayList();
                id = resultado.get(i).getNumeroMatricula();
                System.out.println(id);
                

                if (id == resultado.get(i).getNumeroMatricula()) {

                    String hq2 = ("FROM Realiza WHERE numeroMatricula =" + id);
                           
                    notas = consulta.list();
                }
                int media = 1;
                double soma = 0;
                int cont = 0;
                for (int j = 0; j < resultado.size()-1; j++) {
                    if (id == resultado.get(j).getNumeroMatricula()) {

                        soma = (int) (soma + notas.get(j).getNota());
                        cont = cont + 1;
                        //System.out.println(resultado1.get(j).getNota());
                        //System.out.println("contador " + cont);
                    }
                }

                //System.out.println("soma " + soma);
                media = (int) (media * (soma / cont));
              
                //veriricar media
                if (media >= 14) {
                    
                    Relatorio re = new Relatorio(id, media, "Dispensado");
                    relatorio.add(re);
                    
                  //separar aprovado
                } else if ( media>=10 || media <= 13) {
                    Relatorio re = new Relatorio(id, media, "Aprovado");
                    relatorio.add(re);
                    //aprovado.add(re);
                    //System.out.println("Aprovado");
                    /*for(int k=0;k<aprovado.size();k++){
                        System.out.println(dispensa.get(k).getId());
                        System.out.println(dispensa.get(k).getMedia());
                        System.out.println(dispensa.get(k).getSituacao());
                    }*/
                } else if (media > 7) {
                    Relatorio re = new Relatorio(id, media, "Admitido");
                    relatorio.add(re);
                    //admitido.add(re);
                    //System.out.println("Admitido");
                } else {
                    Relatorio re = new Relatorio(id, media, "Excluido");
                    relatorio.add(re);
                    //excluido.add(re);
                    //pior.add(re);
                    //System.out.println("Excluido");
                }

            }

            return relatorio;
        } catch (RuntimeException e) {
            throw e;

        } finally {
            sessao.close();
        }
    }
}
/***
 * 1-criar um metodo para retornar id e a media
 * 2-preencher relatorio
 */