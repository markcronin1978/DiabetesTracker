package ie.cit.service.impl;


import java.util.List;

import ie.cit.dao.HistoryRepository;
import ie.cit.dao.PatientRepository;
import ie.cit.dao.PhysicianRepository;
import ie.cit.dao.RegularCheckUpRepository;
import ie.cit.dao.YearlyCheckupRepository;
import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.domain.RegularCheckUp;
import ie.cit.domain.YearlyCheckup;
import ie.cit.service.MedicalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class MedicalServiceImpl implements MedicalService {
	
	private PatientRepository patientRepository;
	private PhysicianRepository physicianRepository;
	private HistoryRepository historyRepository;
	private RegularCheckUpRepository regularCheckUpRepository;
	private YearlyCheckupRepository yearlyCheckupRepository;
	
	@Autowired
	public MedicalServiceImpl(PatientRepository patientRepository, PhysicianRepository physicianRepository, 
			HistoryRepository historyRepository, RegularCheckUpRepository regularCheckUpRepository,
			YearlyCheckupRepository yearlyCheckupRepository){
		this.patientRepository = patientRepository;
		this.physicianRepository = physicianRepository;
		this.historyRepository = historyRepository;
		this.regularCheckUpRepository = regularCheckUpRepository;
		this.yearlyCheckupRepository = yearlyCheckupRepository;
	}

	public List<Patient> findall(String name) {
		return patientRepository.findAll(name);
	}

	public String getName(String username) {
		return physicianRepository.getName(username);
	}

	public void save(Patient patient) {
		patientRepository.save(patient);		
	}

	public void save(History history) {
		historyRepository.save(history);		
	}

	public History getAll(String id) {
		return historyRepository.getAll(id);
	}

	public void save(RegularCheckUp regularCheckUp) {
		regularCheckUpRepository.save(regularCheckUp);
		
	}

	public void save(YearlyCheckup yearlyCheckup) {
		yearlyCheckupRepository.save(yearlyCheckup);
		
	}

	public String getPatientById(String id) {
		return patientRepository.getPatientById(id);
	}

	public List<RegularCheckUp> getRegAll(String id) {
		return regularCheckUpRepository.getRegAll(id);
	}


}
