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
 * Unit test on CategoryDaoImpl
 */
public class CategoryDaoImplTest {

    public CategoryDaoImpl categoryDao;
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

        categoryDao = new CategoryDaoImpl();
        categoryDao.setEntityManager(entityManager);
        categoryDao.setNamedQueryUtil(namedQueryUtil);
    }

    @Test
    public void testGetReturnsNonNullWhenPkIsSet() {
        Category model = new Category();
        model.setCategoryId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        when(entityManager.find(eq(Category.class), any())).thenReturn(model);

        Category result = categoryDao.get(model);

        assertThat(result).isNotNull();
        verify(entityManager, times(1)).find(eq(Category.class), any());
    }

    @Test
    public void testGetReturnsNullWhenPkIsSet() {
        Category model = new Category();
        model.setCategoryId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        when(entityManager.find(eq(Category.class), any())).thenReturn(null);

        Category result = categoryDao.get(model);

        assertThat(result).isNull();
        verify(entityManager, times(1)).find(eq(Category.class), any());
    }

    @Test
    public void testSave() {
        List<Category> categories = new ArrayList<Category>();
        categories.add(new Category());
        categories.add(new Category());

        categoryDao.save(categories);

        verify(entityManager, times(2)).persist(any());
    }

    @Test
    public void testDelete() {
        Category model1 = new Category();
        model1.setCategoryId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        Category model2 = new Category();
        model2.setCategoryId(ValueGenerator.getUniqueNumeric(Integer.class, "2147483647"));

        List<Category> categories = new ArrayList<Category>();
        categories.add(model1);
        categories.add(model2);

        when(entityManager.contains(any())).thenReturn(true);

        categoryDao.delete(categories);

        verify(entityManager, times(2)).remove(any());
    }

    @Test
    public void testFindUseNamedQueryUtil() {
        Category model = new Category();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setNamedQuery("myNamedQuery");
        List<Category> categories = new ArrayList<Category>();

        when(namedQueryUtil.findByNamedQuery(any(SearchTemplate.class), any())).thenReturn((List) categories);

        List<Category> result = categoryDao.find(model, searchTemplate);

        assertThat(result).isSameAs(categories);
        verify(namedQueryUtil, times(1)).findByNamedQuery(any(SearchTemplate.class), any());

    }

    @Test
    public void testFindCountUseNamedQueryUtil() {
        final int expectedResult = 10;
        Category model = new Category();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setNamedQuery("myNamedQuery");

        when(namedQueryUtil.numberByNamedQuery(any(SearchTemplate.class), any())).thenReturn(expectedResult);

        int result = categoryDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(expectedResult);
        verify(namedQueryUtil, times(1)).numberByNamedQuery(any(SearchTemplate.class), any());
    }

    @Test
    public void testFindCountCaseNullResultCriteria() {
        Category model = new Category();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setCacheable(false);

        Criteria criteria = criteriaUtil.prepareThenReturnCriteria(entityManager, session, Category.class);
        when(criteria.uniqueResult()).thenReturn(null);

        int result = categoryDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(0);
        verify(criteria, times(1)).uniqueResult();
    }

    @Test
    public void testFindCountCaseNotNullResultCriteria() {
        final int expectedResult = 10;
        Category model = new Category();
        SearchTemplate searchTemplate = new SearchTemplate();
        searchTemplate.setCacheable(false);

        Criteria criteria = criteriaUtil.prepareThenReturnCriteria(entityManager, session, Category.class);
        when(criteria.uniqueResult()).thenReturn(expectedResult);

        int result = categoryDao.findCount(model, searchTemplate);

        assertThat(result).isEqualTo(expectedResult);
        verify(criteria, times(1)).uniqueResult();
    }

    @Test
    public void testGetLocalSearchTemplateWithNullSearchTemplate() {
        String cacheRegion = "cacheRegion";
        boolean cacheable = true;
        categoryDao.setCacheable(cacheable);
        categoryDao.setCacheRegion(cacheRegion);

        SearchTemplate result = categoryDao.getLocalSearchTemplate(null);

        assertThat(result.getCacheRegion()).isEqualTo(cacheRegion);
        assertThat(result.isCacheable()).isEqualTo(cacheable);
    }

    @Test
    public void testGetLocalSearchTemplateWithDefaultSearchTemplate() {
        String cacheRegion = "cacheRegion";
        boolean cacheable = true;
        categoryDao.setCacheable(cacheable);
        categoryDao.setCacheRegion(cacheRegion);
        SearchTemplate defaultSearchTemplate = new SearchTemplate().setCacheable(null);

        SearchTemplate result = categoryDao.getLocalSearchTemplate(defaultSearchTemplate);

        assertThat(result.getCacheRegion()).isEqualTo(cacheRegion);
        assertThat(result.isCacheable()).isEqualTo(cacheable);
    }

    @Test
    public void testGetLocalSearchTemplateWithNormalSearchTemplate() {
        String normalCacheRegion = "normalcacheRegion";
        boolean normalCacheable = false;
        categoryDao.setCacheable(true);
        categoryDao.setCacheRegion("cacheRegion");

        SearchTemplate normalSearchTemplate = new SearchTemplate();
        normalSearchTemplate.setCacheable(normalCacheable);
        normalSearchTemplate.setCacheRegion(normalCacheRegion);

        SearchTemplate result = categoryDao.getLocalSearchTemplate(normalSearchTemplate);

        assertThat(result.getCacheRegion()).isEqualTo(normalCacheRegion);
        assertThat(result.isCacheable()).isEqualTo(normalCacheable);
    }
}