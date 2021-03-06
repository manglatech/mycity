package com.mgt.findmycity.domain;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@NamedQueries({ @NamedQuery(name = "findAverageUserRatings", 
				query = "select AVG(c.ratings) as averageRatings, count(c.ratings) as numberOfComments from Comments c " +
						"where c.entityId=:entityId and c.entityTypeId=:entityTypeId ") })
@Entity
@Table(name = "comments", catalog = "findmycity", uniqueConstraints = {})
public class Comments implements java.io.Serializable {

	private static final long serialVersionUID = 3310580380386956014L;
	private int id;
	private int entityId;
	private int entityTypeId;
	private String name;
	private String email;
	private String comment;
	private Integer ratings;

	// Constructors

	/** default constructor */
	public Comments() {
	}

	/** minimal constructor */
	public Comments(int id, int entityId, int entityTypeId, String name,
			String comment) {
		this.id = id;
		this.entityId = entityId;
		this.entityTypeId = entityTypeId;
		this.name = name;
		this.comment = comment;
	}

	/** full constructor */
	public Comments(int id, int entityId, int entityTypeId, String name,
			String email, String comment, Integer ratings) {
		this.id = id;
		this.entityId = entityId;
		this.entityTypeId = entityTypeId;
		this.name = name;
		this.email = email;
		this.comment = comment;
		this.ratings = ratings;
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

	@Column(name = "ENTITY_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public int getEntityId() {
		return this.entityId;
	}

	public void setEntityId(int entityId) {
		this.entityId = entityId;
	}

	@Column(name = "ENTITY_TYPE_ID", unique = false, nullable = false, insertable = true, updatable = true)
	public int getEntityTypeId() {
		return this.entityTypeId;
	}

	public void setEntityTypeId(int entityTypeId) {
		this.entityTypeId = entityTypeId;
	}

	@Column(name = "NAME", unique = false, nullable = false, insertable = true, updatable = true, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "EMAIL", unique = false, nullable = true, insertable = true, updatable = true, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "COMMENT", unique = false, nullable = false, insertable = true, updatable = true, length = 2000)
	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Column(name = "RATINGS", unique = false, nullable = true, insertable = true, updatable = true)
	public Integer getRatings() {
		return this.ratings;
	}

	public void setRatings(Integer ratings) {
		this.ratings = ratings;
	}

}
