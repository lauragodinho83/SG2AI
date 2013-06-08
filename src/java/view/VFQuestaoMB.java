/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.VFQuestaoEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Assunto;
import model.VFQuestao;

/**
 *
 * @author daniel
 */
@ManagedBean
@ViewScoped
public class VFQuestaoMB {
    
    @EJB
    VFQuestaoEJB vfQuestaoEJB;
    private VFQuestao vfQuestao;

    private Assunto assuntosSelecionados;
    
    public VFQuestaoMB() {
        vfQuestao = new VFQuestao();       
    }

    public VFQuestao getVfQuestao() {
        return vfQuestao;
    }

    public void setVfQuestao(VFQuestao vfQuestao) {
        this.vfQuestao = vfQuestao;
    }

    public Assunto getAssuntosSelecionados() {
        return assuntosSelecionados;
    }

    public void setAssuntosSelecionados(Assunto assuntosSelecionados) {
        this.assuntosSelecionados = assuntosSelecionados;
    }
    
    public void salvarQuestao (){
        vfQuestaoEJB.salvar( vfQuestao );
        setVfQuestao(new VFQuestao());
        Mensagem.sucesso();
    }
    public List<VFQuestao> obterTodas(){
        return vfQuestaoEJB.obterTodos();
    }
    
    public void editar(VFQuestao vfQuestao){
        setVfQuestao(vfQuestao);
    }
    
    public void excluir(Long id){
        vfQuestaoEJB.excluir(id);
        Mensagem.sucesso();
    }
    
    public String renomeaBoolean( VFQuestao vfQuestao){
        if(vfQuestao.isVeracidade() == true){
            return "Verdadeira";
        }
        return "Falsa";
    }
}
