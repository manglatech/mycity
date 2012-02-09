package com.mgt.findmycity.services.spring;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Restaurent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class RestaurentServiceTest{

	private RestaurentService service;

	@Autowired
	public void setRestaurentService(RestaurentService service) {
		this.service = service;
	}

/*	@Test
	public void insertRestaurent() {
		try {
			Restaurent entity = new Restaurent();
			entity.setCode("TEST");
			entity.setName("TEST");
			service.save(entity);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}*/
	
	@Test
	public void getRestaurentById() {
		try {
			Restaurent entity = service.getRestaurent(4);
			Assert.assertNotNull(entity);
			Assert.assertTrue(true);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
