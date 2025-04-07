package Utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;



public  class DataReader {
	private static Properties prop;
//	private String projectPath=System.getProperty("user.dir");

	private String filePath="Data//config.properties";
	FileInputStream fs;
	
public DataReader() throws IOException{
//	System.out.println("Project Path is:"+projectPath);
	prop=new Properties();
	
		fs=new FileInputStream(filePath);
	prop.load(fs);	
	
	
}
public  String getUrl(){
	 String url = prop.getProperty("url");
	 if(url!= null) return url;
	 else throw new RuntimeException("location not specified in the config.properties file."); 
	 }
public String getUsername(){
	String username = prop.getProperty("username");
	 if(username!= null) return username;
	 else throw new RuntimeException("location not specified in the config.properties file."); 
	 }
public String getPassword(){
	String password = prop.getProperty("password");
	 if(password!= null) return password;
	 else throw new RuntimeException("location not specified in the config.properties file."); 
	 }	


}


