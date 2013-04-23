/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.City;

/**
 *
 * @author daniel
 */
@Stateless
public class CityEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    public void save( City city ) {
        em.merge( city );
    }
    
}
