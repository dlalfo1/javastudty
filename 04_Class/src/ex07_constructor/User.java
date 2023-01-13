package ex07_constructor;

public class User {
	
	// 필드
	String id;
	String pw;
	
	
	// 생성자
	User(){ // 이 상태에선 "admin", "12356" 인수를 넣어줄 수가 없음 
		id = "anonymous";
		pw = "1234";
	}
	
	User(String userId, String userPw){ // 이름이 userId, userPw 인것은 필드와 이름이 같을 수 없기 때문에
		id = userId; // 매개변수가 id일 경우 id = id; 이므로 구분이 안돼서 오류가 뜬다.
		pw = userPw;
		
	}
	
	
	// 메소드
	// 생성자라고 착각할 수 있으나 생성자는 클래서의 이름과 같아야함! 
	// 생성자가 메소드의 일부인거지 메소드가 전부 생성자는 아니다~
	void info() {
		System.out.println("아이디 : " + id);
		System.out.println("비밀번호 : " + pw); // 이건 생성자가 아닌가?
	}


}
