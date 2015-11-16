package ie.cit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.dao.PhysicianRepository;
import ie.cit.domain.Patient;
import ie.cit.domain.Physician;
import ie.cit.service.AdminService;
import ie.cit.service.MedicalService;

@Service
public class AdminServiceImpl implements AdminService{
	
	private PhysicianRepository physicianRepository;
	
	@Autowired
	public AdminServiceImpl(PhysicianRepository physicianRepository){
		this.physicianRepository = physicianRepository;
	}

	public List<Physician> findAll() {
		return physicianRepository.findAll();
	}

}
