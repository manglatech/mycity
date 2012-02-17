package com.mgt.findmycity.services.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericHibernateDao<T, ID extends Serializable> {

	void setEntityManager(EntityManager entityManager);

	Class<T> getPersistentClass();

	T findById(ID id);

	T doFind(T entity);

	List<T> findAll();

	T doPersistent(T entity);

	T doMerge(T entity);

	void doRemove(T entity);

	void doRemove(Iterable<T> entities);

	T doPersistent(Iterable<T> entity);

}