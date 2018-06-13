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
import javax.swing.JOptionPane;
import model.Professor;

/**
 *
 * @author Nicolas
 */
public class ProfessorController {
    private Connection connection;
    private final String INSERT = "INSERT INTO professor (nome, titulacao) VALUES (?,?)";
    private final String DELETE = "DELETE FROM  produto WHERE cod_aluno= ?";
    private final String Updated = "UPDATE professor SET "+"nome=?"+"titulacao=?"+"WHERE = cod_prof";
    private PreparedStatement sql = null;
    private ResultSet rs = null;
    public ProfessorController(){
    this.connection = new ConnectionFactory().getConnection(); 
   }
    
    public void AddProfessor(Professor professor) {
       try{ 
           String nome = professor.getNome();
           String titulacao = professor.getTitulacao();
           sql = connection.prepareStatement(INSERT);
           sql.setString(1, nome);
           sql.setString(2,titulacao);
           sql.execute();
           sql.close();
           connection.close();
        JOptionPane.showMessageDialog(null, "Dados Salvos!");
       }catch(SQLException e){
           
           JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
        
       }
       
        }
    
     public void Updated(int codigo, String nome, String titulacao) {    
        try{
            sql = connection.prepareStatement(Updated);
            sql.setString(1, nome);
            sql.setString(2,titulacao);
            sql.setInt(3,codigo);
            sql.execute();
            sql.close();
            connection.close();
        
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o dado");
        }

    }
    }

