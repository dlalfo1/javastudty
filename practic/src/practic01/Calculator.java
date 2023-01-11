package practic01;

public class Calculator {

	// 메소드 선언
	// 반환 타입 메소드 이름 ( 타입 변수, 타입 변수) {
	
	// 실행문
	
	
	int add(int a, int b) { // add라는 메소드를 만들어준거임, a랑 b값 받으면
		
		return a + b;		// a + b 수행해서 add로 값 반환해줘~
		
	}
		
	int sub(int a, int b) {
		
		return a - b;
	}
	
	int mul(int a, int b) {
		
		return a * b;
	}
	
	double div(double a, double b) {
		
		return a / b;
	}
	
	int max(int a, int b) {
		
		int result = 0;
		if(a > b) {
			result = a;
		}
		else {
			result = b;
		}
		
		return result;
	}
	
	int min(int a, int b) {
		
		int result = 0;
		if(a < b) {
			result = a;
		}
		else {
			result = b;
		}
		
		return result;
	}
	
}
