package ie.cit.web;

import javax.validation.Valid;

import ie.cit.domain.Patient;
import ie.cit.domain.Physician;
import ie.cit.service.PatientService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/patient")
public class PatientController {
	
	private PatientService patientService;
	Physician py;
	Patient p; 
	
	@Autowired
	public PatientController(PatientService patientService){
		this.patientService = patientService;
	}

}
