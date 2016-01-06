package ie.cit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.domain.Patient;


@Transactional
@Service
public interface PatientService {

	/**
	 * return patient list
	 * @return
	 */
	List<Patient> findAll();

	/**
	 * Get Patient by Id Number
	 * @param id
	 * @return
	 */
	Patient getById(String id);

	/**
	 * Save Patient
	 * @param patient
	 */
	void save(Patient patient);
	
	

	

}
