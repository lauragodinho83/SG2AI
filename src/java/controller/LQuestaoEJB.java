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
import model.LQuestao;

/**
 *
 * @author daniel
 */
@Stateless
public class LQuestaoEJB {

    @PersistenceContext
    EntityManager em;
    
    public void salvar( LQuestao lQuestao ) {
        em.merge( lQuestao );
    }
    
    public void excluir( Long id ) {
        LQuestao lQuestao = em.find( LQuestao.class, id );
        
        em.remove( lQuestao );
    }
    
    public List<LQuestao> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM LQuestao o" );
        
        return query.getResultList();
    }

}
