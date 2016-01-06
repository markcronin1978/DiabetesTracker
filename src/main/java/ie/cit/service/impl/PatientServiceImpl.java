package ie.cit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.dao.PatientRepository;
import ie.cit.domain.Patient;
import ie.cit.service.PatientService;


@Service
public class PatientServiceImpl implements PatientService {

	
	private PatientRepository patientRepository;
	
	@Autowired
	public PatientServiceImpl(PatientRepository patientRepository){
		this.patientRepository = patientRepository;
	}
	
	/**
	 * List all Patients
	 */
	public List<Patient> findAll() {
		return patientRepository.findAll();
	}

	/**
	 * Get Patient by ID number
	 */
	public Patient getById(String id) {
		return patientRepository.getById(id);
	}

	/**
	 * Save Patient
	 */
	public void save(Patient patient) {
		patientRepository.save(patient);
		
	}

}
