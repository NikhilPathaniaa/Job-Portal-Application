package jsp.org.jobportal.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PortalUser {

	@Size(min = 3,max = 15,message="* Enter between 3~15 charactes")
	private String name;
	@NotNull(message = "* this is required field")
	@Email(message = "* Enter Proper Email format")
	private String email;
	@DecimalMin(value="6000000000", message = "* Enter Proper Mobile Number")
	@DecimalMax(value="9999999999", message = "* Enter Proper Mobile Number")
	private long mobile;
	@NotNull(message = "* this is required field")
	private LocalDate dob;
	@Size(min = 3,max = 18,message="* Enter between 3~18 charactes")
	private String password;
	@Size(min = 3,max = 18,message="* Enter between 3~18 charactes")
	private String confirm_password; 
	@NotNull(message = "* this is required field")
	private String role;
}
