/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/manager/Manager.e.vm.java
 */
package com.mgt.mycity.service;

import com.mgt.mycity.domain.Role;
import com.mgt.mycity.service.support.GenericEntityService;

/**
 * The RoleService is a data-centric service for the {@link Role} entity.
 * It provides the expected methods to get/delete a {@link Role} instance
 * plus some methods to perform searches.
 * <p>
 * Search logic is driven by 2 kinds of parameters: a {@link Role} instance used
 * as a properties holder against which the search will be performed and a {@link SearchTemplate}
 * instance from where you can control your search options including the usage
 * of named queries.
 */
public interface RoleService extends GenericEntityService<Role, Integer> {
}