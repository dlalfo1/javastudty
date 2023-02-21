package dto;

public class ContactDTO {
	
	
	// 테이블의 칼럼명을 변수로 선언해준다.
	private int contact_no;
	private String name;
	private String tel;
	private String email;
	private String address;
	
	 // 디폴트 생성자
	public ContactDTO() {
		
	}
	
	// 매개변수가 있는 생성자
	public ContactDTO(int contact_no, String name, String tel, String email, String address) { 
		super();
		this.contact_no = contact_no; 
		this.name = name;
		this.tel = tel;
		this.email = email;
		this.address = address;
	}

	// 게터와 세터
	public int getContact_no() {
		return contact_no;
	}

	public void setContact_no(int contact_no) {
		this.contact_no = contact_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// 연락처 정보를 쉽게 보기 위해서 toString 메소드 추가
	@Override
	public String toString() { 
		return "ContactDTO [contact_no=" + contact_no + ", name=" + name + ", tel=" + tel + ", email=" + email
				+ ", address=" + address + "]";
	}
	


}