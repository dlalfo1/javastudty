package ex01_one_dim;

public class Ex03_advanced_for {
	
	public static void ex01() {
		
		int[] scores = {50, 90, 60, 100, 80};
		
		int total = 0;
		int max = 0;
		int min = 100;
		
		// 향상된 for문 (일반 for문도 꼭 공부해야함)
		
		
		for(int n : scores) { // 외우기
			total += n; // 배열 인덱스를 지정하지않고 아무데서나 꺼내온다는 뜻으로 n 선언.
			if(max < n) {
				max = n;
			}
			if(min > n ) {
				min = n;
		}
	}
//		
//		for(int n : scores) {// scores 배열에 저장된 5개의 값을 자바가 알아서 빼서쓸게 라는 뜻. 하나씩 꺼내줌.
//			total += n;
//			if(max < n) {
//				max = n;
//			}
//			if(min > n) {
//				min = n;
//			}
//	}
//	
		System.out.println(total); // 합계
		System.out.println(max);   // 최대값
		System.out.println(min);   // 최소값
		
}

	public static void ex02() {
		
		String[] files = {"hello.txt", "hi.txt", "안녕.txt"};
		
		for(String file : files) { // files에서 아무거나 꺼내오고 그걸 반복할게~
			System.out.println(file); // 한번 돌아갈 때마다 출력
		}
				
	}
	public static void main(String[] args) {
		ex02();
	}

}
