package ex03_method;

public class Calculator {
	
	// 메소드 (함수) - 계산기의 기능을 만드는 것

	/* 
		메소드 형식
	 	
	 	반환타입 메소드명(매개변수) {
	 		메소드 본문
	 		return 반환값(결과값)
	 	}
	  
	  	1. 반환값 + 반환타입, 반환값과 반환타입은 같이 보는거임
	  		메소드 실행(메소드 호출)의 결과
	    2. 메소드명
	    	개발자 마음대로
	  	3. 매개변수
	  		메소드로 전달되는 값(인수, argument)
	*/
	
	/* 
	 	메소드의 4가지 형식                     메소드 호출
	 	
	 	1. 반환값 X, 인수X
	 		void method() {					    method(); 				
	 			메소드 본문                     ex01(); 이런거
	 		}
	 		
	 	2. 반환값 X, 인수 O                     int a = 0;
	 		void method(int arg) {              method(a);
	 			메소드 본문
	 		}
	 		
	   3. 반환값 O, 인수 X                      int result;
	   		int method() {                      result = mothod() 
	   			메소드 본문
	   			return 반환값
	   		}
	   		
	   4. 반환값 O, 인수 O                     int a = 0;
	   		int method(int arg) {			   int result;
	   			메소드 본문					   result = method(a); a를 주고 result를 받아온다
	   			retrun 반환값
	   		}
	 */
	
	// addition 메소드 정의
	double addition(double a, double b) {  // 에디션 메소드로 더블타입의 각 두개가 전달되면 전달된 두개 값을 더해서 돌려줘라 그 값은 더블타입니다.
	
	// addition 기능의 타입을 선정(double)
		
		return a + b; // a + b의 값을 반환해줘! 결과를 보여줘! 이 결과값의 타입은 double이다.
		
	}
	// subtraction 메소드 정의
	double subtraction(double a, double b) {
		
		return a - b;
	
	}
}
