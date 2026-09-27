/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
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
@Table(name = "questao")
@NamedQueries({
    @NamedQuery(name = "Questao.findAll", query = "SELECT q FROM Questao q"),
    @NamedQuery(name = "Questao.findByIdQuestao", query = "SELECT q FROM Questao q WHERE q.idQuestao = :idQuestao"),
    @NamedQuery(name = "Questao.findByTipoQuestao", query = "SELECT q FROM Questao q WHERE q.tipoQuestao = :tipoQuestao"),
    @NamedQuery(name = "Questao.findByNivelDificuldadeQuestao", query = "SELECT q FROM Questao q WHERE q.nivelDificuldadeQuestao = :nivelDificuldadeQuestao"),
    @NamedQuery(name = "Questao.findByDescricaoQuestao", query = "SELECT q FROM Questao q WHERE q.descricaoQuestao = :descricaoQuestao"),
    @NamedQuery(name = "Questao.findByMultiplaEscolha", query = "SELECT q FROM Questao q WHERE q.multiplaEscolha = :multiplaEscolha"),
    @NamedQuery(name = "Questao.findByQuantidadeOpcaoQuestao", query = "SELECT q FROM Questao q WHERE q.quantidadeOpcaoQuestao = :quantidadeOpcaoQuestao"),
    @NamedQuery(name = "Questao.findByOpcaoMarcacaoQuestao", query = "SELECT q FROM Questao q WHERE q.opcaoMarcacaoQuestao = :opcaoMarcacaoQuestao"),
    @NamedQuery(name = "Questao.findByOpcaoCorretaQuestao", query = "SELECT q FROM Questao q WHERE q.opcaoCorretaQuestao = :opcaoCorretaQuestao")})
public class Questao implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idQuestao")
    private Integer idQuestao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipoQuestao")
    private String tipoQuestao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "nivelDificuldadeQuestao")
    private String nivelDificuldadeQuestao;
    
    @Size(max = 450)
    @Column(name = "descricaoQuestao")
    private String descricaoQuestao;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "multiplaEscolha")
    private String multiplaEscolha;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "quantidadeOpcaoQuestao")
    private int quantidadeOpcaoQuestao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "opcaoMarcacaoQuestao")
    private int opcaoMarcacaoQuestao;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "opcaoCorretaQuestao")
    private int opcaoCorretaQuestao;
    
    @ManyToMany(mappedBy = "questaoCollection")
    private Collection<Avaliacao> avaliacaoCollection;
    
    @JoinColumns({
        @JoinColumn(name = "disciplina_idDisciplina", referencedColumnName = "idDisciplina"),
        @JoinColumn(name = "disciplina_curso_idCurso", referencedColumnName = "curso_idCurso")})
    @ManyToOne(optional = false)
    private Disciplina disciplina;
    
    @JoinColumn(name = "usuario_idUsuario", referencedColumnName = "idUsuario")
    @ManyToOne(optional = false)
    private Usuario usuarioidUsuario;

    public Questao() {
    }

    public Questao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public Questao(Integer idQuestao, String tipoQuestao, String nivelDificuldadeQuestao, String multiplaEscolha, int quantidadeOpcaoQuestao, int opcaoMarcacaoQuestao, int opcaoCorretaQuestao) {
        this.idQuestao = idQuestao;
        this.tipoQuestao = tipoQuestao;
        this.nivelDificuldadeQuestao = nivelDificuldadeQuestao;
        this.multiplaEscolha = multiplaEscolha;
        this.quantidadeOpcaoQuestao = quantidadeOpcaoQuestao;
        this.opcaoMarcacaoQuestao = opcaoMarcacaoQuestao;
        this.opcaoCorretaQuestao = opcaoCorretaQuestao;
    }

    public Integer getIdQuestao() {
        return idQuestao;
    }

    public void setIdQuestao(Integer idQuestao) {
        this.idQuestao = idQuestao;
    }

    public String getTipoQuestao() {
        return tipoQuestao;
    }

    public void setTipoQuestao(String tipoQuestao) {
        this.tipoQuestao = tipoQuestao;
    }

    public String getNivelDificuldadeQuestao() {
        return nivelDificuldadeQuestao;
    }

    public void setNivelDificuldadeQuestao(String nivelDificuldadeQuestao) {
        this.nivelDificuldadeQuestao = nivelDificuldadeQuestao;
    }

    public String getDescricaoQuestao() {
        return descricaoQuestao;
    }

    public void setDescricaoQuestao(String descricaoQuestao) {
        this.descricaoQuestao = descricaoQuestao;
    }

    public String getMultiplaEscolha() {
        return multiplaEscolha;
    }

    public void setMultiplaEscolha(String multiplaEscolha) {
        this.multiplaEscolha = multiplaEscolha;
    }

    public int getQuantidadeOpcaoQuestao() {
        return quantidadeOpcaoQuestao;
    }

    public void setQuantidadeOpcaoQuestao(int quantidadeOpcaoQuestao) {
        this.quantidadeOpcaoQuestao = quantidadeOpcaoQuestao;
    }

    public int getOpcaoMarcacaoQuestao() {
        return opcaoMarcacaoQuestao;
    }

    public void setOpcaoMarcacaoQuestao(int opcaoMarcacaoQuestao) {
        this.opcaoMarcacaoQuestao = opcaoMarcacaoQuestao;
    }

    public int getOpcaoCorretaQuestao() {
        return opcaoCorretaQuestao;
    }

    public void setOpcaoCorretaQuestao(int opcaoCorretaQuestao) {
        this.opcaoCorretaQuestao = opcaoCorretaQuestao;
    }

    public Collection<Avaliacao> getAvaliacaoCollection() {
        return avaliacaoCollection;
    }

    public void setAvaliacaoCollection(Collection<Avaliacao> avaliacaoCollection) {
        this.avaliacaoCollection = avaliacaoCollection;
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
        hash += (idQuestao != null ? idQuestao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Questao)) {
            return false;
        }
        Questao other = (Questao) object;
        if ((this.idQuestao == null && other.idQuestao != null) || (this.idQuestao != null && !this.idQuestao.equals(other.idQuestao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unifan.tdefullstackapi.Questao[ idQuestao=" + idQuestao + " ]";
    }
    
}
