package ex02_finally;

import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		
		// finally 블록
		// 항상 마지막에 실행되는 블록으로 생략할 수 있다.
		
		Scanner sc = null; // 스캐너 선언과 생성을 분리하기. 선언이 try문 안에 있다면 finally문에서 sc변수를 사용할 수 없다.
						   // 그러므로 스캐너 선언은 try문 밖에서 먼저 해준다. 선언할 때 초기값을 넣어줘야 한다.
		try {
			sc = new Scanner(System.in); // 스캐너 생성은 try문 안에서 한다.
			System.out.println("나이를 입력하세요 >>> ");
			int age = sc.nextInt();
			System.out.println(age >= 20 ? "주류 구매 가능" : "주류 구매 불가능");
		} catch(Exception e) {
			System.out.println("예외가 발생");
		} finally { // close 기능이 필요한 애들은 finally문을 써준다.
			sc.close();	// finally 블록은 자원(resource : 여기선 키보드로 입력받는걸 뜻함)을 반납할 때 주로 사용한다.		
		}

	}

}
	
