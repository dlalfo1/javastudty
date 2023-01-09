package ex01_branch;

public class Ex01_if {

	
	public static void ex01() {
		
		// if 문
		// if 조건문은 () 만 쓰고 세미콜론은 쓰지 않는다.
		
		int score = 100; // 합격점수
		
		if(score >= 60) {
			System.out.println("합격");
		}
		
		if(score < 60) {
			System.out.println("불합격");	
		}
	}
	
	public static void ex02() {
		
		// if 문의 중괄호
		// 실행문이 1개인 경우 생략할 수 있다. but 무조건 적어주는게 좋다.
		// 실행문이 2개 이상인 경우는 반드시 필요하다.
		
		int score = 50; 
		
		if(score >= 60) {
			System.out.println("합격"); 
			System.out.println("축하합니다.");	
		}
		
		if(score < 60) {
			System.out.println("불합격");
			System.out.println("보충수업입니다.");
		}	
	}
	public static void main(String[] args) {
	
		ex02();

	}

}
