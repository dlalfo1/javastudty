package ex05_op_condition;

public class MainClass {

	// ex01 메소드 정의
	public static void ex01() {
		
		int a = 3;
		int b = 4;
		
		boolean result1 = a > b; // false
		boolean result2 = a >= b; // false => x
		boolean result3 = a < b; // true
		boolean result4 = a <= b; // true =< x
		boolean result5 = a == b; // false a와 b가 같다.
		boolean result6 = a != b; // true a와 b가 같지 않다.
		
		// 크거나 같다, 작거나 같다의 경우 항상 크기관련 부호가 앞에 오고 그다음에 같다 부호가 와야한다.
		
		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
		System.out.println(result4);
		System.out.println(result5);
		System.out.println(result6);
			
	}
	
	public static void ex02() {
		
		// 논리 연산
		// 1. 논리 AND : &&, 모든 조건이 true이면  true, 아니면 false. 그리고 이므로 둘 다 만족해야함.
		// 2. 논리 OR : ||, 하나의 조건이라도 true이면 true, 아니면 false. 또는 이므로 둘 중 하나만 만족해도 됨.
		// 3. 논리 NOT : !, 조건이 true이면 false, 조건이 false이면 true.
		
		int a = 10;
		int b = 10;
		
		boolean result1 = (a == 10) && (b == 10); // 둘 다 참이기 때문에 true.
		boolean result2 = (a == 10) && (b == 20); // 하나가 거짓이기 때문에 false.
		
		System.out.println(result1);
		System.out.println(result2);
		
		boolean result3 = (a == 10) || (b == 10); // 둘 중 하나라도 참이면 true.
		boolean result4 = (a == 10) || (b == 20); // b가 거짓이여도 a가 참이기 때문에 true.
		
		System.out.println(result3);
		System.out.println(result4);
		
		boolean result5 = !(a == 10); // true의 반대이므로 false.
		boolean result6 = !(a == 20); // false의 반대이므로 true.
		
		System.out.println(result5);
		System.out.println(result6);
	
	}
	
	public static void ex03() {
		
		// Short Circuit Evaluation
		// 1. 논리 AND의 경우 조건의 결과가 false인 경우가 발생하면 더 이상 동작하지 않는다. 최종 결과가 false로 정해졌기 때문이다.
		// 2. 논리 OR의 경우 조건의 결과가 true인 경우 발생하면 더 이상 동작하지 않는다. 최종 결과가 true로 정해졋기 때문이다.
		
		int a = 10;
		int b = 10;
		
		boolean result1 = (a == 20) && (++b == 11);
		
		System.out.println(b); // 이미 앞 항의 조건이 false이기 때문에 최종 결과가 false로 정해졌으므로 b값은 기초값인 10
		System.out.println(result1); 
		
		boolean result2 = (a == 10) || (++b == 10);
	
		System.out.println(b); // 이미 앞 항의 조건이 true이기 때문에 최정결과가 true로 정해졌으므로 b값은 기초값인 10
		System.out.println(result2);
		
	}
	
	public static void ex04() { // 연습
		
		int score = 75;
		
		boolean result1 = (70 <= score) && (score < 80); // 70점대는 true 아니면 false.
		
		System.out.println(result1);
		
		boolean result2 = (score / 10) == 7; // 70점대는 10으로 나눴을경우 몫이 7이기 때문에 이런식으로도 가능.
		
		System.out.println(result2);
	}
	
	public static void ex05() {
		
		//조건 연산
		// 1.(조건식) ? 2.true 일 때 처리 : 3.false 일 때 처리 => 항의 개수가 삼항이므로 삼항영산자라고 함.
		
		int score = 100;
		
		String result= (score >= 60) ? "합격" : "불합격";
		
		System.out.println(result);
		
	}

	public static void ex06() { // 연습
		
		int n = 3;
		
		String result = (n % 2 == 0) ? "짝수" : "홀수"; // 짝수, 홀수
		
		System.out.println(result); // 3 나누기 2의 나머지는 1, 0과 같지 않으므로 false, 홀수 출력.
		
	}
	
	public static void ex07() { // 연습
		
		int n = 0;
		
		String result = (n != 0 && n % 3 == 0) ? "3의 배수" : (n % 2 == 0) ? "짝수" : "홀수";
		
		// n이 0이라면 3의 배수라고 나오는 점이 문제.
	
		System.out.println(result);
		
	}
	
	public static void main(String[] args) {
		
    // ex01 메소드 호출
	     ex06();
	}

}
