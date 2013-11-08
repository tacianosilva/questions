package br.ufrn.ceres.bsi.questions.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManagerFactory;

import br.ufrn.ceres.bsi.questions.dao.util.JPAUtil;
import br.ufrn.ceres.bsi.questions.model.Usuario;

@Stateless
public class UserService extends DataAccessService<Usuario>{

    public UserService(EntityManagerFactory emf) {
        super(Usuario.class, emf);
    }

    /**
     * Returns new user
     * @return Usuario
     */
    public Usuario newUser(){
        return new Usuario();
    }

}