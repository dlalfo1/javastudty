package ex05_upcasting;

/*
	업캐스팅 (아주 중요~ 실무에선 이렇게 처리함)
	1. upcasting 
	2. 자식 클랙스 객체를 부모 클래스 타입으로 저장할 수 있다.
	3. 강제로 캐스팅하지 않아도 자동으로 처리 된다. (처리는 자동으로 된다.)
	
 */

/*
	업캐스팅의 장점
	1. 하나의 클래스로 여러가지 객체를 저장할 수 있다.
	2. 부모 타입으로 모든 자식 객체를 저장할 수 있다.
*/

/*
	업캐스팅의 단점
	1. 부모 타입으로 저장되기 때문에 부모 클래스의 메소드만 호출할 수 있다.
	   // eat와 sleep 메소드는 호출 가능하지만 study는 호출할 수 없다.
	2. 자식 클래스의 메소드를 호출할 수 있도록, 부모 클래스에도 자식 클래스에서 호출할 메소드를 추가해준다.


*/

public class MainClass {

	public static void main(String[] args) {
		
		// 부모 타입 선언
		Person person; // 만든건 부모 타입인데
		
		// 자식 객체 생성
		person = new Student(); // 자식 객채를 생성가능하다.
		person = new Alba(); // 자식의 자식 객체도 생성가능하다.
		// 자식 타입의 부모 객체는 생성할 수 없다.
		
		// 메소드 호출
		
		person.study();
		person.eat();
		person.sleep();
		person.work();
		
		
		/*
		  Person  person;
		  person.stusy() 동작방식
		
		  
			person.study() 동작 방식
			1.person study 동작 방식
			2. Person person 이므로 클래스의 study 메소드를 호출한다.
			3. person = new Student()이므로  student 클래스의 study를 가져온다.
			4. 최정적으로 Student 클래스의 study 메소드가 실행된다.
		 
		 
		 */
		
		
	
		
	
		}
		
		
}





