package ex01_connection;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class MainClass {
	
	public static void ex01() {
		
		// 클래스를 로드하는 방법(메모리에 로드한다 : 사용하겠다)
		// try catch가 먼저 요구된다.
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // oracle.jdbc.driver.OracleDriver도 가능하다.
			System.out.println("클래스가 로드되었습니다.");
			
			
		} catch(ClassNotFoundException e) {
			e.printStackTrace(); // 혹시 예외라면 오타찾고, 빌드패스 확인하면 된다.
		}
		
	}
		
	public static void ex02() {
		
		
		// Oracle DataBase와 연결할 때 사용하는 Connection 인터페이스
		
		Connection con = null; // 선언만 필요한 이유 : 예외처리 때문에
		
		// Oracle 접속 정보 (DB 사용시 언제나 필요한 정보이다.)
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 오라클 xe버전이 가벼운 버전이라 thin이라 부른다.
		String user = "GDJ61";
		String password = "1111";
		
		// DriverManager 클래스로부터 Connection 객체를 받아 온다.
		
		try {
			 
			con = DriverManager.getConnection(url, user, password);
			System.out.println("DB에 접속되었습니다.");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		// 사용이 끝난 Connection 객체는 반드시 닫아야 한다.
		
		try {
			
			if(con != null) {
				con.close(); // 예외가 발생해서 트라이캐치문 필요하다.		
							 // 커넥션은 필수로 닫아줘야 한다.
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
	}
		
		
		
	public static void ex03() {
		
		// 정리 : 코드는 길어졌지만 이렇게 깃에 올리면 id와 pw를 노출시키지 않을 수 있다.
		
		// 프로퍼티 파일을 읽는 문자 입력 스트림 생성하기
		BufferedReader reader = null;
		Connection con = null;
		
		try {
			
			reader = new BufferedReader(new FileReader("db.properties"));
			
		
			// 프로퍼티 파일을 읽어서 프로퍼티 객체 생성하기
			Properties properties = new Properties(); // 디폴트타입으로 생성해야 한다(리더로 읽은 값을 이용해서 객체를 사용하는 방법은 없다.)
			properties.load(reader); // load 메소드 사용하여 리더를 불러온다. (예외처리 필요하다.)
		
			//프로퍼티 객체에 저장된 각 Property 읽기 (user와 password를 뜻한다.)
			String url = properties.getProperty("url");
			String user = properties.getProperty("user"); // getProperty 메소드를 사용해서 프로퍼티 파일의 프로퍼티를 가져온다.
			String password = properties.getProperty("password"); 
			
			// DriverManager로부터 Connection 객체 얻기
			con = DriverManager.getConnection(url, user, password); // SQLEXCEPTION 처리 필요
			System.out.println("DB에 접속되었습니다.");
			
	} catch (IOException e) {
		
		e.printStackTrace();
		
	} catch(SQLException e){ // 실제로 개발할 땐 이렇게 나눌 필요 없다 EXCEPTION으로 다 받으면 된다.
		e.printStackTrace();
	} finally {
		
		try {
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	 }
		
	}
		
	public static Connection getConnection() { // 반환할게 있으니 void타입이 아니다.
		
	
		Connection con = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties properties = new Properties();
			properties.load(new BufferedReader(new FileReader("db.properties"))); // 이 안에 객체가 생기는게 어케되는..?
			
			con = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("user"), properties.getProperty("password"));
			
			
		} catch(Exception e) { // ClassNotFoundException, SQLException, IOException 을 처리해준다.
			e.printStackTrace();
		}
		
		return con;
		
		// con을 반환할 때 커넥션을 닫아서 주지 않는다. 닫으면 사용할 수 없기 때문이다. 그러므로 finally문이 없다.
		// 커넥션 닫는 메소드를 따로 만들어 줘야 한다.
	}
	
	public static void main(String[] args) {
		Connection con = getConnection();
		System.out.println("DB에 접속되었습니다.");
		
		// con.close(); 하려면 여기서 해야한다. 물론 트라이캐치문 필요하다.
		


	}

}
