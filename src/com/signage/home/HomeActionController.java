package com.signage.home;


import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.signage.API.APICall;
import com.signage.API.PropertiesReader;

import net.sf.json.JSONObject;

@Controller
public class HomeActionController {

	private APICall api = new APICall();
	
	

	@RequestMapping(value = "/{action}", method = RequestMethod.GET)
	public String homeGetMethod(@PathVariable("action") String action, HttpServletRequest request,
			HttpServletResponse response) {

		String page = " ";
		if (action.equals("Home")) {
			page = "/Dashboard";
			
			  JSONObject parameter = new JSONObject(); 
			 String ViewResponse = api.sendGet("APIMasjid","DashBoard",parameter.toString());
			 JSONObject dashBoardDetails =JSONObject.fromObject(ViewResponse);
			  request.setAttribute("dasboardDetails", dashBoardDetails.getJSONObject("details"));
			 
		}

		if (action.equals("AddMasjid"))
			page = "/addnew_masjid";
		if (action.equals("AddDevice")) {
			page = "/addnew_device";
			
			
			
			JSONObject parameter = new JSONObject();
			String ViewResponse = api.sendGet("APIMasjid", "ViewMasjidList", parameter.toString());
			System.out.println("view response::" + ViewResponse);
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("masjid_Details", ListDetails.getJSONArray("details"));
			String slideshow = api.sendGet("APIMasjid", "ViewSlideShow", parameter.toString());
			JSONObject slideShowDetails = JSONObject.fromObject(slideshow);

			request.setAttribute("slideshowDetails", slideShowDetails.getJSONArray("details"));

			String appVersion = api.sendGet("APIMasjid", "ViewAppVersion", parameter.toString());
			JSONObject appVersionDetails = JSONObject.fromObject(appVersion);
			request.setAttribute("appVersionDetails", appVersionDetails.getJSONArray("details"));
			

			String code = api.sendGet("APIMasjid", "APICode", parameter.toString());
			
			JSONObject codeDetails = JSONObject.fromObject(code);
			request.setAttribute("deviceCode", codeDetails.getJSONObject("details"));

		}
		if (action.equals("AddSlideShow")) {
			page = "/addnew_slideshow";

			JSONObject parameter = new JSONObject();
			String ViewResponse = api.sendGet("APIMasjid", "ViewMasjidList", parameter.toString());
			System.out.println("view response::" + ViewResponse);
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("masjid_Details", ListDetails.getJSONArray("details"));

		}

		if (action.equals("AddNewUser")) {
			page = "/addnew_user";

			JSONObject parameter = new JSONObject();
			String ViewResponse = api.sendGet("APIMasjid", "ViewMasjidList", parameter.toString());
			System.out.println("view response::" + ViewResponse);
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("masjid_Details", ListDetails.getJSONArray("details"));

		}
		if (action.equals("AddAppVersion")) {
			page = "/addnew_appversion";

		}

		if (action.equals("AddNewSlide")) {
			page = "addnew_slide";
			System.out.println("adding new slide");

			JSONObject parameter = new JSONObject();
			String ViewResponse = api.sendGet("APIMasjid", "ViewMasjidList", parameter.toString());
			System.out.println("view response::" + ViewResponse);
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("masjid_Details", ListDetails.getJSONArray("details"));
			String slideshow = api.sendGet("APIMasjid", "ViewSlideShow", parameter.toString());
			JSONObject slideShowDetails = JSONObject.fromObject(slideshow);

			request.setAttribute("slideshowDetails", slideShowDetails.getJSONArray("details"));

		}
		if (action.equals("EditMasjid")) {
			page = "edit_masjid";
			System.out.println("mid::" + request.getParameter("mid"));
			JSONObject parameter = new JSONObject();
			parameter.put("masjidID", request.getParameter("mid"));
			String ViewResponse = api.sendGet("APIMasjid", "ViewMasjid", parameter.toString());
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("masjid_Details", ListDetails.getJSONObject("details"));
		}
		if (action.equals("EditSlideShow")) {
			page = "edit_slideshow";
			System.out.println("sid::" + request.getParameter("sid"));
			JSONObject parameter = new JSONObject();
			parameter.put("SID", request.getParameter("sid"));
			String ViewResponse = api.sendGet("APIMasjid", "ViewSlide", parameter.toString());
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("slideDetails", ListDetails.getJSONObject("details"));
		}
		if (action.equals("EditDevice")) {
			page = "edit_device";
			
			
			JSONObject parameter = new JSONObject();
			String ViewResponse = api.sendGet("APIMasjid", "ViewMasjidList", parameter.toString());
			System.out.println("view response::" + ViewResponse);
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("masjid_Details", ListDetails.getJSONArray("details"));
			
			 parameter = new JSONObject();
			parameter.put("id", request.getAttribute("id"));

			 ViewResponse = api.sendGet("APIMasjid", "ViewSlideShow", parameter.toString());
			ListDetails = JSONObject.fromObject(ViewResponse);
		
			request.setAttribute("slideshowDetails", ListDetails.getJSONArray("details"));
			
			parameter = new JSONObject();
			 ViewResponse = api.sendGet("APIMasjid", "ViewAppVersion", parameter.toString());
			 ListDetails = JSONObject.fromObject(ViewResponse);

			request.setAttribute("appVersionDetails", ListDetails.getJSONArray("details"));
			
			System.out.println("DID::" + request.getParameter("did"));
			 parameter = new JSONObject();
			parameter.put("DID", request.getParameter("did"));
			 ViewResponse = api.sendGet("APIMasjid", "Viewdevice", parameter.toString());
			 ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("deviceDetails", ListDetails.getJSONObject("details"));
		}

		if (action.equals("EditUser")) {
			page = "edit_user";

			System.out.println("UID::" + request.getParameter("uid"));
			JSONObject parameter = new JSONObject();
			parameter.put("UID", request.getParameter("uid"));
			String ViewResponse = api.sendGet("APIMasjid", "ViewUser", parameter.toString());
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("userDetails", ListDetails.getJSONObject("details"));

		}
		if (action.equals("MyProfile"))
			page = "user_profile";
		if (action.equals("EditAppVersion")) {
			page = "edit_appversion";
			System.out.println("aid::" + request.getParameter("aid"));
			JSONObject parameter = new JSONObject();
			parameter.put("AID", request.getParameter("aid"));
			String ViewResponse = api.sendGet("APIMasjid", "ViewVersion", parameter.toString());
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("appVersionDetails", ListDetails.getJSONObject("details"));

		}
		
		
		
		if(action.equals("EditSlide"))
		{
			page= "edit-slide";
			
			System.out.println("SLIDEID::" + request.getParameter("id"));
			JSONObject parameter = new JSONObject();
			parameter.put("SLIDEID", request.getParameter("id"));
			String ViewResponse = api.sendGet("APIMasjid", "ViewSlide", parameter.toString());
			JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
			request.setAttribute("slideDetails", ListDetails.getJSONObject("details"));
			
		}
		

		return page;
	}
	
