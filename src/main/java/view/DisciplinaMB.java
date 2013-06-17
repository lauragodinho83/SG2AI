/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DisciplinaEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Disciplina;

/**
 *
 * @author jeferson
 */
@Named(value = "disciplinaMB")
@RequestScoped
public class DisciplinaMB {

    public DisciplinaMB() {
    }
    private Disciplina disciplina = new Disciplina();
    @EJB
    DisciplinaEJB disciplinaEJB;

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void salvar() {
        disciplina = disciplinaEJB.salvar(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaEJB.findAll();
    }
}
