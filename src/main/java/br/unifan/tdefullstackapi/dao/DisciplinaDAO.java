/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import br.unifan.tdefullstackapi.entity.Disciplina;
import br.unifan.tdefullstackapi.entity.DisciplinaPK;
import br.unifan.tdefullstackapi.resources.AbstractFacade;
import jakarta.ejb.Stateless;

/**
 *
 * @author USER
 */

@Stateless
public class DisciplinaDAO extends AbstractFacade<Disciplina> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public DisciplinaDAO() {
        super(Disciplina.class);
    }

    public void create(Disciplina entity) {
        super.create(entity);
    }

    public void edit(Disciplina entity) {
        super.edit(entity);
    }

    public void remove(DisciplinaPK key) {
        super.remove(super.find(key));
    }

    public Disciplina find(DisciplinaPK key) {
        return super.find(key);
    }

    public List<Disciplina> findAll() {
        return super.findAll();
    }

    public List<Disciplina> findRange(Integer from, Integer to) {
        return super.findRange(new int[]{from, to});
    }

    public String countREST() {
        return String.valueOf(super.count());
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
}