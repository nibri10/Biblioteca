/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Nicolas
 */
@Entity
@Table(name = "livro", catalog = "emprestimo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Livro.findAll", query = "SELECT l FROM Livro l")
    , @NamedQuery(name = "Livro.findByCodLivro", query = "SELECT l FROM Livro l WHERE l.codLivro = :codLivro")
    , @NamedQuery(name = "Livro.findByTitulo", query = "SELECT l FROM Livro l WHERE l.titulo = :titulo")
    , @NamedQuery(name = "Livro.findByIsbn", query = "SELECT l FROM Livro l WHERE l.isbn = :isbn")
    , @NamedQuery(name = "Livro.findByQuantidade", query = "SELECT l FROM Livro l WHERE l.quantidade = :quantidade")
    , @NamedQuery(name = "Livro.findByFkEditora", query = "SELECT l FROM Livro l WHERE l.fkEditora = :fkEditora")
    , @NamedQuery(name = "Livro.findByFkAutor", query = "SELECT l FROM Livro l WHERE l.fkAutor = :fkAutor")})
public class Livro implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_livro")
    private Integer codLivro;
    @Basic(optional = false)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @Column(name = "isbn")
    private String isbn;
    @Basic(optional = false)
    @Column(name = "quantidade")
    private int quantidade;
    @Column(name = "fk_editora")
    private Integer fkEditora;
    @Column(name = "fk_autor")
    private Integer fkAutor;

    public Livro() {
    }

    public Livro(Integer codLivro) {
        this.codLivro = codLivro;
    }

    public Livro(Integer codLivro, String titulo, String isbn, int quantidade) {
        this.codLivro = codLivro;
        this.titulo = titulo;
        this.isbn = isbn;
        this.quantidade = quantidade;
    }

    public Integer getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(Integer codLivro) {
        Integer oldCodLivro = this.codLivro;
        this.codLivro = codLivro;
        changeSupport.firePropertyChange("codLivro", oldCodLivro, codLivro);
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        String oldTitulo = this.titulo;
        this.titulo = titulo;
        changeSupport.firePropertyChange("titulo", oldTitulo, titulo);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        String oldIsbn = this.isbn;
        this.isbn = isbn;
        changeSupport.firePropertyChange("isbn", oldIsbn, isbn);
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        int oldQuantidade = this.quantidade;
        this.quantidade = quantidade;
        changeSupport.firePropertyChange("quantidade", oldQuantidade, quantidade);
    }

    public Integer getFkEditora() {
        return fkEditora;
    }

    public void setFkEditora(Integer fkEditora) {
        Integer oldFkEditora = this.fkEditora;
        this.fkEditora = fkEditora;
        changeSupport.firePropertyChange("fkEditora", oldFkEditora, fkEditora);
    }

    public Integer getFkAutor() {
        return fkAutor;
    }

    public void setFkAutor(Integer fkAutor) {
        Integer oldFkAutor = this.fkAutor;
        this.fkAutor = fkAutor;
        changeSupport.firePropertyChange("fkAutor", oldFkAutor, fkAutor);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codLivro != null ? codLivro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Livro)) {
            return false;
        }
        Livro other = (Livro) object;
        if ((this.codLivro == null && other.codLivro != null) || (this.codLivro != null && !this.codLivro.equals(other.codLivro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Livro[ codLivro=" + codLivro + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
