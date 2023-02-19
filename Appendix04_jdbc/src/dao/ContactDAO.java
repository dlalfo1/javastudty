package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.sun.source.tree.CatchTree;

import dto.ContactDTO;

	/*
		DAO
		1. Database Access 	Object
		2. Database에 접근해서 쿼리문을 실행하고 쿼리문의 실행 결과를 받아온다.
		3. 여러 객체가 만들어 지지 않도록 singleton 패턴으로 생성한다.
			=> ex) 객체1이 INSERT하는동안 객체2가 SELECT 하지 않도록 DAO를 하나만 만든다. 걔가 모든일 다함. 완전 머슴임
	*/
	
	public class ContactDAO {
		
		/************ 1. singleton **************/
		
		// 필드에 미리 ContactDAO 객체를 생성해둔다. (외부에서 못 본다.)
		private static ContactDAO dao = new ContactDAO(); 
		
		// 외부에선 객체를 못 만들게 막아놓는다. (외부에서 못 본다.)
		// 원래 디폴트 생성자는 굳이 만들지 않아도 자동으로 생성되지만
        // private으로 막아놓기 위해서 생성해준다.
		private ContactDAO()  {	} 
		
		// getInstance 메소드로 내가 만들어놓은 객체를 갖다 쓴다. (해당 클래스의 인스턴스를 반환하는 역할을 수행)
		// static 메소드는 클래스메소드라고도 한다 => 클래스 이름으로만 호출이 가능하기 때문이다.
		public static ContactDAO getInstance() {
			return dao;
		}
	
		
		/************ 2. field **************/
		// 필드란? 메소드들이 공통으로 사용할 변수들을 선언해주는곳
		// => ContactDAO 클래스의 메소드들이 공통으로 사용할 요소를 선언한다.
		
		private Connection con; // 데이터베이스 접속을 담당하는 인터페이스
		private PreparedStatement ps; // 쿼리문 실행을 담당하는 인터페이스
		private ResultSet rs; // SELECT문 결과 처리를 담당하는 인터페이스
		private String sql; // 쿼리문 자체 (쿼리문을 저장함)
		private int res; // INSET, UPDATE, DELETE 결과 저장 (ex) 1개의 행이 수정되었습니다.)
		
	
		/************ 3. method  **************/
		
		// CRUD(DB기본작업) : CREATE(INSERT), READ(SELECT), UPDATE, DELETE 
		
		// CRUD 메소드의 진행 순서 : 1.Connection 얻기 -> 2.CRUD 작업 -> 3.사용한 자원 반납
		// => Connection 얻기, 사용한 자원 반납은 항상 필요한 기능이므로 메소드화 시킨다. (한번 만들어놓고 간편하게 호출해서 사용할 수 있도록)
		
		
		// 공통 메소드 -1 (Connecton 얻기)
		// dao의 getConnection 메소드를 사용하면 DB접속까지의 작업을 처리한다.
		private Connection getConnection() {
			
		
			Connection con = null; 
			
			try {
				
				Class.forName("oracle.jdbc.OracleDriver");
				
				Properties p = new Properties();
				p.load(new BufferedReader(new FileReader("db.properties")));
				
				con = DriverManager.getConnection(p.getProperty("url"), p); 
					
			} catch (Exception e){
				e.printStackTrace();
			}
			
			return con;
			
		}
		
		// 공통 메소드 -2 (사용한 자원 반납)
		// dao의 close 메소드를 호출하면 열려있는 연결들을 닫아준다.
		private void close() {
			try {
				// if문의 조건이 1개일 경우 중괄호({ })를 적지 않아도 된다.
				if(rs != null) rs.close();
				if(ps != null) ps.close();
				if(con != null) con.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// CRUD 메소드 -1 (연락처 추가하기)
		// 1. 반환값은	: 0(실패) 또는 1(성공)
		// 2. 매개변수  : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.
		
		
		// CRUD 메소드 이름 지을 때는 DB 친화 짓는게 좋다.
		// ContactDTO 객체를 생성하고 set메소드로 필드값을 저장해준것이 insertContact 메소드의 매개변수로 들어올것이다.
		// insertContact 메소드는 이미 ContactDTO 객체에 이름, 전화번호,이메일, 주소등 모든 정보가 저장되어 있다고 생각하고 동작되는 곳이다.
		// 정보를 저장하는 코드는 DAO에 나오지 않는다.
		// 다른 패키지의 클래스 가져다 쓰는거니까 ContactDAO import 해줘야 한다.
		// ContactServiceImpl 클래스에서 사용자한테 입력 받은 값들을 가진 DTO contact 객체를 매개변수로 받아
		// get메소드를 사용하여 값들을 빼온 후 sql 쿼리문 변수에 대입하고 executeUpdate로 실행시켜준다.
		
		public int insertContact(ContactDTO contact) { 
			
			try {
				
				 // 필드로 선언해놓은 con
				 // 접속은과 자원반납은 어떤 메소드에서도 똑같이 반복해줘야한다.
				con = getConnection();
				
				// 쿼리문 작성, 변수는 물음표(?)로 처리
				sql = "INSERT INTO CONTACT_TBL(CONTACT_NO, NAME, TEL, EMAIL, ADDRESS) VALUES(CONTACT_SEQ.NEXTVAL, ?, ?, ?, ? )";
				
				// ps에 쿼리문 전달
				ps = con.prepareStatement(sql);
				
				// 쿼리문의 변수처리된 곳에 get메소드로 값을 넣어주는 작업
				// 지금 작성되는 메소드에서는 이미 contact에 모든 정보가 들어가있다고 생각하는 것이다.(아직 필드값에 원하는 정보는 저장하지 않았다.)
				// ContactServiceImpl에서 contact객체를 생성해 사용자로부터 입력받은 값을 저장하고
				// contact객체의 값을 get메소드로 가져와 set메소드로 쿼리문의 변수에 대입하여 쿼리문을 실행한다.
				ps.setString(1, contact.getName());
				ps.setString(2, contact.getTel());
				ps.setString(3, contact.getEmail());
				ps.setString(4, contact.getAddress());
				
				// 쿼리문 실행
				res = ps.executeUpdate();
				
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return res;
			
		}
			
		// CRUD 메소드 -2 (연락처 삭제하기)
		// 1. 반환값	: 0(실패) 또는 1(성공)
		// 2. 매개변수  : int contact_no 변수에는 삭제할 연락처의 고유 번호가 저장되어 있다.
		// 다른 값과 다른 고유한 값으로 삭제해야 정확하다.
		public int deleteContact(int contact_no) {
			
			try {
				
				con = getConnection();
				sql = "DELETE FROM CONTACT_TBL WHERE CONTACT_NO = ?";
				ps = con.prepareStatement(sql);
				ps.setInt(1, contact_no);
				res = ps.executeUpdate(); // 쿼리문 실행한걸 res에 넣어준다.
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return res; // 메소드를 호출하면 res값을 반환한다. => 즉 쿼리문이 실행된다.
		}
		
		// CRUD 메소드 -3 (이름을 이용한 연락처 조회하기)
		// 연락처를 삭제할 때 이름으로 정보를 확인한뒤 contact_no로 확실하게 지우기 위하여.
		// 1. 반환값	: List<ContactDTO>
		// 2. 매개변수	: String name 변수에는 조회할 연락처의 이름이 저장되어 있다.
		// ContactDTO는 하나의 정보 객체이기 때문에 얘를 List에 담아준다.
		// List에 들어있는 연락처정보를 이름으로 조회해서 빼오는 기능.
		// List는 순서가 있으며 중복이 허용된다.
		
		 /* 
			 이 코드는 이름을 통해 연락처 정보를 조회하는 메소드이다.
			 매개변수로 입력된 이름과 일치하는 데이터를 데이터베이스에서 조회한 후, 
			 조회된 데이터를 ContactDTO 객체로 생성하여 리스트에 담아 반환한다.
		 */
		public List<ContactDTO> selectContactsByName(String name) {
			
			
			List<ContactDTO> contactList = new ArrayList<ContactDTO>();
			
			try {
				
				con = getConnection();
				
				// 데이터베이스에서 이름이 일치하는 데이터를 조회하기 위한 SQL 쿼리문을 작성
				sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
				sql += " FROM CONTACT_TBL";
				sql += " WHERE NAME = ?";
				
				// 작성된 SQL 쿼리문을 실행하기 위한 PreparedStatement 객체를 생성하고, 매개변수로 쿼리문을 넣어준다.
				ps = con.prepareStatement(sql);
				
				// 입력된 name을 쿼리문의 변수에 대입한다.
				ps.setString(1, name);
				
				// executeQuery() 메소드를 통해 SQL 쿼리문을 실행하고 결과값을 ResultSet 객체로 받아온다.
				rs = ps.executeQuery();
				
				// 결과행이 2개이기 때문에 while문을 돌린다.
				// ResultSet 객체에 조회된 데이터가 존재하는 동안 while문을 실행
				// rs 객체는 행 단위로 처리한다.
				while(rs.next()) {
					
					ContactDTO contact = new ContactDTO();
					
				// 조회된 데이터로부터 ContactDTO 객체를 생성한다.
				// ResultSet 객체의 getInt(), getString() 메소드를 통해 
				// 조회된 데이터를 추출하여 ContactDTO 객체의 필드에 값을 저장한다.
				// 예를 들면 이름을 정숙으로 입력했으면 정숙의 정보가 입력된 contact 객체가 List에 담기는것이다.
					contact.setContact_no(rs.getInt("CONTACT_NO"));
					contact.setName(rs.getString("NAME"));
					contact.setTel(rs.getString("TEL"));
					contact.setEmail(rs.getString("EMAIL"));
					contact.setEmail(rs.getString("ADDRESS"));
					
					
					contactList.add(contact);
					
				}
				
	
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return contactList;
		
			
		}
		
		// CRUD 메소드 -4 (연락처 수정하기)
		// 1. 반환값	: 0(실패) 또는 1(성공)
		// 2. 매개변수  : ContactDTO contact 객체에는 연락처 정보(name, tel, email, address)가 모두 저장되어 있다.
		public int updateContact(ContactDTO contact) {
			
			try {
				
				con = getConnection();
				sql =  "UPDATE CONTACT_TBL";
				sql += "   SET NAME = ?, TEL = ?, EMAIL = ?, ADDRESS =? ";
				sql += " WHERE CONTACT_NO = ?";
				ps = con.prepareStatement(sql);
				ps.setString(1, contact.getName());
				ps.setString(2, contact.getTel());
				ps.setString(3, contact.getEmail());
				ps.setString(4, contact.getAddress());
				ps.setInt(5, contact.getContact_no());
				res = ps.executeUpdate();
				
			} catch(Exception e){
				e.printStackTrace();
			} finally {
				close();
			}
			
			return res;
			
			
		}
		
		// CURD 메소드 -5 (연락처 No를 이용한 연락처 조회하기)]
		// 1. 반환값	: ContactDTO => 연락처 No는 PK 이므로 값이 하나이기 때문에
		// 2. 매개변수  : int contact_no 변수에는 조회할 연락처의 고유 번호가 저장되어 있다.
		
		
		public ContactDTO selectContactByNo(int contact_no) {
			// 같은 이름이 있을경우 한번더 contact_no를 확인해주는 작업
			
			ContactDTO contact = null;
			// contact값을 바꾸지 못했다면 null값이 넘어가는 경우도 있는것.
		
		try {
			
			con = getConnection();
			sql  = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
			sql += "  FROM CONTACT_TBL";
			sql += " WHERE CONTACT_NO = ?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, contact_no);
			rs = ps.executeQuery();
		  
			// 결과행이 1개이니까 if문 사용
		    if(rs.next()) {
		    	contact = new ContactDTO();
		    	contact.setContact_no(contact_no);
		    	contact.setName(rs.getString(2)); // getString("NAME")과 같다. 열이 올 수 있다.(2열)
		    	contact.setTel(rs.getString(3));
		    	contact.setEmail(rs.getString(4));
		    	contact.setAddress(rs.getString(5));
		    }
		
		} catch(Exception e) {
			 e.printStackTrace();
		} finally {
			close();
		}
		return contact;
		
		}
		
		// CRUD 메소드 -6 (연락처 전체 조회하기)
		// 1. 반환값	: List<ContactDTO>
		// 2. 매개변수	: 없다
		
		public List<ContactDTO> selectAllContacts() {
			
			
			List<ContactDTO> contactList = new ArrayList<ContactDTO>();
			
			try {
				
				con = getConnection();
				sql = "SELECT CONTACT_NO, NAME, TEL, EMAIL, ADDRESS";
				sql += " FROM CONTACT_TBL";
				sql += " ORDER BY CONTACT_NO DESC";
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				// 결과행이 2개이기 때문에 while문을 돌린다.
				
				while(rs.next()) {
					
					
					// rs 객체는 행 단위로 처리한다.
					ContactDTO contact = new ContactDTO();
					contact.setContact_no(rs.getInt("CONTACT_NO"));
					contact.setName(rs.getString("NAME"));
					contact.setTel(rs.getString("TEL"));
					contact.setEmail(rs.getString("EMAIL"));
					contact.setEmail(rs.getString("ADDRESS"));
					
					
					contactList.add(contact);
					
				}
				
	
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				close();
			}
			
			return contactList;
		
			
		}
		

		
		
}
