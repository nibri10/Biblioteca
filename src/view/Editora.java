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
@Table(name = "editora", catalog = "emprestimo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Editora.findAll", query = "SELECT e FROM Editora e")
    , @NamedQuery(name = "Editora.findByCodEditora", query = "SELECT e FROM Editora e WHERE e.codEditora = :codEditora")
    , @NamedQuery(name = "Editora.findByNome", query = "SELECT e FROM Editora e WHERE e.nome = :nome")
    , @NamedQuery(name = "Editora.findByCidade", query = "SELECT e FROM Editora e WHERE e.cidade = :cidade")})
public class Editora implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_editora")
    private Integer codEditora;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "cidade")
    private String cidade;

    public Editora() {
    }

    public Editora(Integer codEditora) {
        this.codEditora = codEditora;
    }

    public Editora(Integer codEditora, String nome, String cidade) {
        this.codEditora = codEditora;
        this.nome = nome;
        this.cidade = cidade;
    }

    public Integer getCodEditora() {
        return codEditora;
    }

    public void setCodEditora(Integer codEditora) {
        Integer oldCodEditora = this.codEditora;
        this.codEditora = codEditora;
        changeSupport.firePropertyChange("codEditora", oldCodEditora, codEditora);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        String oldCidade = this.cidade;
        this.cidade = cidade;
        changeSupport.firePropertyChange("cidade", oldCidade, cidade);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEditora != null ? codEditora.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Editora)) {
            return false;
        }
        Editora other = (Editora) object;
        if ((this.codEditora == null && other.codEditora != null) || (this.codEditora != null && !this.codEditora.equals(other.codEditora))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Editora[ codEditora=" + codEditora + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
