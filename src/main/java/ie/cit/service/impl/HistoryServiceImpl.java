package ie.cit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.dao.HistoryRepository;
import ie.cit.dao.PatientRepository;
import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.service.HistoryService;


@Service
public class HistoryServiceImpl implements HistoryService {

	private PatientRepository patientRepository;
	private HistoryRepository historyRepository;
	
	@Autowired
	public HistoryServiceImpl(PatientRepository patientRepository,HistoryRepository historyRepository){
		this.patientRepository = patientRepository;
		this.historyRepository = historyRepository;
	}
	
	/**
	 * return list of patients
	 */
	public List<Patient> findAll(){
		return patientRepository.findAll();
	}

	/**
	 * Return history of specific patient
	 */
	public History getById(String id) {
		return historyRepository.getById(id);
	}
	
	/**
	 * Save History
	 */
	public void save(History history) {
		historyRepository.save(history);		
	}

}
