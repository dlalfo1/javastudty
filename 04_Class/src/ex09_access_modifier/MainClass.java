package ex09_access_modifier;

public class MainClass {

	public static void main(String[] args) {
		
		// User 객체 생성하기
		User user = new User();
		
		// user.id = "admin";    id값을 바꿀 수 없음. User 클래스에서 id를 private하게 썼으므로.
		// user.pw = "123456"; 
		
		// user 객체에 id 전달하기
		user.setId("admin");
		
		// user 객체의 id 확인하기
		System.out.println(user.getId());
		
		// user 객체에 pw 전달하기
		user.setPw("123456");
		
		// user 객체의 pw 확인하기                                                                                                                                                                                                                                                                                                                                                                                         
		System.out.println(user.getPw());

	}

}
