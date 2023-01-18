package ex06_Object;

public class MainClass {


	/*
		java.lang.Object 클래스
		1. 모든 클래스의 최상위 슈퍼 클래스이다.(모든 클래스의 부모임)
		2. 별도의 슈퍼 클래스를 명시하지 않는 경우 Object 클래스가 슈퍼 클래스이다.
		3. 모든 것을 저장할 수 있는 만능 타입이다.
		4. Object 타입으로 저장된 객체는 Object 클래스의 메소드만 호출할 수 있으므로 다시 원래 객체 타입으로 캐스팅해서 사용해야 한다.
	*/
	
	/*
		Object 클래스의 주요 메소드
		1. equals   
		 	1) 동등 비교할 때 사용하는 메소드
		 	2) 동등 비교하는 객체들의 참조값(번지수)을 비교함(객체의 값을 비교하지 못 함)
		 	3) 객체의 값으로 동등 비교를 수행하기 위해서는 equals 메소드를 "오버라이드" 해야 함. (객체 비교하고 싶으면 오버라이드 사용해야 함.)
		2. toString 
			1) 문자열로 변환할 때 사용하는 메소드
			2) "객체이름 + @ + 참조값" 형식으로 변환함
			3) 원하는 형식으로 변경하려면 toString 메소드를 "오버라이드" 해야 함.
	*/

	public static void ex01() {
		
		Object person = new Person(); // Object 타입은 뭐든지 저장할 수 있으니까 Person도 저장 가능하다
		
		if(person instanceof Person) { 
			
			
			((Person) person).eat(); // Object 객체는 항상 캐스팅해야 한다.
			((Person) person).sleep();
		}
		
	}
	public static void ex02() {
		
		// name이 같으면 같은 Person으로 처리하기로 한 시스템(가정)
		
		Person person1 = new Person("홍길동"); 
		Person person2 = new Person("홍길동"); // new 연산자를 썼기 때문에 새로운 참조값이 하나 생기고 거기에 홍길동을 저장.
		
		if(person1.equals(person2)) { // 문자열을 비교한게 아니라 객체의 참조값(주소)를 비교한거라 false.
			System.out.println("같은 Person이다.");
		} else {
			System.out.println("다른 Person이다.");
		}
		
		person1.setName("홍길동");
		System.out.println(person1.getName());
		
	}
	public static void ex03() {
		
		Person person = new Person("홍길동"); 
		
		System.out.println(person);             // toString메소드 호출을 생략한다. 
		System.out.println(person.toString()); // 참조값이 출력됨, 그래서 sysout 으로 출력할 때 toString메소드 호출을 생략한다. 어차피 똑같음.
													
	}
	public static void main(String[] args) {
		ex01();
	
	}

}
