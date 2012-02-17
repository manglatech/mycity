package com.mgt.findmycity.services.dao;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.mgt.findmycity.domain.Comments;
import com.mgt.findmycity.info.CommentsSummary;
import com.mgt.findmycity.services.dao.base.GenericHibernateDAOImpl;
import com.mgt.findmycity.util.CommentsConstants;

@Repository
public class CommentsDAOImpl extends GenericHibernateDAOImpl<Comments, Integer>
		implements CommentsDAO<Comments, Integer> {

	@Override
	public CommentsSummary findAverageUserRatings(Integer entityId,
			Integer entityTypeId) {

		Query q = getManager().createNamedQuery(
				CommentsConstants.FIND_AVE_USER_RATINGS);
		q.setParameter("entityId", entityId);
		q.setParameter("entityTypeId", entityTypeId);
		
		Object[] objs = (Object[]) q.getSingleResult();

		CommentsSummary result = null;
		if (objs != null && objs.length > 0 && objs.length == 2) {
			result = new CommentsSummary();
			result.setAverageRatings(((Double) objs[0]));
			result.setNumberOfComments((Long) objs[1]);
		}
		return result;
	}
}
