package com.realpage.fracto.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.realpage.fracto.entities.Property;
import com.realpage.fracto.service.OwnerService;

@RestController
@RequestMapping(path="/v2")
public class OwnerRestController {
	
	@Autowired
	private OwnerService ownerService;
	
	@GetMapping(path = "/owner/{ownerId}", produces = "application/json")
	public String getPropertiesById(
			@PathVariable(name = "ownerId", required = true) Integer ownerId) {

		
		ObjectMapper mapper = new ObjectMapper();
		try {
			
			List<Property> properties = ownerService.getPropertiesByOwnerId(ownerId);
			HashMap hm = ownerService.getOwnerAllPropertyInfo(ownerId);
			HashMap finalInfo = new HashMap();
			finalInfo.put("properties", properties);
			finalInfo.put("growth", "2.8");
			finalInfo.put("lastMonthIncome", "$6,000.00");
			finalInfo.put("lastMonthVariance", "10"); 
			finalInfo.putAll(hm);
			return mapper.writeValueAsString(finalInfo);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	} 
	

}
