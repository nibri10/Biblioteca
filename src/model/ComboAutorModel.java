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
public class ComboAutorModel {
    
    private int cod;
    private String nome;
    private String sobrenome;

    public ComboAutorModel(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
        
    }
    
    

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    @Override
    public String toString() {
        return "comboAutorModel{" + "cod=" + cod + ", nome=" + nome + ", sobrenome=" + sobrenome + '}';
    }
    
    
    
    
    
}
