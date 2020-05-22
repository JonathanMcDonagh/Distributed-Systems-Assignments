/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities.service;

import entities.Users;
import entities.Cars;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author Jonathan McDonagh / 20074520
 * Assignment 4
 * Distributed Systems
 * 
 */
public abstract class AbstractFacade<T> {

    private Class<T> entityClass;

    public AbstractFacade(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    protected abstract EntityManager getEntityManager();

    public void create(T entity) {
        getEntityManager().persist(entity);
    }

    public void edit(T entity) {
        getEntityManager().merge(entity);
    }

    public void remove(T entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }
    
    /* Get by userID and Password */
    public Users findUserByIDandPassword(int i, String p) {
        return (Users) getEntityManager()
                .createNamedQuery("Users.findUserByIDandPassword")
                .setParameter("userID", i)
                .setParameter("password", p)
                .getSingleResult();
    }

    /* Find By ID */
    public T find(Object id) {
        return getEntityManager().find(entityClass, id);
    }
    
    /* Find By Username */
    public T findUsername(String u) {
        return (T) getEntityManager().createNamedQuery("Users.findByUsername").setParameter("username", u).getSingleResult();
    }
    
    /* Find By Password */
    public T findPassword(String u) {
        return (T) getEntityManager().createNamedQuery("Users.findByPassword").setParameter("password", u).getSingleResult();
    }
    
    /* Get by carID and Year */
    public Cars findByCarIdAndYear(int i, int y) {
        return (Cars) getEntityManager()
                .createNamedQuery("Cars.findByCarIdAndYear")
                .setParameter("carID", i)
                .setParameter("cYear", y)
                .getSingleResult();
    }
    
    /* Get by Make and Model */
    public Cars findByMakeAndModel(String make, String model) {
        return (Cars) getEntityManager()
                .createNamedQuery("Cars.findByMakeAndModel")
                .setParameter("cMake", make)
                .setParameter("cModel", model)
                .getSingleResult();
    }

    
    /* Find By Make */
    public T findMake(String c) {
        return (T) getEntityManager().createNamedQuery("Cars.findByCMake").setParameter("cMake", c).getSingleResult();
    }
    
    /* Find By Model */    
    public T findModel(String c) {
        return (T) getEntityManager().createNamedQuery("Cars.findByCModel").setParameter("cModel", c).getSingleResult();
    }
    
    /* Find By Year */       
    public T findYear(int c) {
        return (T) getEntityManager().createNamedQuery("Cars.findByCYear").setParameter("cYear", c).getSingleResult();
    }

    /* Find All */       
    public List<T> findAll() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        return getEntityManager().createQuery(cq).getResultList();
    }
    
    /* Find By from/to */   
    public List<T> findRange(int[] range) {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        cq.select(cq.from(entityClass));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        q.setMaxResults(range[1] - range[0] + 1);
        q.setFirstResult(range[0]);
        return q.getResultList();
    }

    /* Find count */   
    public int count() {
        javax.persistence.criteria.CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
        javax.persistence.criteria.Root<T> rt = cq.from(entityClass);
        cq.select(getEntityManager().getCriteriaBuilder().count(rt));
        javax.persistence.Query q = getEntityManager().createQuery(cq);
        return ((Long) q.getSingleResult()).intValue();
    }
    
}
