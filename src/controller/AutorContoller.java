/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.Autor;
import org.jdesktop.beansbinding.Validator;


/**
 *
 * @author Nicolas
 */
public class AutorContoller {
      private Connection connection;
    
     public AutorContoller(){
    this.connection = new ConnectionFactory().getConnection(); 
    
   }
     
      public void AddAutor(Autor autor) {  
       
       try{ 
        String nome = autor.getNome();
        String sobrenome = autor.getSobrenome();
        String sql = "INSERT INTO autor (nome,sobrenome) VALUES (?,?)";
        
        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
        stmt.setString(1, nome);
        stmt.setString(2,sobrenome);
        stmt.execute();
        stmt.close();
        connection.close();
        JOptionPane.showMessageDialog(null, "Dados Salvos!");
        
       }catch(SQLException e){
          
           JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
           
          
       }
    
    }
      
      
      public void Listar(){
          List<Autor> autorResult = new ArrayList<Autor>();
          Autor autor = null;
          String sql = "SELECT cod_autor,nome, sobrenome FROM autor";
          try {
              java.sql.Statement stmt = connection.createStatement();
              ResultSet rs = stmt.executeQuery(sql);
              while(rs.next()){
                  autor= new Autor();
                  autor.setNome(rs.getString("nome"));
                  autor.setSobrenome(rs.getString("sobrenome"));
                  autorResult.add(autor);
              }
              
              rs.close();
              stmt.close();
              connection.close();
              
              
              
          } catch (SQLException ex) {
              Logger.getLogger(AutorContoller.class.getName()).log(Level.SEVERE, null, ex);
          }
      
      }
    
}
