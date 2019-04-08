package com.realpage.fracto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

public class OwnerMapper implements RowMapper<HashMap> {

	@Override
	public HashMap mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		hm.put("firstName", rs.getString("first_name"));
		hm.put("lastName", rs.getString("last_name"));
		hm.put("areaSqft", rs.getString("owner_share_area_sqft"));
		hm.put("percentage", rs.getString("owner_share_percentage"));
		return hm;
	}

}
