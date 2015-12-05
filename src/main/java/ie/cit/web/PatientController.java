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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/patientController")
public class PatientController {
	
	private PatientService patientService;
	Physician py;
	Patient p; 
	
	@Autowired
	public PatientController(PatientService patientService){
		this.patientService = patientService;
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPatient(Model model) {
		model.addAttribute("patient", patientService.findAll());
		return "editPatientList";
	}

	@RequestMapping(value="/{id}", method=RequestMethod.GET)    
	public String editPatient(Model model, @PathVariable String id) {
		model.addAttribute("patient", patientService.getById(id));  
		return "editPatientForm"; 										
	}
	
	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public String addEditPatient(@ModelAttribute @Valid Patient patient, BindingResult results, Model model){
		if(results.hasErrors()){
			return "editPatientForm";
		}else{
			patientService.save(patient);
			return "redirect:/patientController/";
		}
	}
}