	@RequestMapping(value = "/AddMasjid", method = RequestMethod.POST)

	public String AddPostMasjid(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("adding masjid details");
		String page = "";
		JSONObject object = new JSONObject();
		System.out.println("masjid name::" + request.getParameter("masjid"));
		object.put("MasjidName", request.getParameter("masjid"));
		object.put("Street", request.getParameter("street"));
		object.put("City", request.getParameter("city"));
		object.put("State", request.getParameter("state"));
		object.put("Zipcode", request.getParameter("zipcode"));
		System.out.println("object details::" + object.toString());

		String addResponse = api.sendPost("APIMasjid", "AddMasjid", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(addResponse);

		HashMap details = new HashMap();

		page = "redirect:/ViewMasjidList";

		return page;
	}

	@RequestMapping(value = "/ViewMasjidList", method = RequestMethod.GET)
	public String viewMasjid(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside view masjid method");
		String page = "/masjid_list";
		HttpSession session = request.getSession();
		JSONObject parameter = new JSONObject();
		String ViewResponse = api.sendGet("APIMasjid", "ViewMasjidList", parameter.toString());
		JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
		request.setAttribute("masjid_Details", ListDetails.getJSONArray("details"));
		return page;
	}

	@RequestMapping(value = "/EditMasjidDetails", method = RequestMethod.POST)
	public String editMasjidDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("editing masjid details");

		String page = "";

		JSONObject parameter = new JSONObject();

		System.out.println("masjidID::" + request.getParameter("mid"));
		parameter.put("MID", request.getParameter("mid"));

		parameter.put("MasjidName", request.getParameter("masjid_name"));
		parameter.put("Street", request.getParameter("street"));
		parameter.put("City", request.getParameter("city"));
		parameter.put("State", request.getParameter("state"));

		String editDetails = api.sendPost("APIMasjid", "EditMasjid", parameter.toString());
		JSONObject editResponse = JSONObject.fromObject(editDetails);
		System.out.println("json::" + editResponse.toString());
		if (editResponse.getInt("details") > 0) {

			page = "redirect:/ViewMasjidList";

		}

		return page;
	}

