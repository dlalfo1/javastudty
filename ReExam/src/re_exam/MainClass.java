package re_exam;

import java.util.Arrays;

public class MainClass {
	
	public static void ex01() {
		
		
		// 문제1. 절대값 구하기
		int number = -5;
		
		/*
		int absNumber;
		if(number >= 0) {
			absNumber = number;
		} else {
			absNumber = -number; // absNumber = number * -1;
		}
		*/
		
		int absNumber = (number >= 0) ? number : - number; // 위의 if - else 식을 삼항연산자로 간단히 작성할 수 있다.
		System.out.println(absNumber);
	}
	
	public static void ex02() {
		
		// 문제2. 나이에 따른 구분하기
		// 0 ~ 7 : 미취학아동
		// 8 ~ 13 : 초등학생
		// 14 ~ 16 : 중학생
		// 17 ~ 19: 고등학생
		// 20 ~ 100 : 성인
		// 나머지 : 잘못된 나이
		// 이런건 if문으로 풀면 됨, switch문 쓸 필요가 없음..
		
		String strAge = "30";
		int age = Integer.parseInt(strAge); // 문자열 "30"을 정수 30을 바꿔준다.
		
		if(age < 0 || age > 100){ // 0보다 작거나 또는 100보다 크거나
			System.out.println("잘못된 나이");
		} else if(age <= 7) { // age >= 0 은 조건식에 적을 필요가 없다 왜냐 if문 첫번째줄에서 이미 0보다 작으면 잘못된 점수라고 걸러줬기 때문에! 
			System.out.println("미취학아동");				  
			
		} else if(age <= 13) {
			System.out.println("초등학생");
		} else if(age <= 16) {
			System.out.println("중학생");
		} else if(age <= 19) {
			System.out.println("고등학생");
		} else {
			System.out.println("성인");
		}
		
	}
		
	public static void ex03() {
		
		// 문제3. 삼각형 넓이 구하기
		// 결과로 소숫점 값을 원하면 연산에 하나는 소숫점을 넣어줄 것. 그럼 double을 써서 강제 캐스팅 할 필요가 없다.
		
		int width = 3;
		int height = 3;
		double area = width * height * 0.5; // 나누기 2나 곱하기 0.5나 같은 값임.
		
		System.out.println("삼각형 넓이 : " + area);
	}
		
	public static void ex04() {
		
		// 문제4. 월 -> 계절과 마지막 일 출력하기
		
		/* 
		  month % 12 / 3 계절 구할 땐 이 값으 외워야겠다.
		  겨울 : 0
		  봄 : 1
		  여름 : 2
		  가을 : 3
		*/
		
		int month = 12; 
		String[] season = {"겨울", "봄", "여름", "가을"};
		int [] lastDay = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31}; // 앞에 0은 dummy node로 아무것도 안하는 앤데 배열 숫자 맞춰주기 위해서 넣어줌
		if(month < 0 || month > 12) {
			System.out.println(month + "월은 잘못된 입력입니다.");
			return;
		}
		System.out.println(month + "월은 " + lastDay[month] + "일까지 있습니다"); // 만약 배열 앞에 0 안 넣어주면 lastDay[month-1] 로 하면된다. 둘다 상관없음.
		System.out.println(month + "월은 " + season[month % 12 / 3] + "입니다.");
		
	}	
	
	public static void ex05() {
		
		// 문제5. 10과 가까운 수 찾기
		
		int a = 8;
		int b = 11;
		int diff1 = (a > 10) ? a - 10 : 10 - a; // 2
		int diff2 = (b > 10) ? b - 10 : 10 - b; // 1
		
		System.out.println("10과 가까운 수는 " + (diff1 < diff2 ? a : b) + "입니다.");
		
	}
	
	public static void ex06() {
		
		// 문제6. money 분리하기

		int money = 87654;
		
		int[] unit = {50000, 10000, 5000, 1000, 500, 100, 50, 10, 5, 1};
		int[] count = new int[unit.length];
		
		
		for(int i = 0; i < unit.length; i++) {
			count[i] = money / unit[i];
			money %= unit[i];
			System.out.println(unit[i] + "원권 : " + count[i] + "개");
		}
		
		System.out.println(Arrays.toString(unit));
		System.out.println(Arrays.toString(count));
							// Arrays.toString(); 배열의 값을 문자열로 출력해주는 메소드.
	}					
	
	
	public static void ex07() {
		
		// 문제 7. 2차원 배열에 구구단 결과 저장하기.
		
		int[][] arr = new int[8][9];
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) { // 2차원 배열의 j는 arr[i].length이다
				arr[i][j] = (i + 2) * (j *1);
				
				System.out.print(String.format("%3d", arr[i][j])); // 첫번째 출력방법
			}
			System.out.println();
		}
		
		System.out.println("---------------------------------"); // 두번째 출력방법
		for(int i = 0; i < arr.length; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		System.out.println("---------------------------------"); // 세번째 출력방법
		
		for(int[] a : arr) {
			System.out.println(Arrays.toString(a));
		}
	}
			
			/* 이 배열을 먼저 떠올리고 규칙이 뭘까 생각해보는거임
			  
				arr[0][0] = 2 * 1;
				arr[0][1] = 2 * 2;
				arr[0][2] = 2 * 3;
				arr[0][3] = 2 * 4;
				
				arr[1][0] = 3 * 1;
				arr[1][1] = 3 * 2;
				arr[1][2] = 3 * 3;
				arr[1][3] = 3 * 4;
				
				arr[2][0] = 4 * 1;
				arr[2][1] = 4 * 1;
				arr[2][2] = 4 * 1;
				arr[2][3] = 4 * 1;
			*/	
				
	public static void main(String[] args) {
		ex07();

	}

}
