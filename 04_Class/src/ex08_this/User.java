package ex08_this;

public class User {

	/*
	 	this
	 	1. 현재 객체의 참조값이다.
	 	2. 클래스 내부에서만 사용할 수 있다.
	 	3. 클래스의 구성 요소(필드, 메소드)를 호출할 때 사용할 수 있다.
	 		1) 필드		: this.필드
	 		2. 메소드 	: this.메소드()
	 */
	
	// 필드
	
	String id; // this.id
	String pw; // this.pw
	
	// 생성자
	
	User(String id, String pw){
		this.id = id;
		this.pw = pw;
	}
	
	// 메소드
	void printThis() {
		System.out.println(this); // User 객체를 User 내부에서 부르면 this, 외부에서 부르면 user
	}
	
	void info() {
		System.out.println("아이디 : "  + id); // 여기엔 아무도 this.id라고 안함
		System.out.println("아이디 : "  + pw);
	}
}
