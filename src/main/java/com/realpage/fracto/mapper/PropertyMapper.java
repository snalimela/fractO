package com.realpage.fracto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.realpage.fracto.entities.Property;

public class PropertyMapper implements RowMapper<Property> {

	@Override
	public Property mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		Property property = new Property();
		property.setPropertyId(Integer.parseInt(rs.getString("property_id")));
		property.setPropertyName(rs.getString("property_name"));
		property.setCity(rs.getString("city"));
		property.setState(rs.getString("state"));
		property.setCountry(rs.getString("country"));
		property.setDescription(rs.getString("description"));
		property.setPriceSqft(Double.parseDouble(rs.getString("price_sqft")));
		property.setAddress1(rs.getString("address1"));
		property.setAddress2(rs.getString("address2"));
		property.setKey(rs.getString("property_key"));
		property.setAreaSqft(rs.getInt("area_sqft"));
		property.setZipcode(rs.getString("zipcode"));
		return property;
	}

}
