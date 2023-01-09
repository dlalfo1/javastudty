package ex01_variable;

public class MainClass {

	// single comment - 한 줄 주석(설명)
	
	/*
	   multiple comment 
	   여러 줄 주석 
	 */
	
	/*
	   키워드 이름 규칙
	   1. 프로젝트 : 마음대로.
	   2. 패키지 : 모두 소문자로 작성. 실무에서는 회사 도메인과 앱 이름으로 작성(com.samsung.galaxy)
	   3. 클래스 : 첫 글자만 대문자로 작성하고 나머지는 소문자. Upper Camel Case 방식.(HelloWorld)
	   4. 메소드 : 첫글자 소문자 - 그 다음단어는 첫 글자만 대문자로 작성하고 나머지는 소문자. Lower Camel Case 방식.(helloWorld)  
	   5. 변수   : 첫글자 소문자 - 그 다음단어는 첫 글자만 대문자로 작성하고 나머지는 소문자. Lower Camel Case 방식.(helloWorld)  
	   6. 상수   : 모두 대문자로 작성. Snake Case 방식. (HELLO_WORLD) - 가독성을 위해서 단어 사이에 언더바 넣어준다.
	   
	 */
	
	/*
	   main 메소드
	   1. Java가 실행될 때 main 메소드가 실행된다.
	   2. 열린 main 메소드가 없으면 최근에 실행에 성공한 main 메소드를 실행한다.
	   
	 */
	
	public static void main(String[] args) {
		
		
		// 코드는 들여쓰기가 잘 되어 있어야 한다. (탭 키 사용)
    	
		// 변수 선언하기(어떤 데이터를 저장할 것인가? 어떤 이름을 사용할 것인가?)
		
		// 타입의 구분
		// 1. primitive type : 기본 타입(소문자로 되어 있음), 값을 저장하는 타입
	    // 2. reference type : 참조 타입(첫 글자가 대문자로 되어 있음, 모든 클래스는 참조 타입), 값이 저장된 참조값을 저장하는 타입
		
		//논리 타입 (참과 거짓을 저장한다.)
		
		boolean isGood = true;
		boolean isAlive = false;
		
		System.out.println(isGood);
		System.out.println(isAlive);
		
		// 문자 타입(Character) : 1글자
		
		char ch1 = 'A';
		char ch2 = '홍';
		char ch3 = '\n'; // 라인 피드 - 줄 바꿈
		char ch4 = '\t'; // 탭
		char ch5 = '\''; // 작은 따옴표
		char ch6 = '\"'; // 큰 따옴표
		
		System.out.println(ch1);
		System.out.println(ch2);
		System.out.println(ch3);
		System.out.println(ch4);
		System.out.println(ch5);
		System.out.println(ch6);
		
		// 정수 타입
		
		int age = 46;
		long money = 1000L; // long타입에 숫자를 저장할 때는 끝에 대문자 L을 붙여준다.
							// 하지만 롱타입 범위보다 더 작은 정수를 저장할 때엔 붙여주지 않아도 된다.
		System.out.println(age);
		System.out.println(money);
		
		// 정수 구분의 기준
		
		System.out.println(Integer.MAX_VALUE); // Integer타입이 담을 수 있는 정수의 최대 범위.
		System.out.println(Long.MAX_VALUE); // Long타입이 담을 수 있는 정수의 최대 범위.
	
		
		// 실수 타입(소숫점)
		
		double leftEye = 0.7;
		double rightEye = 1.2;
		
		System.out.println(leftEye);
		System.out.println(rightEye);
	    	
		// 문자열 타입(여러 글자를 의미, 글자 수의 제한이 없음)
	
		String name = "이미래"; // Java에서 기본 타입과 같은 사용법을 제공
		System.out.println(name);
		
		String country = new String("Korea"); // 대부분의 참조 타입 사용법
		System.out.println(country);
		
		// 상수 선언하기(final 키워드가 필요, 이게 마지막 값이야~, 변수는 대문자로 작성)
		
		final double PI = 3.141592; //
		System.out.println(PI);
		
		// PI = 3; 컴파일 에러. 한번 선언된 상수의 값은 변할 수 없다.
		
		int x = 10; 
		System.out.println(x);
		
		x = 20; // 반면에 변수는 x에 10을 저장했더라도 다시 20을 저장할 수 있다. 최종 x의 값은 20.
		System.out.println(x);
      	
		System.out.println("\"문자열 연습\""); 
		System.out.println("\'문자열 연습\'"); 
		System.out.println("\t문자열 연습\""); 
		System.out.println("문자열 \n연습"); 
	
		
		//이거 추가되나 보기.
	}

}