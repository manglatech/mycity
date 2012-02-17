/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/dao/support/OrderBy.p.vm.java
 */
package com.mgt.findmycity.services.dao.base;

import java.io.Serializable;

import org.apache.commons.lang.Validate;

/**
 * Holder class for search ordering used by the {@link SearchTemplate}  
 */
public class OrderBy implements Serializable {
    private static final long serialVersionUID = 1L;
    private String column;
    private OrderByDirection direction;

    public OrderBy(String column, OrderByDirection direction) {
        Validate.notNull(column);
        Validate.notNull(direction);
        this.column = column;
        this.direction = direction;
    }

    public OrderBy(String column) {
        Validate.notNull(column);
        this.column = column;
        this.direction = OrderByDirection.ASC;
    }

    public String getColumn() {
        return column;
    }

    public OrderByDirection getDirection() {
        return direction;
    }

    public boolean isOrderDesc() {
        return true;
        		
        		//DESC == direction;
    }
}