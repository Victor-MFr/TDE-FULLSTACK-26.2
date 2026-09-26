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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.io.Serializable;

/**
 *
 * @author USER
 */
@Entity
@Table(name = "pdftemplate")
@NamedQueries({
    @NamedQuery(name = "Pdftemplate.findAll", query = "SELECT p FROM Pdftemplate p"),
    @NamedQuery(name = "Pdftemplate.findByIdPdfTemplate", query = "SELECT p FROM Pdftemplate p WHERE p.idPdfTemplate = :idPdfTemplate"),
    @NamedQuery(name = "Pdftemplate.findByNomeTemplate", query = "SELECT p FROM Pdftemplate p WHERE p.nomeTemplate = :nomeTemplate"),
    @NamedQuery(name = "Pdftemplate.findByNomeArquivoTemplate", query = "SELECT p FROM Pdftemplate p WHERE p.nomeArquivoTemplate = :nomeArquivoTemplate")})
public class Pdftemplate implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPdfTemplate")
    private Integer idPdfTemplate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nomeTemplate")
    private String nomeTemplate;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "nomeArquivoTemplate")
    private String nomeArquivoTemplate;
    
    @JoinColumn(name = "avaliacao_idAvaliacao", referencedColumnName = "idAvaliacao")
    @ManyToOne(optional = false)
    private Avaliacao avaliacaoidAvaliacao;

    public Pdftemplate() {
    }

    public Pdftemplate(Integer idPdfTemplate) {
        this.idPdfTemplate = idPdfTemplate;
    }

    public Pdftemplate(Integer idPdfTemplate, String nomeTemplate, String nomeArquivoTemplate) {
        this.idPdfTemplate = idPdfTemplate;
        this.nomeTemplate = nomeTemplate;
        this.nomeArquivoTemplate = nomeArquivoTemplate;
    }

    public Integer getIdPdfTemplate() {
        return idPdfTemplate;
    }

    public void setIdPdfTemplate(Integer idPdfTemplate) {
        this.idPdfTemplate = idPdfTemplate;
    }

    public String getNomeTemplate() {
        return nomeTemplate;
    }

    public void setNomeTemplate(String nomeTemplate) {
        this.nomeTemplate = nomeTemplate;
    }

    public String getNomeArquivoTemplate() {
        return nomeArquivoTemplate;
    }

    public void setNomeArquivoTemplate(String nomeArquivoTemplate) {
        this.nomeArquivoTemplate = nomeArquivoTemplate;
    }

    public Avaliacao getAvaliacaoidAvaliacao() {
        return avaliacaoidAvaliacao;
    }

    public void setAvaliacaoidAvaliacao(Avaliacao avaliacaoidAvaliacao) {
        this.avaliacaoidAvaliacao = avaliacaoidAvaliacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPdfTemplate != null ? idPdfTemplate.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pdftemplate)) {
            return false;
        }
        Pdftemplate other = (Pdftemplate) object;
        if ((this.idPdfTemplate == null && other.idPdfTemplate != null) || (this.idPdfTemplate != null && !this.idPdfTemplate.equals(other.idPdfTemplate))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unifan.tdefullstackapi.Pdftemplate[ idPdfTemplate=" + idPdfTemplate + " ]";
    }
    
}
