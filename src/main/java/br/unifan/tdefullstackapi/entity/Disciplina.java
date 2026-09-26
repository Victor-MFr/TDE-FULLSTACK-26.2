/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "disciplina")
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByIdDisciplina", query = "SELECT d FROM Disciplina d WHERE d.disciplinaPK.idDisciplina = :idDisciplina"),
    @NamedQuery(name = "Disciplina.findByNomeDisciplina", query = "SELECT d FROM Disciplina d WHERE d.nomeDisciplina = :nomeDisciplina"),
    @NamedQuery(name = "Disciplina.findByCargaHoraria", query = "SELECT d FROM Disciplina d WHERE d.cargaHoraria = :cargaHoraria"),
    @NamedQuery(name = "Disciplina.findByTurnoDisciplina", query = "SELECT d FROM Disciplina d WHERE d.turnoDisciplina = :turnoDisciplina"),
    @NamedQuery(name = "Disciplina.findByDescricaoDisciplina", query = "SELECT d FROM Disciplina d WHERE d.descricaoDisciplina = :descricaoDisciplina"),
    @NamedQuery(name = "Disciplina.findByCursoidCurso", query = "SELECT d FROM Disciplina d WHERE d.disciplinaPK.cursoidCurso = :cursoidCurso")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DisciplinaPK disciplinaPK;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nomeDisciplina")
    private String nomeDisciplina;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "cargaHoraria")
    private int cargaHoraria;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "turnoDisciplina")
    private String turnoDisciplina;
    
    @Size(max = 450)
    @Column(name = "descricaoDisciplina")
    private String descricaoDisciplina;
    
    @JoinTable(name = "usuario_has_disciplina", joinColumns = {
        @JoinColumn(name = "disciplina_idDisciplina", referencedColumnName = "idDisciplina"),
        @JoinColumn(name = "disciplina_curso_idCurso", referencedColumnName = "curso_idCurso")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")})
    @ManyToMany
    private Collection<Usuario> usuarioCollection;
    
    @JoinColumn(name = "curso_idCurso", referencedColumnName = "idCurso", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private Collection<Avaliacao> avaliacaoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private Collection<Questao> questaoCollection;

    public Disciplina() {
    }

    public Disciplina(DisciplinaPK disciplinaPK) {
        this.disciplinaPK = disciplinaPK;
    }

    public Disciplina(DisciplinaPK disciplinaPK, String nomeDisciplina, int cargaHoraria, String turnoDisciplina) {
        this.disciplinaPK = disciplinaPK;
        this.nomeDisciplina = nomeDisciplina;
        this.cargaHoraria = cargaHoraria;
        this.turnoDisciplina = turnoDisciplina;
    }

    public Disciplina(int idDisciplina, int cursoidCurso) {
        this.disciplinaPK = new DisciplinaPK(idDisciplina, cursoidCurso);
    }

    public DisciplinaPK getDisciplinaPK() {
        return disciplinaPK;
    }

    public void setDisciplinaPK(DisciplinaPK disciplinaPK) {
        this.disciplinaPK = disciplinaPK;
    }

    public String getNomeDisciplina() {
        return nomeDisciplina;
    }

    public void setNomeDisciplina(String nomeDisciplina) {
        this.nomeDisciplina = nomeDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getTurnoDisciplina() {
        return turnoDisciplina;
    }

    public void setTurnoDisciplina(String turnoDisciplina) {
        this.turnoDisciplina = turnoDisciplina;
    }

    public String getDescricaoDisciplina() {
        return descricaoDisciplina;
    }

    public void setDescricaoDisciplina(String descricaoDisciplina) {
        this.descricaoDisciplina = descricaoDisciplina;
    }

    public Collection<Usuario> getUsuarioCollection() {
        return usuarioCollection;
    }

    public void setUsuarioCollection(Collection<Usuario> usuarioCollection) {
        this.usuarioCollection = usuarioCollection;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
    }

    public Collection<Questao> getQuestaoCollection() {
        return questaoCollection;
    }

    public void setQuestaoCollection(Collection<Questao> questaoCollection) {
        this.questaoCollection = questaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (disciplinaPK != null ? disciplinaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.disciplinaPK == null && other.disciplinaPK != null) || (this.disciplinaPK != null && !this.disciplinaPK.equals(other.disciplinaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unifan.tdefullstackapi.Disciplina[ disciplinaPK=" + disciplinaPK + " ]";
    }
    
}
