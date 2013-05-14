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
import model.Estudante;

/**
 *
 * @author Automacao
 */
@Stateless
public class EstudanteEJB {

    @PersistenceContext
    private EntityManager em;
    
    public void salvar( Estudante estudante ) {
        em.merge( estudante );
    }
    
    public void excluir( Long id ) {
        Estudante estudante = em.find( Estudante.class, id );
        
        em.remove( estudante );
    }
    
    public List<Estudante> obterTodos() {
        Query query = em.createQuery( "SELECT o FROM Estudante o" );
        
        return query.getResultList();
    }
}
