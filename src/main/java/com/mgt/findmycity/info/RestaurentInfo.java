package com.mgt.findmycity.info;

import javax.xml.bind.annotation.XmlRootElement;

import com.mgt.findmycity.domain.Restaurent;
import com.mgt.findmycity.info.base.BaseInfo;

@XmlRootElement
public class RestaurentInfo extends BaseInfo{
	
	private Restaurent restaurent;
	
	public RestaurentInfo() {
		super();
		this.restaurent = new Restaurent();
	}
	public RestaurentInfo(Restaurent restaurent) {
		if(restaurent != null){
			this.restaurent = restaurent;
		}else{
			
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
	/*public Restaurent getRestaurent() {
		return restaurent;
	}
	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}*/
	
}
