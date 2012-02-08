package com.mgt.findmycity.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class RestaurentCategoryId implements java.io.Serializable {

	private static final long serialVersionUID = 3685749658925198254L;
	private int restaurentId;
	private int categoryId;

	// Constructors

	/** default constructor */
	public RestaurentCategoryId() {
	}

	/** full constructor */
	public RestaurentCategoryId(int restaurentId, int categoryId) {
		this.restaurentId = restaurentId;
		this.categoryId = categoryId;
	}

	// Property accessors
	@Column(name = "RESTAURENT_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public int getRestaurentId() {
		return this.restaurentId;
	}

	public void setRestaurentId(int restaurentId) {
		this.restaurentId = restaurentId;
	}

	@Column(name = "CATEGORY_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public int getCategoryId() {
		return this.categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof RestaurentCategoryId))
			return false;
		RestaurentCategoryId castOther = (RestaurentCategoryId) other;

		return (this.getRestaurentId() == castOther.getRestaurentId())
				&& (this.getCategoryId() == castOther.getCategoryId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getRestaurentId();
		result = 37 * result + this.getCategoryId();
		return result;
	}

}
