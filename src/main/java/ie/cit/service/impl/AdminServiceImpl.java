package ie.cit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.dao.PhysicianRepository;
import ie.cit.domain.Physician;
import ie.cit.service.AdminService;


@Service
public class AdminServiceImpl implements AdminService{
	
	private PhysicianRepository physicianRepository;
	
	@Autowired
	public AdminServiceImpl(PhysicianRepository physicianRepository){
		this.physicianRepository = physicianRepository;
	}

	/**
	 * Return list of physicians
	 */
	public List<Physician> findAll() {
		return physicianRepository.findAll();
	}

}
