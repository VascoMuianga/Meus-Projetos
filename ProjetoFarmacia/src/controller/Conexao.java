/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author V_Muianga
 */
public class Conexao {
    
    public Connection getConnection (){
    try {
        return DriverManager.getConnection ("jdbc:mysql://localhost/Farmacia", "root","");
    }catch (SQLException e){
        throw new RuntimeException(e);
    }
}
}
