package com.realpage.fracto.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realpage.fracto.dao.OwnerDao;
import com.realpage.fracto.entities.Property;

@Service
public class OwnerServiceImpl implements OwnerService {

	@Autowired
	private OwnerDao ownerDao;
	
	@Override
	public void insertOwner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOwner() {
		// TODO Auto-generated method stub
		
	}

		


	@Override
	public List<Property> getPropertiesByOwnerId(Integer ownerId) {
		// TODO Auto-generated method stub
	return ownerDao.getPropertiesByOwnerId(ownerId);	
		
	}
	public HashMap getOwnerAllPropertyInfo(Integer ownerId) {
		return ownerDao.getOwnerAllPropertyInfo(ownerId);
	}

	@Override
	public void getOwnerById() {
		// TODO Auto-generated method stub
		
	}
	

}
