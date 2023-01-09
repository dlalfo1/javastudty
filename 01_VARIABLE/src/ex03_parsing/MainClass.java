package ex03_parsing;

public class MainClass {

	public static void main(String[] args) {
		

		// 구문 분석(parsing)
		// 문자열을 기본 타입으로 변환하는 과정을 의미한다.
		
		String strScore = "90";
		String strMoney = "10000000000";
		String strEye = "0.7";
		
		
		/* 
		    int
		    일단 String 타입을 다른 타입으로 바꿔주려면 새로운 타입과 변수를 선언해 줘야한다.
		    int score = Integer.parseInt(strSore);
		 */
		
		/*
	       long
		   long money = Long.parseLong(strMoney);
		 */
		
		/* 
		   double
	       double Eye = Double.parseDouble(strEye);
	       
		 */
		
		// String -> int로 변환. 
		int score = Integer.parseInt(strScore); // 외우기..
		
		System.out.println(score);
		
		// String -> long으로 변환
		
		long money = Long.parseLong(strMoney);
		
		System.out.println(money);
		
		// String -> double로 변환
		
		double eye = Double.parseDouble(strEye);
		
		System.out.println(eye);
		
	}

}
