package com.realpage.fracto.service;

import java.util.HashMap;
import java.util.List;

import com.realpage.fracto.entities.Property;


public interface OwnerService {
	
	public void insertOwner(); 

	public void updateOwner();

	public void getOwnerById();

	public List<Property> getPropertiesByOwnerId(Integer ownerId); 
	
	public HashMap getOwnerAllPropertyInfo(Integer ownerId);

}
