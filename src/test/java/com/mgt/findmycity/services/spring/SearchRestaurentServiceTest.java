package com.mgt.findmycity.services.spring;

import java.util.List;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mgt.findmycity.domain.Restaurent;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "/applicationContext.xml" })
public class SearchRestaurentServiceTest{

	private RestaurentService service;
	private static final String INVALID_CATEGORY = "NO_CATEGORY";
	private static final String VALID_CATEGORY = "FAST FOOD";
	
	@Autowired
	public void setRestaurentService(RestaurentService service) {
		this.service = service;
	}
	@Before
	public void setUp(){
	}
	@After
	public void tearDown(){
	}
	@Test
	public void findByCategory() {
		try {
			List<Restaurent> result = service.findByCategory(INVALID_CATEGORY);
			Assert.assertEquals(result.size(), 0);
			result = service.findByCategory(VALID_CATEGORY);
			Assert.assertNotSame(result.size(), 0);
		} catch (Exception e) {
			e.printStackTrace();
			Assert.assertTrue(false);
		}
	}
}
