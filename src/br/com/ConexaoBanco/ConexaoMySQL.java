/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.ConexaoBanco;

/**
 *
 * @author Marlon Prudente
 */
/*
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
*OBS: Se fosse somente uma classe para conexão, se importaria apenas isso.
*/

import java.sql.*;
/* Estou importando todos os métodos e classes do sql,
porque esta classe utilizará a maioria, para testes de aprendizado.*/
 

//Início da classe de conexão//

public class ConexaoMySQL {

             public static String status = "Não conectou...";

//Método Construtor da Classe//

        public ConexaoMySQL() {

    } 

//Método de Conexão//

public static java.sql.Connection getConexaoMySQL() {

        Connection connection = null;          //atributo do tipo Connection
        //Esse atributo receberá as informações para se conectar ao BD.

try {

// Carregando o JDBC Driver padrão

String driverName = "com.mysql.jdbc.Driver";                        
/*O Drive para Java é conseguido através do próprio site do MySQL, nele está todos os métodos utilizados.
por padrão, o driverName sempre será este.*/

Class.forName(driverName); 

// Configurando a nossa conexão com um banco de dados//

            String serverName = "localhost";    //caminho do servidor do BD

            String mydatabase = "livraria";        //nome do seu banco de dados

            String url = "jdbc:mysql://" + serverName + "/" + mydatabase;

            String username = "root";        //nome de um usuário de seu BD      

            String password = "$$dafuq";      //sua senha de acesso

            connection = DriverManager.getConnection(url, username, password);
            /*Através dessa atribuição, conection receberá as informações.*/ 

            //Testa sua conexão//  

            if (connection != null) {

                status = ("STATUS--->Conectado com sucesso!");

            } else {

                status = ("STATUS--->Não foi possivel realizar conexão");

            } 

            return connection; 

        } catch (ClassNotFoundException e) {  //Driver não encontrado 

            System.out.println("O driver expecificado nao foi encontrado.");

            return null;

        } catch (SQLException e) {
            
//Não conseguindo se conectar ao banco
            System.out.println("Nao foi possivel conectar ao Banco de Dados.");

            return null;

        }

 

    }

 

    //Método que retorna o status da sua conexão//

    public static String statusConection() {

        return status;
    }

  

   //Método que fecha sua conexão//

    public static boolean FecharConexao() {

        try {

            ConexaoMySQL.getConexaoMySQL().close();
            return true;

        } catch (SQLException e) {
            
            return false;

        }

 

    }

  

   //Método que reinicia sua conexão//

    public static java.sql.Connection ReiniciarConexao() {

        FecharConexao();

        return ConexaoMySQL.getConexaoMySQL();

    }
    
    /*Método para Consulta ao BD, sendo "rs" a tabela que a conexão retorna, sendo necessário 
    trabalhar com essa informação, para poder apresentar ao usuário.*/
    
    public static void consultar(Integer id) throws SQLException  
        {  
            
            String sql = "SELECT * FROM livros WHERE GENERO_ID = '" + id + "'"; 
            Statement stm = ConexaoMySQL.getConexaoMySQL().createStatement();
            
            ResultSet rs = stm.executeQuery(sql);
            while(rs.next()){
                System.out.print(rs.getString("livro_id"));
                System.out.print(" - ");
                System.out.println(rs.getString("titulo"));
            }
            
            
  
    } 
 

}
