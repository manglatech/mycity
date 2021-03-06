package com.mgt.findmycity.domain;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
@Entity
@Table(name = "photo", catalog = "findmycity", uniqueConstraints = {})
public class Photo implements java.io.Serializable {

	private static final long serialVersionUID = 5285176850910937081L;
	private int id;
	private String name;
	private String desc;
	private String location;
	private Set<Restaurent> restaurents = new HashSet<Restaurent>(0);

	public Photo() {
	}

	public Photo(int id, String location) {
		this.id = id;
		this.location = location;
	}
	
	public Photo(int id, String name, String desc, String location,
			Set<Restaurent> restaurents) {
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.location = location;
		this.restaurents = restaurents;
	}

	@Id
	@Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = false, nullable = true, insertable = true, updatable = true, length = 26)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "DESC", unique = false, nullable = true, insertable = true, updatable = true, length = 100)
	public String getDesc() {
		return this.desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name = "LOCATION", unique = false, nullable = false, insertable = true, updatable = true, length = 256)
	public String getLocation() {
		return this.location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "photo")
	@XmlTransient
	public Set<Restaurent> getRestaurents() {
		return this.restaurents;
	}

	public void setRestaurents(Set<Restaurent> restaurents) {
		this.restaurents = restaurents;
	}

}
