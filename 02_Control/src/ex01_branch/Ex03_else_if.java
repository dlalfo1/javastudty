package ex01_branch;

public class Ex03_else_if {
	
	public static void ex01() {
		
		// 80 이상 : 상
		// 60 이상 : 중
		// 나머지 : 하
		
		int score = 50;
		
		if(score >= 80) {
			System.out.println("상");
		}
		else if(score >= 60) {
			System.out.println("중");
		}
		else {
			System.out.println("하");
		}
		
		
	}

	public static void ex02() { // 연습
		
		//수, 우, 미, 양, 가, 잘못된 점수 
		
		int score = 0;
		
		// 점수의 범위는 0부터 100까지니
		if(score < 0 || score > 100) {
			System.out.println("잘못된 점수");
		}
		else if(score >= 90) {
			System.out.println("수");	
		}
		else if(score >=80) {
			System.out.println("우");
		}
		else if(score >=70) {
			System.out.println("미");
		}
		else if(score >=60) {
			System.out.println("양");	
		}
		else {
			System.out.println("가");
		}
	}

	public static void ex03() {
		
		int month = 1;
		
		int mod = month % 12;
		
		if(mod <= 2) { 
			System.out.println("겨울"); // 12, 1, 2 % 12 => 0, 1 ,2
		}
		else if(mod <= 5) {
			System.out.println("봄");// 3, 4, 5 % 12 => 3, 4, 5
		}
		else if(mod <= 8) { 
			System.out.println("여름"); // 6, 7, 8 % 12 => 6, 7 ,8
		}
		else { 
			System.out.println("가을"); 
		}
		
			
		}
	
	public static void ex04() { // 연습
		
		int day = 6; // 금요일 7토 8일 9월 10화 11수 12목 13금 14토 15일 16월
		int nDay = 10; // 10일 후
		
		day += nDay; //day = day + nDay;
		String weekName; // 월요일
		
		int mod = day % 7;
		
		if(mod == 0) {
			weekName = "토";
		}
		else if(mod == 1) {
			weekName = "일";
		}
		else if(mod == 2) {
			weekName = "월";
		}
		else if(mod == 3) {
			weekName = "화";
		}
		else if(mod == 4) {
			weekName = "수";
		}
		else if(mod == 5) {
			weekName = "목";
		}
		else {
			weekName = "금";
		}
	
		System.out.println(nDay + "일 후는 " + weekName + "요일이다");
		
	}
	
	public static void main(String[] args) {
		ex04();

	}

}
