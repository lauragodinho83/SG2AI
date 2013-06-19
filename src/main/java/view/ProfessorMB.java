package view;

import controller.ProfessorEJB;
import helper.Mensagem;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Professor;

/**
 *
 * @author jeferson
 */
@ManagedBean
@ViewScoped
public class ProfessorMB {

    public ProfessorMB() {
    }
    @EJB
    ProfessorEJB professorEJB;
    private Professor professor = new Professor();
    private Professor professorSelecionado;


    public List < Professor > getProfessores() 
    {
        return professorEJB.obterTodos();
    }
  
    
    
    public Professor getProfessorSelecionado() 
    {
        return professorSelecionado;
    }

    
    
    public void setProfessorSelecionado( Professor professorSelecionado ) 
    {
        this.professorSelecionado = professorSelecionado;
    }
    
    

    public Professor getProfessor()
    {
        return professor;
    }
    
    

    public void setProfessor( Professor professor ) 
    {
        this.professor = professor;

    }

    
    
    public void salvarProfessor() 
    {
        professor = professorEJB.salvar( professor );
    }

    
    
    public void selecionarProfessor( Professor professor ) 
    {
        setProfessorSelecionado( professor );
    }
    
    

    public void editar( Professor professor )
    {
        setProfessor( professor );
    }

    
    
    public void excluir( Long id )
    {
        professorEJB.excluir( id );
        Mensagem.sucesso();
    }
    
    
    
    public List < Professor > obterTodos()
    {
        return professorEJB.obterTodos();
    }
    
    
}
