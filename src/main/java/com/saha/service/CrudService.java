package com.saha.service;

import com.google.common.reflect.TypeToken;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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

    public void selectById() {
        String hql = "select * from musician_m mm where mm.id > 3 and mm.first_name = 'John'";
        Query query = em.createNativeQuery(hql);
        List result = query.getResultList();
    }

    public void selectByIdOracle() {
        String hql = "select * from TUTORIALS t WHERE t.ID = 1";
        Query query = em.createNativeQuery(hql);
        List result = query.getResultList();

    }
}
