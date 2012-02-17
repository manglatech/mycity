package com.mgt.findmycity.services.dao.base;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericHibernateDAOImpl<T, ID extends Serializable>
		implements GenericHibernateDao<T, ID> {

	private Class<T> persistentClass;
	
	private EntityManager em;
	
	@Override
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
	@SuppressWarnings("unchecked")
	public GenericHibernateDAOImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	@Override
	public Class<T> getPersistentClass() {
		return persistentClass;
	}
	@Override
	public T findById(ID id) {
		T entity;
		entity = (T) getManager().find(getPersistentClass(), id);
		return entity;
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll() {
		return getManager().createQuery( "from " + getPersistentClass().getName())
			       .getResultList();
	}
	@Override
	public T doPersistent(T entity) {
		getManager().persist(entity);
		getManager().flush();
		return entity;
	}
	@Override
	public void doRemove(T entity) {
		getManager().remove(entity);
	}
}