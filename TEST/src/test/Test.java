package test;

public class Test {
	
	public static void ex01() {
		
		// 문제1. int serial의 첫 번째 글자가 1,3,5이면 "남자", 2,4,6이면 "여자"를 출력하시오.
		// int serial의 첫 번째 글자는 항상 1 ~ 6 사이의 정수라고 가정한다.
		// 예시
		// 남자입니다.
		
		int serial = 3;

		if(serial % 2 != 0) {
			
			System.out.println("남자입니다");
			
		}
		
		if(serial % 2 == 0) {
			
			System.out.println("여자입니다");
		}
		
		}

	public static void ex02() {
		
		// 문제3. 구구단을 모두 출력하지 말고 5 x 5 = 25까지만 출력하시오.
		// 예시
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		// 5 x 5 = 25
		
		
		for(int dan = 2; 2 <= dan && dan <= 5; dan++) { // 바깥 for문 시작
			for(int n = 1; n <= 9; n++) { // 안쪽 for문 시작
				
				if(dan * n == 30) {
					break;
				}
				System.out.println(dan + " X " + n + " = " + dan * n);
				
				}
					
						} // 안쪽 for문 종료
				
			} // 바깥 for문 종료
		
	public static void ex03() {
		
		// 문제5. 1부터 100 사이의 모든 짝수와 홀수를 각각 더한 결과를 모두 출력하시오.
		// 예시
		// 짝수 합은 2550입니다.
		// 홀수 합은 2500입니다.
		
		// 일단 짝수랑, 홀수를 담을 변수를 선언해줌
		
		int a = 0; // 짝수
		int b = 0; // 홀수
		
		// for문을 돌리기 위한 i를 선언해준다
		
		for(int i = 1; i <= 100; i++) {
			if(i % 2 == 0) {
				a += i;
			}
			else
				b += i;
			
		}
	
		System.out.println("짝수 합은 " + a + "입니다");
		System.out.println("홀수 합은 " + b + "입니다");
	}
			
	
	public static void main(String[] args) {
		ex01();
	}

}
