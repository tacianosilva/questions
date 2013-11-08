package br.ufrn.ceres.bsi.questions.dao.util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Classe que define a <code>EntityManagerFactory</code> para a Unidade de
 * Persistência do JPA.
 * @author Taciano Morais Silva
 * @version 12/06/2012, 20h58m
 * @since 12/06/2012, 20h58m
 */
public class JPAUtil {

    public static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("questionsPU");

}
