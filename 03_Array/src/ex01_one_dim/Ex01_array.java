package ex01_one_dim;

public class Ex01_array {

		/* 
	 	배열이란?
	 	1. 여러 개의 변수를 하나의 이름으로 관리하는 자료 구조
	 	2. 배열의 구성 요소
	 		1) 배열명 : 모든 변수의 대표 이름
	 		2) 인덱스 : 각 변수를 구분하기 위한 위치 정보. 0부터 시작하는 정수값.
	*/
	
	/*
		배열의 사용 방법
		
		1. 배열의 선언 
			1) int[] arr; // 권장
			2) int arr[]; 
			
		2. 배열의 생성
			arr = new int[5];
			
	*/
	
	
	/*
		배열요소
		1. 배열의 각 변수를 의미 
		2. 배열명[인덱스] 
		3. 배열이 생성되면 자동으로 초기화 된다.
		0(int), 0.0(double), false(boolean), null(참조타입) 값으로 초기화 된다.(값이 없음을 의미)
		숫자 0이랑 false는 본질적으로 같은 값이다. true는 1과 같다.
		< - > int = a; a는 값을 가지지만 무슨 값인지는 모름. 쓰레기값이 들어가 있음.
	 		
    */
	
	public static void ex01() {
		
		int[] arr; // 배열의 선언
		
		arr = new int[5]; // 배열의 생성
		
		System.out.println(arr[0]); // 배열의 요소, 1이 아님에 주의
		System.out.println(arr[1]); // 대괄호 안의 1을 출력한다는 얘기가 아님!, 인덱스 번호일뿐!, 인덱스 : i
		System.out.println(arr[2]); 
		System.out.println(arr[3]); 
		System.out.println(arr[4]); 
	}
	
	public static void ex02() {
		
		// 배열 선언 + 생성
		int[] arr = new int[5];
		
		// 배열 요소 순회(하나씩 접근하기), 대부분의 배열은 순회를 쓴다.
		for(int i = 0; i < 5; i++) { // i <= 4 라고 안 씀! 무조건 i = 0; 으로 0부터 시작하고 
									 // 조건문의 값은 배열수랑 동일하게 하기. 그래야 알아보기 쉬움
									 // 5개의 배열 요소를 만드는구나~ 알 수 있다.
			System.out.println(arr[i]);
		}
		
	}
	
	public static void ex03() {
		
		// 배열 길이
		int length = 5;
		
		// 배열 선언 + 생성
		int[] arr = new int[length];
		
		// 배열 순회
		
		for(int i = 0; i< length; i++) {
			System.out.println(arr[i]);
		}
	}
		
	public static void ex04() { // 배열 중 가장 흔한 경우, 되도록 이걸로 사용.
		
		// 배열 선언 + 생성
		int[] arr = new int[5];

		//배열 순회
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); 
			
		
		}
	}
	
	public static void ex05() { // 연습
		
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
		
		// 각 점수를 배열에 저장하기
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;

		// 합계(평균), 최대/최소
		int total = 0; // Zero
		int max = 0; // 배열 중 가장 작은 값
		int min = 100; // 배열 중 가장 큰 값
		
	
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
			if(max < scores[i]) {
				max = scores[i];
			}
			if(min > scores[i]) {
				min = scores[i];
			}
					
		}
		
		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + (double)total / scores.length);
		System.out.println("최대 : " + max + "점");
		System.out.println("최소 : " + min + "점");
	}
	
	public static void ex06() { // 연습
		
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
		
		// 각 점수를 배열에 저장하기
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;

	
		// 합계(평균), 최대/최소
		int total = scores[0];  
		int max = scores[0];
		int min = scores[0];
		
		// 배열의 첫 번째 요소를 초기화로 저장하고
		// 배열의 두 번째 요소부터 순회한다.
		// 즉 total, max, min을 100점으로 초기화 한 후 for문에 초기식을 int i = 1로 함으로써 인덱스 0번은 빼고 1번부터 더해짐.
		
	
		for(int i = 1; i < scores.length; i++) {
			total += scores[i]; // i가 1부터 시작하는 이유는 합계 구할 때 0번째 배열값을 두번더 하지 않기 위해.
			
			if(max < scores[i]) { // max보다 큰 값일 경우
				max = scores[i]; // max를 그 값으로 변경한다.
			}
			if(min > scores[i]) {
				min = scores[i];
			}
				
			
		}

		System.out.println("합계 : " + total + "점");
		System.out.println("평균 : " + (double)total / scores.length);
		System.out.println("최대 : " + max + "점");
		System.out.println("최소 : " + min + "점");
	}
	
	public static void ex07() {
		
		// 배열 초기화
		int[] arr = {10, 20, 30};
		
		// 배열 순회
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public static void ex08() {
		
		String[] weekName = {"토", "일", "월", "화", "수", "목", "금"};
		
		int day = 13;
		
		
		System.out.println(day + "일은 " + weekName[day % weekName.length] + "요일이다.");
			
	}
	
	public static void ex09() {
		
		String[] season = {"겨울", "봄", "여름", "가을"};
		
		// 12, 1, 2 겨울
		// 3, 4, 5 봄
		// 6, 7, 8 여름
		// 9, 10 11 가을
		
		int month = 2;
		
		System.out.println(month + "월은 " + season[month % 12 / 3] + "이다");
		System.out.println(month % 12 / 3);
	}
	
	public static void ex10() {
		
		// 점수를 배열로 관리하기
		int[] scores = new int[5];
					
	// 각 점수를 배열에 저장하기
	// scores[0] = 100;
	// scores[1] = 70;
	// scores[2] = 95;
	// scores[3] = 83;
	// scores[4] = 76;
	
	// 합계(평균), 최대/최소
	// int total = 0; // Zero
	// int max = 0; // 배열 중 가장 작은 값
	// int min = 100; // 배열 중 가장 큰 값
		
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;
		
		int total = 0;
		int max  = 0;
		int min = 100;
		
		//최대
		
		for(int i = 0; i < scores.length; i++) {
			total += scores[i];
			
			if(max < scores[i]) { // max를 위에서 0으로 초기화 해줬으므로
								  // 0보다 큰 scores[i]의 값들이 계속 max에 저장됨.
				max = scores[i];
			}
			
			if(min > scores[i]) { // min을 위에서 100값 (배열 중 최대값) 으로 초기화 해줬으므로
				min = scores[i];  // 100보다 작은 scores[i]의 값들이 계속 min에 저장됨.
			}
		}
		System.out.println(max);
		System.out.println(total);
		System.out.println(min);
		System.out.println((double)total / scores.length);
		
		int[] arr = new int[5];
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}
	
		
	public static void main(String[] args) {
		ex10();
	}
		
}
