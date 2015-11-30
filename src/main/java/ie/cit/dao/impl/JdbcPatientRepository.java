package ie.cit.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import ie.cit.dao.PatientRepository;
import ie.cit.dao.mapper.PatientMapper;
import ie.cit.domain.Patient;


@Repository
public class JdbcPatientRepository implements PatientRepository{
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcPatientRepository(DataSource dataSource){
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	/**
	 * 
	 */
	public List<Patient> findAll(String name) {
		String sql = "SELECT * FROM patient WHERE phyname = ?";
		return jdbcTemplate.query(sql, new PatientMapper(), name);
	}
	
	/**
	 * 
	 */

	public void save(Patient patient) {
		if(searchById(patient.getId())==null){
			add(patient);
		}else{
			update(patient);
		}
		
	}
	
	public Patient searchById(String id){
		try{
			String sql = "SELECT * FROM patient WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new PatientMapper(), id);
		}catch(DataAccessException e){
			
		}
		return null;
	}
	
	public void add(Patient patient){
		jdbcTemplate  
		.update("INSERT INTO patient(id, name, address1, address2, address3, address4, phoneno, dateofbirth, phyname)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", patient.getId(), 
				patient.getName().toUpperCase(), patient.getAddress1(),patient.getAddress2(), 
				patient.getAddress3(), patient.getAddress4(), patient.getPhoneNumber(), patient.getDateOfBirth(), patient.getPhyName());
	}
	
	public void update(Patient patient){
		jdbcTemplate
		.update("UPDATE patient SET name = ?, address1 = ?, address2 = ?, address3 = ?, "
				+ "address4 = ?, phoneno = ?, dateofbirth = ?, phyname = ?"
				+ " WHERE id = ?", patient.getName().toUpperCase(), patient.getAddress1(), patient.getAddress2(), 
				patient.getAddress3(), patient.getAddress4(), patient.getPhoneNumber(),patient.getDateOfBirth(), patient.getPhyName(), 
				patient.getId());
	}

	public String getPatientById(String id) {
		String sql = "SELECT id FROM patient WHERE id = ?";
		String id1 = (String) jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
		return id1;
	}

	public List<Patient> findByName(String name) {
		String sql = "SELECT * FROM patient WHERE name = ?";
		return jdbcTemplate.query(sql, new PatientMapper(), name);
	}

	public Patient getPatientName(String name) {
		String sql = "SELECT * FROM patient WHERE name = ?";
		return jdbcTemplate.queryForObject(sql, new PatientMapper(), name);		
	}

}
