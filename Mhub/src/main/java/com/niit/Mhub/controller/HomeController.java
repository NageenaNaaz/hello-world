package com.niit.Mhub.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.niit.Mhub.dao.UserDAO;
import com.niit.Mhub.dao.UserDAOimpl;
import com.niit.Mhub.model.SignupModel;
import com.niit.Mhub.model.UserDetails;
import com.niit.Mhub.service.UserService;

@Controller
public class HomeController {

	@Autowired
	SessionFactory sessionFactory;
	@Autowired
	SessionFactory sf;
	@Autowired
	UserService us;
	@RequestMapping("/")
	public ModelAndView getHomePage() {

		ModelAndView mv = new ModelAndView("index");
		return mv;
	}
	@RequestMapping("/signup")
	public ModelAndView signup() {
		// us.insertSignupModel(sm);

		return new ModelAndView("signup", "command", new SignupModel());
	}
	@RequestMapping("/login")
	public ModelAndView login() {

		ModelAndView mv = new ModelAndView("login");
		return mv;
	}
	@RequestMapping("/ManageUsers")
	public ModelAndView ManageUsers() {

		ModelAndView mv = new ModelAndView("ManageUsers");
		return mv;
	}
	@RequestMapping("/logincheck") // from login.jsp
	public ModelAndView logincheck(HttpServletRequest request,@RequestParam(value="username")String username,@RequestParam(value="pwd")String passwd) {
		System.out.println("\nMyContoller - logincheck");
		ModelAndView mv;
		System.out.println("\nMyContoller - /loginCheck - before session factory");
		UserDAO ud = new UserDAOimpl(sessionFactory);
		System.out.println("\nMyContoller - /loginCheck - after session factory");
		HttpSession session=request.getSession();
		session.setAttribute("UNAME", username);
		
		if(ud.isValidUser(username,passwd)==true && ud.isAdminUser(username,passwd)==true) {
			System.out.println("login admin ok");
			mv=new ModelAndView("adminindex");
		}
		else if(ud.isValidUser(username,passwd)==true)
		{
			System.out.println("login user ok");
			mv=new ModelAndView("userindex");
		}
		else {
			System.out.println("login ok");			
			mv=new ModelAndView("loginerror");
		}
		return mv;	
	}
	@RequestMapping("/addcustomer")
	public ModelAndView addCustomer(@ModelAttribute("SignupModel") SignupModel sm) {
		System.out.println("in add customer");
		us.insertSignupModel(sm);

		ModelAndView mv = new ModelAndView("signup", "command", new SignupModel());
		return mv;
	}
	
	@SuppressWarnings("unused")
	@RequestMapping("/viewSignup")
	public ModelAndView viewproducts() {
		List<SignupModel> arr = us.getSignupList();
		Gson gson = new Gson();
		String json = gson.toJson(arr);
		return new ModelAndView("SignupList", "data", gson.toJson(arr));
	}
	//update and delete
			int a;
			@RequestMapping("/edit/{UserId}")
			public ModelAndView edit(@PathVariable("UserId")int pid,HttpServletRequest req) 
			 {
				System.out.println("in controller1");
				a=pid;
				System.out.println("in controller2");
				SignupModel p=new SignupModel();			
				System.out.println("in controller3");
				Session s=sf.openSession();
				SignupModel p1=(SignupModel)s.get(SignupModel.class,a);
				System.out.println("haiiiiii");
				System.out.println("p1.getUserName()"+p1.getUserName());
				ModelAndView m1 = new ModelAndView("updatesignup");
				HttpSession sess=req.getSession();
				sess.setAttribute("data1",p1);
				m1.addObject("command", p1);
				System.out.println(p1.getUserName());
				m1.addObject("data", p1);		 
				return m1;
				}
			
			@RequestMapping("edit/updatesignup")
			public ModelAndView update(@ModelAttribute("abayas")SignupModel p) 
			 {
				us.update(p);
				return new ModelAndView("redirect:/viewSignup");  
			 }
			//delete product
			@RequestMapping("/delete/{UserId}")
			 public ModelAndView delete(@PathVariable("UserId")int id) 
			 {
				us.remove(id);
				return new ModelAndView("redirect:/viewSignup");  
			 }
	//go back page
		@RequestMapping("/indexpage")
		public ModelAndView indexpage() {

			ModelAndView mv = new ModelAndView("index");
			return mv;
		}
		@RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
		public String homePage(ModelMap model) {
			model.addAttribute("user", getPrincipal());
			return "index";
		}

		@RequestMapping(value = "/admin", method = RequestMethod.GET)
		public String adminPage(ModelMap model) {
			model.addAttribute("user", getPrincipal());
			return "admin";
		}

		
		@RequestMapping(value = "/db", method = RequestMethod.GET)
		public String dbaPage(ModelMap model) {
			
			
			model.addAttribute("user", getPrincipal());
			return "dba";
		}
		@RequestMapping(value = "/Access_Denied", method = RequestMethod.GET)
		public String accessDeniedPage(ModelMap model) {
			model.addAttribute("user", getPrincipal());
			return "accessDenied";
		}

		/*@RequestMapping(value = "/login", method = RequestMethod.GET)
		public String loginPage() {
			return "login";
		}*/
		@RequestMapping(value = "/login", method = RequestMethod.GET)
	    public ModelAndView loginPage(@RequestParam(value = "error",required = false) String error,
	    @RequestParam(value = "logout", required = false) String logout) {
	         
	        ModelAndView model = new ModelAndView();
	        if (error != null) {
	            model.addObject("error", "Invalid Credentials provided.");
	        }
	 
	        if (logout != null) {
	            model.addObject("message", "Logged out from application successfully.");
	        }
	 
	        model.setViewName("login");
	        return model;
	    }
		@RequestMapping(value="/logout", method = RequestMethod.GET)
		public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
			return "redirect:/login?logout";
		}

		private String getPrincipal(){
			String userName = null;
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

			if (principal instanceof UserDetails) {
				userName = ((UserDetails)principal).getUserName();
			} else {
				userName = principal.toString();
			}
			return userName;
		}

}
