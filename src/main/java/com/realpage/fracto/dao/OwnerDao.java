package com.realpage.fracto.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.realpage.fracto.entities.Property;

@Repository
public interface OwnerDao {

	
	public List<Property> getPropertiesByOwnerId(Integer ownerId);
	
	public HashMap getOwnerAllPropertyInfo(Integer ownerId);
}
