package jsp.org.jobportal.service;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import jakarta.servlet.http.HttpSession;
import jsp.org.jobportal.dao.PortalUserDao;
import jsp.org.jobportal.dto.ApplicantDetails;
import jsp.org.jobportal.dto.PortalUser;

@Service
public class ApplicantService {

	@Autowired
	PortalUserDao userDao;

	public String completeProfile(ApplicantDetails details, File resume, HttpSession session, ModelMap map) {
		PortalUser portalUser = (PortalUser) session.getAttribute("portalUser");
		if (portalUser == null) {
			map.put("msg", "Invalid Session");
			return "home.html";
		} else {
			String resumePath = "cloudPath";// Get from cloudinary
			details.setResumePath(resumePath);
			portalUser.setApplicantDetails(details);
			portalUser.setProfileComplete(true);
			userDao.saveUser(portalUser);
			map.put("msg", "Profile is Completed");
			return "applicant-home.html";
		}
	}

}