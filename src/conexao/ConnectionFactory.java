/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

// faz as importações de classes necessárias para o funcionamento do programa 
import java.sql.Connection; 
// conexão SQL para Java 
import java.sql.DriverManager; 
// driver de conexão SQL para Java 
import java.sql.SQLException; 
// classe para tratamento de exceções 
public class ConnectionFactory {
    
       private final String driver = "jdbc:mysql://127.0.0.1:3306/emprestimo";
       private final String user = "root";
       private final String password = "123456";
    
     public Connection getConnection() {
		 try {
			return DriverManager.getConnection(driver,user,password);
		 }         
		 catch(SQLException excecao) {
			throw new RuntimeException(excecao);
		 }
     }
     
}

