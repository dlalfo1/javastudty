package ex08_interface;


/*
	용어 정리하기
		
	1. 클래스를 상속 받는다. extends 키워드를 사용한다.
		public class Person	{ }
		public class Student extends Person	{ }
		
	2. 인터페이스(추상메소드가 있는 추상 클래스)를 구현한다. implements 키워드를 사용한다.
	   (인터페이스를 상속받는다라고 표현하지 않는다. extends 키워드 X)
	   public interface Person { }
	   public class Student implements Person { }

*/
public class Student implements Person {

	@Override
	public void study() {
		System.out.println("공부한다");
	 		
	}

	
	
	
	

}
