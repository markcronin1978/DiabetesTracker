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
	 * Return list of patient by physician name
	 */
	public List<Patient> findAll(String name) {
		String sql = "SELECT * FROM patient WHERE phyname = ?";
		return jdbcTemplate.query(sql, new PatientMapper(), name);
	}
	
	/**
	 * Method to check whether to add or update patient information
	 */
	public void save(Patient patient) {
		if(searchById(patient.getId())==null){
			add(patient);
		}else{
			update(patient);
		}		
	}
	
	/**
	 * Check if patient already exists in database
	 * @param id
	 * @return
	 */
	public Patient searchById(String id){
		try{
			String sql = "SELECT * FROM patient WHERE id = ?";
			return jdbcTemplate.queryForObject(sql, new PatientMapper(), id);
		}catch(DataAccessException e){
			
		}
		return null;
	}
	
	/**
	 * Add Patient information to database
	 * @param patient
	 */
	public void add(Patient patient){
		jdbcTemplate  
		.update("INSERT INTO patient(id, name, address1, address2, address3, address4, phoneno, dateofbirth, phyname)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", patient.getId(), 
				patient.getName().toUpperCase(), patient.getAddress1(),patient.getAddress2(), 
				patient.getAddress3(), patient.getAddress4(), patient.getPhoneNumber(), patient.getDateOfBirth(), patient.getPhyName());
	}
	
	/**
	 * Update patient information in database
	 * @param patient
	 */
	public void update(Patient patient){
		jdbcTemplate
		.update("UPDATE patient SET name = ?, address1 = ?, address2 = ?, address3 = ?, "
				+ "address4 = ?, phoneno = ?, dateofbirth = ?, phyname = ?"
				+ " WHERE id = ?", patient.getName().toUpperCase(), patient.getAddress1(), patient.getAddress2(), 
				patient.getAddress3(), patient.getAddress4(), patient.getPhoneNumber(),patient.getDateOfBirth(), patient.getPhyName(), 
				patient.getId());
	}

	/**
	 * Get Patient by ID
	 */
	public String getPatientById(String id) {
		String sql = "SELECT id FROM patient WHERE id = ?";
		String id1 = (String) jdbcTemplate.queryForObject(sql, new Object[] {id}, String.class);
		return id1;
	}

	/**
	 * Return a list of patient with the same name
	 */
	public List<Patient> findByName(String name) {
		String sql = "SELECT * FROM patient WHERE name = ?";
		return jdbcTemplate.query(sql, new PatientMapper(), name);
	}
	
	/**
	 * Return an object of a specific patient
	 */
	public Patient getPatientName(String name) {
		String sql = "SELECT * FROM patient WHERE name = ?";
		return jdbcTemplate.queryForObject(sql, new PatientMapper(), name);		
	}

	/**
	 * return a list of patients in ascending order
	 */
	@Override
	public List<Patient> findAll() {
		String sql = "SELECT * FROM patient ORDER BY name ASC";
		return jdbcTemplate.query(sql, new PatientMapper());
	}
	
	/**
	 * get a specifc patient information by ID
	 */
	@Override
	public Patient getById(String id) {
		String sql = "SELECT * FROM patient WHERE id = ?";
		return jdbcTemplate.queryForObject(sql, new PatientMapper(), id);
	}

}
