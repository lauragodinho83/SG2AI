/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.QuestaoEJB;
import helper.Mensagem;
import java.util.List;
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
public class QuestaoMB {
    
    @EJB
    QuestaoEJB questaoEJB;
    private Questao questao;
    
    public QuestaoMB() {
        questao = new Questao();       
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }
    
    public void salvarQuestao () {
        
        System.out.println("Salvando questão MB");
        
        questaoEJB.salvar(questao);
        setQuestao(new Questao());
        Mensagem.sucesso();
    }
    
    public List<Questao> obterTodas(){
        return questaoEJB.obterTodos();
    }
    
    public void editar(Questao questao){
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
