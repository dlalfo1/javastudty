package ex02_loop;

public class Ex01_for {
	
	/*
	 	for문
	 	1. 연속된 숫자를 생성하는 반복문(배열에서 주로 사용)
	 	2. 형식
	 		for(초기문; 조건문; 증감문)	{
	 			실행문
	 		}
	 */
	public static void ex01() {
		
		// 1~10
		// 증감문에서 ++a나 a++나 둘 중 아무거나 쓰면 된다.
		
		for(int a = 1; a <= 10; ++a) {
			System.out.println(a + 1); // 순서 : 1.초기문 2.조건문 3.실행문 4.증감문
										// 초기문은 한번만 실행되고 2~3번이 반복되는것.
										// 시작은 1 그다음 실행문으로 1이 출력된 후 1증가 후 2가 되는 것임.
		}
		
	}

	public static void ex02() {
		
		// 횟수(5번)
		int count = 5;
		
		for(int a = 0; a < count; a++) { // 1에서 5까지 1 2 3 4 5 총 다섯번 출력. 개발자들은 보통 초기문을 0으로 씀. 
									     // 조건문을 a < 5로 쓰면 반복 횟수도 5번이라는걸 명시할 수 있음. 
									     // 반복 횟수를 변수를 하나 정해서 쓸 수도 있음.
						
			System.out.println("Hello World");
		}
	}
	
	public static void ex03() { // 연습
		
		// 10 ~ 1 출력
		
		for(int a = 10; 1 <= a && a <= 10; a--) {
			System.out.println(a);
		}
	}
	
	public static void ex04() { // 연습
		
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// . . .
		
		int dan = 2; // 이 곳에 원하는 구구단을 넣으면 된다.
		
		
		for(int a = 1; a <= 9; a++) {
			System.out.println(dan + " x " + a + " = " + (dan * a)); 
		
		}
		
	}
	public static void main(String[] args) {
		ex04();
	}

}
