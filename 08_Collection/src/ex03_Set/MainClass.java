package ex03_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MainClass {
	
	 /*
	  	Set
	 	1. 저장된 요소들에 인덱스가 없다. -> 저장 순서가 없다. (List는 인덱스가 있다.)
	 	2. 중복 저장이 되지 않는다. (로또문제에서 난수 발생시킬 때 값이 중복으로 나오지 않게 할 때 사용하기....)
	 */

	
	// List와 Set는 사용구현법이 비슷하다. 왜냐 부모클래스(Collection 인터페이스)가 같기 때문에
	
	public static void ex01() {
	
		// HashSet 객체 선언 및 생성
		Set<String> set = new HashSet<String>();

		// 추가
		set.add("spring"); // spring이 3개여도 출력에서 하나밖에 안 나옴.
		set.add("spring");
		set.add("spring");
		set.add("summer");
		set.add("autumn");
		set.add("winter");
		
		// 제거
		set.remove("winter");
		
		// 수정하는 건 불가능하다. why? 인덱스가 없으므로. 
		
		// 확인
		System.out.println(set); // 이거 출력하면 순서가 마구잡이로 생성된다.
		
	}
	
	public static void ex02() {
		
		// HashSet 객체의 초기화 (List를 이용해서 초기화를 진행)
		Set<Integer> set = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		
		// 인덱스가 없기 때문에 향상 for문만 가능
		for(Integer n : set) {
			System.out.println(n);
		}
	}
	public static void ex03() { // 할 일 없으면 보기.... 사용할 일 별로 없음. . . .
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		
		// 교집합 
		set1.retainAll(set2); // set1에 교집합 결과가 저장된다.
	
		System.out.println(set1); // 여기에 교집합 결과가 저장된다.
		System.out.println(set2);
	}
	
	public static void ex04() {
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		
		// 합집합 
		set1.addAll(set2); // set1에 합집합 결과가 저장된다.
	
		System.out.println(set1); // 여기에 합집합 결과가 저장된다.
		System.out.println(set2);
	}

	public static void ex05() {
		
		
		Set<Integer> set1 = new HashSet<Integer>(Arrays.asList(1, 2, 3, 4, 5));
		Set<Integer> set2 = new HashSet<Integer>(Arrays.asList(3, 4, 5, 6, 7));
		
		// 차집합 
		set1.removeAll(set2); // set1에 차집합 결과가 저장된다.
	
		System.out.println(set1); // 여기에 차집합 결과가 저장된다.
		System.out.println(set2);
	}
	
	public static void ex06() { // 연습
		
		Set<Integer> lotto = new HashSet<Integer>();
		
		// 1 ~ 45 : 6개 랜덤으로 발생
		while(lotto.size() < 6) {
			lotto.add((int)(Math.random() * 45) +1);
		}
		
		System.out.println(lotto);
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		ex06();
		
		

	}

}
