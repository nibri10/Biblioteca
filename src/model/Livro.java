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
public class Livro {
    private String titulo;
    private String autor;
    private String ISBN;
    private int quantidade;
    private String editora;
    private int Codigo;
    
    public Livro(){
    }

    public Livro(String titulo, String autor, String ISBN, int quantidade, String editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.quantidade = quantidade;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", ISBN=" + ISBN + ", quantidade=" + quantidade + ", editora=" + editora + ", Codigo=" + Codigo + '}';
    }

    
    
    
    
    

    
    
    
    
}
