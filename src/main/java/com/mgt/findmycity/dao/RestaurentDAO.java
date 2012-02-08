package com.mgt.findmycity.dao;

import org.springframework.transaction.annotation.Transactional;


import com.mgt.findmycity.dao.base.GenericHibernateDAO;
import com.mgt.findmycity.domain.Restaurent;

@Transactional
public class RestaurentDAO extends GenericHibernateDAO<Restaurent, Integer> {

}
