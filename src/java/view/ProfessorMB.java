/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProfessorEJB;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.faces.bean.RequestScoped;
import model.Professor;

/**
 *
 * @author jeferson
 */
@Named(value = "professorMB")
@RequestScoped
public class ProfessorMB {

    public ProfessorMB() {
    }
    @EJB
    ProfessorEJB professorEJB;
    private Professor professor = new Professor();

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    
    public void salvarProfessor() {
        professor = professorEJB.salvar(professor);
    }
}
