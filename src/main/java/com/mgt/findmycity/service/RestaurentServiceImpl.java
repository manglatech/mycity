package com.mgt.findmycity.service;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.info.RestaurentInfo;

public class RestaurentServiceImpl implements RestaurentService {
	
	private EntityManager em;
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.em = entityManager;
	}
	
	@Override
	public RestaurentInfo getRestaurent(Integer Id){
		Restaurent restaurent = em.find(Restaurent.class, Id);
		return getRestaurentInfo(restaurent);
	}

	@Override
	@Transactional
	public void save(RestaurentInfo r_info) {
		Restaurent restaurent = getRestaurentObject(r_info);
	    if (!em.contains(restaurent)) {
	        em.persist(restaurent);
	        em.flush();
	    }
	}

	@Override
	public Collection<RestaurentInfo> getRestaurents() {
		return null;
		//Query query = em.createNamedQuery("getRestaurents",Restaurent.class);
	    //return getRestaurents((Collection<Restaurent>) query.getResultList());
	}
	
	private Restaurent getRestaurentObject(RestaurentInfo info) {
		Restaurent restaurent = new Restaurent();
		restaurent.setRestaurentId(2);
		restaurent.setCode(info.getCode());
		restaurent.setName(info.getName());
		return restaurent;
	}
	
	private RestaurentInfo getRestaurentInfo(Restaurent restaurent) {
		return new RestaurentInfo(restaurent);
	}
	
	private Collection<RestaurentInfo> getRestaurents(Collection<Restaurent> restaurent) {
		Collection<RestaurentInfo> infos = new ArrayList<RestaurentInfo>();
		for (Restaurent rest : restaurent) {
			infos.add(new RestaurentInfo(rest));
		}
		return infos;
	}
	
}
