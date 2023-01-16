package practice04_Shape;

public interface Shape { // 인터페이스는 필드를 가질 수  없다, 필드는 인터페이스 구현하는 Circle 클래스에서 만든다.
	
	// final 상수
	public final static double PI = 3.141592;
	
	// 추상 메소드
	
	public double getArea(); // 도형의 넓이를 반환

}
