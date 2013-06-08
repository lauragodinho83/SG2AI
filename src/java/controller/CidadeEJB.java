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
import model.Cidade;



/**
 *
 * @author Automacao
 */
@Stateless
public class CidadeEJB {

    @PersistenceContext
    private EntityManager em;
    
    public void salvar( Cidade cidade ) {
        em.merge( cidade );
    }
    
    public void excluir( Long id ) {
        Cidade cidade = em.find( Cidade.class, id );
        
        em.remove( cidade );
    }
    
    public List<Cidade> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM Cidade o" );
        
        return query.getResultList();
    }
}
