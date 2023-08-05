/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Armazem;

/**
 *
 * @author V_Muianga
 */
public class controllerArmazem {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public static void Salvar(Armazem armazem) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {
            try {
                pst = con.prepareStatement("insert into Armazem (codigo,nome) values (?,?)");
                pst.setString(1, armazem.getCodigo());
                pst.setString(2, armazem.getNome());
                
                
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Armazem Guardado com sucesso!!");
                
                
            } catch (SQLException e) {
            }
           
            
        }
    }   


///listar

    /**
     *
     * @return
     * @throws SQLException
     */
   
public static List<Armazem> listar() throws SQLException{
    
    PreparedStatement pst;
    List<Armazem> listaA;
    try (Connection con = new Conexao().getConnection()) {

            listaA = new ArrayList();
            try {
                
                pst = con.prepareStatement("select * from Armazem ");
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    
                    String codigo= rs.getString(2);
                    String nome= rs.getString(3);
                    
                    Armazem armazem=new Armazem(codigo, nome);
                    listaA.add(armazem);
                }
                
                //JOptionPane.showMessageDialog(null,"Armazem Guardado com sucesso!!");
                
                
            } catch (SQLException e) {
            }
            
            
         return listaA;
    } 
}

public static void editar(int id,String codigo,String nome) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {
           
            try {
                
                pst = con.prepareStatement("update Armazem set codigo=?,nome=? where codigo="+"'"+id+"'");
                pst.setString(1, codigo);
                pst.setString(2, nome);
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "atualizado com sucesso!!");
                
            } catch (SQLException e) {
            }

        }
}   
public static void deletar(String id) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {
           
            try {
                
                pst = con.prepareStatement("delete from Armazem  where codigo="+"'"+id+"'");
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deletado com sucesso!!");
                
            } catch (SQLException e) {
            }

        }
    

}

}

