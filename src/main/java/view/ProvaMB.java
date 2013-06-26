package view;

import controller.ProvaEJB;
import controller.QuestaoEJB;
import helper.Mensagem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Disciplina;
import model.Professor;
import model.Prova;
import model.Questao;

@Named(value = "provaMB")
@Dependent
@ManagedBean
@SessionScoped
public class ProvaMB implements java.io.Serializable{

    @EJB
    ProvaEJB provaEJB;
    @EJB
    QuestaoEJB questaoEJB;
    private Prova prova;
    private Professor professorSelecionado;
    private Disciplina disciplinaSelecionada;
            
    public ProvaMB() {
        prova = new Prova();
        prova.setProfessor(new Professor());
        prova.setDisciplina(new Disciplina());
        
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }
    
    public Professor getProfessorSelecionado() {
        return professorSelecionado;
    }

    public void setProfessorSelecionado(Professor professorSelecionado) {
        this.professorSelecionado = professorSelecionado;
    }

    public Disciplina getDisciplinaSelecionada() {
        return disciplinaSelecionada;
    }

    public void setDisciplinaSelecionada(Disciplina disciplinaSelecionada) {
        this.disciplinaSelecionada = disciplinaSelecionada;
    }
    
    public void salvarProva(){
        provaEJB.salvar(prova);
        setProva(new Prova());
        Mensagem.sucesso();
    }
    
    public List<Prova> obterProvas(){
        return provaEJB.obterTodas();
    }
    
    public void editarProva(Prova Prova){
        setProva(prova);
    }
    
    public void excluirProva(Long id){
        provaEJB.excluir(id);
        Mensagem.sucesso();
    }
    
    public List<Questao> obterQuestoes(){
        return questaoEJB.obterTodos();
    }
}
