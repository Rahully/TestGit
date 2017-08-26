package com.signage.masjid.DAO;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public interface AddMasjidService {

	public int addUsers(JSONObject addUserDetails);

	public int addMasjid(String addMasjidDetails);

	public int addDevice(String addDeviceDetails);

	public int addAppVersion(String addAppversion);
	
	public int addSlide(JSONObject addSlide);

	public JSONArray viewMasjidList(String viewList);

	public JSONArray viewDeviceList(String viewList);

	public int addSlideShow(String addslideshow);

	public JSONArray viewUserList(String viewList);

	public JSONArray viewAppversionList(String viewList);
	
	public JSONArray viewSlideList(JSONObject slideList);

	public JSONArray viewSlideShow(String viewList);

	public int editMasjid(JSONObject masjidDetails);

	public int editSlideShow(JSONObject masjidDetails);

	public int editAppVersionDetails(JSONObject appversionDetails);

	public int deleteSlideShow(String deleteSlideshow);

	public int deleteMasjid(String deletemasjid);

	public int deleteAppVersion(String deleteAppVersion);

	public int deleteUser(String deleteUser);
	
	public int deleteSlide(String deleteSlide);

	public int editUser(JSONObject userDetails);

	public int editDevice(JSONObject deviceDetails);

	public JSONObject viewDasboardDetails(JSONObject details);

	public JSONObject viewMasjid(JSONObject masjidData);

	public JSONObject viewSlideShow(JSONObject slideshowData);

	public JSONObject viewAppversion(JSONObject appVersionData);

	public JSONObject viewUser(JSONObject userData);

	public JSONObject viewDevice(JSONObject userData);
	
	public JSONObject viewSlide(JSONObject slideData);

	public int deleteDevice(String deleteDevice);
	
	public JSONObject deviceCode(JSONObject code);

}
