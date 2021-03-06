/*
 * (c) Copyright 2005-2012 JAXIO, www.jaxio.com
 * Source code generated by Celerio, a Jaxio product
 * Want to use Celerio within your company? email us at info@jaxio.com
 * Follow us on twitter: @springfuse
 * Template pack-backend:src/main/java/project/domain/Entity.e.vm.java
 */
package com.mgt.mycity.domain;

import static javax.persistence.CascadeType.PERSIST;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.TemporalType.TIMESTAMP;
import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;
import static com.mgt.mycity.util.ResourcesUtil.DATE_FORMAT_PATTERN;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;
import org.apache.log4j.Logger;
import org.hibernate.annotations.Cache;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;
import com.mgt.mycity.domain.Category;
import com.mgt.mycity.domain.Photo;
import com.mgt.mycity.validation.JpaUnique;

@Entity
@Table(name = "restaurent")
@Cache(usage = NONSTRICT_READ_WRITE)
@JpaUnique
public class Restaurent implements Identifiable<Integer>, Serializable, Copyable<Restaurent> {
    private static final long serialVersionUID = 1L;
    private static final Logger log = Logger.getLogger(Restaurent.class);

    // Raw attributes
    private Integer restaurentId; // pk
    private String code; // not null
    private String name; // not null
    private String desc;
    private String isActive;
    private Date createdDate; // not null
    private String createdBy; // not null
    private Date modifiedBy;
    private String modifiedDate;

    // Technical attributes for query by example
    private Integer photoId;

    // Many to one
    private Photo photo; // (photoId)

    // Many to many
    private List<Category> categories = new ArrayList<Category>();

    // ---------------------------
    // Constructors
    // ---------------------------

    public Restaurent() {
    }

    public Restaurent(Integer primaryKey) {
        setPrimaryKey(primaryKey);
    }

    // ---------------------------
    // Identifiable implementation
    // ---------------------------

    @Override
    @Transient
    @XmlTransient
    public Integer getPrimaryKey() {
        return getRestaurentId();
    }

    @Override
    public void setPrimaryKey(Integer restaurentId) {
        setRestaurentId(restaurentId);
    }

    @Override
    @Transient
    @XmlTransient
    public boolean isPrimaryKeySet() {
        return isRestaurentIdSet();
    }

    // -------------------------------
    // Getter & Setter
    // -------------------------------

    // -- [restaurentId] ------------------------

    @Column(name = "RESTAURENT_ID", nullable = false, unique = true, precision = 10)
    @GeneratedValue
    @Id
    public Integer getRestaurentId() {
        return restaurentId;
    }

    public void setRestaurentId(Integer restaurentId) {
        this.restaurentId = restaurentId;
    }

    @Transient
    public boolean isRestaurentIdSet() {
        return restaurentId != null;
    }

    // -- [code] ------------------------

    @NotEmpty
    @Size(max = 10)
    @Column(name = "CODE", nullable = false, length = 10)
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    // -- [name] ------------------------

    @NotEmpty
    @Size(max = 10)
    @Column(name = "NAME", nullable = false, length = 10)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // -- [desc] ------------------------

    @Size(max = 500)
    @Column(name = "`DESC`", length = 500)
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    // -- [photoId] ------------------------

    @Column(name = "PHOTO_ID", precision = 10, insertable = false, updatable = false)
    public Integer getPhotoId() {
        return photoId;
    }

    private void setPhotoId(Integer photoId) {
        this.photoId = photoId;
    }

    // -- [isActive] ------------------------

