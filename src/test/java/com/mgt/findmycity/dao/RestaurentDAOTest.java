package com.mgt.findmycity.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mgt.findmycity.domain.Restaurent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class RestaurentDAOTest {

	private RestaurentDAO dao;

	@Autowired
	public void setDao(RestaurentDAO dao) {
		this.dao = dao;
	}

	@Test
	public void insertRestaurent() {
		try {
			Restaurent entity = new Restaurent();
			entity.setRestaurentId(100);
			entity.setCode("TEST");
			entity.setName("TEST");
			dao.doPersistent(entity);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
