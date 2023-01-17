package ex02_random;

import java.util.UUID;

public class Ex04_UUID {

	public static void main(String[] args) {

		// 중복되지 않는 값이 필요할 때 사용.
		
		/*
			java.util.UUID // 전세계 누가 써도 아무도 겹치지 않게 만들어 준다.
			1. 전역 고유 식별자(Universal Unique IDentifier
			2. 32개의 16진수와 4개의 하이픈(-)로 구성된 식별자 값이다.
		*/
	
		UUID uuid = UUID.randomUUID(); // uuid의 값은 아직 문자열 상태가 아니다
		String str = uuid.toString(); // 이렇게 문자열로 바꿔주기
	
		System.out.println(uuid); 
		
		// 하이픈(-) 모두 없애기 : 모든 하이픈(-)을 빈 문자열("")로 바꾸기
		String replacedStr = str.replace("-", "");
		System.out.println(replacedStr);
	
	}
	

}
