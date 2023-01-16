package ex07_abstract;

/*
	추상 메소드
	1. abstract method
	2. 본문이 없는 메소드이다.
	3. 중괄호를 없애고, 세미콜론을 붙이고, abstract(추상적인) 키워드를 메소드 앞에 추가한다.
*/

/*
 	추상 클래스
 	1.abstract class
 	2. 추상 메소드를 1개 이상 가진 클래스이다.
  	3. abstract 키워드를 클래스 앞에 추가한다.
  	4. 추상 클래스(Person)를 상속 받는 클래스(Student)는 "반드시" "모든" "추상메소드"를 오버라이드 해야 한다. 
  	5. 추상 클래스는 객체 생성이 불가능하다.(new Person이 불가능)
  		(본문이 없는 메소드를 가지고 있기 때문에)
 */
public abstract class Person { // Person은 추상메소드를 1개 가지고 있으므로 추상클래스이다. 그러므로 클래에도 abstract를 붙여줘야한다.
	    // 2번
	public void eat() {
		System.out.println("먹는다.");
	}
	
	public void sleep() {
		System.out.println("잔다.");
	}
	// public void study() { 이렇게 해줘야 person이 study를 부를 수 있다. 오버라이드
		
	public abstract void study();// 본문이 없는 메소드. 형태가 없다.추상메소드
			// 1번
	
	
}
