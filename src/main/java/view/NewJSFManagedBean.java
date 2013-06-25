/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author daniel
 */
@Named(value = "newJSFManagedBean")
@SessionScoped
public class NewJSFManagedBean implements Serializable  {

    /**
     * Creates a new instance of NewJSFManagedBean
     */
    public NewJSFManagedBean() {
    }
}
