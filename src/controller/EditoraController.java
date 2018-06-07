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
    private final String SELECT = "SELECT * FROM editora";
    private final String DELETE = "DELETE FROM  livro WHERE cod_livro= ?";

    public EditoraController() {
        this.connection = new ConnectionFactory().getConnection();
    }

    public void AddEditora(Editora editora) {
        try {
            String nome = editora.getNome();
            String cidade = editora.getCidade();
            PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(INSERT);
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

    public List<Editora> getBusca() throws SQLException {
        sql = connection.prepareStatement(SELECT);
        rs = sql.executeQuery();
        List<Editora> EditoraL = new LinkedList<>();
        while (rs.next()) {
            Editora editora = new Editora();
            editora.setCodigo(Integer.parseInt(rs.getString("codigo")));
            editora.setNome(rs.getString("nome"));
            editora.setCidade(rs.getString("cidade"));
            EditoraL.add(editora);
        }
        rs.close();
        sql.close();
        return EditoraL;
    }

    public void getDelete(String valor) throws SQLException {
        sql = connection.prepareStatement(DELETE);
        sql.setString(1, valor);
        if (sql.executeUpdate() == 1) {
            JOptionPane.showMessageDialog(null, "Dado Deletado com sucesso!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o dado");
        }

    }

}
