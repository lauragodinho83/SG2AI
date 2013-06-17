/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Professor;

/**
 *
 * @author jeferson
 */
@Stateless
public class ProfessorEJB {

    @PersistenceContext
    EntityManager em;

    public List<Professor> obterTodos() {
        Query query = em.createQuery("SELECT p FROM Professor p");

        return query.getResultList();
    }

    public Professor salvar(Professor professor) {
        professor = em.merge(professor);
        //automaticamente ele salva no banco, atribui o objeto ja com a ID salva, retornando
        /*for (Disciplina d : professor.getDisciplina()) {
         d.getProfessor().add(professor);
         em.merge(d);
         }*/
        return professor;
    }

    public void excluir(Long id) {
        Professor professor = em.find(Professor.class, id);

        em.remove(professor);
    }
}
