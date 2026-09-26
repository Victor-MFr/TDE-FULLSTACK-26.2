/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.entity;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;
import java.io.Serializable;

/**
 *
 * @author USER
 */
@Embeddable
public class DisciplinaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "idDisciplina")
    private int idDisciplina;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "curso_idCurso")
    private int cursoidCurso;

    public DisciplinaPK() {
    }

    public DisciplinaPK(int idDisciplina, int cursoidCurso) {
        this.idDisciplina = idDisciplina;
        this.cursoidCurso = cursoidCurso;
    }

    public int getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(int idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public int getCursoidCurso() {
        return cursoidCurso;
    }

    public void setCursoidCurso(int cursoidCurso) {
        this.cursoidCurso = cursoidCurso;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idDisciplina;
        hash += (int) cursoidCurso;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaPK)) {
            return false;
        }
        DisciplinaPK other = (DisciplinaPK) object;
        if (this.idDisciplina != other.idDisciplina) {
            return false;
        }
        if (this.cursoidCurso != other.cursoidCurso) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.unifan.tdefullstackapi.DisciplinaPK[ idDisciplina=" + idDisciplina + ", cursoidCurso=" + cursoidCurso + " ]";
    }
    
}
