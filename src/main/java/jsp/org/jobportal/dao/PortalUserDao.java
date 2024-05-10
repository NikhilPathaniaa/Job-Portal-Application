package jsp.org.jobportal.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jsp.org.jobportal.dto.PortalUser;
import jsp.org.jobportal.repository.PortalUserRepository;

@Repository
public class PortalUserDao {

	@Autowired
	PortalUserRepository userRepository;

	public boolean existsByEmail(String email) {
		return userRepository.existsByEmailAndVerifiedTrue(email);
	}

	public void saveUser(PortalUser portalUser) {
		userRepository.save(portalUser);
	}

	public PortalUser findUserById(int id) {
		return userRepository.findById(id).orElse(null);
	}

	public void deleteIfExists(String email) {
		PortalUser user = userRepository.findByEmail(email);
		if (user != null)
			userRepository.delete(user);
	}

	public PortalUser findUserByMobile(long mobile) {
		return userRepository.findByMobile(mobile);
	}

	public PortalUser findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}

	public boolean existsByMobile(long mobile) {
		return userRepository.existsByMobileAndVerifiedTrue(mobile);
	}

	public List<PortalUser> fetchRecruiters() {
		return userRepository.findByRecruiterDetailsNotNull();
	}
}