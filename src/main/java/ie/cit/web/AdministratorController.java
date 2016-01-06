package ie.cit.web;

import ie.cit.service.AdminService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/adminController")
public class AdministratorController {
	
	private AdminService adminService;
	
	@Autowired
	public AdministratorController(AdminService adminService){
		this.adminService = adminService;
	}
	
	/**
	 * this URL comes from the UserController
	 * @param model
	 * @return content view & a list of physician.
	 */
	@RequestMapping(value="/", method=RequestMethod.GET)   
	public String listPhysician(Model model) {
		model.addAttribute("physician", adminService.findAll());
		return "physicianList";
	}

}
