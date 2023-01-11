package ex05_ellipsis;

public class MainClass {

	public static void main(String[] args) {
		
		// Calculator 객체 생성
		
		Calculator calc = new Calculator(); 
		
		System.out.println(calc.addition(1.1, 2.2)); //3.300000003 왜 이랬더라
		System.out.println(calc.addition(1.1, 2.2, 3.3));
		System.out.println(calc.addition(1.1, 2.2, 3.3, 4.4));
		System.out.println(calc.addition(1.1, 2.2, 3.3, 4.4, 5.5));
		
	}

}
