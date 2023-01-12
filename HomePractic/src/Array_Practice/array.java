package Array_Practice;

import java.util.Arrays;

public class array {

	
	public static void ex01() {
		
		//배열타입 + 참조변수 = new 배열타입[배열길이]
		
		int[] score = new int[5];  // 길이가 5인 int배열을 생성하고 그 주속값을 참조변수 score에 저장한다
		score[4] = 100; // score의 인덱스 4번에 100을 저장한다
		
		System.out.println(Arrays.toString(score));
		
		// [0, 0, 0, 0, 100] 출력
		
		// Ctrl + Shift + o = import문 추가해줌
		
		for(int i = 0; i < score.length; i++){ 
			// 배열의 길이만큼 for문이 돌아갈테니 0부터 4까지 4번 돌아간다
			System.out.println(score[i]); // score 주소값의 인덱스 4번값만 100이 출력된다.
		}
	
	}
	
	public static void ex02() {
		
		// 총합, 평균, 최대값, 최소값 구하기
		
		int[] score = {100, 88, 100, 100,90};
		
		// 일단 각각의 값을 저장할 변수를 선언해준다.
		
		int sum = 0;
		double avg = 0;
		int max = score[0];
		int min = score[0];
		
		// 총합 구하기
		
		for(int i = 0; i < score.length; i++) {
			
			sum += score[i]; // score 배열의 인덱스 i 값을 계속 sum에 저장한다. 
		}
		
		System.out.println("총합 : " + sum );
		
		// 평균값 구하기
		avg = sum / (double)score.length; // 총합을 score 배열의 길이 = 5로 나눈값을 avg에 저장한다
		
		System.out.println("평균값 : " + avg );

		// 최대값 구하기
		
		for(int i = 0; i < score.length; i++) {
			
			if(score[i] > max) {
				max = score[i];
			}
			if(score[i] < min) {
				min = score[i];
			}
		}
		
		System.out.println("최대값 : " + max );
		System.out.println("최소값 : " + min );
			
		// 최소값 구하기
		
		}
	
	public static void main(String[] args) {

		ex02();

	}

}
