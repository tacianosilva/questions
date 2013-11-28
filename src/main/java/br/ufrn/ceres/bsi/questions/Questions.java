package br.ufrn.ceres.bsi.questions;

import java.io.Serializable;
import java.util.List;

import br.ufrn.ceres.bsi.questions.bo.NegocioException;
import br.ufrn.ceres.bsi.questions.bo.QuestaoBO;
import br.ufrn.ceres.bsi.questions.bo.UsuarioBO;
import br.ufrn.ceres.bsi.questions.model.Questao;
import br.ufrn.ceres.bsi.questions.model.Usuario;

/**
 * Fachada do sistema Questions.
 *
 * @author Taciano de Morais Silva - tacianosilva@gmail.com
 * @version 25/10/2012, Taciano de Morais Silva - tacianosilva@gmail.com
 * @since 25/10/2012
 */
public final class Questions extends AbstractFacade implements Serializable {

    /**
     * serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Instância única da fachada.
     */
    private static volatile Questions instance = null;

    /**
     * Construtor privado da fachada.
     */
    private Questions() {
    }

    /**
     * Retorna a instância única do singleton Questions (fachada).
     *
     * @return A instância do Sepe.
     */
    public static Questions getInstance() {
        if (instance == null) {
            synchronized (Questions.class) {
                Questions inst = instance;
                if (inst == null) {
                    instance = new Questions();
                }
            }
        }
        return instance;
    }

    public Usuario inserirUsuario(Usuario usuario) throws NegocioException {
        UsuarioBO bo = createUsuarioBO();
        return bo.inserir(usuario);
    }

    public List<Usuario> listarUsuarios() throws NegocioException {
        UsuarioBO bo = createUsuarioBO();
        return bo.listar();
    }

    public void alterarUsuario(Usuario usuario) throws NegocioException {
        UsuarioBO bo = createUsuarioBO();
        bo.alterar(usuario);
    }

    public void excluirUsuario(Integer codigo) throws NegocioException{
        UsuarioBO bo = createUsuarioBO();
        bo.excluir(codigo);
    }

    public Usuario buscarUsuario(Integer id) throws NegocioException {
        UsuarioBO bo = createUsuarioBO();
        return bo.buscar(id);
    }

    public Usuario buscarUsuarioPorNome(String nome) throws NegocioException {
        UsuarioBO bo = createUsuarioBO();
        return bo.buscarPorNome(nome);
    }

    public Questao inserirQuestao(Questao questao) throws NegocioException {
        QuestaoBO bo = createQuestaoBO();
        return bo.inserir(questao);
    }

    public List<Questao> listarQuestoes() throws NegocioException {
        QuestaoBO bo = createQuestaoBO();
        return bo.listar();
    }
}
