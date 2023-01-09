package ex02_loop;

public class Ex03_break {
	
	/*
	 	break문
	 	1. switch문 종료
	 	2. 반복문(for, while) 종료
	*/
	
	public static void ex01() {
		
		/* 
			무한 루프
			1. 끝나지 않는 반복문
			2. 형식
				for(;;) 조건문에 세미콜론만 두개 적으면 무한 루프. 
				while(true) 괄호안에 true 넣어주면 무한 루프. 실무에선 대부분 while 문 쓴다.
		*/
		
		// 1 ~ 10
		
		int a = 1;
		
		while(true) { // while문의 시작
			
			if(a > 10) { // if문 시작
				break; // a가 10보다 커진다면 반복문을 종료하겠다. 10까지는 출력됨 11은 10보다 크니까 출력 X.
				       // break를 끝내는건 if문이 아니라 반복문임. break를 안 써주면 무한루프문이므로 계속 출력됨.
				
			} //if문 종료
			
			System.out.println(a); // 1
			a++; // 2
			
		} // while문의 종료
	}
	
	public static void ex02() { // 연습
		
		// 모금
		
		int goal = 100000; // 모금 목표가액
		int money = 60; // 인당 모금금액
		int total = 0; // 모금 누적금액
		int n = 0; // 모금 횟수
		
		while(true) {
			
			// 1회 모금액 60원 현재 60원
			// 2회 모금액 60원 현재 120원
			// 3회 모금액 60원 현재 180원
			// ?회 모금액 60원 현재 100000원 이상이면 stop
			
			if(total >= goal) {
				break;
			}
			
			total += money;
			System.out.println(++n + "회 모금액 " + money + " 현재 " + total + "원");
			
		}
		
	}
	
	public static void ex03() { // while 무한루프 if문 break 활용 연습
		
		// 1 ~ 10 숫자 출력하기
		
		int a = 1;
		while(true) { // while문 시작
			if(a >10) { //if문 시작
				break;
			} //if문 종료
			System.out.println(a);
			a++;
		} // while문 종료
		
	} 
	
	public static void ex04() { // while 무한루프 if문 break 활용 연습
		
		int goal = 100000; // 모금 목표가액
		int money = 60; // 인당 모금금액
		int total = 0; // 모금 누적금액
		int n = 0; // 모금 횟수
		
		// 1회 모금액 60원 현재 60원
		// 2회 모금액 60원 현재 120원
		// 3회 모금액 60원 현재 180원
		// ?회 모금액 60원 현재 100000원 이상이면 stop
		
		while(true) { // while문 시작
			
			if(total > goal) { // if문 시작, total이 goal보다 크면 while문을 멈춰라. 즉 반복을 멈춰라!
				break;
			} // if문 종료
			total += money;
			System.out.println(++n + "회 모금액" + money + "원 " + "현재" + total + "원");
			
	  } // while문 종료
	}
	public static void main(String[] args) {
		ex04();
		
	}

}
