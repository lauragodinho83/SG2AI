/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DistrictEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.District;

/**
 *
 * @author daniel
 */
@Named(value = "districtMB")
@RequestScoped
public class DistrictMB {

    @EJB
    private DistrictEJB districtEJB;
    
    private District district;
    
    /**
     * Creates a new instance of DistrictMB
     */
    public DistrictMB() {
    }

    public District getDistrict() {
        return district;
    }

    public void setDistrict(District district) {
        this.district = district;
    }
    
    public void save( District district ) {
        districtEJB.save( district );
    }
}
