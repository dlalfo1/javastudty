package ex01_try_catch;

import java.util.Scanner;

public class MainClass {
	
	public static void ex01() {
		
		try { // 문제 발생이 없으면 try문만 실행하고 끝
			
			String[] season = new String[4];
			
			season[0] = "spring";
			season[1] = "summer";
			season[2] = "autumn";
			season[3] = "winter";
			season[4] = "what??"; 
			
			for(String str : season) {
				System.out.println(str.substring(0,3));
			}
			
		} catch(Exception e) { // Unchecked의 Exception의 경우 RuntimeException으로도 처리 가능.
						  // 예외 객체의 이름은 관습적으로 e라고 적는다
			System.out.println("ArrayIndexOutOfBoundsException 발생");  // 문제가 생기면 catch문도 실행
		}
		
	}
	
	public static void ex02() {
		
		try {
			
			String input = "1,2,3,,4,5";
			String[] numbers = input.split(","); // input에 저장된 것들을 콤마(,)로 분리해줘라. 콤마 없애고 나머지 보여줘. 그걸 nubers 배열에 저장해줘라
			int[] iNumbers = new int[numbers.length];
			
			for(int i = 0; i < numbers.length; i++) {
				iNumbers[i] = Integer.parseInt(numbers[i]);
				System.out.println(iNumbers[i]);
		}
			
		} catch(Exception e) { // 모든 예외는 Exception으로 처리 가능
			System.out.println("NumberFormatException 발생");
			
		}
	}
	
	public static void ex03() {
		
		try {
		Scanner sc = new Scanner(System.in);
		System.out.println("계산식을 입력하시오(예시 : 1+2) >>> ");
		String expr = sc.next();
		String[] item = expr.split("[+]"); // 얘네중 하나로 분리해줘. split 아직 안 배움
		
		int number1 = Integer.parseInt(item[0]);
		int number2 = Integer.parseInt(item[1]);
		System.out.println(number1 + number2);
		sc.close();
		
		} catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("+를 포함해서 입력하세요.");
		} catch(NumberFormatException e) {
			System.out.println("정수 덧셈만 가능합니다.");
		} catch(Exception e) { // 마지막 catch 블록은 Exception으로 모든 예외를 처리한다.
			System.out.println("예외가 발생했습니다.");
		}
	}		
	public static void main(String[] args) {
		ex03();

	}

}
