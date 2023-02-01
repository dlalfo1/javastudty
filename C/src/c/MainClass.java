package c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MainClass {

	public static void ex01() { // List
		
		// ArrayList는 List의 구현체이므로 List가 사용하는 기능을 전부 포함하고 + 다른 기능이 있다
		// 즉, ArrayList만 가지는 전용메소드를 사용하지 않는 이상 ArrayList로 선언할 필요가 없다
		// 실무적으로도 필요없다 보통 List를 사용한다
		
		// List<String> list = new List<String>(); 가 안되는 이유!!!!
		// List는 인터페이스로써 추상메소드만 가지고 있기때문에 애초에 객체를 생성할 수 없다
		// 추상메소드를 가진 인터페이스는 객체를 생성할 수 없다 아무것도 가진게 없으니!!!
		// 만들려면 본인 아래에있는 애들 호출해서 기능 사용해야한다.
		
	
		List<String> list = new ArrayList<String>();
		
		// 추가할줄 알아야 하고
		
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		
		// 꺼내올줄 알아야하고 이건 기본이다.
		// List엔 인덱스값이 있으니 순서대로 꺼내올 수 있다.
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---");
		
		for(String season : list) { // list에 담겨있는걸 순회해서 season에 담고 출력해라.
			System.out.println(season);
		}
		
		
		
		// for문 향상for문 차이
		
		int[] arr = new int[3];
		arr[0] = 10;
		arr[1] = 20;
		arr[2] = 30;
		
		for(int i =0; i < arr.length; i++) {
			arr[i] += 10; // 20 30 40 이 나옴
			
		}   
		System.out.println(Arrays.toString(arr));  
		
		for(int n : arr) {
			n += 10; // 10 20 30 
					 // n은 배열의 복사본일뿐 배열자체는 아니므로 기존 배열에 더해지지 않는다.
		}
	}
	
	public static void ex02() { // Map
		
		/* 추가로 알려줌
		
		 Map map = new Map 리스트와 같은 이유로 인터페이스는 객체를 못 만든다
		
		 트리맵을 사용하려면 타입도 트리맵으로 쓰기(key값을 순서대로 꺼내오고 싶다면 트리맵을 쓸 때가 있다.)
		
		 트리맵을 사용할 때 맵타입으로 생성하면 맵의 기능밖에 못 쓴다. 순차정렬관련 기능은 트리맵에만 있다.
		
		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();

		treeMap.put(90, "제시카");
		treeMap.put(100, "블랑카");
		treeMap.put(50, "제레미");
		treeMap.put(80, "사만다");
		
		System.out.println(treeMap); // key값의 순서대로 꺼내온다
		
		*/
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(10, "b");
		map.put(101, "c");
		map.put(11, "d");
		
		System.out.println(map); // put한 순서대로 나오지 않는다. HashMap에는 순서가 없다
		
	}
	
	public static void ex03() { // Map
		
		Map<String, String> map = new HashMap<String, String>();
		
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age = 20;
		
		
		map.put("name", name);
		map.put("phon", phone);
		map.put("age", age + ""); // int 숫자를 문자열로 변경하려면 그냥 + "" 빈 문자열 넣어주면 된다
		
		System.out.println(map);
		
	}
	
	
	public static void ex04() { 
	
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("Servicekey", "dlsjflfs");
		map.put("Content-Type", "application/xml");
		
		System.out.println(map.get("Servicekey"));
		System.out.println(map.get("Content-Type"));
		
		ex05(map);
	}
	
	public static void ex05(Map<String, Object> map) {
		
		
		// map에 put으로 여러 엔트리값을 넣었어도 결국은 한 데이터
		// 이걸 map과 value로 나눠서 보고싶으면 entrySet기능을 사용해줘야한다
		// 그걸 Set에 담기기때문에 Set Entry 타입에 저장을 해줘야하는거다.
		// map을 사용하는 이유는 많은 정보를 모으기 위해서다
		// map 은 한번생성하고 put해서 정보를 모으면 되니까 모아서 어디로 보내기 위해서임
		// map을 받은곳은 또 그걸 푸는거고..
		// 왜 엔트리셋으로 가져오냐.. 맵의 키값이 중복없이 저장되는 SET형태이다
		// 그래서 셋으로 가져오는거임...엔트리셋하려면 엔트리타입도 넣어야하는거고...
		
		Set<Entry<String, Object>> set = map.entrySet();
		
		for(Entry<String, Object> entry : map.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
			
		
		
		}
		
		
		
		
		
	}
	public static void main(String[] args) {
		ex04();
		
	}

}
