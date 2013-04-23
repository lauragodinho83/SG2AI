/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Gender;

/**
 *
 * @author daniel
 */
@Stateless
public class GenderEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    public void save( Gender gender ) {
        em.merge( gender );
    }
    
}
