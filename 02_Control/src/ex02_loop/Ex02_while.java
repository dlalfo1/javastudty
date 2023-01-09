package ex02_loop;

public class Ex02_while {

	/* 
	 	while문
	 	1. 특정 조건을 만족하면 반복하는 반복문 (어떤 데이터를 가져오는 경우에 주로 사용) 
	 	   어떤 데이터가 남아있으면 계속해서 꺼내오는
	 	2. 형식
	 		while(조건문){
	 			실행문
	 		}
	*/
	public static void ex01() {
		
		// 1~10
		// 아직 file , db를 배우지 않았기때문에 이런것. 원래는 for문으로 짜야함.
		int a = 1;
		while(a <= 10) {
			System.out.println(a);
			a++;
		}
		
	}
	
	public static void ex02() { // 연습
		
		int account = 85000; // 통장 잔액
		int money = 550; // 출금할 금액
		int n = 0; // 출금횟수
		
		
		
			while(account >= money) {
			System.out.print(++n + "번째 출금 결과 : " ); // n++면 0을 출력하고 1을 늘리니까 ++n으로  써준다.
			account -= money;
			System.out.println("계좌 " + account + "원");
			
		}
		
	}
	
	public static void ex03() { // while문 연습
		
		int account = 85000; // 통장 잔액
		int money = 550; // 출금할 금액
		int n = 0; // 출금횟수
		
		
		// 통장 잔액에서 출금할 금액이 안 남았을 때까지 계속 출력하기
		// ex)0번째 출금 결과 : 계좌 잔액 00원 이렇게 출력
		
	
		while(account >= 550) {
			account -= money;
			n++;
			System.out.println(n + "번째 출금 결과 : " + "계좌 잔액 " + account);
		}
		
	}
	
	public static void main(String[] args) {
		ex02();
		
	}

}
