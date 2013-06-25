/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.EstudanteEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Estudante;

/**
 *
 * @author Automacao
 */
@ManagedBean
@ViewScoped
public class EstudanteMB implements java.io.Serializable {

    @EJB
    EstudanteEJB estudanteEJB;
    
    private Estudante estudante = new Estudante();
    private List<Estudante> estudantes;
    private Estudante estudanteSelecionado;
    
    public EstudanteMB() {
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public Estudante getEstudanteSelecionado() {
        return estudanteSelecionado;
    }

    public void setEstudanteSelecionado(Estudante estudanteSelecionado) {
        this.estudanteSelecionado = estudanteSelecionado;
    }

    public List<Estudante> getEstudantes() {
        setEstudantes( obterTodos() );
        return estudantes;
    }

    public void setEstudantes(List<Estudante> estudantes) {
        this.estudantes = estudantes;
    }
    
    public void salvar() {
        estudanteEJB.salvar( estudante );
        
        setEstudante( new Estudante() );
        
        Mensagem.sucesso();
    }
    
    public void editar( Estudante estudante ) {
        setEstudante( estudante );
    }
    
    public void excluir( Long id ) {
        estudanteEJB.excluir( id );
        
        Mensagem.sucesso();
    }
    
    public void selecionarEstudante( Estudante estudante ) {
        setEstudanteSelecionado( estudante );
    }
    
    private List<Estudante> obterTodos() {
        return estudanteEJB.obterTodos();
    }
}
