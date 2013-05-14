/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.QuestaoEJB;
import helper.Mensagem;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Alternativa;
import model.Questao;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class QuestaoMB {
    
    @EJB
    QuestaoEJB questaoEJB;
    private Questao questao;
    private Alternativa alternativa;
    private List<Alternativa> alternativas;
    
    public QuestaoMB() {
        alternativas = new ArrayList<Alternativa>();
        alternativa = new Alternativa();
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Alternativa getAlternativa() {
        return alternativa;
    }

    public void setAlternativa(Alternativa alternativa) {
        this.alternativa = alternativa;
    }

    public List<Alternativa> getAlternativas() {
        return alternativas;
    }

    public void setAlternativas(List<Alternativa> alternativas) {
        this.alternativas = alternativas;
    }
    
    public void adicionarAlternativa() {
        alternativas.add( alternativa );
        alternativa = new Alternativa();
        
        Mensagem.sucesso();
    }
    
}
