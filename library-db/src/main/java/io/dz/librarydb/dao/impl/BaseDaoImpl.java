package io.dz.librarydb.dao.impl;

import io.dz.librarydb.dao.BaseDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Repository
@Transactional
public abstract class BaseDaoImpl<T extends Serializable> implements BaseDao<T> {

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session session ;
    private Class<T> clazz;

    protected final void setClazz(final Class<T> clazzToSet) {
        clazz= clazzToSet;
    }


    @Override
    public T save(T entity) {
        try {
            getCurrentSession().save(entity);
            return entity;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getLocalizedMessage(), ex);
        }

    }

    @Override
    public T getById(String id) {
        try {
            return session.get(clazz, id);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getLocalizedMessage(), ex);
        }
    }

    @Override
    public T update(T entity) {

       try{
           if(Objects.nonNull(entity)){
               return (T) getCurrentSession().merge(entity);
           }
           else {
               throw new RuntimeException("can't Save Null Object");
           }
       } catch (Exception ex){
           throw new  RuntimeException(ex);
       }
    }

    @Override
    public List<T> getAll() {
        try{

            return getCurrentSession().createQuery("from " + clazz.getName()).list();
        } catch (Exception ex){
            throw new RuntimeException(ex);
        }

    }

    @Override
    public void delete(T entity) {
        try{
            if(Objects.nonNull(entity)){
                getCurrentSession().delete(entity);
            }else {
                throw new RuntimeException("can't delete ");
            }

        } catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    protected final Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }
}
