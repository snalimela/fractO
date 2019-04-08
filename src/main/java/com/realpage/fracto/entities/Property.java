package com.realpage.fracto.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Property {
	
	@Id
	@Column(name="property_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int propertyId;
	@Column(name=" property_name")
	private String propertyName;
	@Column(name="property_key")
	private String key;
	@Column(name="description")
	private String description;
	@Column(name="address1")
	private String address1;
	@Column(name="address2")
	private String address2;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="zipcode")
	private String zipcode;
	@Column(name="country")
	private String country;
	@Column(name="property_type")
	private String propertyType;
	@Column(name="area_sqft")
	private Integer AreaSqft;
	@Column(name="price_sqft")
	private Double priceSqft;
	@Column(name="no_of_units")
	private int noOfUnits;
	@Column(name="no_of_floorplans")
	private int noOfFloorplan;
	
	public int getPropertyId() {
		return propertyId;
	}
	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getPropertyType() {
		return propertyType;
	}
	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public Integer getAreaSqft() {
		return AreaSqft;
	}
	public void setAreaSqft(Integer areaSqft) {
		AreaSqft = areaSqft;
	}
	public Double getPriceSqft() {
		return priceSqft;
	}
	public void setPriceSqft(Double priceSqft) {
		this.priceSqft = priceSqft;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getNoOfUnits() {
		return noOfUnits;
	}
	public void setNoOfUnits(int noOfUnits) {
		this.noOfUnits = noOfUnits;
	}
	public int getNoOfFloorplan() {
		return noOfFloorplan;
	}
	public void setNoOfFloorplan(int noOfFloorplan) {
		this.noOfFloorplan = noOfFloorplan;
	}
	
	

}
