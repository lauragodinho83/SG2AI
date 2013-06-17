/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author VictorHUgo
 */
@Entity
public class Prova implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    @JoinTable(
            name = "prova_questao",
            joinColumns = 
            @JoinColumn(name = "Prova_ID", referencedColumnName = "id"),
            inverseJoinColumns = 
            @JoinColumn(name = "Questao_ID",  referencedColumnName = "id"))
    private List<Questao> questao = new ArrayList<Questao>();
    @OneToOne
    private Professor professor;
    @OneToOne
    private Disciplina disciplina;
    private Integer valor;
    private float valorPorQuestao;
    private String descricao;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Questao> getQuestao() {
        return questao;
    }

    public void setQuestao(List<Questao> questao) {
        this.questao = questao;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public float getValorPorQuestao() {
        return valorPorQuestao;
    }

    public void setValorPorQuestao(float valorPorQuestao) {
        this.valorPorQuestao = valorPorQuestao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prova)) {
            return false;
        }
        Prova other = (Prova) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.Prova[ id=" + id + " ]";
    }
    
}
