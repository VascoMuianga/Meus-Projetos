/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Fornecedor;

/**
 *
 * @author V_Muianga
 */
public class controllerFornecedor {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public static void Salvar(Fornecedor fornecedor) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {
            try {
                pst = con.prepareStatement("insert into Fornecedor (codigo,nome,nuit) values (?,?,?)");
                pst.setString(1, fornecedor.getCodigo());
                pst.setString(2, fornecedor.getNome());
                pst.setString(3, fornecedor.getNuit());
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Fornecedor Guardado com sucesso!!");
                
                
            } catch (SQLException e) {
            }
           
            
        }
    }
    public static List<Fornecedor>  listar() throws SQLException{
    
        PreparedStatement pst;
        List<Fornecedor> list;
        //String codigo="";
        //String nome="";
        try (Connection con = new Conexao().getConnection()) {

            //String codigo="";
            //String nome="";
            list = new ArrayList();
            try {
                
                pst = con.prepareStatement("select * from Fornecedor ");
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    
                    String codigo= rs.getString(2);
                    String nome= rs.getString(3);
                    String nuit=rs.getString(4);
                    Fornecedor fornecedor=new Fornecedor(codigo, nome,nuit);
                    list.add(fornecedor);
                }
                
                //JOptionPane.showMessageDialog(null,"Armazem Guardado com sucesso!!");
                
                
            } catch (SQLException e) {
            }
            
            
           return list;
           
        }
    }
    
    public static void editar(String codigo,String nome,String nuit) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {
           
            try {
                
                pst = con.prepareStatement("update Fornecedor set codigo=?,nome=?, nuit=? where codigo="+"'"+codigo+"'");
                pst.setString(1, codigo);
                pst.setString(2, nome);
                pst.setString(3, nuit);
                
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
                
                pst = con.prepareStatement("delete from Fornecedor  where codigo="+"'"+id+"'");
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deletado com sucesso!!");
                
            } catch (SQLException e) {
            }

        }
}
}

