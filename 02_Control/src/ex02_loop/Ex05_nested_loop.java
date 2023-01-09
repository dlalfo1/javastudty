package ex02_loop;

public class Ex05_nested_loop {
	
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
		
	public static void ex05() { // 구구단 연습
		
	}
	public static void main(String[] args) {
		ex04();
		
	}

}