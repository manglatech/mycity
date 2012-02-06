package com.mgt.findmycity.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericHibernateDAO<T, ID extends Serializable>
		implements GenericDAO<T, ID> {

	private Class<T> persistentClass;
	
	private EntityManager em;
	
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	protected EntityManager getManager() {
		if (em == null)
			throw new IllegalStateException(
					"Entity Manager has not been set on DAO before usage");
		return em;
	}
	
	public GenericHibernateDAO() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@SuppressWarnings("unchecked")
	public T findById(ID id) {
		T entity;
		entity = (T) getManager().find(getPersistentClass(), id);
		getManager().clear();
		return entity;
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		//return findByCriteria();
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public T doPersistent(T entity) {
		getManager().merge(entity);
		return entity;
	}

	public void doRemove(T entity) {
		getManager().remove(entity);
	}

	public void flush() {
		getManager().flush();
	}

	public void clear() {
		getManager().clear();
	}

}