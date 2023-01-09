package ex02_loop;

public class Ex04_continue {
	
	/* 
	 	continue문 (핵심 포인트는 제외)
	 	1. 반복문의 실행 시작 지점부터 다시 실행
		2. 어떤 코드를 제외하고 반복문을 실행하고 싶을 때 사용
		3. 자주 사용하지 않기 때문에 그렇게 중요하지 않다.
		
	 */

	public static void ex01() {
		
		// 1 ~ 50 사이에서 4의 배수 제외하고 출력하기.
		
		for(int a = 1; a <=50; a++) { // for문 시작
			
			if(a % 4 == 0) { // if문 시작
				// a는 4의 배수이다. 
				// a가 4의 배수라면 밑의 continue를 만나 a가 실행되지 않고 다시 for문으로 돌아간다.
				continue; 
				
			} //if문 종료
			
			System.out.println(a);
			
		} // for문 종료
	}

	public static void ex02() { // 연습 for문 안에 if문 continue 사용
		
		// 1 ~ 50 사이에서 4의 배수 제외하고 출력하기.
		
		for(int a = 1; a <= 50; a++) { // for문 시작
			if(a % 4 == 0) { // if문 시작
				continue;
			} // if문 종료
			System.out.println(a);
		} // for문 종료
		
	}	
	
	public static void main(String[] args) {
		ex02();

	}

}
