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
import model.Produto;

/**
 *
 * @author V_Muianga
 */
public class controllerProduto {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    public static void Salvar(Produto produto) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {
            try {
                pst = con.prepareStatement("insert into Produto (codigo,nomeProduto,preco,stock,armazem,fornecedor) values (?,?,?,?,?,?)");
                pst.setString(1, produto.getCodigo());
                pst.setString(2, produto.getNomeProduto());
                pst.setString(3, produto.getPreco());
               
                pst.setString(4, produto.getStock());
                pst.setString(5, produto.getArmazem());
                pst.setString(6, produto.getFornecedor());
                
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null,"Produto Guardado com sucesso!!");
                
                
            } catch (SQLException e) {
            }
           
            
        }
} 
    public static List<Produto>  listar() throws SQLException{
    
    PreparedStatement pst;
    List<Produto> list;
    //String codigo="";
        //String nome="";
        try (Connection con = new Conexao().getConnection()) {

            //String codigo="";
            //String nome="";
            list = new ArrayList();
            try {
                
                pst = con.prepareStatement("select * from Produto ");
                ResultSet rs = pst.executeQuery();
                
                while(rs.next()){
                    
                    String codigo= rs.getString(2);
                    String nome= rs.getString(3);
                    String preco=rs.getString(4);
                    
                    String stock=rs.getString(5);
                    String armazem=rs.getString(6);
                    String fornecedor=rs.getString(7);
                    
                    Produto produto=new Produto(codigo, nome, preco, stock, armazem, fornecedor);
                    list.add(produto);
                }
                
                //JOptionPane.showMessageDialog(null,"Armazem Guardado com sucesso!!");
                
                
            } catch (SQLException e) {
            }
            
            
           return list;
    }
}
    public static void editar(String codigo,String  nome, String preco,  String stock) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {


            try {
                
                
                pst = con.prepareStatement("update Produto set codigo=?,nomeProduto=?, preco=?, stock=? where codigo="+"'"+codigo+"'");
                pst.setString(1, codigo);
                pst.setString(2, nome);
                pst.setString(3, preco);
                
                pst.setString(4, stock);
                
                
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
                
                pst = con.prepareStatement("delete from Produto  where codigo="+"'"+id+"'");
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Deletado com sucesso!!");
                
            } catch (SQLException e) {
            }

        }
    
}


}

