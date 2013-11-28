package br.ufrn.ceres.bsi.questions.bo;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import br.ufrn.ceres.bsi.questions.dao.UserService;
import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Usuario;

public class UsuarioBO extends AbstractBO {

    /**
     * Logger.
     */
    private static final Logger logger = Logger.getLogger(UsuarioBO.class.getName());

    private UserService dao;

    public UsuarioBO() {
        dao = new UserService(JPAUtil.EMF);
    }

    public Usuario inserir(Usuario usuario) {
        // TODO Auto-generated method stub
        return null;
    }

    public List<Usuario> listar() throws NegocioException {
        try {
            return dao.findEntities();
        }
        catch (Exception ex) {
            logger.log(Level.SEVERE, ex.getMessage(), ex);
            throw new NegocioException("erro.usuario.bo.listar", ex);
        }
    }

    public void alterar(Usuario usuario) {
        // TODO Auto-generated method stub

    }

    public void excluir(Integer codigo) {
        // TODO Auto-generated method stub

    }

    public Usuario buscar(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    public Usuario buscarPorNome(String nome) {
        // TODO Auto-generated method stub
        return null;
    }

}
