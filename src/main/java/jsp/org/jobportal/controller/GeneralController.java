package jsp.org.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	public String signup()
	{
		return "login.html";
	}
}
