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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "city", catalog = "findmycity", uniqueConstraints = {})
public class City implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3699023572850431078L;
	// Fields

	private int id;
	private String name;
	private Set<Address> addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public City() {
	}

	/** minimal constructor */
	public City(int id, String name) {
		this.id = id;
		this.name = name;
	}

	/** full constructor */
	public City(int id, String name, Set<Address> addresses) {
		this.id = id;
		this.name = name;
		this.addresses = addresses;
	}

	// Property accessors
	@Id
	@Column(name = "ID", unique = true, nullable = false, insertable = true, updatable = true)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "city")
	@XmlTransient
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
