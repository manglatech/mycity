package com.mgt.findmycity.dao.base;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T, ID extends Serializable> {
	 
    T findById(ID id);
    List<T> findAll();
    T doPersistent(T entity);
    void doRemove(T entity);
    
}