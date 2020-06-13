package io.dz.librarydb.service.impl;

import java.util.List;

public abstract class BaseService<E> {
    List<E> getAll(){
        return null;
    }

    E save(E e){
        return null;
    }

    E getById(String id){
        return null;
    }
}
