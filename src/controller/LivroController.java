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
import model.Livro;

/**
 *
 * @author Nicolas
 */
public class LivroController {

    private final Connection connection;

    public LivroController() {
        this.connection = new ConnectionFactory().getConnection();
    }
    private final String INSERT="INSERT INTO livro(titulo,isbn,quantidade,fk_editora,fk_autor) VALUES(?,?,?,?,?)";
    private final String SELECT="SELECT * FROM PRODUTO";
    private PreparedStatement sql = null;

    public void addLivro(Livro livro) {
        try {
            String titulo = livro.getTitulo();
            int autor = livro.getAutor();
            String isbn = livro.getISBN();
            int editora = livro.getEditora();
            int quantidade = livro.getQuantidade(); 
            PreparedStatement stmt =  connection.prepareStatement(INSERT);
            stmt.setString(1, titulo);
            stmt.setString(2, isbn);
            stmt.setInt(3,quantidade);
            stmt.setInt(4,editora);
            stmt.setInt(5,autor);
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Dados Salvos!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");

        }
    }
    public List<Livro> getBusca() throws SQLException {
        PreparedStatement sql = null;
        ResultSet rs = null;
        sql = connection.prepareStatement(SELECT);
        rs = sql.executeQuery();
        List<Livro> Livro = new LinkedList<>();
        while (rs.next()) {
            Livro livro = new Livro();
            livro.setCodigo(Integer.parseInt(rs.getString("codigo")));
            livro.setTitulo(rs.getString("titulo"));
            livro.setQuantidade(rs.getInt("quantidade"));
            Livro.add(livro);
        }
        rs.close();
        sql.close();
        return Livro;
    }

    public void getDelete(String valor) throws SQLException {
        sql = connection.prepareStatement("DELETE FROM  livro WHERE cod_livro= ?");
        sql.setString(1, valor);
        if (sql.executeUpdate() == 1) {
            JOptionPane.showMessageDialog(null, "Dado Deletado com sucesso!!!");
        } else {
            JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o dado");
        }

    }

}
