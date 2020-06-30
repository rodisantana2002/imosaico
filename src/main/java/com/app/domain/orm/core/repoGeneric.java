/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.domain.orm.core;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Rodolfo Santana <RWS Informática>
 */
public abstract class repoGeneric< T extends Serializable> {

    private Class< T> clazz;

    @PersistenceContext
    EntityManager entityManager;

    public final void setClazz(Class< T> clazzToSet) {
        this.clazz = clazzToSet;
    }

    public T findById(long id) {
        return entityManager.find(clazz, id);
    }

    public List< T> findAll() {
        return entityManager.createQuery("from " + clazz.getName()).getResultList();
    }

    public void create(T entity) {
        entityManager.persist(entity);
    }

    public T update(T entity) {
        return entityManager.merge(entity);
    }

    public void delete(T entity) {
        entityManager.remove(entity);
    }

    public void deleteById(long entityId) {
        T entity = findById(entityId);
        delete(entity);
    }
}
