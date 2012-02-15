package com.mgt.findmycity.services.dao;

import java.io.Serializable;
import java.util.List;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.domain.RestaurentMenu;
import com.mgt.findmycity.services.dao.base.GenericHibernateDao;

public interface RestaurentDAO<T, ID extends Serializable> extends GenericHibernateDao<T,ID>{
	
	public T findByCode(String code) throws Exception;
	public List<Restaurent> findByCategory(String category);
	public List<RestaurentMenu> getRestaurentMenu(int id);
	
}