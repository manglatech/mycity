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


@Entity
@Table(name = "geo_location_info", catalog = "findmycity", uniqueConstraints = {})
public class GeoLocationInfo implements java.io.Serializable {


	private static final long serialVersionUID = 2806073258690194916L;
	private int id;
	private double lat;
	private double lon;
	private Double latRad;
	private Double lonRad;
	private String geoHash;
	private Set<Address> addresses = new HashSet<Address>(0);

	// Constructors

	/** default constructor */
	public GeoLocationInfo() {
	}

	/** minimal constructor */
	public GeoLocationInfo(int id, double lat, double lon) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
	}

	/** full constructor */
	public GeoLocationInfo(int id, double lat, double lon, Double latRad,
			Double lonRad, String geoHash, Set<Address> addresses) {
		this.id = id;
		this.lat = lat;
		this.lon = lon;
		this.latRad = latRad;
		this.lonRad = lonRad;
		this.geoHash = geoHash;
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

	@Column(name = "LAT", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public double getLat() {
		return this.lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	@Column(name = "LON", unique = false, nullable = false, insertable = true, updatable = true, precision = 22, scale = 0)
	public double getLon() {
		return this.lon;
	}

	public void setLon(double lon) {
		this.lon = lon;
	}

	@Column(name = "LAT_RAD", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Double getLatRad() {
		return this.latRad;
	}

	public void setLatRad(Double latRad) {
		this.latRad = latRad;
	}

	@Column(name = "LON_RAD", unique = false, nullable = true, insertable = true, updatable = true, precision = 22, scale = 0)
	public Double getLonRad() {
		return this.lonRad;
	}

	public void setLonRad(Double lonRad) {
		this.lonRad = lonRad;
	}

	@Column(name = "GEO_HASH", unique = false, nullable = true, insertable = true, updatable = true, length = 26)
	public String getGeoHash() {
		return this.geoHash;
	}

	public void setGeoHash(String geoHash) {
		this.geoHash = geoHash;
	}

	@OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY, mappedBy = "geoLocationInfo")
	public Set<Address> getAddresses() {
		return this.addresses;
	}

	public void setAddresses(Set<Address> addresses) {
		this.addresses = addresses;
	}

}
