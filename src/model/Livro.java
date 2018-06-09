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
public class Livro {
    private String titulo;
    private int autor;
    private String ISBN;
    private int quantidade;
    private int editora;
    private int Codigo;
    
    public Livro(){
    }

    public Livro(String titulo, int autor, String ISBN, int quantidade, int editora, int Codigo) {
        this.titulo = titulo;
        this.autor = autor;
        this.ISBN = ISBN;
        this.quantidade = quantidade;
        this.editora = editora;
        this.Codigo = Codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getAutor() {
        return autor;
    }

    public void setAutor(int autor) {
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

    public int getEditora() {
        return editora;
    }

    public void setEditora(int editora) {
        this.editora = editora;
    }

    public int getCodigo() {
        return Codigo;
    }

    public void setCodigo(int Codigo) {
        this.Codigo = Codigo;
    }

    
    }


    
    
    
    
    

    
    
    
    

