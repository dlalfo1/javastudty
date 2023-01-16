package practice04_Shape;

public class Circle implements Shape { // Circle은 Shape 인터페이스를 구현한다

	
	// 필드
	private double radius;
	
	//생성자 
	
	public Circle(double radius) {
		super();
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		
		return PI * radius * radius;
	}


}
