package com.virtusa.controller;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.virtusa.dao.JobSeekerDaoIf;
import com.virtusa.model.Jobseeker;
import com.virtusa.services.JobseekerServiceIface;


@Controller
public class JobseekerController {
	@Autowired
	JobSeekerDaoIf jobSeekerDaoIf;
	@Autowired
	JobseekerServiceIface jobseekerServiceIface;
	
	@RequestMapping(value="register",method=RequestMethod.POST)
	public String registerJobseeker(@RequestParam("fname") String firstname,@RequestParam("lname") String lastname,@RequestParam("email") String email,@RequestParam("phoneno") String phonenumber,@RequestParam("password") String password,@RequestParam("question") String question,@RequestParam("ans") String answer) {
		boolean result=jobseekerServiceIface.RegisterJob(firstname, lastname, email, phonenumber, password, question, answer);	
				
		if(result==true) {
			return "JobSeekerLogin";
		}
		else {
			return "JobSeekerSignUp";
		}
		
	}
	
	@RequestMapping("/insert")
	public String submitForm(@ModelAttribute("just") Jobseeker just, BindingResult br) {
		if (br.hasErrors()) {
			System.out.println(br.getAllErrors());
			return "JobSeekerSignUP";
		} else {
			String temp=jobSeekerDaoIf.generateId().trim();
			int t = Integer.parseInt(temp);
			t+=1;
			just.setId(t);
			just.setJsid("JSK-"+t);
			System.out.println("here "+temp);
			jobSeekerDaoIf.save(just);
			System.out.println(just.getEmail());
			return "JobSeekerLogin";
		}
	}
	@RequestMapping("/Test")
	public void test() {
		System.out.println("here");
	}
	@RequestMapping("/going")
	public String test1() {
		return "JobSeekerLogin";
	}
	@RequestMapping("/jobseeker")
	public String display(Model m) {
			
			m.addAttribute("just", new Jobseeker());
			
			return "JobListDisplay";
		}
		@RequestMapping("/addEmployee")
		public String loginPage() {
			return "loginPage";
		}
		@RequestMapping("/loginPage")
		public String loginPageEmp() {
			return "loginPage1";
		}
		@RequestMapping("/JobSeekerLogin")
		public String jloginpage() {
			return "JobSeekerLogin";
		}
		@RequestMapping("/JobSeekerSignUP")
	   public String jSignUp(){
			return "JobSeekerSignUP";
		}
		@RequestMapping(value = "JSValidate")
		public ModelAndView loginValid(HttpServletRequest request,@RequestParam("email") String email,@RequestParam("psw") String pwd) {
			Jobseeker jobseeker=new Jobseeker();
			jobseeker.setEmail(email);
			jobseeker.setPassword(pwd);
			String result=jobseekerServiceIface.loginValidateService(jobseeker);
			System.out.println(result);
			if(result.equals("unable to login or wrong credentials")) {
				
				
				System.out.println("Invalid crediatials");
				return new ModelAndView("JobSeekerLogin");
				
				
			} else{
				System.out.println("Correct Credialtials");
				request.getSession().setAttribute("jsid", result);
				return new ModelAndView("JSHome");
			}
			
		}
		@RequestMapping(value="redirect",method=RequestMethod.GET)
		public String redirectPage() {
			return "JSForgotPass";
		}
		@RequestMapping(value="JSForgotPass",method=RequestMethod.POST)
		public ModelAndView forgotpassword(@RequestParam("email") String email,@RequestParam("question") String question,@RequestParam("answer") String answer,@RequestParam("newpass") String password) {
        Jobseeker jobseeker=new Jobseeker();
        jobseeker.setEmail(email);
        jobseeker.setQuestion(question);
        jobseeker.setAnswer(answer);
        jobseeker.setPassword(password);
        String result=jobseekerServiceIface.forgotpass(jobseeker);
        System.out.println(result);
        if(result.equals("Sucessfully updated")) {
        	return new ModelAndView("JobSeekerLogin");
        }
        else 
        	return new ModelAndView("JSForgotPass");
		}
			@RequestMapping("/viewStatus")
		   public String jobseekerview(){
				return "viewStatus";
	
}
		@RequestMapping("/JSHome")
		   public String joblist(){
				return "JSHome";
	
		}
		@RequestMapping(value="page",method=RequestMethod.GET)
		public String redirectToEditPage() {
			return "JSEditProfile";
		}
		
		@RequestMapping(value="CHECKED",method=RequestMethod.POST)
		public ModelAndView Editpass(@RequestParam("newpass") String password,HttpServletRequest request) {
        String jid=(String)request.getSession().getAttribute("jsid");
		Jobseeker jobseeker=new Jobseeker();
        jobseeker.setJsid(jid);
        System.out.println(password);
       
        jobseeker.setPassword(password);
        String result=jobseekerServiceIface.editpass(jobseeker);
        System.out.println(result);
        if(result.equals("Sucessfully updated")) {
        	return new ModelAndView("JobSeekerLogin");
        }
        else 
        	return new ModelAndView("JSForgotPass");
		}
		
		@RequestMapping("/pass")
		   public String passchange(){
				return "JSChangePassword";
		}
		@RequestMapping("/JobSeekerProfile")
		public String jobSeekerProfile(HttpSession session,Model model) {
			Jobseeker js=jobseekerServiceIface.getJSDetails((String)session.getAttribute("jsid"));
			model.addAttribute("jobseeker",js);
			return "JobSeekerProfile";
		}
		@RequestMapping("/testg")
		public String testG(Jobseeker jobseeker,HttpSession session) {
			Jobseeker js=jobseekerServiceIface.getJSDetails((String)session.getAttribute("jsid"));
			jobseeker.setId(js.getId());
			jobseeker.setJsid(js.getJsid());
			jobseeker.setFirstName(js.getFirstName());
			jobseeker.setLastName(js.getLastName());
			jobseeker.setEmail(js.getEmail());
			jobseeker.setPassword(js.getPassword());
			jobseeker.setQuestion(js.getQuestion());
			jobseeker.setAnswer(js.getAnswer());
			jobseekerServiceIface.updateJSDetails(jobseeker);
			return "JobSeekerProfile";
		}
	}