package com.mgt.findmycity.domain;

import java.util.Date;
import java.util.HashSet;
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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
/*@NamedQueries({
	@NamedQuery(
	name = "findByCategoryId",
	query = "select r from Restaurent r " +
                "inner join RestaurentCategory rc " +
                "inner join Category c " +
                "where c.name =:category"
	)
})*/
@XmlRootElement
@Table(name = "restaurent", catalog = "findmycity", uniqueConstraints = {})
public class Restaurent implements java.io.Serializable {

	private static final long serialVersionUID = 251671538736216582L;
	private int restaurentId;
	private Photo photo;
	private String code;
	private String name;
	private String description;
	private String isActive;
	private Date createdDate;
	private String createdBy;
	private Date modifiedBy;
	private String modifiedDate;
	private Set<RestaurentCategory> restaurentCategories = new HashSet<RestaurentCategory>(0);

	public Restaurent() {
	}
	public Restaurent(int restaurentId, String code, String name) {
		this.restaurentId = restaurentId;
		this.code = code;
		this.name = name;
	}
	public Restaurent(int restaurentId, Photo photo, String code, String name,
			String description, String isActive, Date createdDate,
			String createdBy, Date modifiedBy, String modifiedDate,
			Set<RestaurentCategory> restaurentCategories) {
		this.restaurentId = restaurentId;
		this.photo = photo;
		this.code = code;
		this.name = name;
		this.description = description;
		this.isActive = isActive;
		this.createdDate = createdDate;
		this.createdBy = createdBy;
		this.modifiedBy = modifiedBy;
		this.modifiedDate = modifiedDate;
		this.restaurentCategories = restaurentCategories;
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
	@XmlTransient
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

	@Column(name = "CREATED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Date getCreatedDate() {
		return this.createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	@Column(name = "CREATED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 26)
	public String getCreatedBy() {
		return this.createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	@Column(name = "MODIFIED_BY", unique = false, nullable = true, insertable = true, updatable = true, length = 19)
	public Date getModifiedBy() {
		return this.modifiedBy;
	}

	public void setModifiedBy(Date modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	@Column(name = "MODIFIED_DATE", unique = false, nullable = true, insertable = true, updatable = true, length = 26)
	public String getModifiedDate() {
		return this.modifiedDate;
	}
	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
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

}
