package br.ufrn.ceres.bsi.questions.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

import br.ufrn.ceres.bsi.questions.model.Questao;

@Stateless
public class QuestaoService extends DataAccessService<Questao> {

    public QuestaoService(EntityManagerFactory emf) {
        super(Questao.class, emf);
    }

    /**
     * Retorna uma nova questão.
     * @param descricao A descrição da questão.
     * @return {@link Questao}
     */
    public Questao novaQuestao(String descricao){
        return new Questao(descricao);
    }

}