package com.mgt.findmycity.services.dao;

import java.io.Serializable;

import com.mgt.findmycity.services.dao.base.GenericHibernateDao;

public interface RestaurentDAO<T, ID extends Serializable> extends GenericHibernateDao<T,ID>{
	public T findByCode(String code) throws Exception;
}