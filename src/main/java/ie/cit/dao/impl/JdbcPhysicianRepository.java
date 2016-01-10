package ie.cit.dao.impl;

import java.util.List;

import javax.sql.DataSource;

import ie.cit.dao.PhysicianRepository;
import ie.cit.dao.mapper.PhysicianMapper;
import ie.cit.domain.Physician;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class JdbcPhysicianRepository implements PhysicianRepository {

	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcPhysicianRepository(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	/**
	 * Query the database for a list of all physician
	 */	
	public List<Physician> findAll() {
		String sql = "SELECT * FROM physician";
		return jdbcTemplate.query(sql, new PhysicianMapper());
	}

	/**
	 * Check whether to update or save physician
	 */
	public void save(Physician physician) {
		if (searchById(physician.getId())==null){
			add(physician);
		}else{
			update(physician);
		}		
	}
	/**
	 * searches database to check for existing Email address, 
	 * if not present catches SQL Exception and returns null
	 */
	public Physician searchById(String Id) {
		try {
			String sql = "SELECT * FROM physician WHERE Id = ?";
			return jdbcTemplate.queryForObject(sql, new PhysicianMapper(), Id);
		} catch (DataAccessException e) {

		}
		return null;
	}
	/**
	 * save new Physician information
	 * @param physician
	 */
	public void add(Physician physician) {
		jdbcTemplate  
				.update("INSERT INTO physician(id, name, address1, address2, address3, address4, telephone, username, password)"
						+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)", physician.getId(), 
						physician.getName(), physician.getAddress1(),physician.getAddress2(), 
						physician.getAddress3(), physician.getAddress4(), physician.getPhoneNumber(), physician.getUsername(), physician.getPassword());
		jdbcTemplate.update("INSERT INTO users (id, username, password, enabled)" + "VALUES (?, ?, ?, ?)", physician.getId(), physician.getUsername(), physician.getPassword(), true);
		jdbcTemplate.update("INSERT INTO authorities (id, username, authority)" + "VALUES (?, ?, ?)", physician.getId(), physician.getUsername(), "ROLE_USER");

	}
	/**
	 * update new product information
	 * @param physician
	 */
	private void update(Physician physician) {
		jdbcTemplate
				.update("UPDATE physician SET name = ?, address1 = ?, address2 = ?, address3 = ?, "
						+ "address4 = ?, telephone = ?, username = ?, password = ?"
						+ " WHERE id = ?", physician.getName(), physician.getAddress1(), physician.getAddress2(), 
						physician.getAddress3(), physician.getAddress4(), physician.getPhoneNumber(), physician.getUsername(), 
						physician.getPassword(), physician.getId());
		jdbcTemplate
				.update("UPDATE users SET username = ?, password = ?, enabled = ?" + "WHERE username = ?", 
				physician.getUsername(), physician.getPassword(), true, physician.getUsername());

	}

	/**
	 * return a physician with a specific ID
	 */
	public Physician getById(String id) {
		String sql = "SELECT * FROM physician WHERE Id = ?";
		return jdbcTemplate.queryForObject(sql, new PhysicianMapper(), id);
	}

	/**
	 * Get Physician Name by username
	 */
	public String getName(String username) {
		String sql = "SELECT name from physician WHERE username = ?";		
		String name = (String) jdbcTemplate.queryForObject(sql, new Object[] {username}, String.class);
		return name;
	}

}
