package ie.cit.service;

import ie.cit.domain.Physician;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public interface AdminService {
	
	/**
	 * List all Physician
	 * @return list of Physician
	 */
	List<Physician> findAll();
	
}