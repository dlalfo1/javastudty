package ex07_abstract;

public class MainClass {

	public static void main(String[] args) {

		Person person = new Student(); // 자식 객체를 부모 타입에 저장. 부모타입의 기능만 사용 할 수 있다.
		
		// Person 클래스는 객체를 생성하기위해 만든게 아니고, Person(부모)타입으로 Student(자식)을 저장하기 위함이다.
		// 여러 아이들의 부모를 만드는거임.
		// 부모가 가진 코드를 여러 아이들이 활용할 수 있기 때문. (상속의 목적)
		
		person.eat();
		person.sleep();
		person.study();
	}

}
