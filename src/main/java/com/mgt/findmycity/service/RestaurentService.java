package com.mgt.findmycity.service;

import java.util.Collection;

import com.mgt.findmycity.info.RestaurentInfo;

public interface RestaurentService {

	RestaurentInfo getRestaurent(Integer Id);
	void save(RestaurentInfo restaurent);
	Collection<RestaurentInfo> getRestaurents();

}
