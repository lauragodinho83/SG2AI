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
import model.VFQuestao;

/**
 *
 * @author daniel
 */
@Stateless
public class VFQuestaoEJB {

    @PersistenceContext
    EntityManager em;
    
    public void salvar( VFQuestao vfQuestao ) {
        em.merge( vfQuestao );
    }
    
    public void excluir( Long id ) {
        VFQuestao questao = em.find( VFQuestao.class, id );
        
        em.remove( questao );
    }
    
    public List<VFQuestao> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM VFQuestao o" );
        
        return query.getResultList();
    }

}
