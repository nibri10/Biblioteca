/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Editora;

/**
 *
 * @author Nicolas
 */
public class EditoraController {
    
    private Connection connection;
    
     public EditoraController(){
    this.connection = new ConnectionFactory().getConnection(); 
    
   }
     
      public void AddEditora(Editora editora) {  
       
       try{ 
        String nome = editora.getNome();
        String cidade = editora.getCidade();
        String sql = "INSERT INTO Editora (nome,cidade) VALUES (?,?)";
        
        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2,cidade);
        stmt.execute();
        stmt.close();
        connection.close();
        JOptionPane.showMessageDialog(null, "Dados Salvos!");
        
       }catch(SQLException e){
          
           JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
           
          
       }
    
    }


}