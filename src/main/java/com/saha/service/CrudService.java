package com.saha.service;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import javax.persistence.EntityManager;

public class CrudService<T> {

    Class<?> entityClass;
    private EntityManager em;

    public CrudService(Class<?> clazz, EntityManager entityManager) {
        this.em = entityManager;
        this.entityClass = clazz;
    }

    public void create(T object) {
        em.persist(object);
    }

    public void removeById(Long id) {
        T object = (T) em.find(entityClass, id);
        if (object != null) {
            em.remove(object);
        }
    }

    public T findById( Long id) {
        return (T) em.find(entityClass, id);
    }
}
