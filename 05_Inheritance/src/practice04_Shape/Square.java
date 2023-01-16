package practice04_Shape;

public class Square extends Rectangle {

	// 필드 필요없음(Rectangle이 가지고 있음 
	
	// 생성자
	public Square(double width) {
	super(width, width); // 자식 생성자는 반드시 부모 생성자의 호출이 필요하다.
	
	// 필드가 없을땐 슈퍼클래스의 필드를 활용해서 생성자를 만들 수 밖에 없음. from superclass 선택
	
	}
}