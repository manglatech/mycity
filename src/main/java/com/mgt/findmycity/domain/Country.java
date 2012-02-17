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
@Table(name = "country", catalog = "findmycity", uniqueConstraints = {})
public class Country implements java.io.Serializable {

	
	private static final long serialVersionUID = -8367106307949825148L;
	private int id;
	private String name;
	private String code;
	private Set<Address> addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public Country() {
	}

	/** minimal constructor */
	public Country(int id, String name, String code) {
		this.id = id;
		this.name = name;
		this.code = code;
	}

	/** full constructor */
	public Country(int id, String name, String code, Set<Address> addresses) {
		this.id = id;
		this.name = name;
		this.code = code;
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

	@Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "country")
	@XmlTransient
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
