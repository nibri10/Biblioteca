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
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Aluno;
import model.Livro;

/**
 *
 * @author Nicolas
 */
public class AlunoController {

    private final String INSERT = "INSERT INTO aluno (nome,sobrenome) VALUES (?,?)";
    private final String DELETE = "DELETE FROM  aluno WHERE cod_aluno= ?";
    private final String Updated = "UPDATE aluno SET cod_aluno=?,nome=?,sobrenome=? WHERE cod_aluno=?";
    private PreparedStatement sql = null;
    private ResultSet rs = null;
    private final Connection connection;

    public AlunoController() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void AddAluno(Aluno aluno) {
        try {

            String nome = aluno.getNome();
            String sobrenome = aluno.getSobrenome();
            PreparedStatement stmt = connection.prepareStatement(INSERT);
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

   
    public void Updated(int codigo, String nome, String sobrenome) {
        try {
            sql = connection.prepareStatement(Updated);
             sql.setInt(1, codigo);
            sql.setString(2, nome);
            sql.setString(3, sobrenome);
            sql.setInt(4, codigo);
            sql.execute();
            sql.close();
            connection.close();
             JOptionPane.showMessageDialog(null, "Dados Salvos!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o dado");
        }

    }

    public void getDelete(int valor) throws SQLException {
        sql = connection.prepareStatement(DELETE);
        sql.setInt(1, valor);
        if (sql.executeUpdate() == 1) {
            JOptionPane.showMessageDialog(null, "Dado Deletado com sucesso!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o dado");
        }

    }

}
