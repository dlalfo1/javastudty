package ex04_op_number;

public class MainClass {
	
	// ex01 메소드를 정의(메소드 즉, 기능을 하나 만든다)
	// 위치는 main 메소드 위든 아래든 상관없음. main 메소드 안에만 만들지 않으면 됨!
	// Java는 적어놓은 순서대로 작용하는 절차지향언어가 아니기 때문에 어디에 있어도 호출 가능
	
	public static void ex01() {
		
		int a = 10;
		int b = 2;
		
		int add = a + b; // addition 덧셈
		int sub = a - b; // subtraction 뺄셈
		int mul = a * b; // multiplication 곱셈
		int div = a / b; // 나누었을 때 몫 division 나눗셈
		int mod = a % b; // 나누었을 때 나머지 %
		
		System.out.println(add);
		System.out.println(sub);
		System.out.println(mul);
		System.out.println(div);
		System.out.println(mod);
		
	}
	
	// ex02 메소드 정의
	public static void ex02() { // 연습
		
		int a = 5;
		int b = 2;
		
		int div1 = a / b; // 5 나누기 2 는 2.5 인데 타입이 int 이므로 소숫점 앞자리까지만 출력됨.
		double div2 = (double)a / b; // a만 5.0으로 바꿔줘도 자동으로 b가 2.0으로 바뀜. 실수 * 정수 = 실수
		
		System.out.println(div1);
		System.out.println(div2);
		
	}
	
	// ex03 메소드 정의
	public static void ex03() { // 연습
		
		int second = 90;
		int min = second / 60; // / => 나누었을 때 몫
		int sec = second % 60; // % => 나누었을 때 나머지
		
		
		System.out.println(min); // 1
		System.out.println(sec); // 30 
		
	}

	// ex04 메소드 정의
	public static void ex04() {
		
		// 1 증가 : ++
		// 1 감소 : --
		
		// 전위 연산(pre operator)
		// ++a 또는 --a 
		// 변수 a의 값을 1 증가(감소)시킨 뒤에 사용하시오.
		
		int a = 10;
		System.out.println(++a); // b = 11 , 먼저 10에 1을 증가시킨후 출력하라.
		
		// 후위 연산(post operator)
		// b++ 또는 b--
		// 변수 b의 값을 사용한 뒤에 1 증가(감소) 시키시오.
		
		int b = 10;
		System.out.println(b++); // b = 10 , 출력한 후 b를 1 증가시켜라.
		System.out.println(b); // b = 11
		
	}
	
	// ex05 메소드 정의
	public static void ex05() {
		
		// 대입 연산
		// 등호(=)의 오른쪽 값을 왼쪽으로 보내는 연산. 같다라는 뜻이 아님.
		
		int a; // int타입의 변수 a를 선언.
		
		a = 10; // int타입의 변수 a에 10을 저장하겠다.
		 
		// 10 = a; a를 10에 저장할 수 없으니 오류.
		
		System.out.println(a); // 10
	}
	
	// ex06 메소드 정의
	public static void ex06() {
		
		int x = 10;
		int y = 20;
		
		// x , y 값 교환하기 
		
		int temp; // temp라는 일시적 변수를 만들어서 x를 백업해두기.
		temp = x;
		x = y;
	    y = temp;
		
		System.out.println(x); // 20
		System.out.println(y); // 10
		
	}
	
	// ex07 메소드 정의
	public static void ex07() {
		
		int account = 10000;
		
		account += 5000; // account = account + 5000;
		System.out.println(account);
		
		account -= 50000; // account = account - 50000;
		                  // 위의 게산으로 account 변수엔 15000이 저장되어있으므로 15000 - 50000 = -35000
		System.out.println(account);
		
	}
	
	// ex08 메소드 정의
	public static void ex08() { // 연습
		
		long account = 123456;
		
		// 5% 이자 받으면 얼마? 5% 이자만 계산하려면 * 0.05, 이자를 더한 값을 얻고 싶으면 * 1.05
		// 애초에 값을 소숫점값까지 얻고 싶으면 제일 먼저 더블타입의 변수를 하나 선언해줘야함! 
		// account = account * 1.05; 이게 불가능함

		double result;
		
		result = account * 1.05; // result = account + account * 0.05;
		
		System.out.println(result);		
				
	}
	
	public static void main(String[] args) {
		
		// ex01();  ex01 메소드 호출(메소드를 사용하겠다 즉, ex01 메소드 안에 있는 모든 소스 사용)
		// main 메소드를 제외한 메소드는 전부 만들고 호출해야 사용가능함.
		ex07(); // ex08 메소드 호출
	}
		
}
