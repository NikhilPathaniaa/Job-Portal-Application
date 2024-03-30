package jsp.org.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jsp.org.jobportal.dto.PortalUser;

public interface PortalUserRepository extends JpaRepository<PortalUser, Integer>
{

	boolean existsByEmail(String email);
}
