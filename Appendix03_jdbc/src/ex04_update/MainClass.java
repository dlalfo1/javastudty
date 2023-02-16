package ex04_update;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {

	public static void main(String[] args) {

		
		
		
	/*	
		UPDATE BOARD_TBL 
		SET TITLE = '[New] 오늘은 목요일'
		WHERE MEMBER_NUMBER = (SELECT MEMBER_NUMBER
								 FROM MEMBER_TBL
								WHERE ID = 'admin');
		
	*/	
		
		Connection con = null; // 데이터베이스 접속
		PreparedStatement ps = null; // 쿼리문 실행
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스로드
			
			Properties p = new Properties(); // 프로퍼티 객체 생성
			p.load(new BufferedReader(new FileReader("db.properties"))); // 프로퍼티 파일 읽음
			
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 주소 만들어줌
			
		    con = DriverManager.getConnection(url,p); // 주소로 접속함
		    
		    // 쿼리문 작성
		    // id가 admin인 회원이 작성한 게시글의 TITLE 앞에 "[New]"를 추가하시오.
		    String sql = "UPDATE BOARD_TBL SET TITLE = '[New]' || TITLE"; 
		    sql += " WHERE MEMBER_NUMBER = (SELECT MEMBER_NUMBER FROM MEMBER_TBL WHERE ID = ?)";
		    		 // PK,UQ가 포함된 키가 값으로 들어가 있기 때문에 단일행 서브쿼리임 => 대입연산자 사용 가능
		    
		    ps = con.prepareStatement(sql); // 쿼리문 실행
		    
		    String id = "admin2";
		    
		    ps.setString(1, id);
		    
		    int updateResult = ps.executeUpdate();  // 쿼리문이 제대로 실행됐다면 반환될 int값을 넣을 변수 선언
		    
		    System.out.println(updateResult + "개의 행이 수정되었습니다.");
			
			
		}catch(Exception e) {
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
	
	
	

}
