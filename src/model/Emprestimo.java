/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author Nicolas
 */
public class Emprestimo {
    private int codEmprestimo;
    private int CodlivroEmprestimo;
    private int CodigoAluno;
    private int Verifica;
    private int CodigoProfesor;
    private Date data_emprestimo;
    private String cod_dev;
    private String nome;
    private String titulo;
    private String professor;

    public Emprestimo(){}
    
    
    public Emprestimo(int CodlivroEmprestimo, int CodigoAluno, int CodigoProfessor,int verifica) {
        this.CodlivroEmprestimo = CodlivroEmprestimo;
        this.CodigoAluno = CodigoAluno;
        this.Verifica = verifica;
        this.CodigoProfesor= CodigoProfessor;
    }
 
    public int getCodEmprestimo() {
        return codEmprestimo;
    }

    public void setCodEmprestimo(int codEmprestimo) {
        this.codEmprestimo = codEmprestimo;
    }

    public int getCodlivroEmprestimo() {
        return CodlivroEmprestimo;
    }

    public void setCodlivroEmprestimo(int CodlivroEmprestimo) {
        this.CodlivroEmprestimo = CodlivroEmprestimo;
    }

    public int getVerifica() {
        return Verifica;
    }

    public void setVerifica(int Verifica) {
        this.Verifica = Verifica;
    }

    public Date getData_emprestimo() {
        return data_emprestimo;
    }

    public void setData_emprestimo(Date data_emprestimo) {
        this.data_emprestimo = data_emprestimo;
    }

    public int getCodigoAluno() {
        return CodigoAluno;
    }

    public void setCodigoAluno(int CodigoAluno) {
        this.CodigoAluno = CodigoAluno;
    }

    public int getCodigoProfesor() {
        return CodigoProfesor;
    }

    public void setCodigoProfesor(int CodigoProfesor) {
        this.CodigoProfesor = CodigoProfesor;
    }

  

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor;
    }

    public String getCod_dev() {
        return cod_dev;
    }

    public void setCod_dev(String cod_dev) {
        this.cod_dev = cod_dev;
    }

    @Override
    public String toString() {
        return "Emprestimo{" + "codEmprestimo=" + codEmprestimo + ", CodlivroEmprestimo=" + CodlivroEmprestimo + ", CodigoAluno=" + CodigoAluno + ", Verifica=" + Verifica + ", CodigoProfesor=" + CodigoProfesor + ", data_emprestimo=" + data_emprestimo + ", cod_dev=" + cod_dev + ", nome=" + nome + ", titulo=" + titulo + ", professor=" + professor + '}';
    }

  
    
    
    
    
    
}
