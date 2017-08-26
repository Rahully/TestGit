package com.signage.masjid.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.json.JSONObject;

@RestController
public class MasjidAddController {

	@Autowired
	private AddMasjidService add;

	@RequestMapping("APIMasjid/{action}")
	public String addActionAPI(@PathVariable("action") String action, HttpServletRequest request,
			HttpServletResponse response) {

		JSONObject object = new JSONObject();

		/*
		 * <===========================================MASJID===========================================>
		 */

		if (action.equals("AddMasjid")) {
			String masjidDetails = request.getParameter("data");
			System.out.println("masjid details::" + masjidDetails);
			object.put("details", add.addMasjid(masjidDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("masjid added");

		}

		if (action.equals("ViewMasjidList")) {
			System.out.println("viewing list");
			String listDetails = request.getParameter("data");
			object.put("details", add.viewMasjidList(listDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("masjid list are--->");

		}

		if (action.equals("ViewMasjid")) {
			System.out.println("fetching particular masjid");

			JSONObject masjidData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewMasjid(masjidData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("masjid details are--->");

		}
		if (action.equals("EditMasjid")) {
			System.out.println("editing masjid details");
			JSONObject editDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.editMasjid(editDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("Masjid Details modified");

		}

		if (action.equals("DeleteMasjid")) {
			System.out.println("deleting masjid details");
			String deleDetails = request.getParameter("data");
			System.out.println("delete details::" + request.getParameter("data"));
			JSONObject deleteDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.deleteMasjid(deleDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("Masjid deleted ");

		}

		/*
		 * <===========================================DEVICE===========================================>
		 */

		if (action.equals("AddDevice")) {
			System.out.println("adding device");
			String deviceDetails = request.getParameter("data");
			object.put("details", add.addDevice(deviceDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("device added");

		}

		if (action.equals("ViewDeviceList")) {
			System.out.println("viewing device list");
			String listDetails = request.getParameter("data");
			object.put("details", add.viewDeviceList(listDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("device list are--->");
		}
		
		
		if (action.equals("Viewdevice")) {
			System.out.println("fetching particular device");

			JSONObject slideShowData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewDevice(slideShowData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slideshow details are--->");
		}
		
		if (action.equals("EditDevice")) {
			System.out.println("editing device details");
			JSONObject editDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.editDevice(editDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("Masjid Details modified");

		}
		
		
		if (action.equals("Deletedevice")) {
			System.out.println("deleting device details");
			String deleDetails = request.getParameter("data");
			System.out.println("delete details::" + request.getParameter("data"));
			JSONObject deleteDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.deleteDevice(deleDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("Masjid deleted ");

		}
		
		
		if(action.equals("APICode"))
		{
			System.out.println(" device code");
            JSONObject deviceData = JSONObject.fromObject(request.getParameter("data"));
		//	String  deviceData = request.getParameter("data");
			object.put("details", add.deviceCode(deviceData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("device code is--->");
			
			
		}

		/*
		 * <===========================================SLIDESHOW================ ===========================>
		 */

		if (action.equals("AddSlideShow")) {

			System.out.println("adding slideshow");
			String slideshowdetails = request.getParameter("data");

			object.put("details", add.addSlideShow(slideshowdetails));
			object.put("code", "100");
			object.put("message", "success");

			System.out.println("slideshow added");

		}

		if (action.equals("ViewSlideShow")) {
			String listDetails = request.getParameter("data");
			object.put("details", add.viewSlideShow("data"));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slideshow list are");

		}

		if (action.equals("ViewSlide")) {
			System.out.println("fetching particular slideshow");

			JSONObject slideShowData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewSlideShow(slideShowData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slideshow details are--->");
		}

		if (action.equals("EditSlideShow")) {
			System.out.println("editing slideshow details");
			JSONObject editDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.editSlideShow(editDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slideshow Details modified");

		}

		if (action.equals("DeleteSlideShow")) {
			System.out.println("deleting slideshow details");
			String deleDetails = request.getParameter("data");
			System.out.println("delete details::" + request.getParameter("data"));
			JSONObject deleteDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.deleteSlideShow(deleDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slideshow deleted ");

		}

		/*
		 * <===========================================USERS==================== =======================>
		 */

		if (action.equals("Adduser")) {
			System.out.println("adding users");
			JSONObject userDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.addUsers(userDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("add user details::"+object.toString());
			System.out.println("user added sucessfully");

		}

		if (action.equals("ViewUserList")) {

			System.out.println("viewing users list");
			String listDetails = request.getParameter("data");
			object.put("details", add.viewUserList(listDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("users list are--->");

		}

		if (action.equals("ViewUser")) {

			System.out.println("fetching particular user");

			JSONObject slideShowData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewUser(slideShowData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slideshow details are--->");

		}

		if (action.equals("EditUser")) {
			System.out.println("editing users details");
			JSONObject editDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.editUser(editDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("user Details modified");

		}

		if (action.equals("DeleteUser")) {
			System.out.println("deleting user details");
			String deleDetails = request.getParameter("data");
			System.out.println("delete details::" + request.getParameter("data"));
			JSONObject deleteDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.deleteUser(deleDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("user deleted ");

		}

		/*
		 * <===========================================APP-VERSIONS===========================================>
		 */

		if (action.equals("AddVesrion")) {
			System.out.println("adding new app version");
			String appVersionDetails = request.getParameter("data");
			object.put("details", add.addAppVersion(appVersionDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println(" new app version added");

		}

		if (action.equals("ViewAppVersion")) {
			System.out.println("viewing app version");

			String listDetails = request.getParameter("data");
			object.put("details", add.viewAppversionList(listDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("users list are--->");

		}

		if (action.equals("ViewVersion")) {
			System.out.println("fetching particular version");

			JSONObject slideShowData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewAppversion(slideShowData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("version  details are--->");
		}

		if (action.equals("EditAppVersionDetails")) {
			System.out.println("editing particular version");

			JSONObject slideShowData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.editAppVersionDetails(slideShowData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("version  details are--->");
		}

		if (action.equals("DeleteAppVersion")) {
			System.out.println("deleting app version details");
			String deleDetails = request.getParameter("data");
			System.out.println("delete details::" + request.getParameter("data"));
			JSONObject deleteDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.deleteAppVersion(deleDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("app version deleted ");

		}

		/*
		 * <===========================================DASHBOARD===========================================>
		 */

		if (action.equals("DashBoard")) {
			System.out.println("fetiching details");
			JSONObject dashboardDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewDasboardDetails(dashboardDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("details are-->");

		}
		
		/*<=================================================Slide==============================================>*/
		
		if (action.equals("AddSlide")) {
			System.out.println("adding new slide");
			//String slideDetails = request.getParameter("data");
			JSONObject slideDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.addSlide(slideDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println(" new slide added");

		}
		
		
		if (action.equals("ViewSlidList")) {
			System.out.println("viewing slide list");

			
			JSONObject listDetails = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewSlideList(listDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slide list are--->");

		}
		
		
		if (action.equals("ViewSlide")) {
			System.out.println("fetching particular slide");

			JSONObject slideShowData = JSONObject.fromObject(request.getParameter("data"));
			object.put("details", add.viewSlide(slideShowData));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slide  details are--->");
		}
		

		if (action.equals("DeleteSlide")) {
			System.out.println("deleting slide details");
			String deleDetails = request.getParameter("data");
			System.out.println("delete details::" + request.getParameter("data"));
			JSONObject deleteDetails = JSONObject.fromObject(request.getParameter("data"));

			object.put("details", add.deleteSlide(deleDetails));
			object.put("code", "100");
			object.put("message", "success");
			System.out.println("slide deleted ");

		}
		
		
		return object.toString();
	}

}
