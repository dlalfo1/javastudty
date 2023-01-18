package ex02_constructor;

public class User {

	
	private String id;
	private String pw;
	
	
	public User(String id, String pw) { // 매개변수가 있는 생성자가 있으면 기본생성자 만들어줘야 하는거 아닌가?
										// 아니다! 기본생성자 생성은 필수가 아니라 이용할거면 만들라 이거다
		super(); // Object 클래스(있어도 그만 없어도 그만)
		this.id = id;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
	
}

