/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import br.unifan.tdefullstackapi.entity.Curso;
import br.unifan.tdefullstackapi.resources.AbstractFacade;

/**
 *
 * @author USER
 */

public class CursoDAO extends AbstractFacade<Curso> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public CursoDAO() {
        super(Curso.class);
    }

    public void create(Curso entity) {
        super.create(entity);
    }

    public void edit(Curso entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Curso find(Integer id) {
        return super.find(id);
    }

    public List<Curso> findAll() {
        return super.findAll();
    }

    public List<Curso> findRange(Integer from, Integer to) {
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
