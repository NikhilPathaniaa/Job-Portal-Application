package jsp.org.jobportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jsp.org.jobportal.repository.PortalUserRepository;

@Component
public class PortalUserDao {

	@Autowired
	PortalUserRepository userRepository;
	
	public boolean existsByEmail(String email)
	{
		return userRepository.existsByEmail(email);
	}
}
