package practice02_Person_Array;

public class Person {

	// 필드
	private String name; // 펄슨 이름
	private int age; // 펄슨 나이
	
	// 생성자
	public Person() {}  // new Person()
	public Person(String name, int age) {  // new Person("alice", 20)
		this.name = name;
		this.age = age;
	}
	

	// 메소드
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