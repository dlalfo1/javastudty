package ex02_List;

public class User {

	private String id;
	private String pw;
	
	public User() {
		
	}

	public User(String id, String pw) { // 여긴 왜static이 안 붙나
		super();
		this.id = id;
		this.pw = pw;
	}

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
