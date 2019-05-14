package com.autox.client;

import java.util.HashMap;
import java.util.logging.Logger;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

public class RestClient {
	public static Logger logger = Logger.getLogger("RestClient");

	/**
	 * @author NITIN Chourey
	 * @Discription getResponse method navigates to the url and gives responses
	 * @param String URL
	 * @return Nil
	 */
	public static void getResponse(String url) {
		int statusCode = 0;
		String responseString = null;
		HashMap<String, String> allheaders = new HashMap<String, String>();

		try {

			// This line Creates CloseableHttpClient instance with default configuration.
			CloseableHttpClient closeableHttpClient = HttpClients.createDefault();
			HttpGet httpGet = new HttpGet(url);

			// This line Executes HTTP request using the given context.
			CloseableHttpResponse closeableHttpResponse = closeableHttpClient.execute(httpGet);

			// This will return status code
			statusCode = closeableHttpResponse.getStatusLine().getStatusCode();
			logger.info("Status code  : " + statusCode);

			// This will get response string
			responseString = EntityUtils.toString(closeableHttpResponse.getEntity(), "UTF-8");
			JSONObject jasonObject = new JSONObject(responseString);
			logger.info("jason response string  : " + jasonObject);

			// This will return all the headers with response
			Header[] headers = closeableHttpResponse.getAllHeaders();
			for (Header header : headers) {
				allheaders.put(header.getName(), header.getValue());
			}
			logger.info("All headers list  : " + allheaders);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
