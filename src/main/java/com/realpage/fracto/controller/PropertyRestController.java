package com.realpage.fracto.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realpage.fracto.service.PropertyService;

@RestController
@RequestMapping(value="/v2")
public class PropertyRestController {
	
	@Autowired
	private PropertyService propertyService;
	
	
	@GetMapping(path="/property/{propertyId}", produces = "application/json")
    public HashMap getEmployees(@PathVariable int propertyId ) 
    {
		return propertyService.getPropertyById(propertyId);
    }
}
