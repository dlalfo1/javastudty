package practice08_SmartPhone;

public class MainClass {

	public static void main(String[] args) {
		
		// Phone 타입이면 Computer가 안 보이므로 Computer로 캐스팅 필요
		Phone p1 = new SmartPhone(); // Phone 부모 SmartPhone 자식. 부모타입 기능밖에 못씀
		p1.call(); // 부모의 기능인 call 가능
		p1.sms(); // 부모의 기능인 sms 가능
		((Computer) p1).game(); // 컴퓨터 인터페이스 사용하려면 강제 캐스팅 해준후 컴퓨터의 기능은 game 호출 가능
		((Computer) p1).internet(); // 컴퓨터 인터페이스 사용하려면 강제 캐스팅 해준후 컴퓨터의 기능은 internet 호출 가능
		
		// Computer 타입이면 Phone이 안 보이므로 Phone으로 캐스팅 필요
		Computer p2 = new SmartPhone(); // 컴퓨터 부모 스마트폰이 자식 컴퓨터 기능밖에 사용하지 못함.
		((Phone) p2).call(); // 전화걸기 기능 사용하려면 폰으로 캐스팅
		((Phone) p2).sms(); // sms 기능 사용하려면 폰으로 캐스팅
		p2.game(); // game은 컴퓨터 기능이라 가능
		p2.internet(); // internet은 컴퓨터 기능이라 가능
		
		// SmartPhone은 모두 보임
		SmartPhone p3 = new SmartPhone(); // 스마트폰은 다 쓸 수 있음. 폰도 상속하고 컴퓨터 인터페이스니까
		p3.call();
		p3.sms();
		p3.game();
		p3.internet();

	}

}
