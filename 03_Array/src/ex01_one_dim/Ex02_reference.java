package ex01_one_dim;

public class Ex02_reference {
	
	
	/* int[] arr; referencd(참조값) = address(주소값)
	
		arr = new int[5];
	
	 
		  // 총 6개의 저장공간이 생김
	 * 
			arr : 참조(주소,번지)값, 각 배열의 번지수를 저장하는 공간이 필요하기 때문에 생김.
			arr[0]
			arr[1]
			arr[2]
			arr[3]
			arr[4]
			
	 */
	public static void ex01() {
		
		int[] arr;
		arr = new int[5];
		
		System.out.println(arr); // 5개 배열 요소의 참조(주소,번지)값이다.
								 // [I@182decdb 이렇게 출력되는데 @(at : ~에서) 앞은 무시하기. 컴퓨터마다 주소가 다를 수 있음.
		
		/* 
		 참조 = 주소 = 번지 : 배열의 위치를 나타내는 값 
		 16 진수 : 0x로 시작한다
		 
		*/
	
	}
	
	public static void ex02() {
		
		int[] a = new int[5];
		
		// a라는 번지값을 저장할 저장공간이 하나 생기고 그 다음 배열 5개가 들어갈 공간이 생김.ㅣ
		
		int[] b;
		
		b = a; // b가 길이가 5인 배열이 된 것임. a와 b의 번지수가 같아짐.
		
		for(int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
		b[0] = 100; // 배열 a의 번지수와 배열 b의 번지수가 같아졌으므로 배열 b의 0번 인덱스값에 100을 저장하면 배열 a의 0번 인덱스값도 100으로 바뀐다
		
		System.out.println(a[0]); 
		/*
            |-------|
          a | 0x123 |─────┐
            |-------|          │
            |  ...  |          │
            |-------|          │
       a[0] |   0   | 0x123    │
            |-------|          │
       a[1] |   0   |          │
            |-------|          │
       a[2] |   0   |          │ b = a;
            |-------|          │
       a[3] |   0   |          │
            |-------|          │
       a[4] |   0   |          │
            |-------|          │
            |  ...  |          │
            |-------|          │
          b | 0x123 |◀────┘
            |-------|
		*/
		
	}
	
	public static void ex03() { // 심화...
		
		// 생성된 배열의 크기를 늘이는 방법
		
		// 기존 배열
		int[] a = new int[5];
		
		// 신규 배열
		int[] b = new int[10];
		
		// 기존 배열 요소 -> 신규 배열 요소로 복사
		
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i]; // b배열에 a배열 값을 다 가져옴.
			
		}
		
		// 기존 배열의 참조값을 신규 배열의 참조값으로 수정
		
		a = b; // a 참조값을 b로 바꿔줌/
		
		// 기존 배열이 신규 배열로 변경되었으므로 확인
		
		for(int i = 0; i < a.length; i++) {
			System.out.println(a[i]); // 기존 a의 크기는 5였으나 10으로 바뀐걸 확인할 수 있음.
			
			// 이렇게 되면 기존 a가 있던 번지수가 garbage로 남게 되고 자바가 garbage collector를 실행시켜서 처리해줌. (메모리 누수)
			// system.gc(); garbage collecter를 실행시켜달라~ 할 수도 있음. 
			// 하지만 어차피 자바는 실행 안해줌. 조금 재촉할 뿐 때 되면 자바가 자동으로 해줌.
		}
		
	}

	public static void ex04() {
		
	}
	public static void main(String[] args) {
		ex02();

	}

}
