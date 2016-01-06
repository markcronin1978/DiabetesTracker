package ie.cit.dao;

import java.util.List;

import ie.cit.domain.Patient;

public interface PatientRepository {

	/**
	 * @param name
	 * @return a list of patient by name
	 */
	List<Patient> findAll(String name);

	/**
	 * Save Patient
	 * @param patient
	 */
	void save(Patient patient);

	/**
	 * @param id
	 * @return Specific patient information
	 */
	String getPatientById(String id);

	/**
	 * @param name
	 * @return list of patient by name
	 */
	List<Patient> findByName(String name);

	/**
	 * Created for testing reason
	 * @param name
	 * @return
	 */
	Patient getPatientName(String name);
	
	/**
	 * @return a list of patient
	 */
	List<Patient> findAll();

	Patient getById(String id);		
	
	

}
