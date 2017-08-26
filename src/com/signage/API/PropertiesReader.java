package com.signage.API;

public class PropertiesReader {

	public String uploadPath(String folderName)
	{
		String pathname = null,osName = null;
		try{
			osName=System.getProperty("os.name");
			if(osName.contains("Windows")){
				folderName = folderName.replaceAll("/", "\\\\");
				pathname = "D:\\tomcatA\\webapps\\ROOT\\"+((folderName.equals(""))?"":folderName);
			}else if(osName.contains("Mac OS X"))
				pathname = "/Users/chandanmishra/apache-tomcat-9.0.0.M18/webapps/ROOT/"+((folderName.equals(""))?"":folderName+"/");
			else 
				
				pathname = "/home/project/signage/images/"+((folderName.equals(""))?"":folderName+"/");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Unexpected error!");
		}
		System.out.println("pathname ::"+pathname);
		return pathname;
	}
	

	public String viewPath(String methodName,String folderName)
	{
		String pathname = null,osName = null;
		try{
			osName=System.getProperty("os.name");
			if(osName.contains("Windows") || osName.contains("Mac OS X"))
				pathname = "http://127.0.0.1:8080/"+((methodName.equals(""))?"":"Signage/"+methodName+"/");
			else{
				pathname = "https://signage.com/"+((methodName.equals(""))?"":methodName+"/");
				if((folderName.equals("signage/images/")&& methodName.equals("")))
					pathname+="images/";
			}
			pathname+=((folderName.equals(""))?"":folderName);
			
		System.out.println("Final Path : "+pathname);		
		}catch(Exception e){    	   
			System.out.println("Unexpected error!");
		}
		return pathname;
	}
	
	
	public String uploadStaticPath(String folderName)
	{
		String pathname = null,osName = null;
		try{
			osName=System.getProperty("os.name");
			if(osName.contains("Windows")){
				folderName = folderName.replaceAll("/", "\\\\");
				pathname = "D:\\tomcatA\\webapps\\ROOT\\"+((folderName.equals(""))?"":folderName);
			}else if(osName.contains("Mac OS X"))
				pathname = "/Users/chandanmishra/apache-tomcat-9.0.0.M18/webapps/ROOT/"+((folderName.equals(""))?"":folderName+"/");
			else
				pathname = "/home/project/static/"+((folderName.equals(""))?"":folderName+"/");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Unexpected error!");
		}
		System.out.println("pathname ::"+pathname);
		return pathname;
	}
	

	public String viewStaticPath(String methodName,String folderName)
	{
		String pathname = null,osName = null;
		try{
			osName=System.getProperty("os.name");
			if(osName.contains("Windows") || osName.contains("Mac OS X"))
				pathname = "http://127.0.0.1:8080/"+((methodName.equals(" "))?" ":"Signage/"+methodName+"/");
			else{
				pathname = "https://static.signage.com/"+((methodName.equals(""))?"":methodName+"/");
			}
			pathname+=((folderName.equals(""))?"":folderName);
			
		System.out.println("Final Path : "+pathname);		
		}catch(Exception e){    	   
			System.out.println("Unexpected error!");
		}
		return pathname;
	}
	
	
	
	
	
}
