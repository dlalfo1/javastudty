package ex06_op_string;

public class MainClass {

	public static void ex01() {
		
		// 연결 연산
		// 문자열과 + 연산자가 만나면 연결됩니다.
		
		String str1 = "구디" + "아카데미"; // 문자열과 문자열의 단순 연결
		String str2 = 4 + "달라"; //숫자와 문자열의 단순 연결
		String str3 = 100 + 10 + "번지"; // 순서대로 동작해서 100+10 먼저 계산함. 110 + "번지"	
		
		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);		
		
	}
	
	public static void ex02() {
		
		// 모든 타입의 데이터는 빈 문자열("")을 + 시키면 문자열이 된다.
		// 문자열에서 사용할 수 있는 기호는 + 뿐이다.
		
		int a = 100;
		String str = a + "";
		
		System.out.println(a);
		
		// 원래는 이런 게 있다.
		// String str = String.valueOf(a);
		// 하지만 개발자들은 잘 안 쓴다.
		
	}
	
	public static void ex03() {
		
		// 문자열의 비교는 == 또는 != 으로 하지 않는다.
		
		String str1 = "hello";
		System.out.println(str1 == "hello"); // true
		
		String str2 = new String("hello");
		System.out.println(str2 == "hello"); // false 
		
	}
	
	public static void main(String[] args) {
		ex01();
		
	}

}
