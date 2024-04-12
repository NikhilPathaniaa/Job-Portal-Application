package jsp.org.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.org.jobportal.dto.PortalUser;

public interface PortalUserRepository extends JpaRepository<PortalUser, Integer>
{
	PortalUser findByMobile(long mobile);

	PortalUser findByEmail(String email);

	boolean existsByMobile(long mobile);

	boolean existsByEmailAndVerifiedTrue(String email);
}
