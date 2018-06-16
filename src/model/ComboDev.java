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
public class ComboDev {
    private int cod;
    private String nomeLivro;

    public ComboDev(int cod, String nomeLivro) {
        this.cod = cod;
        this.nomeLivro = nomeLivro;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    @Override
    public String toString() {
        return "ComboDev{" + "cod=" + cod + ", nomeLivro=" + nomeLivro + '}';
    }
    
    
    
    
}
