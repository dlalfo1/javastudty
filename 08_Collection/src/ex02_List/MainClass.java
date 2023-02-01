package ex02_List;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainClass {

	
	public static void ex01() {
		
		// 배열 리스트(ArrayList) 선언 및 생성 (실무에서 거의 이것만 쓴다)
		
		// add, get, size 메소드는 꼭 알아두자
		
		// List 인터페이스를 가져다 쓰는거라 앞에 List 써주고 임폴트해줌
		
		// 애초에 <> 안에 String타입을 넣어주면 add 기능을 사용할 때 String값밖에 넣지 못한다.
		
		// 리스트는 인덱스가 있다.
		
		List<String> list = new ArrayList<String>();
		
		// 추가
		list.add("summer"); // 인덱스 지정이 없으면 항상 마지막에 추가됨.
		list.add("autumn");
		list.add("frog");
		list.add("winter");
		list.add(0, "stpring"); // 인덱스 0에 spring 추가됨. 얘가 인덱스 0으로 되고 첫번째 문장이 인덱스1이 된다.
		
		// 수정
		list.set(2, "fall");
		
		//삭제
 	    // list.remove("frog"); // 삭제할 대상을 직접 전달하기
		list.remove(3); // 삭제할 대상의 인덱스를 전달
		// 확인
		System.out.println(list);
		
	}
	
	public static void ex02() {
		
		// ArrayList 초기화
		List<Integer> list = Arrays.asList(1, 2, 3, 4, 5); // 1 2 3 4 5로 초기화 하였다.
		
		// 리스트 길이 
		System.out.println("리스트의 길이 : " + list.size()); // 배열의 길이 찾기
		
		// 리스트에 저장된 개별 요소 확인 방법
		System.out.println("첫 번째 요소: " + list.get(0)); // 배열과 다르게 get[]이 아니라 get() 임. 인덱스의 요소 꺼내올 때 사용한다.
		System.out.println("마지막 요소 : " + list.get(list.size() -1));
	
		// 리스트 순회 (List에서 값 가져오고 싶으면 for문 짜야한다.)
		// 모든 요소의 합계 구하기
		
		int sum = 0;
		
		for(int i = 0, length = list.size(); i < length; i++) { 
			sum +=  list.get(i);
		}
		
		System.out.println("모든 요소의 합 : " + sum);
	}
	
	public static void ex03() { // 연습
		
		List<User> userList = new ArrayList<User>();
		
		for(int i = 0; i < 3;  i++) {
			
			User user = new User("user", "123456");
			userList.add(user);
		}
	
		// 아이디만 출력하기
		for(int i = 0, length = userList.size(); i < length; i++) {
			System.out.println(userList.get(i).getId()); 
			
		}
		
	}
	
	public static void main(String[] args) {
		ex01();
	}

}
