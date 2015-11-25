package ie.cit.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import ie.cit.domain.Patient;

import org.springframework.jdbc.core.RowMapper;

public class PatientMapper implements RowMapper<Patient>{
	/**
	 * here i am using RowMapper the retrieve and add the Patient information to the database
	 */
	public Patient mapRow(ResultSet rs, int rowNum) throws SQLException {
		Patient p = new Patient();
		
		p.setId(rs.getString("Id"));
		p.setName(rs.getString("name"));
		p.setAddress1(rs.getString("address1"));
		p.setAddress2(rs.getString("address2"));
		p.setAddress3(rs.getString("address3"));
		p.setAddress4(rs.getString("address4"));
		p.setPhoneNumber(rs.getString("phoneno"));
		p.setDateOfBirth(rs.getString("dateOfBirth"));
		p.setPhyName(rs.getString("phyname"));		
		return p;
	}

}
