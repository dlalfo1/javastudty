package ex03_throw;

import java.util.Scanner;

public class MainClass {

	public static void ex01() {
		
		try {
			
			Integer.parseInt("하핳");
			int a = 4 / 0;
			System.out.println(a);
	
		} catch(Exception e) {
			
			System.out.println(e.getClass().getName()); // 예외 클래스 이름 확인
			System.out.println(e.getMessage()); // 예외 메세지 확인
		}
	}
	
	public static void ex02() {
		
		try {
			
			Integer.parseInt("호홓");
			
		} catch(Exception e) { // 예외를 확인해야하니까 비워두면 안 됨. 
			
			e.printStackTrace(); // 예외를 추적하는 메소드(개발중에는 이것만 사용함)
								 // 예외가 발생한 내역을 저장한 저장소의 위치를 추적해달라
		}
	}
	
	public static void ex03() {
		
		
		/*
		  throw 
		  1. 예외 객체를 생성해서 직접 던질 수 있다.
		  2. 개발자가 직접 예외를 처리할 때 사용한다.
	    */
		
		Scanner sc = null;
		
		try {
			sc = new Scanner(System.in);
			System.out.println("나이를 입력하세요 >>> ");
			int age = sc.nextInt();
			if(age < 0 || age > 100) {
				throw new RuntimeException(age + "살은 불가능합니다."); // throw 만들 때 RuntimeException(실행 중 발생한 예외 쓰기)
			}
			System.out.println(age >= 20? "주류 구매 가능" : "주류 구매 불가능");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			sc.close();
		}
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
