package com.mgt.findmycity.services.dao;

import java.io.Serializable;

import com.mgt.findmycity.info.CommentsSummary;
import com.mgt.findmycity.services.dao.base.GenericHibernateDao;

public interface CommentsDAO<T, ID extends Serializable> extends GenericHibernateDao<T,ID>{

	CommentsSummary findAverageUserRatings(Integer entityId, Integer entityTypeId);

}
