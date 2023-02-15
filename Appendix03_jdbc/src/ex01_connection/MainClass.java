package ex01_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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
		
		
		
		
		
		
		
		
		

	public static void main(String[] args) {
	
		ex02();
		
		
		
		
		
		

	}

}
