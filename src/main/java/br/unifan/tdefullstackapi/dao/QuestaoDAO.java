/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.unifan.tdefullstackapi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import br.unifan.tdefullstackapi.entity.Questao;
import br.unifan.tdefullstackapi.resources.AbstractFacade;

/**
 *
 * @author USER
 */

public class QuestaoDAO extends AbstractFacade<Questao> {

    @PersistenceContext(unitName = "my_persistence_unit")
    private EntityManager em;

    public QuestaoDAO() {
        super(Questao.class);
    }

    public void create(Questao entity) {
        super.create(entity);
    }

    public void edit(Questao entity) {
        super.edit(entity);
    }

    public void remove(Integer id) {
        super.remove(super.find(id));
    }

    public Questao find(Integer id) {
        return super.find(id);
    }

    public List<Questao> findAll() {
        return super.findAll();
    }

    public List<Questao> findRange(Integer from, Integer to) {
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
