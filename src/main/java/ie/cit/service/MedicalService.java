package ie.cit.service;

import java.util.List;

import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.domain.RegularCheckUp;
import ie.cit.domain.YearlyCheckup;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public interface MedicalService {

	/**
	 * Get list of patients under a 
	 * specific Doctor Name
	 * @param name
	 * @return
	 */
	List<Patient> findall(String name);

	/**
	 * get Doctors name from username
	 * creditionals
	 * @param username
	 * @return
	 */
	String getName(String username);

	void save(Patient patient);

	void save(History history);

	History getAll(String id);

	void save(RegularCheckUp regularCheckUp);

	void save(YearlyCheckup yearlyCheckup);

	String getPatientById(String id);

	List <RegularCheckUp> getRegAll(String id);
		
	
}
