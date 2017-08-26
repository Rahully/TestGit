package com.signage.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

@RestController
public class LoginController {
	
	@Autowired
	private LoginService login;
	
	@RequestMapping("APILogin/{action}")
	public String loginActionAPI(@PathVariable("action") String action, HttpServletRequest request,
			HttpServletResponse response)
	{
	
		System.out.println("hello chandan");
		JSONObject responseObject = new  JSONObject();
		
		if(action.equals("Login"))
		{
			String loginDetails = request.getParameter("data");
			responseObject.put("details", login.checkLogin(loginDetails));
			responseObject.put("code", "100");
			responseObject.put("message", "success");
			System.out.println("hii");
		}
		
		return responseObject.toString();
	}

}
