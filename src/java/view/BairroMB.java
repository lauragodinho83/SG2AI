/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.BairroEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Bairro;

/**
 *
 * @author Automacao
 */
@ManagedBean
@ViewScoped
public class BairroMB {

    @EJB
    BairroEJB bairroEJB;
    
    private Bairro bairro = new Bairro();
    
    public BairroMB() {
    }

    public Bairro getBairro() {
        return bairro;
    }

    public void setBairro(Bairro bairro) {
        this.bairro = bairro;
    }
    
    public void salvar() {
        bairroEJB.salvar( bairro );
        
        setBairro( new Bairro() );
        
        Mensagem.sucesso();
    }
    
    public void editar( Bairro bairro ) {
        setBairro( bairro );
    }
    
    public void excluir( Long id ) {
        bairroEJB.excluir( id );
        
        Mensagem.sucesso();
    }
    
    public List<Bairro> obterTodos() {
        return bairroEJB.obterTodos();
    }
}
