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
public class ComboLivroModel {
    private int codgio;
    private String titulo;

    public ComboLivroModel(int codgio, String titulo) {
        this.codgio = codgio;
        this.titulo = titulo;
    }

    public int getCodgio() {
        return codgio;
    }

    public void setCodgio(int codgio) {
        this.codgio = codgio;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    @Override
    public String toString() {
        return "ComboLivroModel{" + "codgio=" + codgio + ", titulo=" + titulo + '}';
    }
    
    
}
