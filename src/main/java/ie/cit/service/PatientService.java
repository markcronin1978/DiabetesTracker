package ie.cit.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ie.cit.domain.Patient;


@Transactional
@Service
public interface PatientService {

	List<Patient> findAll();

	Patient getById(String id);

	void save(Patient patient);
	
	

	

}
