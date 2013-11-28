package br.ufrn.ceres.bsi.questions.dao;

import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import br.ufrn.ceres.bsi.questions.model.Usuario;

/**
 * Implementation of the generic Data Access Service All CRUD (create, read,
 * update, delete) basic data access operations for any persistent object are
 * performed in this class.
 *
 * @author Emre Simtay <emre@simtay.com>
 **/
public abstract class DataAccessService<T> {

    @PersistenceContext
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public DataAccessService() {
    }

    private Class<T> type;

    /**
     * Default constructor
     *
     * @param type
     *            entity class
     */
    public DataAccessService(Class<T> type, EntityManagerFactory emf) {
        this.type = type;
        this.emf = emf;
    }

    /**
     * Stores an instance of the entity class in the database
     *
     * @param T
     *            Object
     * @return
     */
    public T create(T t) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(t);
            em.flush();
            em.getTransaction().commit();
            return t;
        }
        catch (Exception ex) {
            throw ex;
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Retrieves an entity instance that was previously persisted to the
     * database
     *
     * @param T
     *            Object
     * @param id
     * @return
     */
    public T find(Object id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(this.type, id);
        }
        finally {
            em.close();
        }
    }

    public List<T> findEntities() {
        return findEntities(true, -1, -1);
    }

    public List<T> findEntities(int maxResults, int firstResult) {
        return findEntities(false, maxResults, firstResult);
    }

    private List<T> findEntities(boolean all, int maxResults,
            int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(this.type));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * Removes the record that is associated with the entity instance
     *
     * @param type
     * @param id
     */
    public void delete(Object id) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Object ref;
            ref = em.getReference(this.type, id);
            em.remove(ref);
            em.getTransaction().commit();
        }
        finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * Updates the entity instance
     *
     * @param <T>
     * @param t
     * @return the object that is updated
     */
    public T update(T item) {
        if (item instanceof Usuario) {
            Usuario usuario = (Usuario) item;
            if (usuario.getId() == 1) {
                return item;
            }
        }
        return (T) this.getEntityManager().merge(item);

    }

    /**
     * Returns the number of records that meet the criteria
     *
     * @param namedQueryName
     * @return List
     */
    @SuppressWarnings("unchecked")
    public List<T> findWithNamedQuery(String namedQueryName) {
        return getEntityManager().createNamedQuery(namedQueryName).getResultList();
    }

    /**
     * Returns the number of records that meet the criteria
     *
     * @param namedQueryName
     * @param parameters
     * @return List
     */
    @SuppressWarnings("rawtypes")
    public List findWithNamedQuery(String namedQueryName, Map parameters) {
        return findWithNamedQuery(namedQueryName, parameters, 0);
    }

    /**
     * Returns the number of records with result limit
     *
     * @param queryName
     * @param resultLimit
     * @return List
     */
    @SuppressWarnings("rawtypes")
    public List findWithNamedQuery(String queryName, int resultLimit) {
        return getEntityManager().createNamedQuery(queryName).setMaxResults(resultLimit)
                .getResultList();
    }

    /**
     * Returns the number of records that meet the criteria
     *
     * @param <T>
     * @param sql
     * @param type
     * @return List
     */
    @SuppressWarnings("unchecked")
    public List<T> findByQuery(String sql) {
        return getEntityManager().createQuery(sql).getResultList();
    }

    /**
     * Returns the number of total records
     *
     * @param namedQueryName
     * @return int
     */
    public int countTotalRecord(String namedQueryName) {
        Query query = getEntityManager().createNamedQuery(namedQueryName);
        Number result = (Number) query.getSingleResult();
        return result.intValue();
    }

    /**
     * Returns the number of records that meet the criteria with parameter map
     * and result limit
     *
     * @param namedQueryName
     * @param parameters
     * @param resultLimit
     * @return List
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public List findWithNamedQuery(String namedQueryName, Map parameters,
            int resultLimit) {
        Set<Map.Entry<String, Object>> rawParameters = parameters.entrySet();
        Query query = getEntityManager().createNamedQuery(namedQueryName);
        if (resultLimit > 0) {
            query.setMaxResults(resultLimit);
        }
        for (Map.Entry<String, Object> entry : rawParameters) {
            query.setParameter(entry.getKey(), entry.getValue());
        }
        return query.getResultList();
    }

    /**
     * Returns the number of records that will be used with lazy loading /
     * pagination
     *
     * @param namedQueryName
     * @param start
     * @param end
     * @return List
     */
    @SuppressWarnings("rawtypes")
    public List findWithNamedQuery(String namedQueryName, int start, int end) {
        Query query = getEntityManager().createNamedQuery(namedQueryName);
        query.setMaxResults(end - start);
        query.setFirstResult(start);
        return query.getResultList();
    }
}