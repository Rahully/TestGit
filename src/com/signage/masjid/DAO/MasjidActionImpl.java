package com.signage.masjid.DAO;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Component
public class MasjidActionImpl implements AddMasjidService {

	@Autowired
	private DataSource dataSource;
	private JdbcTemplate template;

	@Override
	public int addMasjid(String addDetails) {

		int step = 0;
		JSONObject object = JSONObject.fromObject(addDetails);

		System.out.println("inside add masjid method");
		System.out.println("add details::" + object);
		try {
			template = new JdbcTemplate(dataSource);
			String SQL = "SELECT MAX(id) FROM masjid";
			int id = template.queryForInt(SQL) + 1;

			SQL = "INSERT INTO masjid( masjid_name, street, city, state, zipcode) " + "VALUES(?,?,?,?,?)";

			System.out.println("insert query::" + SQL);
			step = template.update(SQL, object.getString("MasjidName"), object.getString("Street"),
					object.getString("City"), object.getString("State"), object.getString("Zipcode"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override
	public JSONArray viewMasjidList(String viewList) {
		System.out.println("inside viewMasjidList method");
		JSONArray object = new JSONArray();

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT id, masjid_name, street, city, state from masjid ORDER BY id DESC ";

			object = JSONArray.fromObject(template.queryForList(SQL));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

	public int deleteMasjid(String deleteMasjid) {

		JSONObject object = JSONObject.fromObject(deleteMasjid);
		System.out.println("deleting masjid records");
		int step = 0;

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "DELETE  FROM masjid WHERE id ='" + object.getString("masjidID") + "'";

			System.out.println("delete query::" + SQL);

			step = template.update(SQL);

		} catch (Exception e) {
		}

		return step;
	}

	@Override
	public int editMasjid(JSONObject masjidDetails) {

		System.out.println("editing masjid Details");
		int step = 0;
		JSONObject object = new JSONObject();

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "UPDATE masjid SET  masjid_name = '" + masjidDetails.getString("MasjidName") + "', street = '"
					+ masjidDetails.getString("Street") + "'," + " city = '" + masjidDetails.getString("City") + "',"
					+ "state = '" + masjidDetails.getString("State") + "' WHERE id = '" + masjidDetails.getString("MID")
					+ "'";

			/*
			 * String SQL
			 * ="UPDATE majid SET masjid_name = '"+masjidDetails.getString(
			 * "MasjidName")
			 * +"', street ='"+masjidDetails.getString("Street")+"'"
			 * +"', city= '"+masjidDetails. getString("City") +"'"
			 * +"', state ='"+masjidDetails.
			 * getString("State")+"' WHERE masjid_id ='"+masjidDetails.getString
			 * ("MID")+"'" ;
			 */
			System.out.println("update query is::" + SQL);

			step = template.update(SQL);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return step;
	}

	@Override
	public int addDevice(String addDeviceDetails) {

		System.out.println("inside add device method");
		int step = 0;
		JSONObject object = JSONObject.fromObject(addDeviceDetails);
		JSONObject details = new JSONObject();
		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "";
			
			SQL = "INSERT INTO device (masjid_id, device_name,device_code,  location, slideshow_id, appversion_id, status )"
					+ "VALUES(?,?,?,?,?,?,?)";

			System.out.println("insert query::" + SQL);

			step = template.update(SQL, object.getString("MasjidID"), object.getString("DeviceName"),
					object.getString("DeviceCode"), object.getString("Location"), object.getString("SlideShowID"),
					object.getString("AppVersionID"), object.getString("Status"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override
	public JSONArray viewDeviceList(String viewList) {

		System.out.println("inside view device method");
		JSONArray object = new JSONArray();

		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT d.device_id, d.device_name,d.device_code ,m.id, m.masjid_name, s.slide_id, s.slideshow_name, a.app_ver_id, a.version "
					+ "FROM device d INNER JOIN masjid m ON d.masjid_id = m.id"
					+ "  INNER JOIN slideshow s ON d.slideshow_id = s.slide_id"
					+ "  INNER JOIN app_version a ON d.appversion_id = a.app_ver_id";

			System.out.println("query::" + SQL);
			object = JSONArray.fromObject(template.queryForList(SQL));

		} catch (Exception e) {

		}

		return object;
	}

	@Override
	public int addSlideShow(String addslideshow) {

		System.out.println("inside addslideShow method");
		int step = 0;

		JSONObject Details = JSONObject.fromObject(addslideshow);

		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT  id FROM masjid where id = '" + Details.getString("MasjidName") + "'";
			int masjid_id = template.queryForInt(SQL);

			SQL = "INSERT into slideshow(masjid_id, slideshow_name) VALUES(?,?)";
			step = template.update(SQL, masjid_id, Details.getString("SlideshowName"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override
	public JSONArray viewUserList(String viewList) {

		System.out.println("inside viewuserlist method");

		JSONArray object = new JSONArray();
		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT * from users";
			object = JSONArray.fromObject(template.queryForList(SQL));

			System.out.println("object details::" + object);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

	@Override
	public JSONArray viewAppversionList(String viewList) {
		System.out.println("inside view app version list method");
		JSONArray object = new JSONArray();
		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT  app_ver_id, version,description,DATE_FORMAT(version_date,'%Y-%m-%d') AS version_date FROM app_version";

			object = JSONArray.fromObject(template.queryForList(SQL));

			System.out.println("object details::" + object);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public int addUsers(JSONObject addUserDetails) {
		System.out.println("inside add user method");
		int step = 0;
		JSONObject object = new JSONObject();
		
	System.out.println("add user details:-"+addUserDetails);
	
	String SQL ="SELECT * from  users where email_id ='"+addUserDetails.getString("Email")+"'";
	System.out.println("sql::"+SQL);
		
	template = new JdbcTemplate(dataSource);
		
		try {
			
			//System.out.println("object size::"+object.size());
			object = JSONObject.fromObject(template.queryForMap(SQL));
			step=-1;
			System.out.println("object size::"+object);
		}
		
		catch(Exception e) {
			step=0;
		}
		
		if(step==0)
		{
			
			try {
			
			SQL = "INSERT INTO users(masjid_id, Name, email_id, password, contact_number, Remark, isActive, isSuperAdmin) "
					+ "VALUES(?,?,?,?,?,?,?,?)";

			System.out.println("insert query::" + SQL);
			step = template.update(SQL, addUserDetails.getString("MasjidID"), addUserDetails.getString("UserName"),
					addUserDetails.getString("Email"), addUserDetails.getString("Password"),
					addUserDetails.getString("ContactNumber"), addUserDetails.getString("Remark"),
					addUserDetails.getString("Status"), addUserDetails.getString("UserGroup"));
			
			}
			
			catch(Exception e)
			{
				step=-2;
				e.printStackTrace();
			}
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		/*try {
			
			template = new JdbcTemplate(dataSource);
			
			String SQL ="SELECT * from  users where email_id ='"+addUserDetails.getString("Email")+"'";
			System.out.println("sql::"+SQL);
			
			object = JSONObject.fromObject(template.queryForMap(SQL));
			System.out.println("object::"+object.toString());
			System.out.println("object:"+object.getInt(SQL));
			
			if(object.getInt(SQL)==0)
			{
				SQL = "INSERT INTO users(masjid_id, Name, email_id, password, contact_number, Remark, isActive, isSuperAdmin) "
						+ "VALUES(?,?,?,?,?,?,?,?)";

				System.out.println("insert query::" + SQL);
				step = template.update(SQL, addUserDetails.getString("MasjidID"), addUserDetails.getString("UserName"),
						addUserDetails.getString("Email"), addUserDetails.getString("Password"),
						addUserDetails.getString("ContactNumber"), addUserDetails.getString("Remark"),
						addUserDetails.getString("Status"), addUserDetails.getString("UserGroup"));
				
				System.out.println("insert step::"+ step);
				
				object = JSONObject.fromObject(template.update(SQL));
				System.out.println("object::"+object.toString());
				

			}
			
			
			
		} catch(Exception e) {}
		
		*/
		
		return step;
		}


	@Override
	public int addAppVersion(String addAppversion) {
		System.out.println("inside add app version method");

		int step = 0;
		JSONObject object = JSONObject.fromObject(addAppversion);
		try {
			String SQL = "";

			template = new JdbcTemplate(dataSource);
			/*
			 * SQL =
			 * "INSERT into app_version(version, DATE_FORMAT(version_date,'%Y-%m-%d') AS  version_date , description) VALUES ('"
			 * + object.getString("Version") + "','" +
			 * object.getString("VersionDate") + "','" +
			 * object.getString("Description") + "')";
			 * System.out.println("insert query is::" + SQL);
			 */

			SQL = "INSERT into app_version(version, version_date , description) VALUES(?,?,?)";
			System.out.println("insert query is::" + SQL);
			step = template.update(SQL, object.getString("Version"), object.getString("VersionDate"),
					object.getString("Description"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override

	public JSONArray viewSlideShow(String viewList) {
		System.out.println("inside view slideshow method");
		JSONArray object = new JSONArray();
		try {
			template = new JdbcTemplate(dataSource);

			/*
			 * String SQL
			 * ="SELECT slide_id, masjid_id, slideshow_name, DATE_FORMAT(last_updated_time,'%Y-%m-%d') AS  last_updated_time FROM slideshow  "
			 * ;
			 */

			String SQL = "SELECT slide_id, masjid.id, masjid.masjid_name ,slideshow_name,DATE_FORMAT(last_updated_time,'%Y-%m-%d') AS  last_updated_time FROM slideshow "
					+ "INNER JOIN masjid ON slideshow.masjid_id = masjid.id";

			System.out.println("query::" + SQL);
			object = JSONArray.fromObject(template.queryForList(SQL));

			System.out.println("object value::" + object.toString());

		} catch (Exception e) {
			e.printStackTrace();

		}

		return object;
	}

	public JSONObject viewDasboardDetails(JSONObject details) {
		System.out.println("inside method");
		JSONObject object = new JSONObject();

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "";
			SQL = "SELECT Count(id) AS NumberOFMasjid FROM masjid";

			int masjidCount = template.queryForInt(SQL);
			System.out.println("total number of masjid::" + masjidCount);

			SQL = "SELECT Count(user_id) AS NumberOFUsers FROM users";

			int userCount = template.queryForInt(SQL);
			System.out.println("total number of users::" + userCount);
			SQL = "SELECT Count(app_ver_id) AS NumberOfVersion FROM app_version";
			int appCount = template.queryForInt(SQL);
			System.out.println("number of app versions::" + appCount);

			SQL = "SELECT Count(id) AS NumberOFSlides FROM slides";

			int slideCount = template.queryForInt(SQL);
			System.out.println("total number of slides::" + slideCount);

			System.out.println("masjid");
			object.put("masjid", masjidCount);
			object.put("users", userCount);
			object.put("app", appCount);
			object.put("slides", slideCount);

		} catch (Exception e) {
			e.printStackTrace();

		}

		return object;
	}

	@Override
	public JSONObject viewMasjid(JSONObject masjidData) {

		JSONObject object = new JSONObject();
		System.out.println("inside view masjid method");
		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "SELECT id, masjid_name, street, city, state	FROM masjid WHERE  id='"
					+ masjidData.getString("masjidID") + "'";

			System.out.println("query is::" + SQL);

			object = JSONObject.fromObject(template.queryForMap(SQL));

			System.out.println("object are::" + object);

		} catch (Exception e) {
		}

		return object;
	}

	@Override
	public JSONObject viewSlideShow(JSONObject slideshowData) {

		JSONObject object = new JSONObject();
		System.out.println("inside view slideshow method");

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT slide_id, masjid.id, masjid.masjid_name ,slideshow_name,DATE_FORMAT(last_updated_time,'%Y-%m-%d') AS  last_updated_time FROM slideshow "
					+ "INNER JOIN masjid ON slideshow.masjid_id = masjid.id WHERE slide_id = ?";
			System.out.println("query is::" + SQL);

			object = JSONObject.fromObject(template.queryForMap(SQL, slideshowData.getString("SID")));

			System.out.println("object are::" + object);

		} catch (Exception e) {

		}

		return object;
	}

	@Override
	public int editSlideShow(JSONObject masjidDetails) {
		System.out.println("editing slideshow Details");
		int step = 0;
		JSONObject object = new JSONObject();

		try {

			template = new JdbcTemplate(dataSource);
			/*
			 * String SQL = "UPDATE slideshow SET  slideshow_name = '" +
			 * masjidDetails.getString("SlideShow") + "' " +
			 * " WHERE slide_id = '" + masjidDetails.getString("SID") + "'";
			 */

			String SQL = "UPDATE slideshow SET slideshow_name= ? WHERE slide_id =?";

			System.out.println("update query is::" + SQL);

			step = template.update(SQL, masjidDetails.getString("SlideShow"), masjidDetails.getString("SID"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return step;

	}

	@Override
	public int deleteSlideShow(String deleteSlideshow) {

		JSONObject object = JSONObject.fromObject(deleteSlideshow);
		System.out.println("deleting slideshow records");
		int step = 0;

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "DELETE  FROM slideshow WHERE slide_id =?";

			System.out.println("delete query::" + SQL);

			step = template.update(SQL, object.getString("SID"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override
	public JSONObject viewAppversion(JSONObject appVersionData) {

		JSONObject object = new JSONObject();
		System.out.println("inside view app version method");

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = " SELECT  app_ver_id, version, DATE_FORMAT(version_date,'%Y-%m-%d') AS  version_date, description FROM app_version WHERE app_ver_id=?";

			System.out.println("query is::" + SQL);

			object = JSONObject.fromObject(template.queryForMap(SQL, appVersionData.getString("AID")));

			System.out.println("object are::" + object);

		} catch (Exception e) {

		}

		return object;
	}

	@Override
	public int editAppVersionDetails(JSONObject appversionDetails) {

		System.out.println("editing appversion Details");
		int step = 0;
		JSONObject object = new JSONObject();

		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "UPDATE app_version SET version= ?, version_date= ?, description=?  WHERE app_ver_id =?";

			System.out.println("update query is::" + SQL);

			step = template.update(SQL, appversionDetails.getString("Version"),
					appversionDetails.getString("VersionDate"), appversionDetails.getString("Description"),
					appversionDetails.getString("AID"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return step;
	}

	@Override
	public int deleteAppVersion(String deleteAppVersion) {
		JSONObject object = JSONObject.fromObject(deleteAppVersion);
		System.out.println("deleting app version records");
		int step = 0;

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "DELETE  FROM app_version WHERE app_ver_id =?";

			System.out.println("delete query::" + SQL);

			step = template.update(SQL, object.getString("AID"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override
	public JSONObject viewUser(JSONObject userData) {
		JSONObject object = new JSONObject();
		System.out.println("inside view user method");

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT user_id, masjid.id, masjid.masjid_name, Name, email_id, password, contact_number, Remark, isActive, isSuperAdmin FROM users  "
					+ "  INNER JOIN masjid ON users.masjid_id = masjid.id WHERE user_id = ?";

			System.out.println("query is::" + SQL);

			object = JSONObject.fromObject(template.queryForMap(SQL, userData.getString("UID")));

			System.out.println("object are::" + object);

		} catch (Exception e) {

		}

		return object;
	}

	@Override
	public int deleteUser(String deleteUser) {
		JSONObject object = JSONObject.fromObject(deleteUser);
		System.out.println("deleting user records");
		int step = 0;

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "DELETE  FROM users WHERE user_id =?";

			System.out.println("delete query::" + SQL);

			step = template.update(SQL, object.getString("UID"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;
	}

	@Override
	public int editUser(JSONObject userDetails) {
		System.out.println("editing user Details");
		int step = 0;
		JSONObject object = new JSONObject();

		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "UPDATE users SET Name= ?, email_id= ?, password=?, contact_number=?, Remark= ?, isActive= ?, isSuperAdmin= ?  WHERE user_id =?";

			System.out.println("update query is::" + SQL);

			step = template.update(SQL, userDetails.getString("Name"), userDetails.getString("Email"),
					userDetails.getString("Password"), userDetails.getString("ContactNumber"),
					userDetails.getString("Remark"), userDetails.getString("Status"),
					userDetails.getString("UserGroup"), userDetails.getString("UID"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return step;
	}

	@Override

	public JSONObject viewDevice(JSONObject userData) {

		JSONObject object = new JSONObject();
		System.out.println("inside view device method");

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT d.device_id, d.device_name,d.device_code ,m.id, m.masjid_name, s.slide_id, s.slideshow_name, a.app_ver_id, a.version , d.location, d.status  "
					+ "FROM device d INNER JOIN masjid m ON d.masjid_id = m.id"
					+ "  INNER JOIN slideshow s ON d.slideshow_id = s.slide_id"
					+ "  INNER JOIN app_version a ON d.appversion_id = a.app_ver_id WHERE device_id=?";

			System.out.println("query is::" + SQL);

			object = JSONObject.fromObject(template.queryForMap(SQL, userData.getString("DID")));

			System.out.println("object are::" + object);

		} catch (Exception e) {

		}

		return object;
	}

	@Override
	public int editDevice(JSONObject deviceDetails) {
		System.out.println("editing appversion Details");
		int step = 0;
		JSONObject object = new JSONObject();

		try {

			template = new JdbcTemplate(dataSource);

			String SQL = "UPDATE device SET masjid_id= ?, slideshow_id= ?,appversion_id =?, location=? ,status=?  WHERE device_id =?";

			System.out.println("update query is::" + SQL);

			step = template.update(SQL, deviceDetails.getString("MasjidName"), deviceDetails.getString("SlideShowName"),
					deviceDetails.getString("AppVersionName"), deviceDetails.getString("Location"),
					deviceDetails.getString("Status"), deviceDetails.getString("DID"));

		} catch (Exception e) {

			e.printStackTrace();
		}

		return step;
	}

	@Override
	public int deleteDevice(String deleteDevice) {

		JSONObject object = JSONObject.fromObject(deleteDevice);
		System.out.println("deleting user records");
		int step = 0;

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "DELETE  FROM device WHERE device_id =?";

			System.out.println("delete query::" + SQL);

			step = template.update(SQL, object.getString("DID"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;

	}

	@Override
	public int addSlide(JSONObject addSlide) {

		int step = 0;

		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

		try {

			SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			java.util.Date myDate = format.parse(addSlide.getString("StartDate"));
			java.util.Date myDate1 = format.parse(addSlide.getString("EndDate"));
			java.sql.Date startdate = new java.sql.Date(myDate1.getTime());
			java.sql.Date enddate = new java.sql.Date(myDate.getTime());

			JSONObject object = JSONObject.fromObject(addSlide);
			System.out.println("printing" + object.toString());

			template = new JdbcTemplate(dataSource);

			String SQL = "INSERT into slides (slideshow_id, file_name,image_path, startdate,  expirydate) VALUES (?,?,?,?,?)";
			System.out.println("insert query::" + SQL);

			step = template.update(SQL, object.getString("SlideShowName"), object.getString("file_name"),
					object.getString("file_path"), startdate, enddate);

			System.out.println("insert query::" + SQL);

		} catch (Exception e) {

			e.printStackTrace();
		}

		return step;
	}

	@Override
	public JSONArray viewSlideList(JSONObject slideList) {
		System.out.println("inside viewSlideList method");
		JSONArray object = new JSONArray();

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT id, slideshow.slide_id, slideshow.slideshow_name, file_name, image_path, "
					+ "DATE_FORMAT(startdate,'%Y-%m-%d') AS startdate, DATE_FORMAT(expirydate,'%Y-%m-%d') AS expirydate "
					+ "FROM slides  INNER JOIN slideshow  ON slides.slideshow_id = slideshow.slide_id ";

			object = JSONArray.fromObject(template.queryForList(SQL));

			System.out.println("query::" + SQL);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

	@Override
	public JSONObject viewSlide(JSONObject slideData) {
		JSONObject object = new JSONObject();
		System.out.println("inside view slide method");

		try {
			template = new JdbcTemplate(dataSource);

			String SQL = "SELECT id, slideshow.slide_id, slideshow.slideshow_name, file_name, image_path, DATE_FORMAT(startdate,'%Y-%m-%d') AS startdate, DATE_FORMAT(expirydate,'%Y-%m-%d') AS expirydate "
					+ "FROM slides  INNER JOIN slideshow  ON slides.slideshow_id = slideshow.slide_id  WHERE id =?";
			System.out.println("query is::" + SQL);

			object = JSONObject.fromObject(template.queryForMap(SQL, slideData.getString("SLIDEID")));

			System.out.println("object are::" + object);

		} catch (Exception e) {

		}

		return object;
	}

	@Override
	public int deleteSlide(String deleteSlide) {
		JSONObject object = JSONObject.fromObject(deleteSlide);
		System.out.println("deleting slide records");
		int step = 0;

		try {

			template = new JdbcTemplate(dataSource);
			String SQL = "DELETE  FROM slides WHERE id =?";

			System.out.println("delete query::" + SQL);

			step = template.update(SQL, object.getString("SLIDEID"));

		} catch (Exception e) {
			e.printStackTrace();
		}

		return step;

	}
	
	

	@Override
	public JSONObject deviceCode(JSONObject code) {
System.out.println("inside device code method");

JSONObject object = new JSONObject();
		
		try {
			
			template = new JdbcTemplate(dataSource);
			
			
		String	SQL="SELECT max(device_id) as id FROM device";
			int id = template.queryForInt(SQL);
			
			System.out.println("query:"+SQL);
			System.out.println("id::"+id);
			
			
			 SQL ="SELECT max(device_code) as device_code FROM device";
		    object = JSONObject.fromObject( template.queryForMap(SQL));
		     
		    String s2 = object.getString("device_code").substring(0, 4)+"-"+(++id);
		    System.out.println(s2);
		    object.put("device_code", s2);
		    
		    System.out.println("object value::"+object.toString());
			
			
		} catch(Exception e) {}
		
		return object;
		
		

}
}
