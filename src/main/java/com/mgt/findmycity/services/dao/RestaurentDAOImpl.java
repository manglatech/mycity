package com.mgt.findmycity.services.dao;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.services.dao.base.GenericHibernateDAOImpl;

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

}
