/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Objects;

/**
 *
 * @author Nicolas
 */
public class Professor {
  
  private int codigo;
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


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return "Professor{" + "codigo=" + codigo + ", nome=" + nome + ", Titulacao=" + Titulacao + '}';
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + this.codigo;
        hash = 59 * hash + Objects.hashCode(this.nome);
        hash = 59 * hash + Objects.hashCode(this.Titulacao);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Professor other = (Professor) obj;
        if (this.codigo != other.codigo) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.Titulacao, other.Titulacao)) {
            return false;
        }
        return true;
    }
    
    
  
  
    
}
