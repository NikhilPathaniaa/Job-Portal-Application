package jsp.org.jobportal.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;

import jakarta.servlet.http.HttpSession;
import jsp.org.jobportal.dao.PortalUserDao;
import jsp.org.jobportal.dto.ApplicantDetails;
import jsp.org.jobportal.dto.PortalUser;


@Service
public class ApplicantService {

	private Cloudinary cloudinary;
	
	@Autowired
	PortalUserDao userDao;

	public ApplicantService(@Value("${apiname}")String cloudName ,@Value("${apikey}")String cloudKey,@Value("${apisecretKey}")String secretKey){
		this.cloudinary=new Cloudinary(ObjectUtils.asMap("cloud_name",cloudName,"api_key",cloudKey,"api_secret",secretKey));
		
	}
	
	public String completeProfile(ApplicantDetails  details, MultipartFile resume, HttpSession session, ModelMap map) {
		PortalUser portalUser = (PortalUser) session.getAttribute("portalUser");
		if (portalUser == null) {
			map.put("msg", "Invalid Session");
			return "home.html";
		} else {
			 String resumePath =uploadResume(resume);
			details.setResumePath(resumePath);
			portalUser.setApplicantDetails(details);
			portalUser.setCompletedProfile(true);
			userDao.saveUser(portalUser);
			map.put("msg", "Profile is Completed");
			return "applicant.html";
		}
	}

	private String uploadResume(MultipartFile resume) {
		Map data=null;
		try {
			data=cloudinary.uploader().upload(resume.getBytes(),ObjectUtils.emptyMap());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return (String) data.get("url");
	}

}