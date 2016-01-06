package ie.cit.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {
	
	/**
	 * This controller is used for the login process
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/")               
	public String login(Model model) {
		return "login"; 
	}
	
	/**
	 * Method to handle failed login
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/loginfail")           
	public String loginFail(Model model) {
		model.addAttribute("errorMsg","Login Failed!");
		return "login";
	}
	
	/**
	 * Logout method
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/logout")             
	public String logout(Model model) {
		return "login";
	}
	
	/**
	 * Accessed denied method
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/accessdenied") 
	public String accessDenied(Model model) {  
		return "accessdenied";
	}
}
