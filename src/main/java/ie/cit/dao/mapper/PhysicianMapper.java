package ie.cit.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.domain.Physician;

import org.springframework.jdbc.core.RowMapper;

public class PhysicianMapper implements RowMapper<Physician> {
	/**
	 * here i am using RowMapper the retrieve and add Physician information to the database
	 */
	public Physician mapRow(ResultSet rs, int rowNum) throws SQLException {
		Physician ph = new Physician();
		
		ph.setId(rs.getString("id"));
		ph.setName(rs.getString("name"));
		ph.setAddress1(rs.getString("address1"));
		ph.setAddress2(rs.getString("address2"));
		ph.setAddress3(rs.getString("address3"));
		ph.setAddress4(rs.getString("address4"));
		ph.setPhoneNumber(rs.getInt("telephone"));
		ph.setUsername(rs.getString("username"));
		ph.setPassword(rs.getString("password"));
		
		return ph;
	}
}

