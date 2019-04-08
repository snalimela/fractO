package com.realpage.fracto.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

import org.springframework.jdbc.core.RowMapper;

public class HashMapMapper implements RowMapper<HashMap> {

	@Override
	public HashMap mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		HashMap hm = new HashMap();
		hm.put("originalCapital", rs.getString("original_capital"));
		hm.put("increasedCapital", rs.getString("increased_captial"));
		hm.put("totalArea", rs.getString("total_area"));
		
		return hm;
	}

}
