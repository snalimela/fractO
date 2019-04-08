package com.realpage.fracto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="property_owner")
public class PropertyOwner {

	@Id
	@Column(name="property_owner_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id; 
	
	@Column(name="property_id")
	private Integer propertyId;
	
	@Column(name="owner_id")
	private Integer ownerId;
	
	@Column(name="owner_share_area_sqft")
	private Integer ownerShareArea;
	
	@Column(name="owner_share_percentage")
	private Double ownerSharePercentage;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(Integer propertyId) {
		this.propertyId = propertyId;
	}
	public Integer getOwnerId() {
		return ownerId;
	}
	public void setOwnerId(Integer ownerId) {
		this.ownerId = ownerId;
	}
	public Integer getOwnerShareArea() {
		return ownerShareArea;
	}
	public void setOwnerShareArea(Integer ownerShareArea) {
		this.ownerShareArea = ownerShareArea;
	}
	public Double getOwnerSharePercentage() {
		return ownerSharePercentage;
	}
	public void setOwnerSharePercentage(Double ownerSharePercentage) {
		this.ownerSharePercentage = ownerSharePercentage;
	}
	
	
}
