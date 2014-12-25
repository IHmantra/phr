package com.ihmphr.spring.web;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IhmPhrController {

	/*
	 * @RequestMapping("/") public ModelAndView handleRequest() throws Exception
	 * {
	 * 
	 * ModelAndView model = new ModelAndView("index"); return model;
	 * 
	 * 
	 * }
	 */

	@RequestMapping(value = "/profile**", method = RequestMethod.GET)
	public ModelAndView adminPage() {

		ModelAndView model = new ModelAndView();
		model.addObject("title", "Spring Security Custom Login Form");
		model.addObject("message", "This is protected page!");
		model.setViewName("profile");

		System.out.println(" Inside 1 ");
		return model;

	}

	// Spring Security see this :
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(
			@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout,
			HttpServletRequest request )

	{
		
		Exception exception = (Exception) request.getSession().getAttribute("SPRING_SECURITY_LAST_EXCEPTION");
		
		// System.out.println(" Login Error Message"+ exception.getMessage());

		System.out.println(" 111 . Value of error " + error);

		ModelAndView model = new ModelAndView();

		System.out.println(" Value of logout " + logout);

		if (error != null) {

			System.out.println(" Setting error Param ");

			model.addObject("error", "Invalid username and password!");
			
		}

		if (logout != null) {

			System.out.println(" Setting log out ");
			model.addObject("msg", "You've been logged out successfully.");
			
		}
		
		model.setViewName("login");
		
		System.out.println(" Inside 2 ");

		return model;

	}
	
	@RequestMapping( value="403", method = RequestMethod.GET )
	public ModelAndView accesssDenied(){
		
		ModelAndView model = new ModelAndView();
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (  !( auth instanceof AnonymousAuthenticationToken) ){
			
			UserDetails userDetails = ( UserDetails ) auth.getPrincipal();
			System.out.println("UserDetails :403 "+ userDetails );
			model.addObject("username",userDetails.getUsername());
			
		}
		
		model.setViewName("403");
		
		return model;
	}

}
