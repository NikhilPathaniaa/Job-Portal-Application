package jsp.org.jobportal.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jsp.org.jobportal.dao.PortalUserDao;
import jsp.org.jobportal.dto.PortalUser;

@Controller
public class GeneralController {

	@Autowired
	PortalUser portalUser;
	
	@Autowired
	PortalUserDao userDao;
	
	@GetMapping("/")
	public String load() 
	{
		return "home.html";
	}
	
	@GetMapping("/login")
	public String loadLogin() 
	{
		return "login.html";
	}		
	
	@GetMapping("/signup")
	public String loadSignup(ModelMap map) 
	{
		map.put("portalUser", portalUser);
		return "signup.html";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid PortalUser portalUser,BindingResult result)
	{
		
		if(LocalDate.now().getYear()-portalUser.getDob().getYear()<18)
			result.rejectValue("dob", "error.dob","* Age should be greater Than 18");
		if(!portalUser.getPassword().equals(portalUser.getConfirm_password()))
			result.rejectValue("confirm_password", "error.confirm_password","* Password and Confirm_password should be matching");
		
		if(result.hasErrors())
			return "signup.html";
		else
			return "login.html";
	}
}
