package com.mgt.findmycity.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.dao.RestaurentDAO;
import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.info.RestaurentInfo;

public class RestaurentServiceImpl implements RestaurentService {
	
	private RestaurentDAO dao;
	
	@Autowired
	public void setDao(RestaurentDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public RestaurentInfo getRestaurent(Integer Id){
		Restaurent restaurent = dao.findById(Id);
		return getRestaurentInfo(restaurent);
	}
	
	@Override
	public void save(RestaurentInfo r_info) {
		Restaurent restaurent = new Restaurent(); 
		try {
			BeanUtils.copyProperties(restaurent, r_info);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		dao.doPersistent(restaurent);
	}
	
	@Override
	public Collection<RestaurentInfo> getRestaurents() {
		List<Restaurent> list = dao.findAll();
		return getRestaurents(list);
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

	@Override
	public void delete(RestaurentInfo r_info) {
		Restaurent restaurent = new Restaurent();
		try {
			BeanUtils.copyProperties(restaurent, r_info);
		} catch (Exception e) {
			e.printStackTrace();
		} 
		dao.doRemove(restaurent);
	}
	
}
