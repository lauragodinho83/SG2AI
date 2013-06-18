/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Curso;

/**
 *
 * @author jeferson
 */
@Stateless
public class CursoEJB {

    @PersistenceContext
    EntityManager em;

    public void salvar(Curso curso) {
        em.merge(curso);
    }

    public void excluir(Long id) {
        Curso curso = em.find(Curso.class, id);
        em.remove(curso);
    }
    
    public List<Curso> findAll(){
        return em.createNamedQuery("Curso.findAll").getResultList();
    }
    
    
     public Curso findById(Integer i) {
        return (Curso) em.createQuery("SELECT c FROM Curso c WHERE c.id=:id")
                .setParameter("id", i)
                .getSingleResult();

    }
    
    
}
