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
public class Professor {
    
  private String nome;
  private String Titulacao;

    public Professor(String nome, String Titulacao) {
        this.nome = nome;
        this.Titulacao = Titulacao;
    }

    public Professor() {
       
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulacao() {
        return Titulacao;
    }

    public void setTitulacao(String Titulacao) {
        this.Titulacao = Titulacao;
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", Titulacao=" + Titulacao + '}';
    }
  
  
    
}
