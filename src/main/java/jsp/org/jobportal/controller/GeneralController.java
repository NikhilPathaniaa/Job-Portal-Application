package jsp.org.jobportal.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

	@GetMapping("/")
	public String load() 
	{
		return "home.html";
	}
	
	@GetMapping("/home")
	public String loadHome() 
	{
		return "home.html";
	}
	
	@GetMapping("/login")
	public String loadLogin() 
	{
		return "login.html";
	}
}
