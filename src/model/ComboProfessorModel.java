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
public class ComboProfessorModel {
    private int codgio;
    private String nome;

    public ComboProfessorModel(int codgio, String nome) {
        this.codgio = codgio;
        this.nome = nome;
    }

    public int getCodgio() {
        return codgio;
    }

    public void setCodgio(int codgio) {
        this.codgio = codgio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return "ComboProfessorModel{" + "codgio=" + codgio + ", nome=" + nome + '}';
    }
    
    
    
}
