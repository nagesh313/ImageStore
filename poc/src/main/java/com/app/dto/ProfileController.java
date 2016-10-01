package com.app.dto;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.MediaType;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HttpServletBean;

@RestController
@Transactional
public class ProfileController {
	@Autowired
	private SessionFactory session;

	@RequestMapping(value = "getProfiles", produces = MediaType.APPLICATION_JSON_VALUE)
	public List getProfiles() {
		return session.getCurrentSession().createQuery("from Profile").list();
	}
	
	@RequestMapping(value="addProfile",method = RequestMethod.POST,headers ="Accept=multipart/form-data", consumes={"multipart/form-data"})
    public void updateProjectDetails(HttpServletRequest request, HttpServletResponse response, @RequestParam MultipartFile file ,@RequestParam String description){
		Profile pro=new Profile();
		pro.setFirstName(description);
		try {
			pro.setProfilePic(file.getBytes());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		session.getCurrentSession().save(pro);
		System.out.println( "asdfasdf");
	}

	/*@RequestMapping(value = { "/add-document-{userId}" }, method = RequestMethod.GET)
    public String addDocuments(@PathVariable int userId, ModelMap model) {
        User user = userService.findById(userId);
        model.addAttribute("user", user);	
 
        FileBucket fileModel = new FileBucket();
        model.addAttribute("fileBucket", fileModel);
 
        List<UserDocument> documents = userDocumentService.findAllByUserId(userId);
        model.addAttribute("documents", documents);
         
        return "managedocuments";
    }*/
}




