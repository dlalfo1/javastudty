package ex04_hash;

public class User {

	private String id;
	private String pw;
	
	public User(String id, String pw) {
		super();
		this.id = id;
		this.pw = pw;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", pw=" + pw + "]";
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	// 해쉬코드 사용하면 객체에 이거 추가해주면 됨...? 동일한거 걸러내기 위해서
	// 그 비교가 객체를 비교하는거임. 객체비교가 필요할 때 이퀄스를 동시에 만들어서 넣어주면 되는거임....
	// 이거 안쓰면... 주소값을 비교하기때문에 걸러낼 수가 없다.
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
}