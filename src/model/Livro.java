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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.titulo);
        hash = 29 * hash + Objects.hashCode(this.autor);
        hash = 29 * hash + Objects.hashCode(this.ISBN);
        hash = 29 * hash + this.quantidade;
        hash = 29 * hash + Objects.hashCode(this.editora);
        hash = 29 * hash + this.Codigo;
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
        final Livro other = (Livro) obj;
        if (this.quantidade != other.quantidade) {
            return false;
        }
        if (this.Codigo != other.Codigo) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        if (!Objects.equals(this.autor, other.autor)) {
            return false;
        }
        if (!Objects.equals(this.ISBN, other.ISBN)) {
            return false;
        }
        if (!Objects.equals(this.editora, other.editora)) {
            return false;
        }
        return true;
    }

    
    
    
    
    

    
    
    
    
}
