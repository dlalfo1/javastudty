package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberTableMainClass {

	public static void ex01() {

		// Connection 생성
		Connection con = null;
		
		try {
			
			// 오라클 드라이버 로드
			Class.forName("oracle.jdbc.OracleDriver"); // forName 메소드 : 클래스 이름으로 클래스 갖다 쓰기.
													  // 빌드패스를 잡지 않거나 오타가 나면 예외가 발생한다.
			
			// 프로퍼티 파일 읽어서 프로퍼티 객체 생성
			Properties p = new Properties();
		    p.load(new BufferedReader(new FileReader("db.properties")));
		    
		    // 프로퍼티 객체에 저장된 각 프로퍼티(속성) 가져오기
		    String url = p.getProperty("url");
		    String user = p.getProperty("user");
		    String password = p.getProperty("password");
		    
		    // Connection 생성 (커넥션은 오라클 드라이버 매니저가 만들어준다.)
		    // 프로퍼티의 이름은 정해진 것이 아니다. url, user, password 말고 다른 단어로 만들어도 된다.
		    // 하지만 나중엔 정해진 이름을 사용한다.
		    con = DriverManager.getConnection(url, user, password);
		    
		    System.out.println("접속되었습니다.");
		    
		  	    
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		/* 2. 쿼리문 작성 및 실행 */
		
		/*
			PreparedStatement 인터페이스 (접속하고 나면 얘가 다 해주는거임 이제)
			1. Prepared  : 미리 준비하시오.
			2. Statement :  쿼리문을
			3. 작성된 쿼리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행한다. 
		    4. Statement : 인터페이스는 보안 문제로 사용하지 않는 것이 좋다. (사용 X)

		*/
		
		// 주의! jdbc에서는 쿼리문의 마지막에 세미콜론(;)을 붙이지 않는다.
		StringBuilder sb = new StringBuilder(); // 쿼리문이 기니까 StringBuilder 생성해서 처리
		sb.append("CREATE TABLE MEMBER_TBL (");
		sb.append("MEMBER_NUMBER NUMBER NOT NULL"); 
		sb.append(", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE");
		sb.append(", NAME VARCHAR2(30 BYTE) NOT NULL");
		sb.append(", ADDRESS VARCHAR2(30 BYTE)");
		sb.append(", JOIN_DATE DATE NOT NULL"); // 여기서 세미콜론(;) 붙이면 안 됨!
		sb.append(", CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NUMBER))"); // 여기서 세미콜론(;) 붙이면 안 됨!
		// 칼럼 만들 때 PK키 바로 선정하면 PRIMARY KEY 키워드 뒤에 괄호치고 칼럼명 안 넣어줘도 된다.
		// 마지막 줄에 따로 뺄 때나 칼럼명이 필요한 것이다.
		
		String sql = sb.toString();
		
		PreparedStatement ps = null; // PreparedStatement도 예외처리가 필요하기 때문에 선언 먼저 한다.
		
		try {
			
			// PreparedStatement 객체 생성
			ps = con.prepareStatement(sql); // 쿼리문을 미리 만들어두어야 PreparedStatement 객체를 생성할 수 있다.
			
			// 쿼리문 실행하기
			ps.execute();
			System.out.println("쿼리문이 실행되었습니다.");
		} catch(Exception e) { // 정확히는 SQLException 발생한다.
			e.printStackTrace();
		} 
		
		
		/* 3. 사용한 자원 반납하기 */
		
		try {
			
			if(ps != null) ps.close(); // if문에 조건이 하나만 있으면 중괄호 안 써줘도 된다. 하지만 써주는게 좋다.
			if(con != null) {
				con.close();
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		
		// 커넥션, 쿼리문 실행, 사용한 자원 반납하기 이게 하나의 쿼리문을 실행하기 위한 순서이다.
		
		
}	
	public static void ex02() { // ex01 연습
		
		/* 테이블 만들기
		
		CREATE TABLE MEMBER_TBL (
		MEMBER_NUMBER NUMBER NOT NULL
		, ID VARCHAR2(30 BYTE) NOT NULL UNIQUE
		, NAME VARCHAR2(30 BYTE) NOT NULL
		, ADDRESS VARCHAR2(30 BYTE)
		, JOIN_DATE DATE NOT NULL
		, CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NUMBER)
		
		); 		 
		
		*/
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);

			String sql = "CREATE TABLE MEMBER_TBL (";
			sql += "MEMBER_NUMBER NUMBER NOT NULL";
			sql += ", ID VARCHAR2(30 BYTE) NOT NULL UNIQUE";
			sql += ", NAME VARCHAR2(30 BYTE) NOT NULL";
			sql += ", ADDRESS VARCHAR2(30 BYTE)";
			sql += ", JOIN_DATE DATE NOT NULL ";
			sql += ", CONSTRAINT PK_MEMBER PRIMARY KEY(MEMBER_NUMBER))";
		
			
			ps = con.prepareStatement(sql);
			
			
			ps.execute();
			System.out.println("쿼리문이 실행되었습니다.");	
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		

		
	}

	public static void main(String[] args) {
		ex02();
		
}

}
 