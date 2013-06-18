/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.DisciplinaEJB;
import helper.Mensagem;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Disciplina;

/**
 *
 * @author jeferson
 */
@ManagedBean
@ViewScoped
public class DisciplinaMB {

    public DisciplinaMB() {
    }
    private Disciplina disciplina;
    @EJB
    DisciplinaEJB disciplinaEJB;
    
    @PostConstruct
    public void inicializar() {
        disciplina = new Disciplina();
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void salvar() {
        disciplinaEJB.salvar(disciplina);
        setDisciplina(new Disciplina());
    }

    public List<Disciplina> findAll() {
        return disciplinaEJB.findAll();
    }

    public void editar(Disciplina disciplina) {
        setDisciplina(disciplina);
    }

    public void excluir(Long id) {
        disciplinaEJB.excluir(id);
        Mensagem.sucesso();
    }
}
