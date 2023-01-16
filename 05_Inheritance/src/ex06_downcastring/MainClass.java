package ex06_downcastring;

public class MainClass {
	
	public static void ex01() {
		
		// upcasting
		Person person = new Student(); // 자식을 부모타입에 저정할 수 있으나 부모타입의 메소드밖에 사용할 수 없다. 즉, 자식타입 메소드는 사용할 수 없다
									   // eat, sleep은 부를 수 있으나 study는 없다.
		
		
		
		// Student student = new Person(); 에러. 원래 다운캐스팅은 자동으로 되지 않는다.
		
		// downcasting
		Student student = (Student)person; // 자식타입의 person을 생성! 근데 굳이 왜..?
		
		// 자식, 부모 메소드 전부 사용할 수 있다.
		student.eat(); 
		student.sleep();
		student.study();
		
	}
	
	public static void ex02() {
		
		// upasting
		Person person = new Person();
		
		//잘못된 캐스팅
		Student student = (Student)person;
				
		// 잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다.		
		student.eat(); 
		student.sleep();
		student.study(); // 오류 발생 부분
		
	}
	
	public static void ex03() {
		
		// Person
		Person person = new Person();
		
		// Student 객체(인스턴스, instance)가 맞다면 Student 타입으로 캐스팅 하자.
		if(person instanceof Student) { // 만약에 person이 Student타입의 객체가 맞다면
			
			
			Student student = (Student)person;  // student는 Person타입이 아니기 때문에 밑의 메소드는 출력되지 않는다.
			student.eat();
			student.sleep();
			student.study();
			
			person.eat(); 
			person.sleep();
			((Student) person).study(); // person을 student로 먼저 바꾸고 그다음 study 메소드를 호출하라.
			
			
		}
		
		
	}
	public static void main(String[] args) {
		ex03();
		
	}

}
