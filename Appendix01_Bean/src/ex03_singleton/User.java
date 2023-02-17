package ex03_singleton;

public class User {

	// static 필드 (미리 User를 객체를 만들어 둔다.) => static으로 가장 먼저 생성한다.
	private static User user = new User();
	
	// private 생성자(외부에서는 생성자를 호출할 수 없다.) => 하나만 사용하도록
	//private User() {
		
	//}

	// static 메소드 (static 필드를 사용하기 위해서) static타입은 static타입끼리 코딩해야 한다.
	// user 필드를 외부에서 사용할 수 있도록 반환하는 일종의 Getter
	public static User getInstance() { // singleton 작업할 때 메소드이름을 getInstance라고 한다. 
									   // getInstance 메소드로 객체를 호출한다.
		return user; 
	}
	
}
