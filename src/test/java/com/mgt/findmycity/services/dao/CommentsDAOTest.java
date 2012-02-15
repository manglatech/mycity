package com.mgt.findmycity.services.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Comments;
import com.mgt.findmycity.info.CommentsSummary;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({ "/applicationContext.xml" })
public class CommentsDAOTest{

	private CommentsDAO<Comments, Integer> dao;
	private static final String CODE = "DAOTEST"; 
	private static final String NAME = "DAOTEST";

	@Autowired
	public void setCommentsDAO(CommentsDAO<Comments, Integer> dao) {
		this.dao = dao;
	}
	@Test
	public void insertRestaurent() {
		try {
			CommentsSummary summary = dao.findAverageUserRatings(4, 1);
			Assert.assertNotNull(summary);
			Assert.assertEquals(1, summary.getNumberOfComments().intValue());
			Assert.assertEquals(4, summary.getAverageRatings().intValue());
			
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
	
	
}
