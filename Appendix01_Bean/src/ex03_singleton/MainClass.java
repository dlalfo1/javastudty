package ex03_singleton;

public class MainClass {

	public static void main(String[] args) {
		
		
		// User 객체 가져오기
		User user1 = User.getInstance(); // static 메소드는 클래스 이름으로 호출하기 때문에 User.getInstance(); 이거임. user.getInstance() 이게 아님.
		User user2 = User.getInstance();
		
		// 같은 User인가?
		System.out.println(user1 == user2);
	}

}
