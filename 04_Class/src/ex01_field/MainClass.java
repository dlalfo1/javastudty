package ex01_field;

public class MainClass {
	
	public static void ex01() {
		
		// 클래스 사용해서 아이디, 비밀번호, 포인트, 브이아이피 여부
		// User 타입의 객체(클래스의 변수) 선언, 항상 선언 + 생성이 먼저
		
		User user1 = new User(); // 이제 user1이라는 변수를 사용해서 User 클래스의 변수 사용 가능!
		
		user1.id = "이미래";
		user1.pw = "123456";
		user1.point = 100;
		user1.isVip = true;
		
		System.out.println("아이디 : " + user1.id);
		System.out.println("비밀번호 : " + user1.pw);
		System.out.println("포인트 : " + user1.point);
		System.out.println("VIP 여부 : " + user1.isVip);
		
	}
	
	public static void ex02() {
		
		
		// 객체 user1의 필드 활용
		User user1 = new User();
		
		// user1의 addr 필드를 생성(Address 클래스 타입이기 때문에 반드시 new를 이용해 생성해야 한다.)
		
		
		user1.addr = new Address();
		
		// User 클래스 안에 Address 클래스가 있음. 그 값은 null.
		// 그러므로 addr 변수를 선언해주고 Address객체를 만들어준다.
		// 그럼 user1에서 Adress클래스의 변수 사용 가능.
		
		user1.addr.postcode = "12345";
		user1.addr.jibunAddress = "가산동";
		user1.addr.roadAddress = "디지털로";
		
		System.out.println("주소 : " + user1.addr.postcode + " " + user1.addr.roadAddress + "(" + user1.addr.jibunAddress + ")" );
				
	}
	
	public static void ex03() {
		
		// 개별 연습
		// 다음 값을 가지는 객체 user2를 생성해 보세요.
		
		// 아이디 : master
		// 비밀번호 : 654321
		// 포인트 : 1000
		// VIP 여부 : ture
		// 주소 : 54321 디지털로(철산동)
		
		// 객체 선언 + 생성
		
		User user2 = new User();
		
		
		// 필드 값 저장
		
		user2.id = "master";
		user2.pw = "654321";
		user2.point = 1000;
		user2.isVip = true;
		
		// user2 객체의 addr 필드 생성
		
		user2.addr = new Address();
		
		user2.addr.postcode = "54321";
		user2.addr.roadAddress = "디지털로";
		user2.addr.jibunAddress = "철산동";
		
		// 확인
		
		System.out.println("아이디 : " + user2.id);
		System.out.println("비밀번호 : " + user2.pw);
		System.out.println("포인트 : " + user2.point);
		System.out.println("VIP 여부 : " + user2.isVip);
		System.out.println("주소 : " + user2.addr.postcode + " " + user2.addr.roadAddress + "(" + user2.addr.jibunAddress + ")" );
		
	}
	
	public static void main(String[] args) {
		ex03();
	}

}
