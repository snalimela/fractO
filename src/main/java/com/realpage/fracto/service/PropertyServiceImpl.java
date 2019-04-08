package com.realpage.fracto.service;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realpage.fracto.dao.PropertyDao;

@Service
public class PropertyServiceImpl implements PropertyService{
	
	@Autowired
	private PropertyDao propertyDao;
	
	
	public void getOwnerByPropertyId(){
		
	}
	
	public void insertProperty(){
		
	}
	
	public void updateProperty(){
		
	}

	@Override
	public HashMap getPropertyById(int propertyId) {
		return propertyDao.getPropertyById(propertyId);
	}

}
