package com.mgt.findmycity.domain;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import com.mgt.findmycity.domain.base.BaseVO;

@Entity
@NamedQueries({
@NamedQuery( name = "findByCategory", query = "select r from Restaurent as r "
+ "inner join r.restaurentCategories as rc " + "inner join rc.category as c " +
"where c.name=:name " ) })

@XmlRootElement
@Table(name = "restaurent", catalog = "findmycity", uniqueConstraints = {})
public class Restaurent extends BaseVO implements java.io.Serializable {

	private static final long serialVersionUID = 251671538736216582L;
	private int restaurentId;
	private Photo photo;
	private String code;
	private String name;
	private String description;
	private String isActive;
	
	private Set<RestaurentCategory> restaurentCategories = new HashSet<RestaurentCategory>(
			0);
	private Set<Delivery> deliveries = new HashSet<Delivery>(0);

	public Restaurent() {
	}

	public Restaurent(int restaurentId, String code, String name) {
		this.restaurentId = restaurentId;
		this.code = code;
		this.name = name;
	}

	public Restaurent(int restaurentId, Photo photo, String code, String name,
			String description, String isActive,
			Set<RestaurentCategory> restaurentCategories) {
		this.restaurentId = restaurentId;
		this.photo = photo;
		this.code = code;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
	}

	@Id
	@Column(name = "RESTAURENT_ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getRestaurentId() {
		return this.restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "PHOTO_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public Photo getPhoto() {
		return this.photo;
	}

	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	@Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESCRIPTION", unique = false, nullable = true, insertable = true, updatable = true, length = 500)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "IS_ACTIVE", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public String getIsActive() {
		return this.isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "restaurent")
	@XmlTransient
	public Set<RestaurentCategory> getRestaurentCategories() {
		return this.restaurentCategories;
	}

	public void setRestaurentCategories(
			Set<RestaurentCategory> restaurentCategories) {
		this.restaurentCategories = restaurentCategories;
	}

	@Transient
	@XmlElement
	public List<Category> getCategory() {
		List<Category> list = new ArrayList<Category>();
		for (RestaurentCategory r_cat : getRestaurentCategories()) {
			list.add(r_cat.getCategory());
		}
		return list;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "restaurent")
	public Set<Delivery> getDeliveries() {
		return this.deliveries;
	}

	public void setDeliveries(Set<Delivery> deliveries) {
		this.deliveries = deliveries;
	}
	
	private String deliveryFlag;
	@Column(name = "DELIVERY_FLAG", unique = false, nullable = true, insertable = true, updatable = true, length = 1)
	public String getDeliveryFlag() {
		return this.deliveryFlag;
	}

	public void setDeliveryFlag(String deliveryFlag) {
		this.deliveryFlag = deliveryFlag;
	}
	
	private Set<MenuItem> menuItems = new HashSet<MenuItem>(0);
	@XmlTransient
	@OneToMany(cascade={CascadeType.ALL}, fetch=FetchType.LAZY, mappedBy="restaurent")
    public Set<MenuItem> getMenuItems() {
        return this.menuItems;
    }
    
    public void setMenuItems(Set<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

}
