package view;

import controller.CursoEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Curso;

/**
 *
 * @author jeferson
 */
@ManagedBean
@ViewScoped
public class CursoMB implements java.io.Serializable {

    public CursoMB() {
    }
    
    @EJB
    CursoEJB cursoEJB;
    private Curso curso = new Curso();
 
    
    public Curso getCurso() 
    {
        return curso;
    }


    
    
    public void setCurso( Curso curso ) 
    {
        this.curso = curso;
    }

      
    
    public void editar( Curso curso ) 
    {
        setCurso( curso );
    }

       
    
    public void salvar() 
    {
        cursoEJB.salvar( curso );
        setCurso( new Curso() );
        Mensagem.sucesso();
    }

    
    
    public void excluir( Long id ) 
    {
        cursoEJB.excluir( id );
        Mensagem.sucesso();
    }

    
    
    public List < Curso > findAll()
    {
        return cursoEJB.findAll();
    }
    
    
}
