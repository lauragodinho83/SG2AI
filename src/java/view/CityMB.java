/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CityEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.City;

/**
 *
 * @author daniel
 */
@Named(value = "cityMB")
@RequestScoped
public class CityMB {

    @EJB
    private CityEJB cityEJB;
    
    private City city = new City();
    
    /**
     * Creates a new instance of CityMB
     */
    public CityMB() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }
    
    public void save( City city ) {
        cityEJB.save( city );
    }
}
