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
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import javax.swing.JOptionPane;
import model.Livro;

/**
 *
 * @author Nicolas
 */
public class LivroController {
    private Connection connection;
    
   public LivroController(){
    this.connection = new ConnectionFactory().getConnection(); 
    
   }
    
    
    public void addLivro (Livro livro){

        
       try{
        String titulo = livro.getTitulo();
        String autor = livro.getAutor();
        String isbn = livro.getISBN();
        String editora = livro.getEditora();
        int quantidade = livro.getQuantidade();
        String sql = "INSERT INTO livro(titulo,autor,isbn,editora,quantidade) VALUES(?,?,?,?,?)";
        PreparedStatement stmt = (PreparedStatement) connection.prepareStatement(sql);
        stmt.setString(1, titulo);
        stmt.setString(2, autor);
        stmt.setString(3,editora);
        stmt.setString(4, isbn);
        stmt.setInt(5, quantidade);
        stmt.execute();
        stmt.close();
        connection.close();
        JOptionPane.showMessageDialog(null, "Dados Salvos!");
       }
       catch(SQLException e){
           JOptionPane.showMessageDialog(null, "Não foi possivel salvar os dados!");
           
       }
 }
    
     //Retorno todos os valores para CadastrarProduto
   public List<Livro> getBusca() throws SQLException{
        
       
        PreparedStatement sql = null;
        ResultSet rs = null;
            sql = connection.prepareStatement("SELECT * FROM PRODUTO");
            rs = sql.executeQuery();
            List<Livro> Livro = new LinkedList<>();
            while(rs.next()){
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
   
   
    public void getDelete(String valor) throws SQLException{
        
       
        PreparedStatement sql = null;
          
            sql = connection.prepareStatement("DELETE FROM  produto WHERE codigo= ?");
            sql.setString(1, valor);
            if(sql.executeUpdate()==1){
             JOptionPane.showMessageDialog(null, "Dado Deletado com sucesso!!!");
            }
            else{
                JOptionPane.showMessageDialog(null, "Nao foi possivel deletar o dado");
            }
           
    }           
       

   

   
           
        
    }

