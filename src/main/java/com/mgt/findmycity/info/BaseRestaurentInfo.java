package com.mgt.findmycity.info;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.info.base.BaseInfo;

public class BaseRestaurentInfo extends BaseInfo {

	protected Restaurent restaurent;
	
	public BaseRestaurentInfo() {
		super();
		this.restaurent = new Restaurent();
	}

	public BaseRestaurentInfo(Restaurent restaurent) {
		if(restaurent != null){
			this.restaurent = restaurent;
		}else{
			this.restaurent = new Restaurent();
		}
	}

	public Integer getId() {
		return restaurent.getRestaurentId();
	}

	public void setId(Integer id) {
		restaurent.setRestaurentId(id);
	}

	public String getCode() {
		return restaurent.getCode();
	}

	public void setCode(String code) {
		restaurent.setCode(code);
	}

	public String getName() {
		return restaurent.getName();
	}

	public void setName(String name) {
		restaurent.setName(name);
	}

}