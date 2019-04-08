package com.realpage.fracto.dao;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;






import com.realpage.fracto.entities.Property;
import com.realpage.fracto.mapper.HashMapMapper;
import com.realpage.fracto.mapper.PropertyMapper;

@Repository
public class OwnerDaoImpl implements OwnerDao {

	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Property> getPropertiesByOwnerId(Integer ownerId) {
		// TODO Auto-generated method stub
		
		
		List<Property> properties = jdbcTemplate
				.query("select p.* FROM property p LEFT JOIN property_owner po ON (po.property_id = p.property_id)"
						+ "LEFT JOIN owner o ON (o.owner_id = po.owner_id)"
						+ "WHERE o.owner_id =" + ownerId, new PropertyMapper());
		return properties;
	}
	public HashMap getOwnerAllPropertyInfo(Integer ownerId) {
		
		HashMap hm = jdbcTemplate
				.queryForObject("select SUM(p.price_sqft * po.owner_share_area_sqft) as original_capital, "+
							"SUM( (p.price_sqft+p.price_sqft_variance)* po.owner_share_area_sqft) as "+
							"increased_captial, SUM(po.owner_share_area_sqft) AS total_area "+
							"FROM property p "+
							"LEFT JOIN property_owner po ON (po.property_id = p.property_id) "+
							"LEFT JOIN owner o ON (o.owner_id = po.owner_id) "+
							"WHERE o.owner_id = " + ownerId, new HashMapMapper());
		return hm;
	}
	
	
	/*@Override
	public void getPropertiesByOwnerId(Integer ownerId) {
		// TODO Auto-generated method stub
		
		Session session= null;
		try {
			
			session = sessionFactory.openSession();
			session.beginTransaction();
			Integer id =(Integer) session.save(employee);
			System.out.println("Employee is created With Id::"+id);
			String hql = "FROM Property p LEFT OUTER JOIN PropertyOwner po "+
							"LEFT OUTER JOIN Owner o "+
							"WHERE o.owner_id = "+ownerId;
			
			Query query = session.createQuery(hql);
			List results = query.list();
			System.out.println(results);
			
			session.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
	
	
	
	
}
