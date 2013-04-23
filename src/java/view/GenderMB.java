/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.GenderEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Gender;

/**
 *
 * @author daniel
 */
@Named(value = "genderMB")
@RequestScoped
public class GenderMB {
    
    @EJB
    GenderEJB genderEJB;
    
    private Gender gender = new Gender();
    
    /**
     * Creates a new instance of GenderMB
     */
    public GenderMB() {
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }
    
    public void save( Gender gender ) {
        genderEJB.save( gender );
    }
}
