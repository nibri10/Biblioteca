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
import model.Autor;

/**
 *
 * @author Nicolas
 */
public class AutorContoller {

    private Connection connection;

    public AutorContoller() {
        this.connection = new ConnectionFactory().getConnection();
    }
    private final String Updated = "UPDATE autor SET cod_autor=?,nome=?,sobrenome=? WHERE cod_autor=?";
    private final String Insert = "INSERT INTO autor (nome,sobrenome) VALUES (?,?)";
    private final String DELETE = "DELETE FROM  autor WHERE cod_autor=?";
    private PreparedStatement sql = null;

    public void AddAutor(Autor autor) {
        try {
            String nome = autor.getNome();
            String sobrenome = autor.getSobrenome();
            PreparedStatement stmt = connection.prepareStatement(Insert);
            stmt.setString(1, nome);
            stmt.setString(2, sobrenome);
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Dados Salvos!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
        }

    }

   

    public void getDelete(int valor) throws SQLException {
        sql = connection.prepareStatement(DELETE);
        sql.setInt(1, valor);
        if (sql.executeUpdate() == 1) {
            JOptionPane.showMessageDialog(null, "Dado Deletado com sucesso!!!");
            sql.close();
            connection.close();
        } else {
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o dado");
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
            JOptionPane.showMessageDialog(null, "Dados Alterados!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o dado");
        }

    }

}
