

package ex05_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainClass {

	public static void ex01() {
		
		/*
		  
		  ********Map은 콜렉션이 아니다! List,Set과는 다르다*********
		  *
		  * Map은 객체를 대신해서 쓸 수 있다. 
		  
		 	HashMap 
		 	1. 하나의 데이터가 2개의 요소로 구성된다.
		 	2. 용어 정리
		 		1) Entry : 하나의 데이터
		 		2) Key 	 : Entry의 구성 요소, 식별자 역할을 수행(배열의 인덱스 같은 역할)
		 		3) Value : Entry의 구성 요소, 실제 데이터(배열에 저장된 데이터와 같은 역할)
		 	3. 주로 Key는 String을 사용한다. (변수 이름)
		 	4. 주로 Value는 Object를 사용한다. (변수에 저장된 값)
		 	5. Key는 중복이 불가능하고, Value는 중복이 가능하다. 
		 		// Key는 변수 이름이니 중복이 불가능함. Value는 값이니 중복이 가능 당연한 소리~~~
		 	
		 	
		 	* Key를 통해 Value값을 얻는다.
		 	* 많은 양의 데이터를 검색하는데 매우 뛰어나다.
		 */

		// Person 정보를 HashMap으로 만들기 (Key관리 용도로 만들어보기)
		Map<String, Object> person = new HashMap<String, Object>(); // 왕 중요...많이 씀. . . . . . .
		
		// 추가
		// put(Key, Value)
		
		person.put("name", "홍길동"); // 하나의 Entry;
		person.put("age", 30);
		
		// 수정
		// put(Key, Value)
		person.put("age", 40); // 기존Key와 동일한 Key를 전달하면 해당 Key값의 Value가 수정된다.
		
		// 삭제 
		// remove(Key)
		int age = (int)person.remove("age"); // 삭제된 Value가 반환된다. Value는 Object 타입이므로 "무조건" 캐스팅해야 사용할 수 있다.
		System.out.println("삭제된 나이 : " + age);
		
		// 확인
		System.out.println(person); // Entry가 2개
	}
	
	public static void ex02() {	
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("autumn", "가을");
		dictionary.put("winter", "겨울");
		
		// Value 가져오기(키값으로 밸류 관리하니까 키값을 가져와야한다.)
		// get(Key)
		String season = dictionary.get("winter");
		System.out.println(season);
		
	}
	
	public static void ex03() {	
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("autumn", "가을");
		dictionary.put("winter", "겨울");
		
		// Map 순회하기 ( 실무에선 Map의 순회문을 짤 일이 없다. api 사용할 때나 사용할 수도 있을 듯. 만들기보단 해석하는 능력이 필요)
		
		
		// keySet() 메소드를 사용해서 key값을 가져오면 Set에 저장된다.
		// 그래서 엔트리엔 순서가 없다. Set엔 순서가 없으므로
		
		// 1. Key만 모두 가져온 뒤 해당 key값을 가진 Value를 가져오기
		Set<String> keySet = dictionary.keySet(); // Set에는 인덱스가 없음 그러니 for문도 쓸 수 없음 향상 for문 가능
												  // dictionary map의 키값만 가져와서 Set으로 돌려준다.
		for(String key : keySet) {
			System.out.println(key + ":" + dictionary.get(key));
		}
		
		// 2. Entry를 모두 가져온 뒤, Key와 Value로 분리하기
		for(Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
	}
	
	public static void ex04() {	// 연습
		
		// 제목(title), 저자(author), 가격(price)으로 구성되는 책(book) : HashMap
		
		
		Map<String, Object> book1 = new HashMap<String, Object>();
		book1.put("title", "어린왕자");
		book1.put("author", "생텍쥐베리");
		book1.put("price", 10000);
		
		Map<String, Object> book2 = new HashMap<String, Object>();
		book2.put("title", "성냥팔이소녀");
		book2.put("author", "안데르센");
		book2.put("price", 20000);
		
		Map<String, Object> book3 = new HashMap<String, Object>();
		book3.put("title", "소나기");
		book3.put("author", "황순원");
		book3.put("price", 30000);
	
		
		// 책(book) 3권이 저장된 ArrayList
		List<Map<String, Object>> books = new ArrayList<Map<String, Object>>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		//for문 순회
	
		// List의 순회
		for(int i = 0, length = books.size(); i < length; i++) {
			// Map의 순회(List에 저장된 요소가 Map이다
			Map<String, Object> book = books.get(i); // ArrayList에서는 (i)
			System.out.println((i + 1) + "번째 책의정보");
			for(Entry<String, Object> entry : book.entrySet()) {
				System.out.println(entry.getKey() + ":" + entry.getValue());
		}
		
		}
		
	}
	public static void main(String[] args) {
		ex03();	
	}

}
