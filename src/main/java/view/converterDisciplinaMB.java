/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DisciplinaEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import model.Disciplina;

/**
 *
 * @author jeferson
 */
@Named(value = "converterDisciplinaMB")
@RequestScoped
public class converterDisciplinaMB implements Converter  {

    /**
     * Creates a new instance of converterDisciplinaMB
     */
    @EJB
    DisciplinaEJB disciplinaEJB;

    public converterDisciplinaMB() {
    }

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {

        return disciplinaEJB.findById((Integer) Integer.parseInt(value));
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        return ((Disciplina) value).getId().toString();
    }
}
