package jsp.org.jobportal.controller;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import jakarta.validation.Valid;
import jsp.org.jobportal.dto.PortalUser;

@Controller
public class GeneralController {

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
	public String loadSignup() 
	{
		return "signup.html";
	}
	
	@PostMapping("/signup")
	public String signup(@Valid PortalUser user,BindingResult result)
	{
		if(LocalDate.now().getYear()-user.getDob().getYear()<18)
			result.rejectValue("dob", "error.dob","* Age should be greater Than 18");
		if(!user.getPassword().equals(user.getConfirm_password()))
			result.rejectValue("confirm_password", "error.confirm_password","* Password and Confirm_password should be matching");
		return "login.html";
	}
}
