package com.mgt.findmycity.services.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.domain.RestaurentMenu;
import com.mgt.findmycity.services.dao.base.GenericHibernateDAOImpl;
import com.mgt.findmycity.util.RestaurentContants;

@Repository
public class RestaurentDAOImpl extends GenericHibernateDAOImpl<Restaurent, Integer> implements RestaurentDAO<Restaurent, Integer> {

	@SuppressWarnings("unchecked")
	@Override
	public Restaurent findByCode(String code) throws Exception {		
		Query query = getManager().createQuery("from Restaurent r where r.code=:code");
		query.setParameter("code", code);
		List<Restaurent> result = query.getResultList();
		if(result.size() > 1){
			throw new Exception("Found more than One Result");
		}
		return result.get(0);
	}
	
	@SuppressWarnings("unchecked")
	public List<Restaurent> findByCategory(String category) {
		Query query = getManager().createNamedQuery(RestaurentContants.FIND_BY_CATEGORY);
		query.setParameter("name", category);
		return query.getResultList();
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<RestaurentMenu> getRestaurentMenu(int id) {
		Query query = getManager().createNamedQuery(RestaurentContants.GET_RESTAURENT_MENU);
		query.setParameter("id", id);
		List<RestaurentMenu> result = query.getResultList();
		return result;
	}
}
