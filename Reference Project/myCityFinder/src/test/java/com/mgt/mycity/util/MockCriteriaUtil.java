/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/util/MockCriteriaUtil.p.vm.java
 */
package com.mgt.mycity.util;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import javax.persistence.EntityManager;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Projection;

public class MockCriteriaUtil {

    public Criteria prepareThenReturnCriteria(EntityManager entityManager, Session session, Class<?> clazz) {
        Criteria criteria = mock(Criteria.class);

        when(entityManager.getDelegate()).thenReturn(session);
        when(session.createCriteria(eq(clazz))).thenReturn(criteria);
        when(criteria.add(any(Criterion.class))).thenReturn(criteria);
        when(criteria.setProjection(any(Projection.class))).thenReturn(criteria);

        return criteria;
    }
}