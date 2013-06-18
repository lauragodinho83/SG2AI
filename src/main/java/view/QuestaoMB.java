/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AssuntoEJB;
import controller.QuestaoEJB;
import helper.AreaDeTransferencia;
import helper.Mensagem;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import model.Assunto;
import model.Questao;

/**
 *
 * @author daniel
 */
@ManagedBean
@SessionScoped
public class QuestaoMB {
    
    @EJB
    QuestaoEJB questaoEJB;
    private Questao questao;

    private Assunto assuntosSelecionados;
    
    public QuestaoMB() {
        questao = new Questao();       
    }

    public Questao getQuestao() {
        return questao;
    }

    public void setQuestao(Questao questao) {
        this.questao = questao;
    }

    public Assunto getAssuntosSelecionados() {
        return assuntosSelecionados;
    }

    public void setAssuntosSelecionados(Assunto assuntosSelecionados) {
        this.assuntosSelecionados = assuntosSelecionados;
    }
    
    public void salvarQuestao (){
        questaoEJB.salvar(questao);
        setQuestao(new Questao());
        Mensagem.sucesso();
    }
    
    public void salvarQuestoesDaAreaDeTransferencia() {
        //AreaDeTransferencia adt = new AreaDeTransferencia();
        
        //String conteudo = adt.getClipboardContents();
        
        Mensagem.erro( "Ainda não está funcionando." );
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
