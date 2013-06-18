/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Curso;
import model.Disciplina;

/**
 *
 * @author jeferson
 */
@Stateless
public class DisciplinaEJB {

    @PersistenceContext
    EntityManager em;
    
    @EJB
    private CursoEJB cursoEJB;

    public void salvar(Disciplina disc) {
        
        Long idCurso = disc.getCurso().getId();
        Curso curso = cursoEJB.findById(idCurso);
        
        disc.setCurso( curso );
        
        System.out.println("EJB metodo salvar ID " + disc.getCurso().getId() + "do curso " + disc.getCurso().getDescricao());
        em.merge(disc);
    
    }

    public List<Disciplina> findAll() {
        return em.createNamedQuery("Disciplina.findAll").getResultList();
    }

    public Disciplina findById(Integer i) {
        return (Disciplina) em.createQuery("SELECT d FROM Disciplina d where d.id=:id")
                .setParameter("id", i)
                .getSingleResult();
    }
    
    public void excluir(Long id){
        
        Disciplina disciplina = em.find( Disciplina.class, id );
        
        em.remove( disciplina );
    }
}
