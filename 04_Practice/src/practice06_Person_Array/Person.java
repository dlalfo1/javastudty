package practice06_Person_Array;

public class Person {

	// 필드
	private String name; // 사람 이름
	private int age; // 사람나이
	
	// 생성자
	public Person() {}  // 디폴트 생성자

	public Person(String name, int age) {  // 매개변수 받아서 필드변수 name, age 초기화 하기
		this.name = name;
		this.age = age;
	}

	// 메소드
	public String getName() { // 사람 이름 가져올 때
		return name;
	}
	public void setName(String name) { // 사람 이름 세팅할 때
		this.name = name;
	}
	public int getAge() { // 사람 나이 가져올 때
		return age;
	}
	public void setAge(int age) { // 사람 나이 세팅할 때
		this.age = age;
	}
	
}
