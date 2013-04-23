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
import model.Student;

/**
 *
 * @author daniel
 */
@Stateless
public class StudentEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    public void save( Student student ) {
        em.merge( student );
    }
    
    public List<Student> getAll() {
        Query query = em.createQuery( "SELECT s FROM Student s" );
        
        return query.getResultList();
    }
    
}
