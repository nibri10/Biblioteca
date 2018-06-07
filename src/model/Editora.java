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
public class Editora {
    private String cidade;
    private String nome;
    
    public Editora(){}

    public Editora(String cidade, String nome) {
        this.cidade = cidade;
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "Editora{" + "cidade=" + cidade + ", nome=" + nome + '}';
    }
    
    
    
}
