package com.mgt.findmycity.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "address", catalog = "findmycity", uniqueConstraints = {})
public class Address implements java.io.Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -140853603900368531L;
	private int id;
	private State state;
	private PostalCode postalCode;
	private Country country;
	private GeoLocationInfo geoLocationInfo;
	private City city;
	private String address1;
	private String address2;
	private String loadGeoLoc;

	// Constructors

	/** default constructor */
	public Address() {
	}

	/** minimal constructor */
	public Address(int id, State state, PostalCode postalCode, Country country,
			City city, String address1, String loadGeoLoc) {
		this.id = id;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.city = city;
		this.address1 = address1;
		this.loadGeoLoc = loadGeoLoc;
	}

	/** full constructor */
	public Address(int id, State state, PostalCode postalCode, Country country,
			GeoLocationInfo geoLocationInfo, City city, String address1,
			String address2, String loadGeoLoc) {
		this.id = id;
		this.state = state;
		this.postalCode = postalCode;
		this.country = country;
		this.geoLocationInfo = geoLocationInfo;
		this.city = city;
		this.address1 = address1;
		this.address2 = address2;
		this.loadGeoLoc = loadGeoLoc;
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

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "STATE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public State getState() {
		return this.state;
	}

	public void setState(State state) {
		this.state = state;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "POSTAL_CODE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public PostalCode getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(PostalCode postalCode) {
		this.postalCode = postalCode;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "COUNTRY_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public Country getCountry() {
		return this.country;
	}

	public void setCountry(Country country) {
		this.country = country;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "GEO_LOC_ID", unique = false, nullable = true, insertable = true, updatable = true)
	public GeoLocationInfo getGeoLocationInfo() {
		return this.geoLocationInfo;
	}

	public void setGeoLocationInfo(GeoLocationInfo geoLocationInfo) {
		this.geoLocationInfo = geoLocationInfo;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CITY_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public City getCity() {
		return this.city;
	}

	public void setCity(City city) {
		this.city = city;
	}

	@Column(name = "ADDRESS_1", unique = false, nullable = false, insertable = true, updatable = true)
	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	@Column(name = "ADDRESS_2", unique = false, nullable = true, insertable = true, updatable = true)
	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	@Column(name = "LOAD_GEO_LOC", unique = false, nullable = false, insertable = true, updatable = true, length = 1)
	@XmlTransient
	public String getLoadGeoLoc() {
		return this.loadGeoLoc;
	}

	public void setLoadGeoLoc(String loadGeoLoc) {
		this.loadGeoLoc = loadGeoLoc;
	}

}
