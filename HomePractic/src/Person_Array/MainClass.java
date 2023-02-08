package Person_Array;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainClass {

	public static void main(String[] args) {
		
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath";
		String serviceKey = "+h82WwRALt+3L4awyNYZmmtJWZkKscUT/Fm7NDCD2dinRfTWm+jbUFT7xCUVAENXwgn1So0f2X0WpNuE69Gymw==";
		URL url = null; 
		HttpURLConnection con = null; 
		BufferedReader reader = null; 
		
		
	try {
			
		StringBuilder sbURL = new StringBuilder(); 
	    
		sbURL.append(apiURL); 
		sbURL.append("?ServiceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); 	
		sbURL.append("&searchYear=2021");
		sbURL.append("&siDo=1100");
		sbURL.append("&guGun=1125");
		sbURL.append("&numOfRows=10");
		sbURL.append("&pageNo=1");
		sbURL.append("&type=json");
		
		
		  
		
		url = new URL(sbURL.toString());
		System.out.println(url);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
}

