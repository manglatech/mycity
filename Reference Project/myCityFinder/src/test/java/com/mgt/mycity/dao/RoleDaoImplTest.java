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
 * Unit test on RoleDaoImpl
 */
public class RoleDaoImplTest {

    public RoleDaoImpl roleDao;
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

        roleDao = new RoleDaoImpl();
        roleDao.setEntityManager(entityManager);
        roleDao.setNamedQueryUtil(namedQueryUtil);
    }

    @Test
    public void testGetReturnsNonNullWhenPkIsSet() {
        Role model = new Role();
        model.setRoleId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        when(entityManager.find(eq(Role.class), any())).thenReturn(model);

        Role result = roleDao.get(model);

        assertThat(result).isNotNull();
        verify(entityManager, times(1)).find(eq(Role.class), any());
    }

    @Test
    public void testGetReturnsNullWhenPkIsSet() {
        Role model = new Role();
        model.setRoleId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        when(entityManager.find(eq(Role.class), any())).thenReturn(null);

        Role result = roleDao.get(model);

        assertThat(result).isNull();
        verify(entityManager, times(1)).find(eq(Role.class), any());
    }

    @Test
    public void testSave() {
        List<Role> roles = new ArrayList<Role>();
        roles.add(new Role());
        roles.add(new Role());

        roleDao.save(roles);

        verify(entityManager, times(2)).persist(any());
    }

    @Test
    public void testDelete() {
        Role model1 = new Role();
        model1.setRoleId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        Role model2 = new Role();
        model2.setRoleId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        List<Role> roles = new ArrayList<Role>();
        roles.add(model1);
        roles.add(model2);

        when(entityManager.contains(any())).thenReturn(true);

        roleDao.delete(roles);

        verify(entityManager, times(2)).remove(any());
    }

    @Test
    public void testFindUseNamedQueryUtil() {
        Role model = new Role();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setNamedQuery("myNamedQuery");
        List<Role> roles = new ArrayList<Role>();

        when(namedQueryUtil.findByNamedQuery(any(SearchTemplate.class), any())).thenReturn((List) roles);

        List<Role> result = roleDao.find(model, searchTemplate);

        assertThat(result).isSameAs(roles);
        verify(namedQueryUtil, times(1)).findByNamedQuery(any(SearchTemplate.class), any());

    }

    @Test
    public void testFindCountUseNamedQueryUtil() {
        final int expectedResult = 10;
        Role model = new Role();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setNamedQuery("myNamedQuery");

        when(namedQueryUtil.numberByNamedQuery(any(SearchTemplate.class), any())).thenReturn(expectedResult);

        int result = roleDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(expectedResult);
        verify(namedQueryUtil, times(1)).numberByNamedQuery(any(SearchTemplate.class), any());
    }

    @Test
    public void testFindCountCaseNullResultCriteria() {
        Role model = new Role();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setCacheable(false);

        Criteria criteria = criteriaUtil.prepareThenReturnCriteria(entityManager, session, Role.class);
        when(criteria.uniqueResult()).thenReturn(null);

        int result = roleDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(0);
        verify(criteria, times(1)).uniqueResult();
    }

    @Test
    public void testFindCountCaseNotNullResultCriteria() {
        final int expectedResult = 10;
        Role model = new Role();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setCacheable(false);

        Criteria criteria = criteriaUtil.prepareThenReturnCriteria(entityManager, session, Role.class);
        when(criteria.uniqueResult()).thenReturn(expectedResult);

        int result = roleDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(expectedResult);
        verify(criteria, times(1)).uniqueResult();
    }

    @Test
    public void testGetLocalSearchTemplateWithNullSearchTemplate() {
        String cacheRegion = "cacheRegion";
        boolean cacheable = true;
        roleDao.setCacheable(cacheable);
        roleDao.setCacheRegion(cacheRegion);

        SearchTemplate result = roleDao.getLocalSearchTemplate(null);

        assertThat(result.getCacheRegion()).isEqualTo(cacheRegion);
        assertThat(result.isCacheable()).isEqualTo(cacheable);
    }

    @Test
    public void testGetLocalSearchTemplateWithDefaultSearchTemplate() {
        String cacheRegion = "cacheRegion";
        boolean cacheable = true;
        roleDao.setCacheable(cacheable);
        roleDao.setCacheRegion(cacheRegion);
        SearchTemplate defaultSearchTemplate = new SearchTemplate().setCacheable(null);

        SearchTemplate result = roleDao.getLocalSearchTemplate(defaultSearchTemplate);

        assertThat(result.getCacheRegion()).isEqualTo(cacheRegion);
        assertThat(result.isCacheable()).isEqualTo(cacheable);
    }

    @Test
    public void testGetLocalSearchTemplateWithNormalSearchTemplate() {
        String normalCacheRegion = "normalcacheRegion";
        boolean normalCacheable = false;
        roleDao.setCacheable(true);
        roleDao.setCacheRegion("cacheRegion");

        SearchTemplate normalSearchTemplate = new SearchTemplate();
        normalSearchTemplate.setCacheable(normalCacheable);
        normalSearchTemplate.setCacheRegion(normalCacheRegion);

        SearchTemplate result = roleDao.getLocalSearchTemplate(normalSearchTemplate);

        assertThat(result.getCacheRegion()).isEqualTo(normalCacheRegion);
        assertThat(result.isCacheable()).isEqualTo(normalCacheable);
    }
}