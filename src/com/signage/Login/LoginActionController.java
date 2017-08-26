 package com.signage.Login;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.signage.API.APICall;

import net.sf.json.JSONObject;

@Controller

public class LoginActionController {

	APICall api = new APICall();
	
	
	@RequestMapping(value="/Login" , method = RequestMethod.GET)
	public String loginGetMethod(HttpServletRequest request , HttpServletResponse response) {
		
		String page ="index";
		HttpSession session = request.getSession();
		
		return null;
	}
	@RequestMapping(value="/Login", method = RequestMethod.POST)
	public String loginPostMethod(HttpServletRequest request , HttpServletResponse response) {
		String page ="";
		//System.out.println("inside login post method");
		
		JSONObject loginObject = new JSONObject();
		loginObject.put("USER", request.getParameter("email"));
		loginObject.put("PASSWORD", request.getParameter("password"));
		String loginResponse = api.sendPost("APILogin", "Login", loginObject.toString());
		
		JSONObject loginDetails = JSONObject.fromObject(loginResponse);
		
		if(loginDetails.getJSONObject("details").getString("Login").equals("active"))
		
			{ HashMap details = new HashMap();
			details.putAll(loginDetails.getJSONObject("details"));
			
			
			
			page += "redirect:/Home";
			
			HttpSession session = request.getSession();
			session.setAttribute("details", details);
			}
		
		else {
			page +="index";
		}
		return page;
	}
	
	@RequestMapping(value ="/Logout", method = RequestMethod.GET)
	public String logoutMethod(HttpServletRequest request , HttpServletResponse response) {
		
		System.out.println("inside logout method");
		
		String page = "";
		HttpSession session = request.getSession();
		System.out.println("Logging out");
		HashMap userDetails = (HashMap) session.getAttribute("details");
		session.removeAttribute("details");
		session.invalidate();
		page="index";
		return page;
	
	}
	
	
	
}