    @Size(max = 1)
    @Column(name = "IS_ACTIVE", length = 1)
    public String getIsActive() {
        return isActive;
    }

    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }

    // -- [createdDate] ------------------------

    @NotNull
    @Column(name = "CREATED_DATE", nullable = false, length = 19)
    @Temporal(TIMESTAMP)
    @DateTimeFormat(pattern = DATE_FORMAT_PATTERN)
    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    // -- [createdBy] ------------------------

    @NotEmpty
    @Size(max = 26)
    @Column(name = "CREATED_BY", nullable = false, length = 26)
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    // -- [modifiedBy] ------------------------

    @Column(name = "MODIFIED_BY", length = 19)
    @Temporal(TIMESTAMP)
    @DateTimeFormat(pattern = DATE_FORMAT_PATTERN)
    public Date getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(Date modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    // -- [modifiedDate] ------------------------

    @Size(max = 26)
    @Column(name = "MODIFIED_DATE", length = 26)
    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    // --------------------------------------------------------------------
    // Many to One support
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-one: Restaurent.photoId ==> Photo.id
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinColumn(name = "PHOTO_ID")
    @ManyToOne(cascade = PERSIST, fetch = LAZY)
    public Photo getPhoto() {
        return photo;
    }

    /**
     * Set the photo without adding this Restaurent instance on the passed photo
     * If you want to preserve referential integrity we recommend to use
     * instead the corresponding adder method provided by Photo
     */
    public void setPhoto(Photo photo) {
        this.photo = photo;

        // We set the foreign key property so it can be used by Hibernate search by Example facility.
        if (photo != null) {
            setPhotoId(photo.getId());
        } else {
            setPhotoId(null);
        }
    }

    // --------------------------------------------------------------------
    // Many to Many
    // --------------------------------------------------------------------

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    // many-to-many: restaurent ==> categories
    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -

    /**
     * Returns the categories List.
     */
    @Cache(usage = NONSTRICT_READ_WRITE)
    @JoinTable(name = "restaurent_category", joinColumns = @JoinColumn(name = "RESTAURENT_ID"), inverseJoinColumns = @JoinColumn(name = "CATEGORY_ID"))
    @ManyToMany(cascade = PERSIST)
    public List<Category> getCategories() {
        return categories;
    }

    /**
     * Set the categories List.
     * It is recommended to use the helper method addCategory /  removeCategory
     * if you want to preserve referential integrity at the object level.
     *
     * @param categories the List of Category
     */
    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    /**
     * Helper method to add the passed category to the categories List.
     */
    public boolean addCategory(Category category) {
        return getCategories().add(category);
    }

    /**
     * Helper method to remove the passed category from the categories List.
     */
    public boolean removeCategory(Category category) {
        return getCategories().remove(category);
    }

    /**
     * Helper method to determine if the passed category is present in the categories List.
     */
    public boolean containsCategory(Category category) {
        return getCategories() != null && getCategories().contains(category);
    }

    // -----------------------------------------
    // Set defaults values
    // -----------------------------------------

    /**
     * Set the default values.
     */
    public void initDefaultValues() {
    }

    // -----------------------------------------
    // equals and hashCode
    // -----------------------------------------

    // The first time equals or hashCode is called,
    // we check if the primary key is present or not.
    // If yes: we use it in equals/hashCode
    // If no: we use a VMID during the entire life of this
    // instance even if later on this instance is assigned
    // a primary key.

    @Override
    public boolean equals(Object restaurent) {
        if (this == restaurent) {
            return true;
        }

        if (!(restaurent instanceof Restaurent)) {
            return false;
        }

        Restaurent other = (Restaurent) restaurent;
        return _getUid().equals(other._getUid());
    }

    @Override
    public int hashCode() {
        return _getUid().hashCode();
    }

    private Object _uid;

    private Object _getUid() {
        if (_uid == null) {
            if (isPrimaryKeySet()) {
                _uid = getPrimaryKey();
            } else {
                _uid = new java.rmi.dgc.VMID();
                log
                        .warn("DEVELOPER: hashCode has changed!."
                                + "If you encounter this message you should take the time to carefuly review equals/hashCode for: "
                                + getClass().getCanonicalName());
            }
        }
        return _uid;
    }

    // -----------------------------------------
    // toString
    // -----------------------------------------

    /**
     * Construct a readable string representation for this Restaurent instance.
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("restaurent.restaurentId=[").append(getRestaurentId()).append("]\n");
        result.append("restaurent.code=[").append(getCode()).append("]\n");
        result.append("restaurent.name=[").append(getName()).append("]\n");
        result.append("restaurent.desc=[").append(getDesc()).append("]\n");
        result.append("restaurent.photoId=[").append(getPhotoId()).append("]\n");
        result.append("restaurent.isActive=[").append(getIsActive()).append("]\n");
        result.append("restaurent.createdDate=[").append(getCreatedDate()).append("]\n");
        result.append("restaurent.createdBy=[").append(getCreatedBy()).append("]\n");
        result.append("restaurent.modifiedBy=[").append(getModifiedBy()).append("]\n");
        result.append("restaurent.modifiedDate=[").append(getModifiedDate()).append("]\n");
        return result.toString();
    }

    // -----------------------------------------
    // Copyable Implementation
    // (Support for REST web layer)
    // -----------------------------------------

    /**
     * Return a copy of the current object
     */
    @Override
    public Restaurent copy() {
        Restaurent restaurent = new Restaurent();
        copyTo(restaurent);
        return restaurent;
    }

    /**
     * Copy the current properties to the given object
     */
    @Override
    public void copyTo(Restaurent restaurent) {
        restaurent.setRestaurentId(getRestaurentId());
        restaurent.setCode(getCode());
        restaurent.setName(getName());
        restaurent.setDesc(getDesc());
        //restaurent.setPhotoId(getPhotoId());
        restaurent.setIsActive(getIsActive());
        restaurent.setCreatedDate(getCreatedDate());
        restaurent.setCreatedBy(getCreatedBy());
        restaurent.setModifiedBy(getModifiedBy());
        restaurent.setModifiedDate(getModifiedDate());
        if (getPhoto() != null) {
            restaurent.setPhoto(new Photo(getPhoto().getPrimaryKey()));
        }
    }
}