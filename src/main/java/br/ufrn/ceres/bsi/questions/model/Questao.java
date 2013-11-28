package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

@Entity
public class Questao extends BaseEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = -8269452968030418236L;

    @Column(nullable = false, length = 250)
    private String descricao;

    @OneToMany(targetEntity = Alternativa.class, cascade=CascadeType.ALL, fetch=FetchType.EAGER)
    private List<Alternativa> alternativas;

    public Questao() {

    }

    public Questao(String descricao) {
        this.setDescricao(descricao);
    }

    public void addAlternativa(Alternativa a1) {
        // TODO Auto-generated method stub

    }

    public void addAlternativaCorreta(Alternativa a3) {
        // TODO Auto-generated method stub

    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
