/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;



/**
 *
 * @author Nicolas
 */
public class DevolucaoModel { 
    private int pk_emprestimo;
  
    public DevolucaoModel(){}

    public DevolucaoModel(int pk_emprestimo) {
        this.pk_emprestimo = pk_emprestimo;
       
    }

    public int getPk_emprestimo() {
        return pk_emprestimo;
    }

    public void setPk_emprestimo(int pk_emprestimo) {
        this.pk_emprestimo = pk_emprestimo;
    }

    @Override
    public String toString() {
        return "DevolucaoModel{" + "pk_emprestimo=" + pk_emprestimo + '}';
    }

   

   
    
    
    
    
    
}
