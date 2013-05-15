/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Disciplina;
import model.Professor;

/**
 *
 * @author jeferson
 */
@Stateless
public class ProfessorEJB {

    @PersistenceContext
    EntityManager em;

    public Professor salvar(Professor professor) {
        professor = em.merge(professor);
        //automaticamente ele salva no banco, atribui o objeto ja com a ID salva, retornando
        for (Disciplina d : professor.getDisciplina()) {
            d.getProfessor().add(professor);
            em.merge(d);
        }
        return professor;
    }
}
