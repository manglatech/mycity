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
@Table(name = "postal_code", catalog = "findmycity", uniqueConstraints = {})
public class PostalCode implements java.io.Serializable {

	private static final long serialVersionUID = 72005035381459721L;
	private int id;
	private String code;
	private Set<Address> addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public PostalCode() {
	}

	/** minimal constructor */
	public PostalCode(int id, String code) {
		this.id = id;
		this.code = code;
	}

	/** full constructor */
	public PostalCode(int id, String code, Set<Address> addresses) {
		this.id = id;
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

	@Column(name = "CODE", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "postalCode")
	@XmlTransient
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
