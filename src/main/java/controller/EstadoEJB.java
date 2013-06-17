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
import model.Estado;

/**
 *
 * @author Automacao
 */
@Stateless
public class EstadoEJB {

    @PersistenceContext
    private EntityManager em;
    
    public void salvar( Estado estado ) {
        em.merge( estado );
    }
    
    public void excluir( Long id ) {
        Estado estado = em.find( Estado.class, id );
        
        em.remove( estado );
    }
    
    public List<Estado> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM Estado o" );
        
        return query.getResultList();
    }
}
