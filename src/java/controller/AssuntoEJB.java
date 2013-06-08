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
import model.Assunto;

/**
 *
 * @author VictorHUgo
 */
@Stateless
public class AssuntoEJB {

    @PersistenceContext
    EntityManager em;
    
    public void salvar(Assunto assunto){
        em.merge(assunto);
    }
    
    public void excluir(Long id){
        Assunto assunto = em.find(Assunto.class, id);
        em.remove(assunto);
    }
    
    public List<Assunto> obterTodos(){
        Query query = em.createQuery("SELECT o FROM Assunto o");
        return query.getResultList();
    }
    
}
