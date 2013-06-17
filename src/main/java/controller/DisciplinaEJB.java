/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Disciplina;

/**
 *
 * @author jeferson
 */
@Stateless
public class DisciplinaEJB {

    @PersistenceContext
    EntityManager em;

    public Disciplina salvar(Disciplina disc) {
        return em.merge(disc);
    }

    public List<Disciplina> findAll() {
        return em.createNamedQuery("Disciplina.findAll").getResultList();
    }

    public Disciplina findById(Integer i) {
        return (Disciplina) em.createNamedQuery("Disciplina.findById")
                .setParameter("id", i)
                .getSingleResult();
    }
}
