package ex02_random;

public class Ex01_Math_random {
	
	
	public static void ex01() {
		
		// java.lang.Matrh 클래스 
		// 임의의 값이 필요할 때 사용
		
		double randNumber = Math.random(); // 0.0 <= 난수 < 1.0

		if(randNumber < 0.1) { // 10% 확률
			System.out.println("대박");
		} else {
			System.out.println("꽝");
		}
		
	}
	
	public static void ex02() {
		
		/*
			난수 생성하기
			Math.random()					0.0 <= n < 1.0
			Math.random() * 3				0.0 <= n < 3.0
			(int)(Math.random() * 3)	  	0 <= n 3
			(int)(Math.random() * 3) + 1	  1 <= n 4
			                      3개  1부터
			---------------------------------------------
			(int)(Math.random() * 개수) + 시작값 : 시작값부터 개수사이의 숫자가 나온다
		*/
	
		double random = Math.random();
		System.out.println((int)(random * 3) + 1 );  // 1 ~ 3 까지 나옴
		
		int random2 = (int)(Math.random() * 9);
		
		System.out.println(random2);
		
		StringBuilder sb = new StringBuilder(); // 랜덤으로 0 ~ 9 까지 숫자 출력후 6자리 붙이기.
		for(int count = 0; count < 6; count++) {
			sb.append((int)(Math.random() * 10));
		}
		
		String str = sb.toString();
		System.out.println(str);
		
		
	}

	public static void main(String[] args) {

		ex02();
		
	}

}
