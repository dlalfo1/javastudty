package ex02_loop;

public class Ex05_nested_loop { // 중첩 반복문
	
	public static void ex01() {
		
		for(int day = 1; day <= 5; day++) {
			for(int hour = 1; hour <=8; hour++) {
				System.out.println(day + "일차 " + hour + "교시 수업");
			}
		}
	}
		
	public static void ex02() { // 연습
		// ex01 while문으로 변경해보기
		
		
		int day = 1; 
		while(day <= 5) { // while문의 시작
			
			int hour = 1;
			while(hour <= 8) {
				
				System.out.println(day +"일차" + hour + "교시 수업");
				hour++;
		}
		
		day++;
		
	   } // while문의 끝
		
	}
	
	public static void ex03() {
		
		// 전체 구구단 출력하기
		// 2 X 1 = 2
		// . . .
		// 9 X 9 = 81
		
		for(int dan = 2; dan <= 9; dan++) {
			for(int n =1; n <= 9; n++) {
				System.out.println(dan + " x " + n + " = " + (dan * n));
			}
		
	    }
	}
	
	public static void ex04() {
	
		// 전체 구구단 출력하기
		// 2x1=2 3x1=3 4x1=4 . . . 9x1=9
		// . . .
		// 2x9=18 3x9=27 4x9=36 . . . 9x9=81
		
		
		for(int n = 1; n <= 9; n++) { // 처음엔 고정, 안쪽 for문이 다 돌고나면 증감됨. 그러면 다시 안쪽 for문 돔.
			for(int dan = 2; dan <= 9; dan++) {  //반복
		
				System.out.print(dan + "x" + n + "=" + (dan * n) + "\t");
			}
			
			System.out.println();	
		}
				
		}
		
	public static void ex05() { // 중첩 for문 연습
		
		// 1일차 1교시 수업
		// 1일차 2교시 수업
		// 1일차 3교시 수업
		// 1일차 4교시 수업
		// . . .
		// 5일차 8교시 수업
		
		for(int day = 1; day <=5; day++) { // 바깥 for문 시작
			for(int hour = 1; hour <=8; hour++) {
				System.out.println(day + "일차 " + hour + "교시 수업");
			}
		} // 바깥 for문 종료
		
	}
	
	public static void ex06() { // 중첩 while문으로 바꿔보기
//		
//		int day = 1;
//		while(day <= 5) { // 바깥 while문 시작
//			
//			int hour = 1; 
//			while(hour <= 8) { // 안쪽 while문 시작
//			
//				System.out.println(day + "일차 " + hour + "교시 수업");
//				hour++;
//			} // 안쪽 while문 종료
//			day++;
//		} // 바깥 while문 종료
//		
		int day = 1;
		while(day <= 5) {
			
			int hour = 1;
			while(hour <= 8) {
				
				System.out.println(day + "일차 " + hour + "교시 수업");
				
				hour++;
			}
				day++;
		}
	}
	
	public static void ex07() { // 중첩 for문 연습
		
		// 전체 구구단 출력하기
				// 2 X 1 = 2
				// . . .
				// 9 X 9 = 81
		
		// 여기서 잠깐 while문은 변수 선언을 해주고 조건문을 들어가고
		// for문은 바로 for문 시작하면 됨. 괄호안에 기초부터 써주니까
		
		for(int dan = 2; dan <= 9; dan++) {
			for(int n = 1; n <= 9; n++) {
				System.out.println(dan + " X " + n + " = " + dan * n);
			}
				System.out.println();
		}
	}
	
	public static void ex08() { // 중첩 for문 연습
		
		// 전체 구구단 출력하기
		// 2x1=2 3x1=3 4x1=4 . . . 9x1=9
		// . . .
		// 2x9=18 3x9=27 4x9=36 . . . 9x9=81
		
		// 2단부터 단이 1씩 증가하면서 가로로 출력되고 한줄 바뀜. 
		// 1은 고정 단수가 1씩 증가하므로 안쪽 for문에 적어줌
		
		for(int n = 1; n <= 9; n++) {
			for(int dan = 2; dan <= 9; dan++) {
				System.out.print(dan + "X" + n + "=" + dan * n + " ");
			}
				System.out.println();
		}
		
		
	}
	public static void main(String[] args) {
		ex08();
		
	}

}