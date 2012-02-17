/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/hibernate/DAOHibernateTest.e.vm.java
 */
package com.mgt.mycity.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;
import org.hibernate.Session;

import com.mgt.mycity.dao.support.NamedQueryUtil;
import com.mgt.mycity.dao.support.SearchTemplate;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import com.mgt.mycity.domain.*;
import com.mgt.mycity.util.*;

/**
 * Unit test on UserDaoImpl
 */
public class UserDaoImplTest {

    public UserDaoImpl userDao;
    public EntityManager entityManager;
    public Session session;
    public NamedQueryUtil namedQueryUtil;
    public MockCriteriaUtil criteriaUtil;

    @Before
    public void setUp() {
        entityManager = mock(EntityManager.class);
        session = mock(Session.class);
        namedQueryUtil = mock(NamedQueryUtil.class);
        criteriaUtil = new MockCriteriaUtil();

        userDao = new UserDaoImpl();
        userDao.setEntityManager(entityManager);
        userDao.setNamedQueryUtil(namedQueryUtil);
    }

    @Test
    public void testGetReturnsNonNullWhenPkIsSet() {
        User model = new User();
        model.setUserId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        when(entityManager.find(eq(User.class), any())).thenReturn(model);

        User result = userDao.get(model);

        assertThat(result).isNotNull();
        verify(entityManager, times(1)).find(eq(User.class), any());
    }

    @Test
    public void testGetReturnsNullWhenPkIsSet() {
        User model = new User();
        model.setUserId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        when(entityManager.find(eq(User.class), any())).thenReturn(null);

        User result = userDao.get(model);

        assertThat(result).isNull();
        verify(entityManager, times(1)).find(eq(User.class), any());
    }

    @Test
    public void testSave() {
        List<User> users = new ArrayList<User>();
        users.add(new User());
        users.add(new User());

        userDao.save(users);

        verify(entityManager, times(2)).persist(any());
    }

    @Test
    public void testDelete() {
        User model1 = new User();
        model1.setUserId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        User model2 = new User();
        model2.setUserId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        List<User> users = new ArrayList<User>();
        users.add(model1);
        users.add(model2);

        when(entityManager.contains(any())).thenReturn(true);

        userDao.delete(users);

        verify(entityManager, times(2)).remove(any());
    }

    @Test
    public void testFindUseNamedQueryUtil() {
        User model = new User();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setNamedQuery("myNamedQuery");
        List<User> users = new ArrayList<User>();

        when(namedQueryUtil.findByNamedQuery(any(SearchTemplate.class), any())).thenReturn((List) users);

        List<User> result = userDao.find(model, searchTemplate);

        assertThat(result).isSameAs(users);
        verify(namedQueryUtil, times(1)).findByNamedQuery(any(SearchTemplate.class), any());

    }

    @Test
    public void testFindCountUseNamedQueryUtil() {
        final int expectedResult = 10;
        User model = new User();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setNamedQuery("myNamedQuery");

        when(namedQueryUtil.numberByNamedQuery(any(SearchTemplate.class), any())).thenReturn(expectedResult);

        int result = userDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(expectedResult);
        verify(namedQueryUtil, times(1)).numberByNamedQuery(any(SearchTemplate.class), any());
    }

    @Test
    public void testFindCountCaseNullResultCriteria() {
        User model = new User();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setCacheable(false);

        Criteria criteria = criteriaUtil.prepareThenReturnCriteria(entityManager, session, User.class);
        when(criteria.uniqueResult()).thenReturn(null);

        int result = userDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(0);
        verify(criteria, times(1)).uniqueResult();
    }

    @Test
    public void testFindCountCaseNotNullResultCriteria() {
        final int expectedResult = 10;
        User model = new User();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setCacheable(false);

        Criteria criteria = criteriaUtil.prepareThenReturnCriteria(entityManager, session, User.class);
        when(criteria.uniqueResult()).thenReturn(expectedResult);

        int result = userDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(expectedResult);
        verify(criteria, times(1)).uniqueResult();
    }

    @Test
    public void testGetLocalSearchTemplateWithNullSearchTemplate() {
        String cacheRegion = "cacheRegion";
        boolean cacheable = true;
        userDao.setCacheable(cacheable);
        userDao.setCacheRegion(cacheRegion);

        SearchTemplate result = userDao.getLocalSearchTemplate(null);

        assertThat(result.getCacheRegion()).isEqualTo(cacheRegion);
        assertThat(result.isCacheable()).isEqualTo(cacheable);
    }

    @Test
    public void testGetLocalSearchTemplateWithDefaultSearchTemplate() {
        String cacheRegion = "cacheRegion";
        boolean cacheable = true;
        userDao.setCacheable(cacheable);
        userDao.setCacheRegion(cacheRegion);
        SearchTemplate defaultSearchTemplate = new SearchTemplate().setCacheable(null);

        SearchTemplate result = userDao.getLocalSearchTemplate(defaultSearchTemplate);

        assertThat(result.getCacheRegion()).isEqualTo(cacheRegion);
        assertThat(result.isCacheable()).isEqualTo(cacheable);
    }

    @Test
    public void testGetLocalSearchTemplateWithNormalSearchTemplate() {
        String normalCacheRegion = "normalcacheRegion";
        boolean normalCacheable = false;
        userDao.setCacheable(true);
        userDao.setCacheRegion("cacheRegion");

        SearchTemplate normalSearchTemplate = new SearchTemplate();
        normalSearchTemplate.setCacheable(normalCacheable);
        normalSearchTemplate.setCacheRegion(normalCacheRegion);

        SearchTemplate result = userDao.getLocalSearchTemplate(normalSearchTemplate);

        assertThat(result.getCacheRegion()).isEqualTo(normalCacheRegion);
        assertThat(result.isCacheable()).isEqualTo(normalCacheable);
    }
}