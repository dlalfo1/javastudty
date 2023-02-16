package ex03_insert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {
	
	// INSERT의 RETURN 타입은 int값이다.
	// INSERT 실행 후 1 행 이(가) 삽입되었습니다. => 여기서 1이 반환되는 것
	// INSERT가 실패한다면 0이 반환된다.
	// executeUpdate() 메소드가 DML 처리를 해준다. => 메소드가 실행되면 int값이 반환되는 것이다.
	// 상수 삽입
	public static void ex01() {
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url,p); // 프로퍼티 파일의 id, password를 String으로 꺼내지 않고 직접 넣는방법
													  // url도 똑같이 할 수 있으나 url 입력 연습하기 위해서 냅둠
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, 'admin2', '관리자', '서울' , TO_DATE('2023-02-15' , 'YYYY-MM-DD'))";
			
			
			// jdbc는 오토커밋이기 때문에 따로 커밋처리할 필요가 없다.
			// con.setAutoCommit(false); 이 작업을 하게 되면 오토커밋을 끄고 내가 원하는 시점에 커밋할 수 있다.
			
			ps = con.prepareStatement(sql);
			
			int insResult = ps.executeUpdate(); // 이제 excute메소드는 사용 X, 앞으로 executeUpdate 메소드 사용한다.
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
			
			
		} catch(Exception e){
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close(); // ps를 먼저 닫는 이유 => 나중에 만들걸 먼저 닫는거다.(분해의 역순)
				}
				if(con != null) {
					con.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	
	
	// 변수 삽입 (실제로 중요!)
	
	public static void ex02() {
		
		Connection con = null;;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, p);
			
		
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			
			// ? => 컬럼에 들어갈 값들이 변수라는 뜻
			
			ps = con.prepareStatement(sql);
			
			String id = "master";
			String name = "운영자";
			String address = "경기";
			
			ps.setString(1, id); // 1번째 물음표(?) 자리에 id를 넣으시오.
			ps.setString(2, name); // 2번째 물음표(?) 자리에 name를 넣으시오.
			ps.setString(3, address); // 3번째 물음표(?) 자리에 address를 넣으시오.
			
			// setInt : int값
			// setDouble : double값
			
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null){
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		}

	public static void ex03() { // ex02 변수삽입 연습
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			String sql = "INSERT INTO MEMBER_TBL(MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE)";
			sql += " VALUES(MEMBER_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			
			ps = con.prepareStatement(sql);
			
			String id = "master";
			String name = "운영자";
			String address = "제주";
			
			ps.setString(1, id);
			ps.setString(2, name);
			ps.setString(3, address);
			
			
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개 행이 삽입되었습니다.");
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps != null) {
					ps.close();
				}
				if(con != null) {
					con.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
	}
	
	// admin이 작성한 임의의 게시물 삽입(BOARD_TBL)
	public static void ex04() {
		
		
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			con = DriverManager.getConnection(url, p);
			
			String sql = "INSERT INTO BOARD_TBL(BOARD_NO, MEMBER_NUMBER, TITLE, CONTENT, CREATE_DATE)";
			sql += " VALUES(BOARD_SEQ.NEXTVAL, ?, ?, ?, SYSDATE)";
			
			
			ps = con.prepareStatement(sql);
			
			
			int memberNo = 1;
			String title = "오늘은 목요일";
			String content = "보충은 취소되었소";
			
			ps.setInt(1, memberNo);
			ps.setString(2, title);
			ps.setString(3, content);
			
			int insResult = ps.executeUpdate();
			
			System.out.println(insResult + "개의 행이 삽입되었습니다.");					
			
			
		} catch(Exception e) {
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
		ex04();
		
		
		
		
		
		
		
		
		
		
		
	}

}
