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
@Table(name = "professor", catalog = "emprestimo", schema = "")
@NamedQueries({
    @NamedQuery(name = "Professor.findAll", query = "SELECT p FROM Professor p")
    , @NamedQuery(name = "Professor.findByCodProf", query = "SELECT p FROM Professor p WHERE p.codProf = :codProf")
    , @NamedQuery(name = "Professor.findByNome", query = "SELECT p FROM Professor p WHERE p.nome = :nome")
    , @NamedQuery(name = "Professor.findByTitulacao", query = "SELECT p FROM Professor p WHERE p.titulacao = :titulacao")})
public class Professor implements Serializable {

    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_prof")
    private Integer codProf;
    @Basic(optional = false)
    @Column(name = "nome")
    private String nome;
    @Basic(optional = false)
    @Column(name = "titulacao")
    private String titulacao;

    public Professor() {
    }

    public Professor(Integer codProf) {
        this.codProf = codProf;
    }

    public Professor(Integer codProf, String nome, String titulacao) {
        this.codProf = codProf;
        this.nome = nome;
        this.titulacao = titulacao;
    }

    public Integer getCodProf() {
        return codProf;
    }

    public void setCodProf(Integer codProf) {
        Integer oldCodProf = this.codProf;
        this.codProf = codProf;
        changeSupport.firePropertyChange("codProf", oldCodProf, codProf);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        String oldNome = this.nome;
        this.nome = nome;
        changeSupport.firePropertyChange("nome", oldNome, nome);
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        String oldTitulacao = this.titulacao;
        this.titulacao = titulacao;
        changeSupport.firePropertyChange("titulacao", oldTitulacao, titulacao);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codProf != null ? codProf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Professor)) {
            return false;
        }
        Professor other = (Professor) object;
        if ((this.codProf == null && other.codProf != null) || (this.codProf != null && !this.codProf.equals(other.codProf))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "view.Professor[ codProf=" + codProf + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}
