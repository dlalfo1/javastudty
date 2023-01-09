package ex02_casting;

public class Ex02_casting {

	public static void main(String[] args) {

		// 강제 변환
		// 1. 큰 크기 -> 작은 크기
		// 2. 실수 -> 정수
		
		int n = 256;
		byte bn = (byte)n; // 변수 n을 byte 타입으로 바꾸시오. 
						   // 강제변환으로 값이 잘려나갔기 때문에 0만 출력된다.
		                   // 강제변환은 앞에 (byte) , (double) 이런식으로 괄호안에 타입을 써준다.
		System.out.println(n);
		System.out.println(bn);
		
		double leftEye = 0.7;
		int iLeftEye = (int)leftEye;  // 변수 leftEye를 int 타입으로 바꾸시오.
		
		System.out.println(leftEye); 
		System.out.println(iLeftEye); // 소수점은 항상 잘려나간다.
		
		double rightEye = 3.2;
		double irghtEye = (int)(rightEye);
		
		System.out.println(rightEye);
		System.out.println(irghtEye); // 강제변환으로 0. 뒤에값(소수점)은 항상 잘려나간다.
		
	}

}
