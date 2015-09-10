/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConexaoBanco;
import java.sql.*;

/**
 *
 * @author Marlon Prudente
 */
public class Main {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    public static void main(String[] args) throws SQLException {

        Integer n = 1;
        
        System.out.print("Antes de Conectar: ");
        System.out.println(ConexaoMySQL.statusConection());
        
        ConexaoMySQL.getConexaoMySQL();
        
        System.out.print("Depois de Conectar: ");
        System.out.println(ConexaoMySQL.statusConection());
        
        ConexaoMySQL.consultar(n);
        
    }
            
    
          
}
