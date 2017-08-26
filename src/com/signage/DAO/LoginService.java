package com.signage.DAO;

import net.sf.json.JSONObject;

public interface LoginService {

	public JSONObject checkLogin(String loginDetails);
}
