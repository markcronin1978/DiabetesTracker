package ie.cit.web;



import javax.validation.Valid;
import ie.cit.domain.History;
import ie.cit.domain.Patient;
import ie.cit.domain.Physician;
import ie.cit.domain.RegularCheckUp;
import ie.cit.domain.YearlyCheckup;
import ie.cit.service.MedicalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/medicalController")
public class MedicalController {
	
	private MedicalService medicalService;
	Patient p = new Patient();
	RegularCheckUp rc;
	Patient patient;
	Physician physician;
	History history;

	
	@Autowired
	public  MedicalController(MedicalService medicalService){
		this.medicalService = medicalService;
	} 
	
	/**
	 * Method requests all patients who are in the care of the logged in physician 
	 * to be return to the .jsp page
	 * @param model
	 * @return a list of physicians own patients
	 */	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	private String getUserDetails(Model model) {
		   UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().
		   getAuthentication().getPrincipal();
		   
		   /**Here i am getting the physicians Name  from the user login details**/
		   
		   String name = medicalService.getName(userDetails.getUsername());
		   physician = new Physician();
		   physician.setName(name);   /**Here i am declaring that the physicians name for the patient**/
		   rc = new RegularCheckUp();
		   

		   model.addAttribute("patient", medicalService.findall(physician.getName()));
		   return "patientList";		   
	}
	/**
	 * Add new patient
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String AddPatient(Model model){
		model.addAttribute("patient", new Patient());
		return "patientForm";
	}
	/**
	 * Save new patient to database
	 * @param patient
	 * @param results
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/savePatient", method = RequestMethod.POST)
	public String AddPatient(@ModelAttribute @Valid Patient patient, BindingResult results, Model model){
		if(results.hasErrors()){
			return "patientForm";
		}else{
			patient.setPhyName(physician.getName());
			medicalService.save(patient);
			p.setId(patient.getId());
			return "redirect:/medicalController/medicalHistoryView/";
		}
	}
	
	/**
	 * return new medical history form to be created
	 * after new patient is saved
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/medicalHistoryView/", method = RequestMethod.GET)
	public String AddMedicalHist(Model model){
		model.addAttribute("history", new History());
		return "medicalHistForm";
		
	}
	
	/**
	 * save medical History form
	 * @param history
	 * @param results
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/medicalHistory", method = RequestMethod.POST)
	public String addMedicalHistory(@ModelAttribute @Valid History history, BindingResult results, Model model){
		if(results.hasErrors()){
			return "medicalHistForm";
		}else{
			history.setPatientId(p.getId());
			medicalService.save(history);
			return "redirect:/medicalController/";
		}
	}	

	/**
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String ViewMedicalHistory(Model model, @PathVariable String id){
		model.addAttribute("history", medicalService.getAll(id));
		return "medicalHist";
	}
	**/
	
	/**
	 * create and return regular check-up form for patient with
	 * id equal to {id}
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/regularCheckup/{id}", method = RequestMethod.GET)
	public String RegularCheckUp(Model model, @PathVariable String id){
		rc.setPatientId(id);
		model.addAttribute("regularCheckUp", new RegularCheckUp());		
		return "regularCheckup";
	}
	
	/**
	 * Save regular check-up form
	 * @param regularCheckUp
	 * @param results
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveRegCheckup", method = RequestMethod.POST)
	public String AddWeight(@ModelAttribute @Valid RegularCheckUp regularCheckUp, BindingResult results, Model model){
		if(results.hasErrors()){
			return "regularCheckup";
		}else{
			regularCheckUp.setPatientId(rc.getPatientId());
			medicalService.save(regularCheckUp);			
			return "redirect:/medicalController/";
		}
	}
	
	@RequestMapping(value = "/yearlyCheckUp", method = RequestMethod.GET)
	public String YearlyCheckUp(Model model){
		String Error_msg = "Regular Consultation Must be conducted Prior to a Yearly Consultation";
		
		if(rc.getPatientId()==null){
			model.addAttribute("patient", medicalService.findall(physician.getName()));
			model.addAttribute("Error_msg", Error_msg);
			return "patientList";
		}else{
			model.addAttribute("yearlyCheckup", new YearlyCheckup());
			return "yearlyCheckUp";
		}
	}
	
	@RequestMapping(value = "/saveYearlyCheckup", method = RequestMethod.POST)
	public String SaveYearlyCheckUp(@ModelAttribute @Valid YearlyCheckup yearlyCheckup, BindingResult results, Model model){
		if(results.hasErrors()){
			return "yearlyCheckUp";
		}else{
			yearlyCheckup.setPatientId(rc.getPatientId());
			medicalService.save(yearlyCheckup);
			RegularCheckUp rc = new RegularCheckUp();
			return "redirect:/medicalController/medicalHistoryView/";
		}
		
	}
	
	/**
	 * Display patient history
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/history/{id}", method = RequestMethod.GET)
	public String ViewMedicalHistory(Model model, @PathVariable String id){
		model.addAttribute("history", medicalService.getAll(id));
		model.addAttribute("regHist", medicalService.getRegAll(id));
		return "history";
	}

}
