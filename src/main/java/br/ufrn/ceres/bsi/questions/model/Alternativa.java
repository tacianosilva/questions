package br.ufrn.ceres.bsi.questions.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Alternativa extends BaseEntity implements Serializable {

    /**
     * serialVersionUID
     */
    private static final long serialVersionUID = 1635239211842407337L;

    @Column(nullable = false, length = 150)
    private String descricao;

    public Alternativa() {

    }

    public Alternativa(String descricao) {
        this.setDescricao(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}