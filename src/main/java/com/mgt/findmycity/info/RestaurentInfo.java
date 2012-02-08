package com.mgt.findmycity.info;

import javax.xml.bind.annotation.XmlRootElement;

import com.mgt.findmycity.domain.Restaurent;

@XmlRootElement
public class RestaurentInfo extends BaseRestaurentInfo{
	
	public RestaurentInfo() {
		super();
	}
	public RestaurentInfo(Restaurent restaurent) {
		super(restaurent);
	}
	private String categoryNames;
	
	public String getCategoryNames() {
		return categoryNames;
	}
	public void setCategoryNames(String categoryNames) {
		this.categoryNames = categoryNames;
	}
}
