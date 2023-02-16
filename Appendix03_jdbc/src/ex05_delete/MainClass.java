package ex05_delete;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MainClass {

	public static void main(String[] args) {


		

		Connection con = null; // 데이터베이스 접속
		PreparedStatement ps = null; // 쿼리문 실행
		
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // 클래스로드
			
			Properties p = new Properties(); // 프로퍼티 객체 생성
			p.load(new BufferedReader(new FileReader("db.properties"))); // 프로퍼티 파일 읽음
			
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 접속할 주소 만들어줌
			
		    con = DriverManager.getConnection(url,p); // 주소로 접속함
		    
		    // 쿼리문 작성
		    // 회원번호가 1인 회원을 삭제하시오
		    
		    String sql = "DELETE FROM MEMBER_TBL WHERE MEMBER_NUMBER = ?";
		    
		    ps = con.prepareStatement(sql);
		    int memberNo = 1;
		    ps.setInt(1, memberNo);
		    
		    
		
		    int delResult = ps.executeUpdate();  // 쿼리문이 제대로 실행됐다면 반환될 int값을 넣을 변수 선언
		    
		    System.out.println(delResult + "개의 행이 삭제되었습니다.");
			// MEMBER_TBL 테이블의 MEMBER_NUMBER가 1인 행이 삭제된다.
		    // => BOARD_TBL의 작성게시글도 사라진다. MEMBER_NUMBER 외래키 옵션이 ON DELETE CASCADE 이기 때문에
		    //    기본키가 사라지면 외래키+외래키의 값들이 사라진다.
			
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
