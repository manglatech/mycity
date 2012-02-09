package com.mgt.findmycity.services.dao;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Restaurent;

@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
@ContextConfiguration({ "/applicationContext.xml" })
public class RestaurentDAOTest{

	private RestaurentDAO<Restaurent, Integer> dao;
	private static final String CODE = "DAOTEST"; 
	private static final String NAME = "DAOTEST";

	@Autowired
	public void setRestaurentService(RestaurentDAO<Restaurent, Integer> dao) {
		this.dao = dao;
	}
	//@Test
	public void insertRestaurent() {
		try {
			Restaurent entity = new Restaurent();
			entity.setCode(CODE);
			entity.setName(NAME);
			dao.doPersistent(entity);
			Restaurent r = (Restaurent) dao.findByCode(CODE);
			System.out.println(r.getRestaurentId());
			Assert.assertNotNull(r);
			Assert.assertEquals(r.getName(),NAME);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
