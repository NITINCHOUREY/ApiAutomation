package com.autox.base;

import java.io.FileInputStream;
import java.util.Properties;

public class Utility {
	public static  Properties prop;

	/**
	 * @author NITIN Chourey
	 * @Discription this constructor will load the property values
	 * 
	 * */
	public Utility() {
		 prop = new Properties();
		try 
		{
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/com/autox/config/config.properties");
			prop.load(fis);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
}
