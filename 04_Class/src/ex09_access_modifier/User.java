package ex09_access_modifier;

public class User {
	
	/*
	 	접근 제어 지시자(Access Modifier) 1,4번만 공부하기
	 	
	 	1. private   : 클래스 내부에서만 접근할 수 있다.
	 	2. default   : 동일한 패키지에서만 접근할 수 있다.
	 	3. protected : 동일한 패키지 또는 상속 관계의 클래스에서만 접근할 수 있다.
	 	4. public	 : 누구나 접근할 수 있다.
	 		
	*/
	
	/*
		정보 은닉(Information Hiding)
		1. 클래스의 내부 정보를 외부에 노출하지않는 것을 말한다.
		2. 클래스의 내부 정도는 "필드"를 의미하므로 "필드"값을 외부에 공개하지 않는 것을 말한다.
		3. "필드"는 private 하게 처리한다.
		4. "메소드"는 public 하게 처리한다. "필드"에 접근하기 위해서는 "메소드"를 통해서 접근해야 한다.
		    메소드도 private라면 private한 필드를 메소드를 통해서 우회해서 갈 수도 없음.
	*/
	
	/*
		Getter와 Setter
		1. Getter
			1) 필드값을 외부로 반출하는 메소드 (User -> MainClass)	
			2) get + 필드 이름을 가지는데 이를 수정하면 안 된다. (내 멋대로 만들어서 사용하면 안 됨)
		2. Setter
			1) 외부로부터 필드값을 받아오는 메소드(MainClass -> User)
			2. set + 필드 이름을 가지는데 이를 수정하면 안 된다. 	 
	
	*/
	
	// 필드
	
	private String id; // private가 생김으로써 MainClass에서 id를 사용할 수 없음, 바꿀 수도 없고 확인할 수도 없게 만들어야 함.
	private String pw; // 특별한 사유가 없다면 무조건 private 붙여야 한다.
	private boolean isVip; // 필드이름이 isVip나 Vip나 Getter 이름은 isVip임.
	
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
	
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	
	
	
	// 메소드
	// 각각 메소드가 무슨 일을 하는지 무조건 공부하기.
	
	// Getter, Setter 메소드는 손으로 직접 입력하지 않는다
	// Source - Generate Getter and Setter - Select All - Generate 
	
	
	
}
