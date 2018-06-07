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
import model.Professor;

/**
 *
 * @author Nicolas
 */
public class ProfessorController {
    private Connection connection;
    
    public ProfessorController(){
    this.connection = new ConnectionFactory().getConnection(); 
   }
    
    public void AddProfessor(Professor professor) {
       try{ 
           String sql = "INSERT INTO professor (nome, titulacao) VALUES (?,?)";
           String nome = professor.getNome();
           String titulacao = professor.getTitulacao();
           PreparedStatement stmt = connection.prepareStatement(sql);
           stmt.setString(1, nome);
           stmt.setString(2,titulacao);
           stmt.execute();
           stmt.close();
           connection.close();
        JOptionPane.showMessageDialog(null, "Dados Salvos!");
       }catch(SQLException e){
           
           JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
        
       }
       
        }
    }

