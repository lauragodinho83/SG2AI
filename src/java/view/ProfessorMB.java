/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.ProfessorEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Professor;

/**
 *
 * @author jeferson
 */
@ManagedBean
@ViewScoped
public class ProfessorMB {

    public ProfessorMB() {
    }
    @EJB
    ProfessorEJB professorEJB;
    private Professor professor = new Professor();
    private Professor professorSelecionado;
    private List<Professor> professores;

    public List<Professor> getProfessores() {
        return professorEJB.obterTodos();
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

    public void editar(Professor professor) {
        setProfessor(professor);
    }

    public void excluir(Long id) {
        System.out.println("excluindo professor " + professor.getNome() + " com id " + id);
        professorEJB.excluir(id);


        Mensagem.sucesso();
    }
}
