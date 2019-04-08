package com.realpage.fracto.dao;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.realpage.fracto.mapper.OwnerMapper;
import com.realpage.fracto.mapper.PropertyDetailsMapper;

@Repository
public class PropertyDaoImpl implements PropertyDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public HashMap getPropertyById(int property_id){
		HashMap properties = jdbcTemplate
				.queryForObject("select * from property where property_id ="+property_id, new PropertyDetailsMapper());
		
		List<HashMap> map= jdbcTemplate
				.query("SELECT first_name,last_name,owner_share_area_sqft,owner_share_percentage FROM owner o"+ 
" LEFT JOIN property_owner po ON (po.owner_id = o.owner_id)"+
" LEFT JOIN property p ON (p.property_id = po.property_id)"+
" WHERE p.property_id = "+property_id, new OwnerMapper());
		properties.put("owners", map);
		HashMap finalList = new HashMap();
		finalList.put("property", properties);
		return  finalList;
	}

}
