/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.CidadeEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Cidade;
import model.Estado;

/**
 *
 * @author Automacao
 */
@ManagedBean
@ViewScoped
public class CidadeMB {

    @EJB
    CidadeEJB cidadeEJB;
    
    private Estado estadoSelecionado;
    
    private Cidade cidade = new Cidade();
    
    public CidadeMB() {
    }

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade bairro) {
        this.cidade = bairro;
    }

    public Estado getEstadoSelecionado() {
        return estadoSelecionado;
    }

    public void setEstadoSelecionado(Estado estadoSelecionado) {
        this.estadoSelecionado = estadoSelecionado;
    }
    
    public void salvar() {
        cidadeEJB.salvar( cidade );
        
        setCidade( new Cidade() );
        
        Mensagem.sucesso();
    }
    
    public void editar( Cidade cidade ) {
        setCidade( cidade );
    }
    
    public void excluir( Long id ) {
        cidadeEJB.excluir( id );
        
        Mensagem.sucesso();
    }
    
    public List<Cidade> obterTodos() {
        return cidadeEJB.obterTodos();
    }
}
