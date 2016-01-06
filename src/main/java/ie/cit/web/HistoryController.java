package ie.cit.web;

import javax.validation.Valid;

import ie.cit.domain.History;
import ie.cit.service.HistoryService;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/historyController")
public class HistoryController {
	
	private HistoryService historyService;
	
	@Autowired
	public HistoryController(HistoryService historyService){
		this.historyService = historyService;
	}
	/**
	 * return list of patients
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String listPatient(Model model) {
		model.addAttribute("patient", historyService.findAll());
		return "historyPatientList";
	}
	
	/**
	 * get specific patient history
	 * @param model
	 * @param id
	 * @return
	 */
	@RequestMapping(value="/{id}", method=RequestMethod.GET)    
	public String editPatientHistory(Model model, @PathVariable String id) {
		model.addAttribute("history", historyService.getById(id));  
		return "editPatientHistoryForm"; 										
	}
	
	/**
	 * Save Patient History
	 * @param history
	 * @param results
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/saveHistory", method = RequestMethod.POST)
	public String addMedicalHistory(@ModelAttribute @Valid History history, BindingResult results, Model model){
		if(results.hasErrors()){
			return "editPatientHistoryForm";
		}else{
			historyService.save(history);
			return "redirect:/historyController/";
		}
	}

}
