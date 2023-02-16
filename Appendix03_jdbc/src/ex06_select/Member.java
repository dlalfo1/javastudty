package ex06_select;

import java.sql.Date;

public class Member {
	
	// 필드는 테이블의 칼럼과 1:1로 매칭한다.
	// select 한번당 Member 객체 1개 생성.
	// 생성자는 둘 다 써보려고 2개 만들어둠.
	
	private int member_number;
	private String id;
	private String name;
	private String address;
	private Date join_date;
	
	public Member() {}
	
	public Member(int member_number, String id, String address, Date join_date) {
		super();
		this.member_number = member_number;
		this.id = id;
		this.address = address;
		this.join_date = join_date;
		
	}	


	public int getMember_number() {
		return member_number;
	}

	public void setMember_number(int member_number) {
		this.member_number = member_number;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Date getJoin_date() {
		return join_date;
	}

	public void setJoin_date(Date join_date) {
		this.join_date = join_date;
	}

	@Override
	public String toString() {
		return "Member [member_number=" + member_number + ", id=" + id + ", address=" + address + ", join_date="
				+ join_date + "]";
	}
	
	

}
