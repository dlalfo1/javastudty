package ex04_hash;

import java.util.HashSet;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {
		
		// Hash 는 알고리즘관련이라 크으게 중요하진 않다.

		User user1 = new User("admin", "123456");
		User user2 = new User("admin", "123456");
				
		Set<User> set = new HashSet<User>();
		set.add(user1);
		set.add(user2);
		
		System.out.println(set); // user1, user2를 비교하지 못하기 때문에 출력이 두번 나옴. set은 중복저장이 안됨에도 불구하고.
		
	}

}
