package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class MainClass {

	public static void ex01() {
		
		/* 
		
		 한국공항공사_항공기 운항정보 : 공항 코드 정보
		 1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
		 2. 요청 변수(Request Parameter)
		 	1) ServiceKey : 인증키
		*/
		  
		// 보통은 디코딩 값 가지고 인코딩하는 걸로 한다.
		String serviceKey = "+h82WwRALt+3L4awyNYZmmtJWZkKscUT/Fm7NDCD2dinRfTWm+jbUFT7xCUVAENXwgn1So0f2X0WpNuE69Gymw==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			url = new URL(apiURL); // MalformedURLException 발생 위치
			con = (HttpURLConnection)url.openConnection(); // IOException 발생 위치
			
			con.setRequestMethod("GET"); // 주소창에 파라미터를 붙여서 요청하는 방식을 GET방식이라 한다.
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); 
			
			// 내려받을 정보의 타입
			// xml의 문서의 content타입(한글로 인코딩 된)
			
			
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 실행 정상일 때
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 실행 오류일 때
			}

			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				sb.append(line); 
			}
			
			reader.close();
			con.disconnect(); // 여기까지가 읽어오는거 마무리
			
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		} catch(IOException e) { // IOException 으로 간단하게 관리만 했다.
			e.printStackTrace();
		}

	}
	
	public static void ex02() {
		
		/*
			 한국공항공사_항공기 운항정보 : 공항 코드 정보
			 1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			 2. 요청 변수(Request Parameter)
			 	1) serviceKey : 인증키
			 	2) pageNo : 조회할 페이지 번호
			 	2) schDate : 검색일자
			 	3) schDeptCityCode : 출발 도시 코드
			 	5) schArrvCityCode : 도착 도시 코드
			 	
		*/	 	
		
		String serviceKey = "+h82WwRALt+3L4awyNYZmmtJWZkKscUT/Fm7NDCD2dinRfTWm+jbUFT7xCUVAENXwgn1So0f2X0WpNuE69Gymw==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "pageNo=1";
			apiURL += "&schDate=20230201";
			apiURL += "&schDeptCityCode=ICN";
			apiURL += "&schArrvCityCode=JFK";
			
			url = new URL(apiURL); // MalformedURLException 발생 위치
			con = (HttpURLConnection)url.openConnection(); // IOException 발생 위치
			
			con.setRequestMethod("GET"); // 주소창에 파라미터를 붙여서 요청하는 방식을 GET방식이라 한다.
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8"); // 내려받을 정보의 타입
																					  // xml의 문서의 content타입(한글로 인코딩 된)
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
			reader = new BufferedReader(new InputStreamReader(con.getInputStream())); // 실행 정상일 때
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream())); // 실행 오류일 때
			}

			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				sb.append(line); 
			}
			
			reader.close();
			con.disconnect(); // 여기까지가 읽어오는거 마무리
			
			File file = new File("C:" + File.separator + "storage", "국제선운행스케줄.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선운행스케줄.xml이 생성되었습니다.");
			
		} catch(IOException e) { // IOException 으로 간단하게 관리만 했다.
			e.printStackTrace();
		}

	}
	
	public static void main(String[] args) {
		ex02();  
	}

}
