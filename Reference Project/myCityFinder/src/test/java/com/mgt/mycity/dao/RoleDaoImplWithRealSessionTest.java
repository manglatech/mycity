/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/hibernate/DAOHibernateWithRealSessionTest.e.vm.java
 */
package com.mgt.mycity.dao;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;

import static org.fest.assertions.Assertions.*;
import static org.mockito.Matchers.*;
import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.mycity.domain.Role;
import com.mgt.mycity.service.RoleGenerator;
import com.mgt.mycity.dao.RoleDao;
import com.mgt.mycity.util.*;

/**
 * Integration test on RoleDaoImpl
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class RoleDaoImplWithRealSessionTest {
    @SuppressWarnings("unused")
    private static final Logger log = Logger.getLogger(RoleDaoImplWithRealSessionTest.class);

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleGenerator roleGenerator;

    @Before
    public void onSetUp() throws Exception {
        //reset generator
        ValueGenerator.resetAll();
    }

    @Test
    public void testSaveAndGet() {
        Role role = roleGenerator.getRole();

        // add it to a Set before saving
        Set<Role> set = new HashSet<Role>();
        set.add(role);

        roleDao.save(role);
        entityManager.flush();

        // reload it from cache and check equality
        Role model = new Role();
        model.setRoleId(role.getRoleId());
        assertThat(role).isEqualTo(roleDao.get(model));

        // clear cache to force reload from db
        entityManager.clear();

        // pk are equals...
        assertThat(role.getPrimaryKey()).isEqualTo(roleDao.get(model).getPrimaryKey());

        // but since you do not use a business key, equality is lost.
        assertThat(role).isNotEqualTo(roleDao.get(model));
    }
}