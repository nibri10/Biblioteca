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
import model.ComboEditoraModel;

/**
 *
 * @author Nicolas
 */
public class ComboPouplation {
    
    private Connection connection;
    private final String Combo="SELECT cod_editora,nome From editora";
    public ComboPouplation() {
        this.connection = new ConnectionFactory().getConnection();
    }
    
    
     public HashMap<String, Integer> populateCombo(){
      HashMap<String, Integer> map = new HashMap<String, Integer>();
      
      Statement st;
      ResultSet rs;
      
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
}
    

