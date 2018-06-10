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
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Emprestimo;



/**
 *
 * @author Nicolas
 */
public class EmprestimoController {
    
    private Connection connection;
    public EmprestimoController() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    private final String Updated = "UPDATE autor SET cod_autor=?"+"nome=?"+"sobrenome=?"+"WHERE = cod_autor";
    private final String Insert = "INSERT INTO emprestimo(fk_aluno,fk_professor,fk_livro,data_emprestimo,verifica) values(?,?,?,?,?)";
    private final String Data = "SELECT NOW";
    private PreparedStatement sql = null;

    public void AddEmprestimo(Emprestimo emprestimo) {
        try {
            int codigoLivroEmprestado = emprestimo.getCodlivroEmprestimo();
            int CodAluno = emprestimo.getCodigoAluno();
            int CodProf = emprestimo.getCodigoProfesor();
            int verifica = emprestimo.getVerifica();
            PreparedStatement stmt = connection.prepareStatement(Insert);
            stmt.setInt(1,CodAluno);
            stmt.setInt(2, CodProf);
            stmt.setInt(3, codigoLivroEmprestado);
            stmt.setDate(4,Date.valueOf(LocalDate.now()));
            stmt.setInt(5, verifica);
            stmt.execute();
            stmt.close();
            connection.close();
            JOptionPane.showMessageDialog(null, "Dados Salvos!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
        }

    }
    
   
    
    
    
    

    
    
}
