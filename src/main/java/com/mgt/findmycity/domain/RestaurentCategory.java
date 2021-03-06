package com.mgt.findmycity.domain;

// Generated Feb 7, 2012 4:18:55 PM by Hibernate Tools 3.1.0.beta4

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "restaurent_category", catalog = "findmycity")
public class RestaurentCategory implements java.io.Serializable {

	private static final long serialVersionUID = 1843026930898708612L;
	private RestaurentCategoryId id;
	private Category category;
	private Restaurent restaurent;

	/** default constructor */
	public RestaurentCategory() {
	}

	/** full constructor */
	public RestaurentCategory(RestaurentCategoryId id, Category category,
			Restaurent restaurent) {
		this.id = id;
		this.category = category;
		this.restaurent = restaurent;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "restaurentId", column = @Column(name = "RESTAURENT_ID", unique = false, nullable = false, insertable = true, updatable = true)),
			@AttributeOverride(name = "categoryId", column = @Column(name = "CATEGORY_ID", unique = false, nullable = false, insertable = true, updatable = true)) })
	@XmlTransient
	public RestaurentCategoryId getId() {
		return this.id;
	}

	public void setId(RestaurentCategoryId id) {
		this.id = id;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORY_ID", unique = false, nullable = false, insertable = false, updatable = false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@ManyToOne(cascade = {}, fetch = FetchType.LAZY)
	@JoinColumn(name = "RESTAURENT_ID", unique = false, nullable = false, insertable = false, updatable = false)
	@XmlTransient
	public Restaurent getRestaurent() {
		return this.restaurent;
	}

	public void setRestaurent(Restaurent restaurent) {
		this.restaurent = restaurent;
	}

}
