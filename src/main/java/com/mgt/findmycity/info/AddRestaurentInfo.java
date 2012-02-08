package com.mgt.findmycity.info;

import javax.xml.bind.annotation.XmlRootElement;

import com.mgt.findmycity.domain.Restaurent;

@XmlRootElement
public class AddRestaurentInfo extends BaseRestaurentInfo{
	
	public AddRestaurentInfo() {
		super();
	}
	public AddRestaurentInfo(Restaurent restaurent) {
		super(restaurent);
	}
	
	private String categoryIds;
	
	public String getCategoryIds() {
		return categoryIds;
	}
	public void setCategoryIds(String categoryIds) {
		this.categoryIds = categoryIds;
	}
	

}
