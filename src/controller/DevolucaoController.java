/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import javax.swing.JOptionPane;
import model.DevolucaoModel;


/**
 *
 * @author Nicolas
 */
public class DevolucaoController {
    
     private final Connection connection;
    public DevolucaoController() {
        this.connection = new ConnectionFactory().getConnection();
    }
    private final String Updated = "UPDATE autor SET cod_autor=?"+"nome=?"+"sobrenome=?"+"WHERE = cod_autor";
    private final String Insert = "INSERT INTO devolucao(fk_emprestimo,data_devolucao) values(?,?)";
    private final String DELETE = "delete from emprestimo where pk_emprestimo=?";
    private PreparedStatement sql = null;

    
     public void AddEmprestimo(DevolucaoModel devolucao) {
        try {
            int codigoEmprestimo = devolucao.getPk_emprestimo();
            PreparedStatement stmt = connection.prepareStatement(Insert);
            stmt.setInt(1,codigoEmprestimo);
            stmt.setDate(2,Date.valueOf(LocalDate.now()));
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Dados Salvos!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Livro já Emprestado!!!");
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