package com.signage.DAO;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.stereotype.Component;

import net.sf.json.JSONObject;

@Component
public class LoginActionImpl implements LoginService {
	
	@Autowired
	private DataSource dataSource;
	private JdbcTemplate template;
		
	@Override
	public JSONObject checkLogin(String LoginDetails) {
		JSONObject object = JSONObject.fromObject(LoginDetails);
		JSONObject userDetails = new JSONObject();
		
		String dynamic="email_id"; 
		String regex = "^(.+)@(.+)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(object.getString("USER"));
		if(matcher.matches()){
	    	System.out.println(object.getString("USER")+ " : " + matcher.matches());	
	    }else{
	    	dynamic="mobile_no";
	    }
		
		System.out.println("In login method...Check Login");
		System.out.println("login method details::" + object);
		try {
			template = new JdbcTemplate(dataSource);

			String SQL  = "SELECT email_id, password, isActive from users where "
			                          +dynamic+"='"+object.getString("USER")+"' AND password='"+object.getString("PASSWORD")+"'";
			
			System.out.println("login query::" + SQL);

			userDetails = JSONObject.fromObject(template.queryForMap(SQL));
			
			if(userDetails.getString("isActive").equals("active"))
			{
				userDetails.put("Login", "active");
			}
			
			else{
				userDetails.put("Login","inactive");
				userDetails.put("errorMessage","Please verfiy your Email id First");
			}
			
			
			
			System.out.println("userdetails::"+userDetails);

			System.out.println("login successful");

		} catch (Exception e) {
			
			
			userDetails.put("Login","inactive");
			userDetails.put("errorMessage","Username and Password wrong");
		}

		
		return userDetails;

	}

}
