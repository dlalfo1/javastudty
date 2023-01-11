package practic01;

public class MainClass {

	public static void main(String[] args) {

	// 메소드를 사용하려면 객체 선언해야함
		
		Calculator calc = new Calculator();
		
		int result1  = calc.add(5, 3);
		int result2  = calc.sub(5, 3);
		int result3  = calc.mul(5, 3); 
		double result4  = calc.div(5, 3);
		int result5 = calc.max(5, 3);
		int result6 = calc.min(5, 3);
		
		
		System.out.println("add(5,3)" + " = " + result1);
		System.out.println("sub(5,3)" + " = " + result2);
		System.out.println("mul(5,3)" + " = " + result3);
		System.out.println("div(5,3)" + " = " + result4);
		System.out.println("max(5,3)" + " = " + result5);
		System.out.println("mix(5,3)" + " = " + result6);
		
		
		
		
		
		
		
		

	}

}
