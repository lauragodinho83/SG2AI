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
import model.Bairro;

/**
 *
 * @author Automacao
 */
@Stateless
public class BairroEJB {

    @PersistenceContext
    private EntityManager em;
    
    public void salvar( Bairro bairro ) {
        em.merge( bairro );
    }
    
    public void excluir( Long id ) {
        Bairro bairro = em.find( Bairro.class, id );
        
        em.remove( bairro );
    }
    
    public List<Bairro> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM Bairro o" );
        
        return query.getResultList();
    }
}
