package ie.cit.dao;

import java.util.List;

import ie.cit.domain.Patient;

public interface PatientRepository {

	List<Patient> findAll(String name);

	void save(Patient patient);

	String getPatientById(String id);
	
	
	

}
