package ie.cit.web;

import javax.validation.Valid;

import ie.cit.domain.Physician;
import ie.cit.service.PhysicianService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/physician")
public class PhysicianController {
	
	private PhysicianService physicianService;
	
	@Autowired
	public PhysicianController(PhysicianService physicianService){
		this.physicianService = physicianService;
	}
	
	/**
	 * Display Physician List
	 * @param model
	 * @return physicianList view
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPhysicians(Model model) {
		model.addAttribute("physician", physicianService.findAll());
		return "physicianList";
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String formPhysician(Model model){
		model.addAttribute("physician", new Physician());
		return "physicianForm";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String AddPhysician(@ModelAttribute @Valid Physician physician, BindingResult results, Model model ){
		if(results.hasErrors()){
			return "physicianForm";
		}else{
			physicianService.save(physician);	
			return "redirect:/physician/";		
		}		
	}
	
	@RequestMapping(value = "/{id}/", method = RequestMethod.GET)
	public String editPhysician(Model model, @PathVariable String id){
		model.addAttribute("physician", physicianService.getById(id));
		return "physicianForm";
	}
	
}
