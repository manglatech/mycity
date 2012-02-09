package com.mgt.findmycity.services.dao.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;

public interface GenericHibernateDao<T, ID extends Serializable> {

	public abstract void setEntityManager(EntityManager entityManager);

	public abstract Class<T> getPersistentClass();

	public abstract T findById(ID id);

	public abstract List<T> findAll();

	public abstract T doPersistent(T entity);

	public abstract void doRemove(T entity);


}