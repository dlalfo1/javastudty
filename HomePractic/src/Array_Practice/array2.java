package Array_Practice;

public class array2 {

	
	public static void ex01() {
		
		int[][] score = { // int타입의 2차원 배열 선언과 생성.
				
				{100, 100,100},
				 {20, 20, 20},
				 {30, 30, 30},
				 {40, 40, 40}
		};
		
		// 각 배열 인덱스에 저장된 값 출력하고 각 배열의 요소값 합계 구하기.
		// 일단 합계를 구하려면 합계를 담을 변수 선언.
		
		int sum = 0;
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j <score[i].length; j++) {
				System.out.println("score ["+ i + "]["+ j +"]=" + score[i][j]);
				sum += score[i][j];
			}
			
		}
		System.out.println("sum = " + sum);
		
	}
	
	public static void ex02() {
		
		int[][] score = {
				
			//   국어 영어 수학 총점 평균
				{100, 100,100}, // 1
				 {20, 20, 20},  // 2
				 {30, 30, 30},  // 3
				 {40, 40, 40},	// 4
				 {50, 50, 50}	// 5
			//  과목별 총전	 
		};
		
		System.out.println("번호 국어 영어 수학 총점 평균");
		System.out.println("==============================");
		
		
		for(int i = 0; i < score.length; i ++ ) {
			
			int sum = 0; // 행의 총점
			double avg = 0.0; // 행의 평균
			
			int korTotal = 0;
			int engTotal = 0;
			int mathTotal = 0;
			
			korTotal += score[i][0];
			engTotal += score[i][1];
			mathTotal += score[i][2];
			
			System.out.print(i+1 + " ");
			
			for(int j = 0; j < score[i].length; j++){
			sum += score[i][j]; 
			System.out.print(score[i][j] +" ");
		}
			
			
			avg = sum / (double)score[i].length;
			System.out.print(sum + " ");
			System.out.println(avg);
			System.out.println();
			System.out.println("==============================");
			System.out.println(korTotal);
			
		}	
		
			
	}
	public static void main(String[] args) {
		ex02();{
			
		}

	}

}
