package ie.cit.service;

import java.util.List;

import ie.cit.domain.History;
import ie.cit.domain.Patient;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public interface HistoryService {

	/**
	 * List all patients
	 * @return
	 */
	List <Patient> findAll();

	/**
	 * Get specific history
	 * @param id
	 * @return
	 */
	History getById(String id);

	/**
	 * Save Patient History
	 * @param history
	 */
	void save(History history);
	

}
