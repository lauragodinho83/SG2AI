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
import model.Questao;

/**
 *
 * @author daniel
 */
@Stateless
public class QuestaoEJB {

    @PersistenceContext
    EntityManager em;
    
    public void salvar( Questao questao ) {       
        em.merge( questao );
    }
    
    public void excluir( Long id ) {
        Questao questao = em.find( Questao.class, id );
        
        em.remove( questao );
    }
    
    public List<Questao> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM Questao o" );
        
        return query.getResultList();
    }
    
    
    public List < Questao > obterQuestaoPorDisciplina (Long id) 
    {
       return em.createQuery( "SELECT o FROM Questao o WHERE o.id:=id" ) .setParameter("id", id) .getResultList();
        
       
    }
    
    public Questao obterPorId( Long id ) {
        Questao questao = em.find( Questao.class, id );
        
        return questao;
    }

}
