/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import conexao.ConnectionFactory;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import model.ComboAlunoModel;
import model.ComboAutorModel;
import model.ComboEditoraModel;
import model.ComboLivroModel;
import model.ComboProfessorModel;

/**
 *
 * @author Nicolas
 */
public class ComboPouplation {
    
    private Connection connection;
    private final String Combo="SELECT cod_editora,nome From editora";
    private final String ComboAutor ="SELECT cod_autor, nome From autor";
    private final String ComboLivro = "SELECT cod_livro, titulo From livro";
    private final String ComboProfessor ="SELECT cod_prof , nome From professor";
    private final String ComboAluno="SELECT cod_aluno, nome From Aluno";
    Statement st =null;
    ResultSet rs = null;
    
    public ComboPouplation() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
public HashMap<String, Integer> populateCombo(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
       try {
           st = connection.createStatement();
           rs = st.executeQuery(Combo);
           ComboEditoraModel comb;
           while(rs.next()){
               comb = new ComboEditoraModel(rs.getInt(1), rs.getString(2));
               map.put(comb.getNome(), comb.getCodigo());
           }
           
       } catch (SQLException ex) {
           System.err.println("Nao foi possivel");
       }
      
       return map;
   }

public HashMap<String, Integer> populateComboAutor(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
       try {
           st = connection.createStatement();
           rs = st.executeQuery(ComboAutor);
           ComboAutorModel CombAutor;
           while(rs.next()){
               CombAutor = new ComboAutorModel(rs.getInt(1), rs.getString(2));
               map.put(CombAutor.getNome(), CombAutor.getCod());
           }
           
       } catch (SQLException ex) {
           System.err.println("Nao foi possivel");
       }
      
       return map;
   }

public HashMap<String, Integer> populateComboLivro(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
       try {
           st = connection.createStatement();
           rs = st.executeQuery(ComboLivro);
           ComboLivroModel CombLivro;
           while(rs.next()){
               CombLivro = new ComboLivroModel(rs.getInt(1), rs.getString(2));
               map.put(CombLivro.getTitulo(), CombLivro.getCodgio());
           }
           
       } catch (SQLException ex) {
           System.err.println("Nao foi possivel");
       }
      
       return map;
   }
public HashMap<String, Integer> populateComboProfessor(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
       try {
           st = connection.createStatement();
           rs = st.executeQuery(ComboProfessor);
           ComboProfessorModel CombProf;
           while(rs.next()){
               CombProf = new ComboProfessorModel(rs.getInt(1), rs.getString(2));
               map.put(CombProf.getNome(), CombProf.getCodgio());
           }
           
       } catch (SQLException ex) {
           System.err.println("Nao foi possivel");
       }
      
       return map;
   }


public HashMap<String, Integer> populateComboAluno(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
       try {
           st = connection.createStatement();
           rs = st.executeQuery(ComboAluno);
           ComboAlunoModel CombAluno;
           while(rs.next()){
               CombAluno = new ComboAlunoModel(rs.getInt(1), rs.getString(2));
               map.put(CombAluno.getNome(), CombAluno.getCodgio());
           }
           
       } catch (SQLException ex) {
           System.err.println("Nao foi possivel");
       }
      
       return map;
   }




}
    

