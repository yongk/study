package com.ruirui.hibernate5.begin;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

public abstract class AbstractDAO<PK extends Serializable, T> {

    private final Class<T> persistentClass;

    private SessionFactory sessionFactory;

    @SuppressWarnings("unchecked")
    public AbstractDAO(){
        this.persistentClass =(Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[1];
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.getCurrentSession();
    }



    @SuppressWarnings("unchecked")
    public T getByKey(PK key) {
        return (T) getSession().get(persistentClass, key);
    }

    public void persist(T entity) {
        getSession().persist(entity);
    }

    public void delete(T entity) {
        getSession().delete(entity);
    }

    @SuppressWarnings("deprecation")
    protected Criteria createEntityCriteria(){
        return getSession().createCriteria(persistentClass);
    }

}
