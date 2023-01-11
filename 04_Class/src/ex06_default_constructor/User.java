package ex06_default_constructor;

public class User {
	
	// 생성자를 만들지 않으면 "디폴트 생성자"가 사용된다.
	
	
	// 필드
	String id;
	String pw;
	
	// 메소드
	// 반환타입이 없다 void
	
	void info() { // info 호출하면 밑에꺼 실행시켜줘~
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw);
	}

}
