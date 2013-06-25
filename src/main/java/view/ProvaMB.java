/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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

/**
 *
 * @author VictorHUgo
 */
@Named(value = "provaMB")
@Dependent
@ManagedBean
@SessionScoped
public class ProvaMB {

    @EJB
    ProvaEJB provaEJB;
    @EJB
    QuestaoEJB questaoEJB;
    private Prova prova;
    private Questao questaoSelecionada;
    private List<Questao> questoesSelecionadas;
    private Professor professorSelecionado;
    private Disciplina disciplinaSelecionada;
            
    public ProvaMB() {
        prova = new Prova();
        questaoSelecionada = new Questao();
        questoesSelecionadas = new ArrayList<Questao>();
        prova.setProfessor(new Professor());
        prova.setDisciplina(new Disciplina());
        prova.setQuestao(questoesSelecionadas);
        
    }

    public Prova getProva() {
        return prova;
    }

    public void setProva(Prova prova) {
        this.prova = prova;
    }

    public Questao getQuestaoSelecionada() {
        return questaoSelecionada;
    }

    public void setQuestaoSelecionada(Questao questaoSelecionada) {
        this.questaoSelecionada = questaoSelecionada;
    }

    public List<Questao> getQuestoesSelecionadas() {
        return questoesSelecionadas;
    }

    public void setQuestoesSelecionadas(List<Questao> questoesSelecionadas) {
        this.questoesSelecionadas = questoesSelecionadas;
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
    
    public void addQuestao(){
        Questao questao = (Questao) questaoEJB.obterPorId(questaoSelecionada.getId());
        questaoSelecionada = questao;
        questoesSelecionadas.add(questaoSelecionada);
    }
    
    public List<Questao> obterQuestoes(){
        return questaoEJB.obterTodos();
    }
}
