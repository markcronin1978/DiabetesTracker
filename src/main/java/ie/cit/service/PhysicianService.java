package ie.cit.service;


import ie.cit.domain.Physician;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public interface PhysicianService {

	/**
	 * List all Physician
	 * @return list of Physician
	 */
	List<Physician> findAll();
	
	/**
	 * save Physician information
	 */
	void save(Physician physician);

	/**
	 * Return Physician by Id number.
	 * @param id
	 * @return
	 */
	Physician getById(String id);

}
