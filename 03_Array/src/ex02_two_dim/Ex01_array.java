package ex02_two_dim;

public class Ex01_array {
	
	public static void ex01() {
		
		// 2차원 배열 선언
		int[][] arr;
		
		// 2차원 배열 선언
		arr = new int[3][2]; // 3행 2열(길이가 2인 배열이 3개가 있다.)
		
							 // 자바는 row major 행 우선 방식을 쓴다.
		
		// 2차원 배열 순회
		for(int i = 0; i < 3; i++) { // i : 행 번호
			for(int j = 0; j < 2; j++) { // j 열 번호
				System.out.print(arr[i][j] + "\t");
			}
				System.out.println();
		}
		
	}
	
	public static void ex02() {
		
		// 2차원 배열 선언 + 생성
		int[][] arr = new int[3][2];
		
		/* ㅇ ㅇ // 행 하나하나가 다 배열임 배열의 길이는 3
		   ㅇ ㅇ
		   ㅇ ㅇ
		*/
		
		// 길이 확인
		
		System.out.println(arr.length); // 3행이다. (1차원 배열이 3개 있다.) 
		  
		System.out.println(arr[0].length); // 1번째 1차원 배열의 길이 : 2
		System.out.println(arr[1].length); // 2번째 1차원 배열의 길이 : 2
		System.out.println(arr[2].length); // 3번째 1차원 배열의 길이 : 2
		
		// 2차원 배열 순회
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
		       System.out.println();
		}		
			
	}
	
	public static void ex03() {
		
		// 2차원 배열 선언
		int[][] arr;
		
		// 2차원 배열 생성(행만 생성하기)
		arr = new int[3][]; // 1차원 배열이 3개다! 행은 비워준다.
		
		// 각 행이 가질 열을 생성하기(각 1차원 배열의 생성)
		arr[0] = new int[5]; 
		arr[1] = new int[3]; 
		arr[2] = new int[2];
		
		// 2차원 배열 순회
		
		for(int i = 0; i < arr.length; i++) { // 배열의 길이는 3행이므로 변수 i에 저장해줌.
			for(int j = 0; j < arr[i].length; j++) { // 열의 길이도 변수 arr[i]에 저장해줌.
				System.out.print(arr[i][j] + "\t");
			}
				System.out.println();
		}
		
	}
	public static void ex04() {
		
		int[][] arr = { // 큰 중괄호를 하나 쳐주고 그 안에 중괄호로 넣어줌
				{1, 2, 3},
				{4, 5, 6}, // 3행 3열
				{7, 8, 9}
		};
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
				System.out.println();
		}
				
				
	}
	
	public static void ex05() { // 걍 내가 해본거..
		int[][] arr;
		
		// 2차원 배열 생성(행만 생성하기)
		arr = new int[10][]; // 1차원 배열이 3개다! 행은 비워준다.
		
		// 각 행이 가질 열을 생성하기(각 1차원 배열의 생성)
		arr[0] = new int[10]; 
		arr[1] = new int[10]; 
		arr[2] = new int[10];	
		arr[3] = new int[10];	
		arr[4] = new int[10];	
		arr[5] = new int[10];	
		arr[6] = new int[10];	
		arr[7] = new int[10];	
		arr[8] = new int[10];	
		arr[9] = new int[10];	
		
		for(int i = 0; i < arr.length; i++) { // 배열의 길이는 3행이므로 변수 i에 저장해줌.
			for(int j = 0; j < arr[i].length; j++) { // 열의 길이도 변수 arr[i]에 저장해줌.
				System.out.print(arr[i][j] + "\t");
			}
				System.out.println();
		}
	}
	public static void main(String[] args) {
		ex04();
		

	}

}
