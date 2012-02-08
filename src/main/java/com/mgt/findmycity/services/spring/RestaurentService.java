package com.mgt.findmycity.services.spring;

import java.util.Collection;

import com.mgt.findmycity.info.RestaurentInfo;

public interface RestaurentService {

	RestaurentInfo getRestaurent(Integer Id);
	void save(RestaurentInfo restaurent);
	void delete(RestaurentInfo restaurent);
	Collection<RestaurentInfo> getRestaurents();

}
