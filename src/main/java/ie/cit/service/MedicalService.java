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
	
	/**
	 * Save Patient
	 * @param patient
	 */
	void save(Patient patient);

	/**
	 * Save History
	 * @param history
	 */
	void save(History history);

	/**
	 * return specific patient history
	 * @param id
	 * @return
	 */
	History getAll(String id);
	
	/**
	 * Save regular checkup
	 * @param regularCheckUp
	 */
	void save(RegularCheckUp regularCheckUp);
	
	/**
	 * Save Yearly Checkup
	 * @param yearlyCheckup
	 */
	void save(YearlyCheckup yearlyCheckup);

	/**
	 * return regular history list of specific patient
	 * @param id
	 * @return
	 */
	List <RegularCheckUp> getRegAll(String id);
	
	/**
	 * get Patient By name
	 * @param name
	 * @return
	 */
	List<Patient> findByName(String name);
	
	/**
	 * Return a single patient by patient name
	 * @param name
	 * @return
	 */
	Patient getPatientName(String name);

	/**
	 * return yearly history list of specific patient
	 * @param id
	 * @return
	 */
	List<YearlyCheckup> getYrAll(String id);
	
		
	
}
