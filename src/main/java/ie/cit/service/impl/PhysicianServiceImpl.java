package ie.cit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ie.cit.dao.PhysicianRepository;
import ie.cit.domain.Physician;
import ie.cit.service.PhysicianService;

@Service
public class PhysicianServiceImpl implements PhysicianService{
	
	private PhysicianRepository physicianRepository;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Autowired
	public PhysicianServiceImpl(PhysicianRepository physicianRepository, BCryptPasswordEncoder passwordEncoder){
		this.physicianRepository = physicianRepository;
		this.passwordEncoder = passwordEncoder;
	}
	/**
	 * list all physicians
	 */
	public List<Physician> findAll() {
		return physicianRepository.findAll();
	}
	/**
	 * save a new Physician
	 */
	public void save(Physician physician) {
		String encodedPass = passwordEncoder.encode(physician.getPassword());
		physician.setPassword(encodedPass);
		physicianRepository.save(physician);
		
	}
	
	public Physician getById(String id) {
		return physicianRepository.getById(id);
	}

}
