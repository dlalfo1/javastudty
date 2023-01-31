package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;


public class MainClass {

		/*
			URL
			1. Uniform Resource  Locator
			2. 정형화된 자원의 경로
			3. 실제로는 웹 주소를 의미한다.
			4. 구성 (호스트 주소는 정해져있고, 서버경로는 개발자가 정하는 것이다. ? 물음표는 하나뿐이다.)
				프로토콜://   호스트       / 서버경로   ?파라미터=값&파라미터=값&...
				   https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=삼성전자
				1) 프로토콜 : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
				2) 호스트 	: 서버의 대표 주소
				3) 서버경로 : URL Mapping(URL Pattern)
				4) 파라미터 : 서버로 보내는 데이터를 의미(변수라고 생각하면 된다.)
		*/
		
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;
		
		try {
			
			url = new URL(apiURL); // 반드시 예외 처리가 필요한 코드
			
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트 : " + url.getHost()); // 호스트 : 서버라고 생각하면 된다.
			System.out.println("파마리터 : " + url.getQuery()); // 파라미터 확인
			
			
			
		} catch(MalformedURLException e) { // Malformed 잘못된 모양의 URLException 주소 예외처리
			System.out.println("apiURL 주소 오류");
		}
		
	}

	public static void ex02() {
		
		// 웹 접속을 담당하는 HttpURLConnection
		
		
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;
				
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection)url.openConnection(); // openConnection메소드를 쓰려면 IOException 처리가 필요하다. 
														   // 접속 즉, 스트림 개념이라 보면 된다.
			
			
			/*
			 	HTTP 응답 코드 공부하기(접속이 됐냐 안됐냐 확인)
				1. 200 : 정상
				2. 40X : 잘못된 요청(사용자가 잘못하였음. 주로 주소 잘못 입력해서 들어갈 때)
				3. 50X : 서버측 오류(서버가 잘못하였음)
			*/
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK); // 200
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND); // 404
			System.out.println("Internal Error :" + HttpURLConnection.HTTP_INTERNAL_ERROR); // 500
			
			// apiURL 접속 확인
			int responseCode = con.getResponseCode();
			if(responseCode == 200) {
				System.out.println(apiURL + " 접속 완료");
			}
			
			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod); // GET : 데이터 받는 방식을 주소창에 입력할게
															    // 예를들어 로그인할 때 id랑 pw 넣을 때는 주소창에 입력하지 않으므로 GET방식이 아니다.
			
			// 컨텐트 타입 (웹 상으로 주고받는 정보의 타입. 자바에서 int,double처럼 정해진 타입 같은 거)
			String contentType = con.getContentType();
			System.out.println("컨텐트 타입 : " + contentType ); // txt/html; charset=UTF-8
			
			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent"); // 누가 요청했는가 (java로 뜬다.)
			System.out.println("User-Agent : " + userAgent ); 
			
			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer); // 이전 주소가 나옴
			
			// 예를 들어 인터넷 서핑하다가 로그인을 하면 첫페이지로 돌아갈 때가 있을 때 그럼 좀 구리고
			// 웹 만들 때 Referer 주소 참조해서 이전페이지로 바로 돌아가게 만들면 좋다.
			
			// 접속 종료
			con.disconnect(); 
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
			
		} catch(IOException e){
			System.out.println("apiURL 접속 오류");
		}
		
	}
	
	public static void ex03() {
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedInputStream in = null; // Daum 로그를 읽어 들이는 입력 스트림
							   // 바이트 스트림이기 때문에 텍스트나 이미지파일이나 전부 받을 수 있다.
		
		BufferedOutputStream out = null; // C:\storage\daum.png로 보내는 출력 스트림
		
		File file = new File("C:" + File.separator + "storage", "daum.png");
		
		try {
			
				url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
				int responseCode = con.getResponseCode();
				if(responseCode == HttpURLConnection.HTTP_OK) {
					
					in = new BufferedInputStream(con.getInputStream());
					out = new BufferedOutputStream(new FileOutputStream(file)); 
																												
					
					byte[] b = new byte[10];
					int readByte = 0;
					
					while((readByte = in.read(b)) != -1) { 
						out.write(b, 0, readByte);
					}
					
					System.out.println("다운로드 완료");
					
					out.close();
					in.close();
					con.disconnect();
					
				}
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
		
	}
	
	public static void ex03_practice() { // ex03 버퍼 사용해보기
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		
		URL url = null;
		
		BufferedInputStream in = null;
		BufferedOutputStream out = null;
		
		File file = new File("C:" + File.separator + "storage", "daum.png");
		
		HttpURLConnection con = null;
		
		try {
				url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
				
				int responseCode = con.getResponseCode(); // 응답 코드를 저장해주고
				if(responseCode == HttpURLConnection.HTTP_OK) { // 그게 만약 정상이면 파일 복사를 시작한다~
				
					in = new BufferedInputStream(con.getInputStream());
					out = new BufferedOutputStream(new FileOutputStream(file));
					
					byte[] b = new byte[10];
					int byteCount = 0;
					
					while((byteCount = in.read(b)) != -1 ) {
						out.write(b, 0, byteCount);
					}
					
					System.out.println("파일 생성 완료");
					
					in.close();
					out.close();
					con.disconnect();
					
				}
			
		} catch(MalformedURLException e) {
			System.out.println("주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		 
	}
	
	public static void ex04() { // 읽어드린 데이터를 문자스트림리더 활용해서 문자열로 바꾸는게 중요하다.
								// 보통 api에서 txt 파일을 읽어드리기 때문에
								// 바이트로 받을거면 스트림을 쓰면 되는데 문자를 읽을거면 스트림리더를써야한다!!!!!
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null; // 한글 깨지면 안되니까 문자를 받을 수 있는 스트림리더를 써야한다.
		BufferedWriter writer = null;
		File file = null;
		
		try {
			
				url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
				
				String message = null;
				int responseCode = con.getResponseCode();
				if(responseCode == HttpURLConnection.HTTP_OK) { 
					reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
					file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
					message = "다운로드 성공";
																		  
				} else { 
					reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
					file = new File("C:" + File.separator + "storage", "다운로드실패.html");
					message = "다운로드 실패";
					
				}
				
				StringBuilder sb = new StringBuilder();
				char[] cbuf = new char[2];
				int readCount = 0;
				
				
				while((readCount = reader.read(cbuf)) != -1) {
					sb.append(cbuf, 0, readCount);
				
				}
				
				writer = new BufferedWriter(new FileWriter(file));
				writer.write(sb.toString());
				
				writer.close();
				reader.close();
				con.disconnect();
			
				System.out.println(message);
				
		} catch (MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
			
		} catch (IOException e) {
			
		}
		
	}
	
	public static void ex04_practice() { // ex04 버퍼 사용해보기
		
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
		
		// 여기에 있는 데이터를 읽어와서 "storage", "다운로드문서.txt" 이 파일 만들어서 여기에 복사하기.
		// 버퍼의 리드라인 사용해보기~
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		File file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
		
		
		try {
			
				url = new URL(apiURL);
				con = (HttpURLConnection)url.openConnection();
				
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			
			
			
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 형식 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex05() { 
		
		/*
			인코딩(암호화) : 원본 데이터를 UTF-8 방식으로 암호화
			디코딩(복호화) : UTF-8 방식으로 암호화된 데이터를 복원
		*/
		
		String data = "한글 english 123456 1@#$+-";
		
		try {
			
			// 인코딩
			String encodeData = URLEncoder.encode(data, "UTF-8");
			System.out.println(encodeData);
			
			// 디코딩
			String decodeData = URLDecoder.decode(encodeData, "UTF-8");
			System.out.println(decodeData);
			
			
		} catch(UnsupportedEncodingException e) { // 오타같이 없는 인코딩값 가져다 썼을 때 나는 예외
			System.out.println("인코딩 실패");
		}
		
		
	}
	
	public static void ex06() { 
		
		// 1시간마다 갱신되는 전국 날씨 정보

		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File file = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			String message = null;
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				file = new File("C:" + File.separator + "storage", "sfc_web_map.xml");
				message = "다운로드 성공";
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				file = new File("C:" + File.separator + "storage", "다운로드실패.html");
				message = "다운로드 실패";
			}
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println(message);
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	public static void main(String[] args) {
		ex06();
	}

}
