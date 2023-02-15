package ex01_setter;

public class User {

	
	private String id;
	private String pw;
	
	// 실제론 생성자보단 get,set을 많이 씀 
	// 생성자가 코드가 간단해보이지만 필드값이 많을경우 다 적기 어려운게 있음
	// get,set은 내가 필요한것만 만들어줘서 값 넣어주면 되니까!
	
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
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
	}
	
	
	
}

