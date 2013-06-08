
package view;

import controller.DisciplinaEJB;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import model.Disciplina;
import model.Professor;

/**
 *
 * @author jeferson
 */
@Named(value = "disciplinaMB")
@RequestScoped
public class DisciplinaMB {

    public DisciplinaMB() {
    }
    @EJB
    private Disciplina disciplina = new Disciplina();
    DisciplinaEJB disciplinaEJB;
    private Disciplina disciplinaSelecionada;
    private List<Disciplina> disciplinas;
    
    public List<Disciplina> getDisciplinas() {
        return disciplinaEJB.obterTodas();
    }
    
    public void setDisciplinas(List<Disciplina> disciplinas){
        this.disciplinas = disciplinas;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void salvarDisciplina() {
        disciplina = disciplinaEJB.salvar(disciplina);
    }

    public List<Disciplina> findAll() {
        return disciplinaEJB.findAll();
    }
    
    public void editar(Disciplina disciplina) {
        setDisciplina(disciplina);
    }
}
