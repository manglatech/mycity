/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-mvc-3:src/main/java/web/controller/SearchForm.e.vm.java
 */
package com.mgt.mycity.web.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.mgt.mycity.domain.Category;
import com.mgt.mycity.web.util.SearchForm;
import com.mgt.mycity.web.util.NullRestriction;

/**
 * SearchForm for {@link CategoryService}
 */
public class CategorySearchForm extends SearchForm implements Serializable {
    private static final long serialVersionUID = 1L;
    private Category category = new Category();

    /**
     * The Category instance used as an example.
     */
    public Category getCategory() {
        return category;
    }

    @Override
    public List<NullRestriction> getNullRestrictions() {
        List<NullRestriction> result = new ArrayList<NullRestriction>();
        return result;
    }
}