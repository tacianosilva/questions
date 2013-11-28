package br.ufrn.ceres.bsi.questions;

import br.ufrn.ceres.bsi.questions.bo.QuestaoBO;
import br.ufrn.ceres.bsi.questions.bo.UsuarioBO;

/**
 * Classe Abstrata para a Fachada do sistema Questions.
 *
 * @author Taciano de Morais Silva - tacianosilva@gmail.com
 * @version 25/10/2012, Taciano de Morais Silva - tacianosilva@gmail.com
 * @since 25/10/2012
 */
class AbstractFacade {

    /**
     * @return
     */
    protected UsuarioBO createUsuarioBO() {
        return new UsuarioBO();
    }

    /**
     * @return
     */
    protected QuestaoBO createQuestaoBO() {
        return new QuestaoBO();
    }
}