	@RequestMapping(value = "/EditVersionDetails", method = RequestMethod.POST)
	public String editAppVersionDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("editing version details");

		String page = "";

		JSONObject parameter = new JSONObject();

		System.out.println("AID::" + request.getParameter("aid"));
		parameter.put("AID", request.getParameter("aid"));

		parameter.put("Version", request.getParameter("version"));
		parameter.put("VersionDate", request.getParameter("version_date"));
		parameter.put("Description", request.getParameter("description"));

		String editDetails = api.sendPost("APIMasjid", "EditAppVersionDetails", parameter.toString());
		JSONObject editResponse = JSONObject.fromObject(editDetails);
		System.out.println("json::" + editResponse.toString());
		if (editResponse.getInt("details") > 0) {

			page = "redirect:/ViewAppVersionList";

		}

		return page;
	}

	@RequestMapping(value = "/DeleteMasjid", method = RequestMethod.GET)
	public String deleteMasjidDetails(HttpServletRequest request, HttpServletResponse response) {

		String page = "";
		System.out.println("inside delete controller");
		JSONObject object = new JSONObject();
		object.put("masjidID", request.getParameter("mid"));

		System.out.println("id ::" + request.getParameter("mid"));

		System.out.println("masjid id::" + object);

		String deleteMasjid = api.sendGet("APIMasjid", "DeleteMasjid", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(deleteMasjid);
		if (responseDetails.getInt("details") > 0) {

			page = "redirect:/ViewMasjidList";

		}

		return page;
	}

	@RequestMapping(value = "/AddDevice", method = RequestMethod.POST)
	public String AddPostDevice(HttpServletRequest request, HttpServletResponse response) {

		String page = "";
		System.out.println("add device details");
		JSONObject deviceObject = new JSONObject();

		System.out.println("masjid id::" + request.getParameter("masjid_name"));
		System.out.println("slideshow id::" + request.getParameter("slideshow"));
		System.out.println("app version id::" + request.getParameter("app_version"));
		deviceObject.put("DeviceName", request.getParameter("device_name"));
		deviceObject.put("MasjidID", request.getParameter("masjid_name"));
		deviceObject.put("SlideShowID", request.getParameter("slideshow"));
		deviceObject.put("AppVersionID", request.getParameter("app_version"));
		deviceObject.put("DeviceCode", request.getParameter("device_code"));
		deviceObject.put("Location", request.getParameter("location"));
		deviceObject.put("Status", request.getParameter("status"));
		String deviceResponse = api.sendPost("APIMasjid", "AddDevice", deviceObject.toString());
		JSONObject responseDetails = JSONObject.fromObject(deviceResponse);

		if (responseDetails.getInt("details") > 0) {
			HashMap details = new HashMap();

			page = "redirect:/ViewDevice";
		}

		return page;
	}

	@RequestMapping(value = "/ViewDevice", method = RequestMethod.GET)
	public String ViewDevice(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside view list of device");
		String page = "/device_list";
		HttpSession session = request.getSession();
		JSONObject parameter = new JSONObject();
		parameter.put("id", session.getAttribute("id"));
		String viewresponse = api.sendGet("APIMasjid", "ViewDeviceList", parameter.toString());
		JSONObject ListDetails = JSONObject.fromObject(viewresponse);

		request.setAttribute("deviceDetails", ListDetails.getJSONArray("details"));

		return page;
	}

	@RequestMapping(value = "/AddUser", method = RequestMethod.POST)
	public String AddPostuser(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("adding users");

		String page = "";
		JSONObject object = new JSONObject();
		System.out.println("id:" + request.getParameter("masjid_name"));
		object.put("MasjidID", request.getParameter("masjid_name"));
		object.put("UserName", request.getParameter("name"));
		object.put("Email", request.getParameter("email"));
		object.put("ContactNumber", request.getParameter("contact_number"));
		object.put("Password", request.getParameter("password"));
		object.put("UserGroup", request.getParameter("user_group"));
		object.put("Status", request.getParameter("status"));
		object.put("Remark", request.getParameter("remark"));
		String userResponse = api.sendPost("APIMasjid", "Adduser", object.toString());
		JSONObject responseDetail = JSONObject.fromObject(userResponse);

		if (responseDetail.getInt("details") > 0) {
			page = "redirect:/AddNewUser";
			
			
		}
		else
		{
			page="redirect:/ViewUsers";
		}

		return page;
	}

	@RequestMapping(value = "/ViewUsers", method = RequestMethod.GET)
	public String viewUser(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("inside viewUser method");
		String page = "/userslist";

		JSONObject parameter = new JSONObject();

		String viewResponse = api.sendGet("APIMasjid", "ViewUserList", parameter.toString());
		JSONObject ListDetail = JSONObject.fromObject(viewResponse);
		request.setAttribute("userDetails", ListDetail.getJSONArray("details"));

		return page;
	}

	@RequestMapping(value = "/EditUser", method = RequestMethod.POST)
	public String editUserDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("editing user details");

		String page = "";

		JSONObject parameter = new JSONObject();

		System.out.println("UID::" + request.getParameter("uis"));
		parameter.put("UID", request.getParameter("uid"));

		parameter.put("MasjidName", request.getParameter("masjid_name"));
		parameter.put("Name", request.getParameter("name"));
		parameter.put("Email", request.getParameter("email"));
		parameter.put("ContactNumber", request.getParameter("contact_number"));
		parameter.put("Password", request.getParameter("password"));
		parameter.put("UserGroup", request.getParameter("user_group"));
		parameter.put("Status", request.getParameter("status"));
		parameter.put("Remark", request.getParameter("remark"));

		String editDetails = api.sendPost("APIMasjid", "EditUser", parameter.toString());
		JSONObject editResponse = JSONObject.fromObject(editDetails);
		System.out.println("json::" + editResponse.toString());
		//int baskId = (Integer) jsonObject.get("basketId");
		int value= (Integer)editResponse.get("details");
		System.out.println("value::"+value);
		
		if (value > 0) {

			page = "redirect:/ViewUsers";

		}

		return page;
	}

	@RequestMapping(value = "/DeleteUser", method = RequestMethod.GET)
	public String deleteUserDetails(HttpServletRequest request, HttpServletResponse response) {

		String page = "";
		System.out.println("inside delete controller");
		JSONObject object = new JSONObject();
		object.put("UID", request.getParameter("uid"));

		System.out.println("id ::" + request.getParameter("uid"));

		String deleteMasjid = api.sendGet("APIMasjid", "DeleteUser", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(deleteMasjid);
		if (responseDetails.getInt("details") > 0) {

			page = "redirect:/ViewUsers";

		}

		return page;
	}

	@RequestMapping(value = "/AddSlideShow", method = RequestMethod.POST)
	public String addSlideShow(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("adding slideshow in progess");

		String page = "";
		JSONObject object = new JSONObject();

		object.put("MasjidName", request.getParameter("masjid"));
		object.put("SlideshowName", request.getParameter("slideshow_name"));
		String slidshowResponse = api.sendPost("APIMasjid", "AddSlideShow", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(slidshowResponse);

		if (responseDetails.getInt("details") > 0) {
			page = "Dashboard";
		}

		return page;
	}

	@RequestMapping(value = "/ViewSlideShow", method = RequestMethod.GET)
	public String viewSlideShowList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("viewing list of slides");

		String page = "/slideshow_list";

		HttpSession session = request.getSession();

		JSONObject parameter = new JSONObject();
		parameter.put("id", request.getAttribute("id"));

		String ViewResponse = api.sendGet("APIMasjid", "ViewSlideShow", parameter.toString());
		JSONObject ListDetails = JSONObject.fromObject(ViewResponse);
		session.setAttribute("slideshowDetails", ListDetails.getJSONArray("details"));
		request.setAttribute("slideshowDetails", ListDetails.getJSONArray("details"));
		return page;

	}

	@RequestMapping(value = "/EditSlideShowDetails", method = RequestMethod.POST)
	public String editSlideShowDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("editing slideshow details");

		String page = "";

		JSONObject parameter = new JSONObject();

		System.out.println("SID::" + request.getParameter("sid"));
		parameter.put("SID", request.getParameter("sid"));

		parameter.put("MasjidName", request.getParameter("masjid"));
		parameter.put("SlideShow", request.getParameter("slideshow_name"));

		String editDetails = api.sendPost("APIMasjid", "EditSlideShow", parameter.toString());
		JSONObject editResponse = JSONObject.fromObject(editDetails);
		System.out.println("json::" + editResponse.toString());
		if (editResponse.getInt("details") > 0) {

			page = "redirect:/ViewSlideShow";

		}

		return page;
	}

	@RequestMapping(value = "AddAppVersion", method = RequestMethod.POST)
	public String addAppVersion(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("adding app version in progress");
		String page = "";
		JSONObject object = new JSONObject();

		object.put("Version", request.getParameter("version"));
		object.put("VersionDate", request.getParameter("version_date"));
		object.put("Description", request.getParameter("description"));

		String appVersion = api.sendPost("APIMasjid", "AddVesrion", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(appVersion);
		if (responseDetails.getInt("details") > 0) {
			page += "addnew_appversion";
		}

		return page;
	}

	@RequestMapping(value = "/ViewAppVersionList", method = RequestMethod.GET)
	public String viewAppVersionList(HttpServletRequest request, HttpServletResponse response) {
		String page = "/appversion_list";

		HttpSession session = request.getSession();
		JSONObject parameter = new JSONObject();
		String ViewResponse = api.sendGet("APIMasjid", "ViewAppVersion", parameter.toString());
		JSONObject ListDetails = JSONObject.fromObject(ViewResponse);

		request.setAttribute("appVersionDetails", ListDetails.getJSONArray("details"));

		return page;
	}

	@RequestMapping(value = "/DeleteAppVersion", method = RequestMethod.GET)
	public String deleteAppVersion(HttpServletRequest request, HttpServletResponse response) {

		String page = "";
		System.out.println("inside delete controller");
		JSONObject object = new JSONObject();
		object.put("AID", request.getParameter("aid"));

		System.out.println("aid ::" + request.getParameter("aid"));

		String deleteAppVersion = api.sendGet("APIMasjid", "DeleteAppVersion", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(deleteAppVersion);
		if (responseDetails.getInt("details") > 0) {

			page = "redirect:/ViewAppVersionList";

		}

		return page;
	}

	@RequestMapping(value = "/AddnewSlide", method = RequestMethod.POST)
	public String addNewSlide(HttpServletRequest request, HttpServletResponse response) throws IOException {
      System.out.println("adding new slide");
		String page = "";
		JSONObject paramValues = new JSONObject();

		MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
		MultipartFile multipartFile = multipartRequest.getFile("add_file");
		Long size = multipartFile.getSize();
		String contentType = multipartFile.getContentType();
		InputStream stream = multipartFile.getInputStream();
		PropertiesReader reader = new PropertiesReader();
		
		if (!multipartFile.getOriginalFilename().equals("")) {
			String fileName = "";
			fileName = multipartFile.getOriginalFilename();
			String fileExtension = fileName.substring(fileName.lastIndexOf("."), fileName.length())
					.toLowerCase();
			String path = reader.uploadStaticPath("signage/images/");
			String pathview = reader.viewStaticPath(" ", "signage/images/") + fileName;
			File dest = new File(path);
			if (!dest.exists())
				dest.mkdirs();
			
			dest = new File(path + fileName);
			System.out.println("filename::"+fileName);
			System.out.println("desc::"+dest);
			multipartFile.transferTo(dest);
			paramValues.put("file_name", fileName);
			paramValues.put("file_path", pathview);
			paramValues.put("SlideShowName", request.getParameter("slideshow_name"));
			paramValues.put("StartDate", request.getParameter("start_date"));
			paramValues.put("EndDate", request.getParameter("end_date"));
		
			String SlideResponse = api.sendPost("APIMasjid", "AddSlide", paramValues.toString());
			JSONObject SlideDetails = JSONObject.fromObject(SlideResponse);
			request.setAttribute("documents_info", SlideDetails);
			
		}

		else {
			paramValues.put("status", "error");
			paramValues.put("message", "Error Uploading file");
			
		}
		
			page="redirect:/ViewSlide";

		
		return page;
	}

	@RequestMapping(value = "/ViewSlide", method = RequestMethod.GET)
	public String viewSlideList(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("listing slides");
        String page = "slide_list";
       
		JSONObject parameter = new JSONObject();
		String ViewResponse = api.sendGet("APIMasjid", "ViewSlidList", parameter.toString());
		JSONObject ListDetails = JSONObject.fromObject(ViewResponse);

		request.setAttribute("SlideListDetails", ListDetails.getJSONArray("details"));

		return page;
        



	}
	
	@RequestMapping(value = "/Images/{imageName}", method=RequestMethod.GET)
	public String getImage( @PathVariable String imageName, HttpServletRequest request, HttpServletResponse response) {
		String page ="";
		
		System.out.println("hi"+ imageName);
		System.out.println("--->");
		return  page;
	}

	@RequestMapping(value = "/DeleteSlideshow", method = RequestMethod.GET)
	public String deleteSlideShow(HttpServletRequest request, HttpServletResponse response) {

		String page = "";
		System.out.println("inside delete controller");
		JSONObject object = new JSONObject();
		object.put("SID", request.getParameter("sid"));

		System.out.println("id ::" + request.getParameter("sid"));
		String deleteSlideShow = api.sendGet("APIMasjid", "DeleteSlideShow", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(deleteSlideShow);
		if (responseDetails.getInt("details") > 0) {

			page = "redirect:/ViewSlideShow";

		}

		return page;
	}

	@RequestMapping(value = "/EditDeviceDetails", method = RequestMethod.POST)
	public String editDeviceDetails(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("editing device details");

		String page = "";

		JSONObject parameter = new JSONObject();

		System.out.println("DID::" + request.getParameter("did"));
		System.out.println("masjid id::"+ request.getParameter("masjid_name"));
		parameter.put("DID", request.getParameter("did"));

		parameter.put("MasjidName", request.getParameter("masjid_name"));
		parameter.put("SlideShowName", request.getParameter("slideshow_name"));
		parameter.put("AppVersionName", request.getParameter("appversion_name"));
		parameter.put("Location", request.getParameter("location"));
		parameter.put("Status", request.getParameter("status"));

		String editDetails = api.sendPost("APIMasjid", "EditDevice", parameter.toString());
		JSONObject editResponse = JSONObject.fromObject(editDetails);
		System.out.println("json::" + editResponse.toString());
		if (editResponse.getInt("details") > 0) {

			page = "redirect:/ViewSlideShow";

		}

		return page;
	}
	
	
	@RequestMapping(value = "/DeleteDevice", method = RequestMethod.GET)
	public String deleteDevice(HttpServletRequest request, HttpServletResponse response) {

		String page = "";
		System.out.println("inside delete controller");
		JSONObject object = new JSONObject();
		object.put("DID", request.getParameter("did"));

		System.out.println("did ::" + request.getParameter("did"));
		String deleteDevice = api.sendGet("APIMasjid", "Deletedevice", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(deleteDevice);
		if (responseDetails.getInt("details") > 0) {

			page = "redirect:/ViewDevice";

		}
		
		
		

		return page;
	}
	
	
	@RequestMapping(value="/DeleteSlide", method=RequestMethod.GET)
	public String deleteSlide(HttpServletRequest request, HttpServletResponse response)
	{
		String page="";
		System.out.println("deleting slide details");
		JSONObject object = new JSONObject();
		object.put("SLIDEID", request.getParameter("id"));
		System.out.println("id::"+request.getParameter("id"));
		
		String deleteSlide = api.sendGet("APIMasjid", "DeleteSlide", object.toString());
		JSONObject responseDetails = JSONObject.fromObject(deleteSlide);
		
		if(responseDetails.getInt("details")>0)
		{
			page = "redirect:/ViewSlide";
		}
		
		
		return page;
	}
	
	
}
