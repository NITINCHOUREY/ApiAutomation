package com.autox.testcase;

import java.util.logging.Logger;

import com.autox.base.Utility;
import com.autox.client.RestClient;

public class Execution {
	public static Logger logger = Logger.getLogger("Execution");
	public static Utility utility = new Utility();

	public static String url = null;

	
	public static void run() {
		url = Utility.prop.getProperty("URL") + Utility.prop.getProperty("SERVICE_URL");
		logger.info("navigating to : "+url);
		RestClient.getResponse(url);
	}
	
	public static void main(String[] args)
	{
		run();
	}
}
