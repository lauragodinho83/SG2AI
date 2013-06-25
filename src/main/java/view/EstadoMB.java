/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EstadoEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Estado;

/**
 *
 * @author Automacao
 */
@ManagedBean
@ViewScoped
public class EstadoMB implements java.io.Serializable{

    @EJB
    EstadoEJB estadoEJB;
    
    private Estado estado = new Estado();
    
    public EstadoMB() {
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado bairro) {
        this.estado = bairro;
    }
    
    public void salvar() {
        estadoEJB.salvar( estado );
        
        setEstado( new Estado() );
        
        Mensagem.sucesso();
    }
    
    public void editar( Estado estado ) {
        setEstado( estado );
    }
    
    public void excluir( Long id ) {
        estadoEJB.excluir( id );
        
        Mensagem.sucesso();
    }
    
    public List<Estado> obterTodos() {
        return estadoEJB.obterTodos();
    }
}
