package practice04_Shape;

public class Rectangle implements Shape {

	
	// 필드 
	private double width; // 너비
	private double height; // 높이
	
	// 생성자
	
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	// 메소드 
		
	@Override
	public double getArea() {
			
		return width * height;
   }
   

}