package ex01_field;

public class User { // User라는 객체를 만들기 위한 하나의 설계도.
	
	/*
	  	필드 (User 클래스에 담을 내용을 쓰면 된다.)
	  	
	  	1. 클래스가 가지는 변수 (메소드가 가지는 변수는 걍 변수임)
	  	2. 일반 변수와 달리 자동으로 초기화 된다. (배열과 똑같이 초기화 됨)
	  
	*/
	
	// User 클래스에 들어갈 내용들을 선언해준다.
	// 아이디, 비밀번호, 포인트, 브이아이피 여부
	
	String id; 	   // 아이디는 문자열이니까 String, 초기화 값 null 
	String pw; 	   // 비밀번호도 문자열이니까 String, 초기화 값 null
	int point; 	   // 점수는 정수니까 int, 초기화 값 0
	boolean isVip; // VIP여부는 논리값이니까 boolean, 초기화 값 false
	// ------------------------------------------------------------
	
	Address addr;  // 초기화 값 null
				   // 

}
