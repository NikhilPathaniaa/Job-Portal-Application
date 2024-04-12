package jsp.org.jobportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;
import jsp.org.jobportal.dao.PortalUserDao;
import jsp.org.jobportal.dto.PortalUser;
import jsp.org.jobportal.dto.RecruiterDetails;

@Service
public class RecruiterService {

	@Autowired
	PortalUserDao userDao;

	public String saveRecruiterDetails(RecruiterDetails details, HttpSession session, ModelMap map) {
		PortalUser portalUser = (PortalUser) session.getAttribute("portalUser");
		if (portalUser == null) {
			map.put("msg", "Invalid Session");
			return "home.html";
		} else {
			portalUser.setRecruiterDetails(details);
			userDao.saveUser(portalUser);
			map.put("msg", "Profile Updated Success");
			return "recruiter-home.html";
		}
	}

	public String checkProfile(ModelMap map, HttpSession session) {
		PortalUser portalUser = (PortalUser) session.getAttribute("portalUser");
		if (portalUser == null) {
			map.put("msg", "Invalid Session");
			return "home.html";
		} else {
			if (portalUser.getRecruiterDetails() == null) {
				return "recruiter-profile.html";
			} else {
				map.put("msg", "Wait for Admins Approval");
				return "recruiter-home.html";
			}
		}
	}

}