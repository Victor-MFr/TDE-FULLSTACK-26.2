/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "avaliacao")
@NamedQueries({
    @NamedQuery(name = "Avaliacao.findAll", query = "SELECT a FROM Avaliacao a"),
    @NamedQuery(name = "Avaliacao.findByIdAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.idAvaliacao = :idAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByValorAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.valorAvaliacao = :valorAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByDocente", query = "SELECT a FROM Avaliacao a WHERE a.docente = :docente"),
    @NamedQuery(name = "Avaliacao.findByTipoAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.tipoAvaliacao = :tipoAvaliacao"),
    @NamedQuery(name = "Avaliacao.findBySemestreAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.semestreAvaliacao = :semestreAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByDataElaboracaoAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.dataElaboracaoAvaliacao = :dataElaboracaoAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByDataRealizacaoAvaliacao", query = "SELECT a FROM Avaliacao a WHERE a.dataRealizacaoAvaliacao = :dataRealizacaoAvaliacao"),
    @NamedQuery(name = "Avaliacao.findByQuantQuestMultiplaEscolha", query = "SELECT a FROM Avaliacao a WHERE a.quantQuestMultiplaEscolha = :quantQuestMultiplaEscolha"),
    @NamedQuery(name = "Avaliacao.findByQuantidadeQuestoesAbertas", query = "SELECT a FROM Avaliacao a WHERE a.quantidadeQuestoesAbertas = :quantidadeQuestoesAbertas")})
public class Avaliacao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAvaliacao")
    private Integer idAvaliacao;
    
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "valorAvaliacao")
    private Float valorAvaliacao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "docente")
    private String docente;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoAvaliacao")
    private String tipoAvaliacao;
    
    @Column(name = "semestreAvaliacao")
    private Integer semestreAvaliacao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "dataElaboracaoAvaliacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataElaboracaoAvaliacao;
    
    @Column(name = "dataRealizacaoAvaliacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataRealizacaoAvaliacao;
    
    @Column(name = "quantQuestMultiplaEscolha")
    private Integer quantQuestMultiplaEscolha;
    
    @Column(name = "quantidadeQuestoesAbertas")
    private Integer quantidadeQuestoesAbertas;
    
    @JoinTable(name = "questao_has_avaliacao", joinColumns = {
        @JoinColumn(name = "avaliacao_idAvaliacao", referencedColumnName = "idAvaliacao")}, inverseJoinColumns = {
        @JoinColumn(name = "questao_idQuestao", referencedColumnName = "idQuestao")})
    @ManyToMany
    private Collection<Questao> questaoCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "avaliacaoidAvaliacao")
    private Collection<Pdftemplate> pdftemplateCollection;
    
    @JoinColumn(name = "curso_idCurso", referencedColumnName = "idCurso")
    @ManyToOne(optional = false)
    private Curso cursoidCurso;
    
    @JoinColumns({
        @JoinColumn(name = "disciplina_idDisciplina", referencedColumnName = "idDisciplina"),
        @JoinColumn(name = "disciplina_curso_idCurso", referencedColumnName = "curso_idCurso")})
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Avaliacao() {
    }

    public Avaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Avaliacao(Integer idAvaliacao, String docente, String tipoAvaliacao, Date dataElaboracaoAvaliacao) {
        this.idAvaliacao = idAvaliacao;
        this.docente = docente;
        this.tipoAvaliacao = tipoAvaliacao;
        this.dataElaboracaoAvaliacao = dataElaboracaoAvaliacao;
    }

    public Integer getIdAvaliacao() {
        return idAvaliacao;
    }

    public void setIdAvaliacao(Integer idAvaliacao) {
        this.idAvaliacao = idAvaliacao;
    }

    public Float getValorAvaliacao() {
        return valorAvaliacao;
    }

    public void setValorAvaliacao(Float valorAvaliacao) {
        this.valorAvaliacao = valorAvaliacao;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getTipoAvaliacao() {
        return tipoAvaliacao;
    }

    public void setTipoAvaliacao(String tipoAvaliacao) {
        this.tipoAvaliacao = tipoAvaliacao;
    }

    public Integer getSemestreAvaliacao() {
        return semestreAvaliacao;
    }

    public void setSemestreAvaliacao(Integer semestreAvaliacao) {
        this.semestreAvaliacao = semestreAvaliacao;
    }

    public Date getDataElaboracaoAvaliacao() {
        return dataElaboracaoAvaliacao;
    }

    public void setDataElaboracaoAvaliacao(Date dataElaboracaoAvaliacao) {
        this.dataElaboracaoAvaliacao = dataElaboracaoAvaliacao;
    }

    public Date getDataRealizacaoAvaliacao() {
        return dataRealizacaoAvaliacao;
    }

    public void setDataRealizacaoAvaliacao(Date dataRealizacaoAvaliacao) {
        this.dataRealizacaoAvaliacao = dataRealizacaoAvaliacao;
    }

    public Integer getQuantQuestMultiplaEscolha() {
        return quantQuestMultiplaEscolha;
    }

    public void setQuantQuestMultiplaEscolha(Integer quantQuestMultiplaEscolha) {
        this.quantQuestMultiplaEscolha = quantQuestMultiplaEscolha;
    }

    public Integer getQuantidadeQuestoesAbertas() {
        return quantidadeQuestoesAbertas;
    }

    public void setQuantidadeQuestoesAbertas(Integer quantidadeQuestoesAbertas) {
        this.quantidadeQuestoesAbertas = quantidadeQuestoesAbertas;
    }

    public Collection<Questao> getQuestaoCollection() {
        return questaoCollection;
    }

    public void setQuestaoCollection(Collection<Questao> questaoCollection) {
        this.questaoCollection = questaoCollection;
    }

    public Collection<Pdftemplate> getPdftemplateCollection() {
        return pdftemplateCollection;
    }

    public void setPdftemplateCollection(Collection<Pdftemplate> pdftemplateCollection) {
        this.pdftemplateCollection = pdftemplateCollection;
    }

    public Curso getCursoidCurso() {
        return cursoidCurso;
    }

    public void setCursoidCurso(Curso cursoidCurso) {
        this.cursoidCurso = cursoidCurso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Usuario getUsuarioidUsuario() {
        return usuarioidUsuario;
    }

    public void setUsuarioidUsuario(Usuario usuarioidUsuario) {
        this.usuarioidUsuario = usuarioidUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAvaliacao != null ? idAvaliacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Avaliacao)) {
            return false;
        }
        Avaliacao other = (Avaliacao) object;
        if ((this.idAvaliacao == null && other.idAvaliacao != null) || (this.idAvaliacao != null && !this.idAvaliacao.equals(other.idAvaliacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unifan.tdefullstackapi.Avaliacao[ idAvaliacao=" + idAvaliacao + " ]";
    }
    
}
