package io.dz.librarydb.dao;

import java.io.Serializable;
import java.util.List;

public interface BaseDao<T  extends Serializable> {
    T save(T t);
    T getById(String id);
    T update(T t);
    List<T> getAll();
    void delete(T t);
}
