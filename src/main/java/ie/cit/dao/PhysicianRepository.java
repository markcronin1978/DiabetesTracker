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

	Physician getById(String id);

	String getName(String username);
	


}
