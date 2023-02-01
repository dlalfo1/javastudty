package ex07_Collections;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainClass {

		// 유틸기능이라 보면된다. 이것도 너무 깊게 공부하지 말기

	public static void printList(List<Integer> list) {
			
			int lastIndex = list.size() -1;
			
			for(int i = 0; i < lastIndex; i++) {
				System.out.print(list.get(i) + "→"); // 마지막 인덱스 이전까지만 순회를 돌리고
			}
			System.out.println(list.get(lastIndex)); // 마지막 인덱스를 출력해준다.
			
		}
		
	public static void main(String[] args) {
		
		List<Integer> list = Arrays.asList(5, 2, 3, 1, 4);
		
		printList(list); // 5→2→3→1→4
		
		Collections.sort(list); // 오름차순 정렬 (1 2 3 4 5)
		printList(list); // 1→2→3→4→5
		  
		int idx = Collections.binarySearch(list, 4); // binarySearch : 이진 검색(반드시 정렬이 되어 있어야 한다.)
		if(idx >= 0) {
			System.out.println("찾았다.");
		} else {
			System.out.println("못 찾았다.");
		}
		
		System.out.println(idx); // 4가 가지고 있는 인덱스값 3이 출력된다.
		
		// int idx = Collections.binarySearch(list, 10); // 없는 값을 찾으라하면 인덱스값이 마이너스값이 나온다.

		}		
	}
