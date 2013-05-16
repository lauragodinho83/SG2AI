/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProfessorEJB;
import java.util.List;
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
    private Professor professorSelecionado;
    private List<Professor> professores;

    public List<Professor> getProfessores() {
        return professores;
    }

    public void setProfessores(List<Professor> professores) {
        this.professores = professores;

    }

    public ProfessorEJB getProfessorEJB() {
        return professorEJB;
    }

    public void setProfessorEJB(ProfessorEJB professorEJB) {
        this.professorEJB = professorEJB;
    }

    public Professor getProfessorSelecionado() {
        return professorSelecionado;
    }

    public void setProfessorSelecionado(Professor professorSelecionado) {
        this.professorSelecionado = professorSelecionado;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;

    }

    public void salvarProfessor() {
        professor = professorEJB.salvar(professor);
        System.out.println("salvando professor " + professor.getNome() + "com ID " + professor.getId());
    }

    public void selecionarProfessor(Professor professor) {
        setProfessorSelecionado(professor);
    }
}
