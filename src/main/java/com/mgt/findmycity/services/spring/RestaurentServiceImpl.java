package com.mgt.findmycity.services.spring;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Comments;
import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.domain.RestaurentMenu;
import com.mgt.findmycity.info.CommentsSummary;
import com.mgt.findmycity.services.dao.CommentsDAO;
import com.mgt.findmycity.services.dao.RestaurentDAO;
import com.mgt.findmycity.util.Constants;

@Service
@Transactional
public class RestaurentServiceImpl implements RestaurentService {
	
	protected RestaurentDAO<Restaurent, Integer> dao;
	protected CommentsDAO<Comments, Integer> c_dao;
	
	@Autowired
	public void setDao(RestaurentDAO<Restaurent, Integer> dao) {
		this.dao = dao;
	}
	@Autowired
	public void setCommentsDao(CommentsDAO<Comments, Integer> c_dao) {
		this.c_dao = c_dao;
	}
	
	@Override
	public Restaurent getRestaurent(Integer Id){
		Restaurent restaurent = dao.findById(Id);
		if(restaurent != null){
			CommentsSummary summary = c_dao.findAverageUserRatings(restaurent.getId(), Constants.RESTAURENT_ENTITY);
			
		}
		return restaurent;
	}
	@Override
	public Restaurent save(Restaurent restaurent) {
		try {
			Restaurent result = dao.doPersistent(restaurent);
			return getRestaurent(result.getId());
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	@Override
	public Collection<Restaurent> getRestaurents() {
		List<Restaurent> list = dao.findAll();
		return list;
	}
	@Override
	public boolean delete(Restaurent restaurent) {
		dao.doRemove(restaurent);
		return true;
	}
	@Override
	public List<Restaurent> findByCategory(String category) {
		List<Restaurent> list = dao.findByCategory(category);
		return list;
	}
	@Override
	public List<RestaurentMenu> getRestaurentMenu(int i) {
		return dao.getRestaurentMenu(i);
	}
}
