/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.LQuestaoEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.LQuestao;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class LQuestaoMB {
    
    @EJB
    LQuestaoEJB lQuestaoEJB;
    private LQuestao questao;

    
    public LQuestaoMB() {
        questao = new LQuestao();
    }

    public LQuestao getQuestao() {
        return questao;
    }

    public void setQuestao(LQuestao questao) {
        this.questao = questao;
    }
    
    public void salvarQuestao(){
        lQuestaoEJB.salvar( questao );
        setQuestao(new LQuestao());
        Mensagem.sucesso();
    }
    public List<LQuestao> obterTodas(){
        return lQuestaoEJB.obterTodos();
    }
    
    public void editar(LQuestao questao){
        setQuestao(questao);
    }
    
    public void excluir(Long id){
        lQuestaoEJB.excluir(id);
        Mensagem.sucesso();
    }
}
