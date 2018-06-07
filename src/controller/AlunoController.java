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

/**
 *
 * @author Nicolas
 */
public class AlunoController {

    private final String sql = "SELECT * FROM ALUNOS";
    private Connection connection;

    public AlunoController() {
        this.connection = new ConnectionFactory().getConnection();
    }

   
    public void AddAluno(Aluno aluno) {

        try {

            String sql = "INSERT INTO aluno (nome,sobrenome) VALUES (?,?)";
            String nome = aluno.getNome();
            String sobrenome = aluno.getSobrenome();
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Dados Salvos!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel efetuar a operação");
        }

    }

   
    
}

