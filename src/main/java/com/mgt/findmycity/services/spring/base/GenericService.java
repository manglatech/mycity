package com.mgt.findmycity.services.spring.base;

import java.io.Serializable;

public interface GenericService<T, ID extends Serializable> {

    T getNew();
    T getNewWithDefaults();
    T getByPrimaryKey(ID id);
    T get(T entity);
    void refresh(T entity);
    void save(T entity);
    T merge(T entity);
    void save(Iterable<T> entities);
    void deleteByPrimaryKey(ID id);
    void delete(T entity);
    void delete(Iterable<T> entities);
    
    /*
    T findUnique(T example);
    T findUniqueOrNone(T example);
    List<T> find();
    public List<T> find(String query);
    List<T> find(T example);
    int findCount();
    int findCount(T example);
    T findUnique(T exampleOrNamedQueryParameters, SearchTemplate searchTemplate);
    T findUniqueOrNone(T exampleOrNamedQueryParameters, SearchTemplate searchTemplate);
    List<T> find(SearchTemplate searchTemplate);
    List<T> find(T exampleOrNamedQueryParameters, SearchTemplate searchTemplate);
    int findCount(SearchTemplate searchTemplate);
    int findCount(T example, SearchTemplate searchTemplate);*/
    
}