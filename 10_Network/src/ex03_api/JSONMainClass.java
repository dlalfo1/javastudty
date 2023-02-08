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
		URL url = null; // URL 클래스는 URL을 추상화하여 만든 클래스이다.
		HttpURLConnection con = null; // HttpURLConnection은 http 웹을 통해 정보를 주고받는 등 통신을 수행하기 위하여 필요한 클래스이다.
		BufferedReader reader = null; // Buffer를 이용한 입력 Stream 클래스이다. (Stream : 데이터 입출력시 전송되는 데이터의 흐름)
		
		
				
		try {
		
		String sidoName = "서울"; // 필수 요청 정보인 시도네임
		StringBuilder sbURL = new StringBuilder(); // URL객체 생성시 코드 글자수를 줄이기 위해서 스트링버퍼 객체 만들어줌.
		sbURL.append(apiURL); // 먼저 api의 주소를 더해주고
		sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8")); // 필수 요청정보인 서비스키 UTF-8 방식으로 암호화.
																			   // 인코딩하지 않으면 사용불가하다.
	
		sbURL.append("&returnType=json");   // 파라미터 값은 api싸이트에 요청하는 변수개념
											// JSON 형식으로 데이터를 받아오겠다는 소리
	
		sbURL.append("&sidoName=" + URLEncoder.encode(sidoName, "UTF-8")); // 한글도 인코딩 필수
		
		
		url = new URL(sbURL.toString()); // 전달받은 sbURL String으로 URL 객체를 만든다.
		con = (HttpURLConnection)url.openConnection(); // openConnection 메서드를 호출하여 HttpURLConnection 객체를 얻은 후 웹에 접속한다.
				// HttpURLConnection, URLConnection 메소드를 둘 다 사용하기 위해서
		System.out.println(url);
		con.setRequestMethod("GET"); // 접속방식 설정(데이터 받는 방식을 주소창에 입력하는걸 GET방식이라 한다.)
									 // POST는 수정방식임(블로그 수정같은거) 우린 읽어들이려고 요청만 하면 되니까 겟방식 쓰면 되는 거임.
		con.setRequestProperty("content-type", "application/json; charset=UTF-8"); 
		// 컨텐트 타입 (웹 상으로 주고받는 정보의 타입. 자바에서 int타입, double타입처럼 정해진 타입 같은 거)
		
		int responseCode = con.getResponseCode(); // 정상접속인지 확인하기 위해서 응답코드 가져오는 메소드 사용

		if(responseCode == 200) {
	
		reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 응답코드가 정상이면 정상스트림 연결
		
		// 정보를 읽어오는것은 con.getInputStream이다. 인풋스트림은 바이트 타입의 정보밖에 가져오지 못하므로
		// 문자열로 가져오기 위하여 InputStreamReader사용하고 성능향상을 하기 위해 BufferedReader를 껴준다.
		// 즉 서버로부터 받은 응답 메시지에서 데이터를 추출해 자바의 문자열로 변환한다.
		} else {
			
			reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); 
			
			// 에러스트림을 열지 않아도 에러시 출력되는 코드는 똑같다.
			// 하지만 개발자들이 걍 그렇게 쓰기로 해서 쓰는거임...
		}
		
		String line = null; // StringBuilder를 사용해서 긁어올 문자들을 저장할 변수 선언
		StringBuilder sb = new StringBuilder(); // StringBuilder 객체 생성
		
		while((line = reader.readLine()) != null) {  // 긁어오는 문자열이 null이 아닐 때 까지 무한반복문.
													 // BufferedReader는 읽어올 문자가 없으면 null로 표기된다.
													 // readLine 메소드는 한줄씩 읽어오는 메소드다. BufferedReader에만 있다.
			sb.append(line); // 여기까지 읽어온 문자열들을 sb객체에 담아준다.
		}
		
		reader.close(); // 다 읽었으니 스트림 닫아준다.
		con.disconnect(); // 웹과의 접속 닫아준다.
		
  	    System.out.println(sb.toString());
  	    
		JSONObject obj = new JSONObject(sb.toString()); // 이제 제이슨 오브젝트 만들어서 JOSON형식으로 바꿔주기
		JSONObject body = obj.getJSONObject("response").getJSONObject("body"); // 원하는건 items 객체의 정보이다.
		JSONArray items = body.getJSONArray("items"); // items는 []형식이므로 JSON 배열에 담아준다.
		for(int i = 0; i < items.length(); i++) { 		
			JSONObject item = items.getJSONObject(i); 	
			
			// JSONArray 배열의 요소는 JSONObject 하나하나이다.
			// 그렇기에 JSONArray의 인덱스 하나하나는 JSONObject이다

			// 필요한 문자열만 가져오기
			String stationName = item.getString("stationName"); // 전부 스트링 값이기 때문에 getString 메소드 사용한다.
			String pm10Value = item.getString("pm10Value"); // 미세먼지(PM10) 농도
			String o3Value = item.getString("o3Value"); // 오존농도
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
	
	public static void ex02_practice() { // 초미세먼지 주간예보 조회 연습
		
		
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
			
			
			url = new URL(sbURL.toString()); // URL 생성
			con = (HttpURLConnection)url.openConnection(); // URL로 접속하기
			
			con.setRequestMethod("GET"); // 접속 방식 정하기
			con.setRequestProperty("Content-Type", "application/json; charset=UFT-8");
			
			int responseCode = con.getResponseCode(); // 응답 잘 됐는지 확인받아서 저장하기
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// 아직 스트림만 연 상태. 읽으려면 readline메소드 써야함.
			// 먼저 읽은 값 스트링빌더에 모으기 위해서 객체 생성
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			
			
			
			JSONArray items = new JSONObject(sb.toString())
								.getJSONObject("response")
								.getJSONObject("body")
								.getJSONArray("items"); // items 배열을 JSONArray에 담아줬다
			
			for(int i = 0; i < items.length(); i++) { // JSONArray에 담긴 items 하나하나는 JSONObject이다
				JSONObject item = items.getJSONObject(i); // 배열에 담긴 오브젝트 가져와서 담기
				System.out.println(item.getString("frcstOneDt") + " : " + item.getString("frcstOneCn"));
				System.out.println(item.getString("frcstTwoDt") + " : " + item.getString("frcstTwoCn"));
				System.out.println(item.getString("frcstThreeDt") + " : " + item.getString("frcstThreeCn"));
				System.out.println(item.getString("frcstFourDt") + " : " + item.getString("frcstFourCn"));
			}
			
		} catch (IOException e)	{
			e.printStackTrace();
		}
	}	

	public static void main(String[] args) {
		ex02();
	}

}
