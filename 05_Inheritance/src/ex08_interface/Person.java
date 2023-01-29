package ex08_interface;

public interface Person{
	
/*
	인터페이스(interface)
	1. 추상 클래스의 한 형태이다. 
	2. JDK 1.7 이전에는 추상 메소드로만 구성된 추상 클래스를 의미한다.
	3. JDK 1.8 이후에는 본문이 있는 default 메소드, static 메소드를 추가할 수 있다.
	4. 인터페이스는 주로 final 상수, 추상 메소드를 가진다.
	5. 인터페이스의 추상 메소드는 public abstract를 모두 생략할 수 있다. (그냥 적자.. 헷갈릴듯..)
*/
	
 	
	// default 메소드 (본문이 있는 메소드)
	// Person 클래스의 기본적인 메소드, 본문이 있는 메소드 쓰고 싶으면 default 키워드 붙이기.
	public default void eat() { 
		System.out.println("먹는다.");
	}

	public default void sleep() {
		System.out.println("잔다.");
	}
	
	// 추상(abstract) 메소드 (본문이 없는 메소드)
	// 인터페이스에선 추상메소드에 abstract 키워드 생략 가능하다.
	public void study();
	
	
	
}
