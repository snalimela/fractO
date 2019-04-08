package com.realpage.fracto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

import com.realpage.fracto.entities.Property;

public class PropertyDetailsMapper implements RowMapper<HashMap> {
	@Override
	public HashMap mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		hm.put("PropertyId",(rs.getString("property_id")));
		hm.put("PropertyName",(rs.getString("property_name")));
		hm.put("City",(rs.getString("city")));
		hm.put("State",(rs.getString("state")));
		hm.put("Country",(rs.getString("country")));
		hm.put("Description",(rs.getString("description")));
		hm.put("Price",(Double.parseDouble(rs.getString("price_sqft"))));
		hm.put("Address1",(rs.getString("address1")));
		hm.put("Address2",(rs.getString("address2")));
		hm.put("PropertyKey",(rs.getString("property_key")));
		hm.put("Area",(rs.getInt("area_sqft")));
		hm.put("zipcode",(rs.getString("zipcode")));
		return hm;
	}
}
