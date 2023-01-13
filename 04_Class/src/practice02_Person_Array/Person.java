package practice02_Person_Array;

public class Person {
	
	// 필드
	private String name;
	private int age;
	
	Person(){ // new Peerson(), name은 null, age는 0임. 그러니 name과 age 값을 바꿔줄 수 있는 메소드가 필요하겠구나! 이 생각을 해야함.
		 	  // 매개변수가 있는 생성자가 생성되었으니 디폴트 생성자를 무조건 만들어줘야함.
			  // 디폴트 생성자는 생성자가 하나도 없을 때 자동으로 컴파일 프로그램이 만들어 주는것임.
		
		
	}
	
	// 생성자(클래스엔 생성자가 반드시 필요하다.)
	public Person(String name, int age) { // 이거 가지고 이거 만들 수 있음 new Person("alice, 20)
		
		this.name = name;
		this.age = age;
		
	}
	
	// 메소드
	// setName 메소드는 name을 바꿔줌
	// setAge 메소드는 age를 바꿔줌
	
	
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
