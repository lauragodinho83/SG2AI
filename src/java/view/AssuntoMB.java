/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AssuntoEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Assunto;

/**
 *
 * @author VictorHUgo
 */
@ManagedBean
@ViewScoped
public class AssuntoMB {

    @EJB
    AssuntoEJB assuntoEJB;
    private Assunto assunto;
    
    public AssuntoMB() {
        assunto = new Assunto();
    }

    public Assunto getAssunto() {
        return assunto;
    }

    public void setAssunto(Assunto assunto) {
        this.assunto = assunto;
    }
    
    public void salvaAssunto(){
        assuntoEJB.salvar(assunto);
        setAssunto(new Assunto());
        Mensagem.sucesso();
    }
    
    public void editarAssunto( Assunto assunto){
        setAssunto(assunto);
    }
    
    public void excluirAssunto( Long id){
        assuntoEJB.excluir(id);
    }
    
    public List<Assunto> obterTodos(){
        return assuntoEJB.obterTodos();
    }
    
}
