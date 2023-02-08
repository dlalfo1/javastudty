package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiMain {

	public static void main(String[] args) {

		
		String serviceKey = "+h82WwRALt+3L4awyNYZmmtJWZkKscUT/Fm7NDCD2dinRfTWm+jbUFT7xCUVAENXwgn1So0f2X0WpNuE69Gymw==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath";
		URL url = null;
		HttpURLConnection con1 = null;
		BufferedReader reader = null;
		
		
		try {
				StringBuilder sbURL = new StringBuilder();
				sbURL.append(apiURL); 
				sbURL.append("?serviceKey="+ URLEncoder.encode(serviceKey, "UTF-8")); 
				sbURL.append("&searchYear=2021");
				sbURL.append("&siDo=1100");
				sbURL.append("&guGun=1125");
				sbURL.append("&type=json");
				sbURL.append("&numOfRows=10");
				sbURL.append("&pageNo=1");	
				
				
				url = new URL(sbURL.toString());
				con1 = (HttpURLConnection)url.openConnection();
				
				con1.setRequestMethod("GET");
				con1.setRequestProperty("content-type", "application/json; charset=UTF-8"); 
				
				int responseCode = con1.getResponseCode();
				
				if(responseCode == 200) {
					reader = new BufferedReader(new InputStreamReader(con1.getInputStream()));
					
				} else {
					reader = new BufferedReader(new InputStreamReader(con1.getErrorStream()));
				}
				
				String line = null;
				StringBuilder sb = new StringBuilder();
				while((line = reader.readLine()) != null) {
					sb.append(line);
				}
				reader.close();
				con1.disconnect();
				
				System.out.println(sb.toString());
				
				File file = new File("accident.txt");
				BufferedWriter writer = new BufferedWriter(new FileWriter(file));
				writer.write(sb.toString());
				
				writer.close();
				
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

}
