package com.mgt.findmycity.services.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Comments;
import com.mgt.findmycity.info.CommentsSummary;
import com.mgt.findmycity.services.dao.CommentsDAO;

@Service
@Transactional
public class CommentsServiceImpl implements CommentsService{

	protected CommentsDAO<Comments, Integer> dao;
	
	@Autowired
	public void setDao(CommentsDAO<Comments, Integer> dao) {
		this.dao = dao;
	}
	
	@Override
	public CommentsSummary findAverageUserRatings(Integer entityId, Integer entityTypeId) {
		CommentsSummary result = dao.findAverageUserRatings(entityId, entityTypeId);
		return result;
	}

}
