package ex06_select;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class MainClass {

	
	// select 결과 행이 1개인 경우
	
	
	public static void ex01() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null; // 오직 SELECT문에서만 사용한다.
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
	
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);

			
			String sql = "SELECT MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE";
			sql += " FROM MEMBER_TBL";
			sql += " WHERE MEMBER_NUMBER = ?";
			
			ps = con.prepareStatement(sql);
			
			int memberNo = 2;
			
			ps.setInt(1, memberNo);
			
			
			rs = ps.executeQuery(); // SELECT문 실행 메소드
			
			// System.out.println(rs.next());	// 첫번째 결과 행이 있으면 true,  없으면 false	
			// System.out.println(rs.next());  // 두번째 결과 행이 있으면 true,  없으면 false
			
			// Member 객체 선언
			// 선언과 생성을 따로 해줘야한다.
			Member member = null;

			
			// 결과 행이 최대 1개 있으므로 if문으로 분기 처리 
			
			if(rs.next()) { // 조회된 결과행이 있다면 객체를 만들어라
							// rs.next : SELECT로 한 행을 긁어온다.                                                              
			// 굳이 if문을 쓰는이유! 왜냐? 
			// 만약에 긁어올게 없으면 객체를 만들 필요가 없는데 if문 없이 아래 코드를 써버리면 긁어온게 없어도 객체를 만들게 된다 
			// 그러니까 if문 조건으로 rs.next를 줘서 긁어올게 있으면 객체를 만든다는 조건을 주는것이다.
				
				// 결과 행의 각 칼럼 정보를 읽어서 Member 객체 만들기
				member = new Member();
				member.setMember_number(rs.getInt("MEMBER_NUMBER"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
				
			} 
			
			// if문이 종료된 뒤, member가 null이라면 조회된 결과가 없었다는 의미가 된다.
			System.out.println(member);
			
			
			/*
				|	MEMBER_NO	|	 ID	 	|	 NAME	|  ADDRESS	|	JOIN_DATE	| 최초 rs가 가르키는 위치 : 없음
				|		2		|  master 	|   운영자 	|	경기	|	23/02/16	| <- 첫번째 rs.next() 호출한 경우
																					  <- 두번째 rs.next() 호출한 경우 결과가 없으므로 false가 반환
			
				-- rs만 가지고는 아무것도 안되고 next 메소드를 사용해야 한다.
				
				1. ResultSet rs 객체는 하나의 행(Row)을 가리키는(찾아갈 수 있는) 포인터 역할이다.
				2. next 메소드르 통해서 각 행(Row)을 가리킬 수 있다.
	        		1) next 메소드를 1번 호출하면 SELECT 전체 결과 중 1행을 가리킨다.
	        		2) next 메소드를 2번 호출하면 SELECT 전체 결과 중 2행을 가리킨다.
	        	3. next 메소드의 호출 결과는 boolean이다.
	        		1) 조회된 결과 행이 있으면 true가 반환된다.
	        		2) 조회된 결과 행이 없으면 false가 반환된다.
	        		
	        	4. 결과 행의 칼럼 정보 가져오는 방법
	        		1) 칼럼의 이름을 그대로 사용한다.
	        		   rs.getInt("MEMBER_NUMBER")
	        		   rs.getString("ID")
	        		   rs.getString("NAME")
	        		   re.getStirng("ADDRESS")
	        		   re.getDate("JOIN_DATE")
	     
	        		2)결과 행의 칼럼 순서대로 번호를 붙여서 사용한다.
	        			rs.getInt(1)
	        			rs.getString(2)
	        			rs.getString(3)
	        			rs.getString(4)
	        			rs.getDate(5)    	       		
	        */
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
	
	// select 결과 행이 2개 이상인 경우
	public static void ex02() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null; // 선언을 위해서 하면 밑에서 띄어쓰기해서 줄 맞추기나 그런 거 할 수 있음.
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
	
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);

			
			sql =  "SELECT MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE";
			sql += "  FROM MEMBER_TBL";	
			
			ps = con.prepareStatement(sql);
						
			rs = ps.executeQuery(); // SELECT문 실행 메소드는 executeQuery()이다.

			// 결과 행이 여러 개 있으므로 ArrayList를 준비한다.
			// ArrayList 계속 나옴.. 확실히 알아두자 add 메소드는 바로 떠올려봐
			List<Member> memberList = new ArrayList<Member>();
			
			// 결과 행이 여러개 있으므로 while문으로 반복 처리
			
			while(rs.next()) { // 조회된 결과행이 있다면 객체를 만들어라
							   // if문과 달리 실행결과가 실패했는지 아닌지 신경 안 씀, 확인할 다른 방법이 있기 때문이다.
				// 결과 행의 각 칼럼 정보를 읽어서 Member 객체 만들기
				Member member = new Member();
				member.setMember_number(rs.getInt("MEMBER_NUMBER"));
				member.setId(rs.getString("ID"));
				member.setName(rs.getString("NAME"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
	
				// Member 객체를 ArrayList에 저장하기
				// while문이 1번 돌 때마다 member 객체를 ArrayList에 저장한다.
				memberList.add(member);		
			} 
			
			// while문이 종료된 뒤, ArrayList의 크기가 0이라면 조회된 결과가 없었다는 의미가 된다.
			for(int i = 0; i < memberList.size(); i++) {
				System.out.println(memberList.get(i));
			}

			
		/*
			|	MEMBER_NO	|	 ID	 	|	 NAME	|  ADDRESS	|	JOIN_DATE	| 최초 rs가 가르키는 위치 : 없음
			|		2		|  master 	|   운영자 	|	경기	|	23/02/16	| <- 첫번째 rs.next() 호출한 경우
			|		3		|  user	 	|   사용자 	|	서울	|	23/02/01	| <- 두번째 rs.next() 호출한 경우
																				  <- 세번째 rs.next() 호출한 경우 결과가 없으므로 false가 반환
																				     false가 반환되면 무한루프문이 종료된다.
		*/
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) {
					rs.close();
				}
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
