package ex03_api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {
	
	
	public static void ex01() {
		
		String serviceKey = "+h82WwRALt+3L4awyNYZmmtJWZkKscUT/Fm7NDCD2dinRfTWm+jbUFT7xCUVAENXwgn1So0f2X0WpNuE69Gymw==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
				
		try {
		
		String sidoName = "서울";
		StringBuilder sbURL = new StringBuilder();
		sbURL.append(apiURL);
		sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
		sbURL.append("&returnType=json");
		sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8"));
		
		
		url = new URL(sbURL.toString());
		con = (HttpURLConnection)url.openConnection(); // 접속을 하고
		
		con.setRequestMethod("GET"); // 접속방식 설정
		con.setRequestProperty("content-type", "application/json; charset=UTF-8"); // 콘텐트 타입 가져올 형식 정해준다.
		
		int responseCode = con.getResponseCode(); // 정상접속인지 확인하기 위해서 응답코드 가져오는 메소드 사용

		if(responseCode == 200) {
			
		reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
		
		} else {
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		
		String line = null;
		StringBuilder sb = new StringBuilder();
		
		while((line = reader.readLine()) != null) { 
			sb.append(line); // 여기까지 api 읽어와서 sb에 담은거
		}
		
		reader.close();
		con.disconnect();
  		
		JSONObject obj = new JSONObject(sb.toString()); // 이제 제이슨 오브젝트 만들어서 json형식으로 바꿔주기
		JSONObject body = obj.getJSONObject("response").getJSONObject("body");
		JSONArray items = body.getJSONArray("items");
		for(int i = 0; i < items.length(); i++) { 		// 제이슨어레이 배열의 요소는 제이슨 오브젝트 하나하나이다.
			JSONObject item = items.getJSONObject(i); 	// 그렇기에 제이슨어레이의 인덱스 하나하나는 제이슨 오브젝트이다

			String stationName = item.getString("stationName"); // 전부 스트링 값이기 때문에 getString 메소드 사용한다.
			String pm10Value = item.getString("pm10Value");
			String o3Value = item.getString("o3Value");
			System.out.println(stationName + " : 미세먼지 - " + pm10Value + ", 오존농도 - " + o3Value);
			
		}
		
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void ex02() { // 초미세먼지 주간예보 조회
		
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustWeekFrcstDspth";
		String serviceKey = "+h82WwRALt+3L4awyNYZmmtJWZkKscUT/Fm7NDCD2dinRfTWm+jbUFT7xCUVAENXwgn1So0f2X0WpNuE69Gymw==";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		
		try {
			
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&searchDate=2023-01-30");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			JSONArray items = new JSONObject(sb.toString())
								.getJSONObject("response")
								.getJSONObject("body")
								.getJSONArray("items");
			for(int i = 0; i < items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
				System.out.println(item.getString("frcstOneDt") + " : " + item.getString("frcstOneCn"));
				System.out.println(item.getString("frcstTwoDt") + " : " + item.getString("frcstTwoCn"));
				System.out.println(item.getString("frcstThreeDt") + " : " + item.getString("frcstThreeCn"));
				System.out.println(item.getString("frcstFourDt") + " : " + item.getString("frcstFourCn"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		 ex02();
	}

}
