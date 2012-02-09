package com.mgt.findmycity.services.spring;

import java.util.Collection;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.mgt.findmycity.domain.Restaurent;

public interface RestaurentService {

	Restaurent getRestaurent(Integer Id);
	Restaurent save(Restaurent info);
	boolean delete(Restaurent restaurent);
	Collection<Restaurent> getRestaurents();
	List<Restaurent> findByCategory(String category);

}
