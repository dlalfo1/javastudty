package Person_Array;

public class Person {
	
	// 필드
	private String name;
	private int age;
	
	// 생성자 (베이커리 브레드앤체인지같은 역할..)
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	// 게터세터
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	

}
