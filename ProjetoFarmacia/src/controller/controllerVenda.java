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
public class controllerVenda {
    
    Connection con;
    PreparedStatement pst;
    ResultSet rs;
    
    
    public static void editar(String codigo , int stock) throws SQLException{
    
        PreparedStatement pst;
        try (Connection con = new Conexao().getConnection()) {


            try {
                
                
                pst = con.prepareStatement("update Produto set  stock=? where codigo="+"'"+codigo+"'");
               
                pst.setInt(1, stock);
                
                
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "atualizado com sucesso!!");
                
            } catch (SQLException e) {
            }

        }
}   



}

