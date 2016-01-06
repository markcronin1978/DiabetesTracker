package ie.cit.dao;

import ie.cit.domain.Physician;

import java.util.List;

public interface PhysicianRepository {
	
	/**
	 * List all Physician 
	 * @return list of Physician
	 */	
	List<Physician> findAll();

	/**
	 * save a new customer
	 * @param customer
	 */
	void save(Physician physician);

	/**
	 * @param id
	 * @return get a specific patient by id
	 */
	Physician getById(String id);

	/**
	 * @param username
	 * @return name by username
	 */
	String getName(String username);
	


}
