/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/test/java/manager/ModelGenerator.e.vm.java
 */
package com.mgt.mycity.service;

import java.util.*;

import com.mgt.mycity.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mgt.mycity.domain.Category;

/**
 * Helper class to create transient entities instance for testing purposes.
 * Simple properties are pre-filled with random values.
 */
@Service
public class CategoryGenerator {

    /**
     * Returns a new Category instance filled with random values.
     */
    public Category getCategory() {
        Category category = new Category();

        // simple attributes follows
        category.setName("d");
        category.setDesc("d");
        return category;
    }

}