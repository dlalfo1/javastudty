package ex02_create;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

public class MemberSeqMainClass {
	
	public static void ex01() {
		
		
				
		Connection con = null;
		PreparedStatement ps = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver"); // 이 작업은 컴퓨터 켜져있을 때 한번만 해주면 된다.
			
			Properties p = new Properties();
			
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = p.getProperty("url");
			String user = p.getProperty("user");
			String password = p.getProperty("password");
			
			con = DriverManager.getConnection(url, user, password);
			
			String sql = "CREATE SEQUENCE MEMBER_SEQ NOCACHE";
			
			ps = con.prepareStatement(sql);
			if(ps.execute()) {
				System.out.println("MEMBER_SEQ가 생성되었습니다.");			
			} else {
				System.out.println("MEMBER_SEQ 생성이 실패했습니다.");
			}
			
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	} 
		
	}
	
	public static void main(String[] args) {
		ex01();
	
	

}

}