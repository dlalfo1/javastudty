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


public class Select_Practice_MainClass {
	
	public static void ex01() {
	

	// select 결과 행이 1개인 경우
	
	
	// 셋 다 예외처리가 필요하기 때문에 선언만 먼저 해준다.	
    
	// 데이터베이스와 접속을 위한 클래스
	Connection con = null;
	
	// 작성된 쿼리문을 전달하면 해당 쿼리문을 실행해 주는 역할을 수행하는 클래스
	PreparedStatement ps = null; 
	
	// SELECT문의 결과를 저장하기 위한 클래스 (오직 SELECT문에서만 사용한다.)
	
	/* ResultSet은 Select문의 결과를 저장하는 하나의 '객체'로서  저장된 '데이터'를 한 행 단위로 불러올 수 있다.
       그리고 한 행에서 값을 가져올 때는 타입을 지정해 불러올 수 있는 특징도 가지고 있다.
       이 ResultSet과 함께 사용되는 메소드가 바로 executeQuery 메소드로 SELECT 문을 실행할 때 사용되는 메소드이다.
	*/
	ResultSet rs = null; 
	
	// 쿼리문을 담을 String 변수를 선언만 해준다.(이렇게 하면 try문 안에서 띄어쓰기 사용해서 쿼리문을 줄맞춤 할 수 있다.)
	String sql = null;
	
	
	// 예외처리 하기 위해서 객체 생성은 try문 안에서 해준다.
	
	try {
		
		// forName 메소드로 클래스의 이름을 불러와 OracleDriver를 로딩한다.(사용할 수 있게 한다.)
		Class.forName("oracle.jdbc.OracleDriver"); 
		
		// 프로퍼티 파일을 사용하기 위해 객체를 생성한다.
		Properties p = new Properties(); 
		
		//load 메소드 사용하여 리더를 통해 프로퍼티 파일을 읽어온다.
		p.load(new BufferedReader(new FileReader("db.properties")));
		
		// 데이터베이스와 연결하기 위한 url을 String에 담아준다
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		
		// java.sql.DriverManager 클래스 안에 getConnection이라는 메소드를 통해서 url과 프로퍼티 값을 넣고 Connection 객체 생성을 해서 반환한다
		con = DriverManager.getConnection(url, p); 
		
		// String 변수를 사용해 쿼리문을 작성해준다
	    sql = "SELECT MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE";
		sql += " FROM MEMBER_TBL";
		sql += " WHERE MEMBER_NUMBER = ?";
		
		// prepareStatement 메소드를 사용해서 쿼리문이 담긴 객체를 생성해준다.
		ps = con.prepareStatement(sql);
		
		
		// 물음표(?)로 변수처리한 WHERE절에 값을 넣어주기 위해 변수를 선언하고 해당값을 넣어준다.
		int memberNo = 1;
		
		// setInt 메소드를 사용해서 int값을 가진 변수에 값을 넣어줄 수 있다.
		// 첫번째 물음표에 memberNo값을 넣어준다는 뜻
		ps.setInt(1, memberNo);
		
		// 변수에 값도 넣어주고 쿼리문을 완성했으니 이제 실행한다.
		// executeQuery 메소드를 사용해서 쿼리문을 실행시키고 그걸 저장한 ResultSet 객체를 생성한다.
		rs = ps.executeQuery();
		

		// Member 객체 선언
		// 선언과 생성을 따로 해줘야한다.
		Member member = null;

		// 결과 행이 최대 1개 있으므로 if문으로 분기 처리 (결과행이 1개일시 if문을 쓴다.)
		// ResultSet 클래스의 next 메소드를 사용하여 SELECT절을 한 행씩 읽어온다.
		
		// 결과 행이 있으면 true, 없으면 false를 반환한다.
		
		/*
		  굳이 if문을 써서 Member 객체를 생성하는 이유는?
		  만약에 긁어올게 없으면 객체를 만들 필요가 없는데 if문을 사용하지 않는다면 결과행이 없어도 객체를 만들게 된다.
		  그러니까 if문 조건으로 rs.next를 줘서 긁어올게 있으면 객체를 만든다는 조건을 주는것이다.
		*/	
		// rs만 가지고는 아무것도 안되고 next 메소드를 사용해야 한다.
		
		if(rs.next()) {
			
			// 결과 행의 각 칼럼 정보를 읽어서 Member 객체 만들기
			
			// Member객체를 생성한다
			member = new Member();
			
			// ResultSet의 get메소드를 사용해서 해당 칼럼의 값을 가져와
			// Member객체의 set메소드로 객체의 필드값을 초기화해준다.
			
			// rs.get을 통해서 칼럼명(String)을 넣으면 칼럼의 정보를 가져다준다
			// getString, getDate도 마찬가지다.
			member.setMember_number(rs.getInt("MEMBER_NUMBER"));
			member.setId(rs.getString("ID"));
			member.setName(rs.getString("NAME"));
			member.setAddress(rs.getString("ADDRESS"));
			member.setJoin_date(rs.getDate("JOIN_DATE"));
			
			
			// if문이 종료된 뒤, member가 null이라면 조회된 결과가 없었다는 의미가 된다.
			// member를 출력하면 Member 클래스의  toString 메소드로 원하는 문자열이 출력된다.


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
			
		}
		
		
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
	}
	public static void ex02() {
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = null;
		
		try {
			
			Class.forName("oracle.jdbc.OracleDriver");
			
			Properties p = new Properties();
			p.load(new BufferedReader(new FileReader("db.properties")));
			
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			con = DriverManager.getConnection(url, p);
			
			sql =  "SELECT MEMBER_NUMBER, ID, NAME, ADDRESS, JOIN_DATE";
			sql += "  FROM MEMBER_TBL";	
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			// 결과 행이 여러 개 있으므로 ArrayList를 준비한다.
			List<Member> memberList = new ArrayList<Member>();
			
			// 결과 행이 여러개 있으므로 while문으로 반복 처리
			
			// next 메소드를 사용해서 읽어온 값이 true라면 객체를 만들어라
			// while문이 반복될 동안 조건문안에 객체를 생성해서 행을 읽어올 때 마다 객체를 생성해준다.
			//  // if문과 달리 실행결과가 실패했는지 아닌지 신경 안쓴다. 확인할 다른 방법이 있기 때문이다.
			while(rs.next()) {
				
			
				// 결과 행의 각 칼럼 정보를 읽어서 Member 객체 만들기
				Member member = new Member();
				member.setMember_number(rs.getInt("MEMBER_NUMBER"));
				member.setId(rs.getString("ID"));
				member.setAddress(rs.getString("ADDRESS"));
				member.setJoin_date(rs.getDate("JOIN_DATE"));
						
				// Member 객체를 ArrayList에 저장하기
				// while문이 1번 돌 때마다 member 객체를 ArrayList에 저장한다.
				memberList.add(member);
				
			}
			
			// while문이 종료된 뒤, ArrayList의 크기가 0이라면 조회된 결과가 없었다는 의미가 된다.
			// while문을 통해서 읽어온내용으로 객체를 생성해줬기 때문에
			// memberList길이 만큼 for문을 돌려서 인덱스를 출력하면 
			// SELECT한 결과가 출력된다.
			for(int i = 0; i < memberList.size(); i++) {
				System.out.println(memberList.get(i));
			}
		
		} catch(Exception e) {
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
