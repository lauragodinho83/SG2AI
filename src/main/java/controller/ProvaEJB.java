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
import model.Prova;

/**
 *
 * @author VictorHUgo
 */
@Stateless
public class ProvaEJB {

    @PersistenceContext
    EntityManager em;
    
    public void salvar(Prova prova){
        em.merge(prova);
    }
    
    public void excluir(Long id){
        Prova prova = em.find(Prova.class, id);
        em.remove(prova);
    }

    public List<Prova> obterTodas(){
        Query query = em.createQuery("SELECT o FROM Prova o");
        return query.getResultList();
    }
    
    
}
