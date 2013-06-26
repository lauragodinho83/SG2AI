/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.QuestaoEJB;
import helper.Mensagem;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Questao;

/**
 *
 * @author daniel
 */
@ManagedBean( name = "questaoMB" )
@ViewScoped
public class QuestaoMB implements java.io.Serializable{
    
    @EJB
    QuestaoEJB questaoEJB;
    private Questao questao;
    private List<Questao> listaQuestao;

    public List<Questao> getListaQuestao() {
        return listaQuestao;
    }

    public void setListaQuestao(List<Questao> listaQuestao) {
        this.listaQuestao = listaQuestao;
    }
    
       
    public QuestaoMB() {
        questao = new Questao();       
    }
    
    @PostConstruct
    public void inicializar(){
        listaQuestao = new ArrayList<>(obterTodas());
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
    
    public void salvarQuestao () {   
        System.out.println("Salvar questao , enunciado " + questao.getEnunciado());
        questaoEJB.salvar(questao);
        setQuestao(new Questao());
        Mensagem.sucesso();
    }
    
    public List<Questao> obterTodas(){
        return questaoEJB.obterTodos();
    }
    
    
    public void obterQuestaoPorDisciplina(Long id)
    {
        listaQuestao = questaoEJB.obterQuestaoPorDisciplina(id);
    }
    
    public void editar(Questao questao){
        System.out.println("metodo editar , enunciado = " + questao.getEnunciado());
        setQuestao(questao);
    }
    
    public void excluir(Long id){
        questaoEJB.excluir(id);
        Mensagem.sucesso();
    }
    
    public String renomeaBoolean( Questao questao){
        if(questao.isVeracidade() == true){
            return "Verdadeira";
        }
        return "Falsa";
    }
}
