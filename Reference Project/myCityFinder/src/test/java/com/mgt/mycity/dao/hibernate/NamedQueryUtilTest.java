/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/hibernate/NamedQueryUtilTest.p.vm.java
 */
package com.mgt.mycity.dao.hibernate;

import java.util.*;

import org.apache.log4j.Logger;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.mgt.mycity.dao.support.*;
import com.mgt.mycity.util.*;
import com.mgt.mycity.context.*;
import com.mgt.mycity.domain.Category;
import com.mgt.mycity.domain.Photo;
import com.mgt.mycity.domain.Restaurent;
import com.mgt.mycity.domain.Role;
import com.mgt.mycity.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring/applicationContext-test.xml" })
@Transactional
public class NamedQueryUtilTest {

    private static final Logger log = Logger.getLogger(NamedQueryUtilTest.class);

    @Autowired
    private NamedQueryUtil namedQueryUtil;

    @Test
    @SuppressWarnings("unchecked")
    public void executeQetAllAccountsQueryName() {
        String sqlQuery = "User.selectAll";
        List<User> accounts = (List<User>) namedQueryUtil
                .findByNamedQuery(new SearchTemplate().setNamedQuery(sqlQuery));

        if (accounts != null) {
            log.info(accounts.size());

            for (User account : accounts) {
                log.info(account.toString());
            }
        }
    }

    @Test
    @SuppressWarnings("unchecked")
    public void executeGetAllAccountsSqlQuery() {
        String sqlQuery = "User.selectAll.native";
        List<User> accounts = (List<User>) namedQueryUtil
                .findByNamedQuery(new SearchTemplate().setNamedQuery(sqlQuery));

        if (accounts != null) {
            log.info(accounts.size());
            for (User account : accounts) {
                log.info(account.toString());
            }
        }
    }

}