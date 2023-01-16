package ex07_abstract;

public class Student extends Person {

	@Override
	public void study() {  // 추상클래스를 상속받는 클래스에선 맨 처음 꼭 오버라이드 해줘야함
		System.out.println("공부한다");
	}
}