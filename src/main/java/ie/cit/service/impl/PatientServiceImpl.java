package ie.cit.service.impl;

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

}
