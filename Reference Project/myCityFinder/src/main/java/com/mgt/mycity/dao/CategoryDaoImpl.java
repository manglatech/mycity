/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/hibernate/DAOHibernate.e.vm.java
 */
package com.mgt.mycity.dao;

import org.springframework.stereotype.Repository;
import com.mgt.mycity.dao.CategoryDao;
import com.mgt.mycity.domain.Category;

import com.mgt.mycity.dao.hibernate.HibernateGenericDao;

/**
 * Hibernate implementation of the {@link CategoryDao} interface.
 */
@Repository
public class CategoryDaoImpl extends HibernateGenericDao<Category, Integer> implements CategoryDao {
    public CategoryDaoImpl() {
        super(Category.class);
    }
}