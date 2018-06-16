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
import model.Editora;

/**
 *
 * @author Nicolas
 */
public class EditoraController {

    private Connection connection;
    private PreparedStatement sql = null;
    private ResultSet rs = null;
    private final String INSERT = "INSERT INTO Editora (nome,cidade) VALUES (?,?)";
    private final String DELETE = "DELETE FROM  editora WHERE cod_editora= ?";
    private final String Updated = "UPDATE editora SET cod_editora=?, nome=?, cidade=? WHERE cod_editora = ?";

    public EditoraController() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void AddEditora(Editora editora) {
        try {
            String nome = editora.getNome();
            String cidade = editora.getCidade();
            PreparedStatement stmt = connection.prepareStatement(INSERT);
            stmt.setString(1, nome);
            stmt.setString(2, cidade);
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
        } else {
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o dado");
        }

    }

    public void Updated(int codigo, String nome, String cidade) {
        try {
            sql = connection.prepareStatement(Updated);
            sql.setInt(1, codigo);
            sql.setString(2, nome);
            sql.setString(3, cidade);
            sql.setInt(4, codigo);
            sql.execute();
            sql.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Dados Alterados com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel alterar o dado");
        }

    }

}
