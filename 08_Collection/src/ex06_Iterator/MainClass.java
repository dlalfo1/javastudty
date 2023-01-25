package ex06_Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainClass {

	/*
		Iterator 인터페이스
		1. 특정 Collection(컬렉션:List, Set)을 순회할 때 사용한다.(while문으로 순회한다.)
		2. 주요 메소드
			1) hasNext() : 남아 있는 요소가 있으면 true 반환
			2) next()	 : 저장된 요소를 하나 꺼냄
	*/
	
	public static void ex01() {
		
		List<String> list = new ArrayList<String>();
		
		list.add("동그랑땡");
		list.add("동태전");
		list.add("굴전");

		Iterator<String> itr = list.iterator(); // 리스트를 순회할 수 있는 반복자
				
		while(itr.hasNext()) { // 리스트의 요소가 남아있으면 와일문을 돌리시오.
			String food = itr.next();
			System.out.println(food);
			
		}
		
	}
	
	public static void ex02() {
		
		Set<Integer> set = new HashSet<Integer>();
		
		set.add(5);
		set.add(15);
		set.add(105);

		Iterator<Integer> itr = set.iterator();
		
		while(itr.hasNext()) {
			Integer number = itr.next();
			System.out.println(number); // Set의 출력순서는 자기 맘대로다. 순서 신경쓰지 말기.
			
		}

	}
	
	public static void ex03() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		// Map은 컬렉션에 속하지 않으니 사용법도 List, Set과 다르다
		// 키 값은 주로 변수이름이니 String으로
		// 밸류는 정수나 문자열이나 이것저것 넣으니까 Object로.
		
		map.put("name", "민경태");
		map.put("age", 46);
		map.put("isAlive", true);
		
		Set<String> keySet = map.keySet(); // keySet 메소드 : 모든 key를 담고 있는 Set를 리턴해준다
		
		Iterator<String> itr = keySet.iterator();
		
		while(itr.hasNext()) {
			
			String key = itr.next();
			Object value = map.get(key); // get 메소드는 map에서 키에 해당하는 밸류값 가져오는 기능을 한다.
			System.out.println(key + ":" + value);
		}
		
	}
	public static void main(String[] args) {
		ex03();
	}

}
