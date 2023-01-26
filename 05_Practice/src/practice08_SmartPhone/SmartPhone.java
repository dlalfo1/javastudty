package practice08_SmartPhone;

// 상속(extends)은 하나만 가능하지만(다중 상속 불가능),
// 구현(implements)은 여러 개가 가능하다.

// 상속과 구현을 동시에 받아도 된다.
// 상속(extends) 먼저, 구현(implements) 나중

// 전화(Phone) 기능과 컴퓨터(Computer) 기능을 모두 갖춘 스마트폰

public class SmartPhone extends Phone implements Computer { // 스마트폰은 폰을 상속받고 컴퓨터도 인터페이스한다.

	@Override
	public void call() { // Phone 클래스 추상메소드 사용하려면 오버라이드 해줘야함
		System.out.println("전화기능");		
	}
	
	@Override
	public void sms() { // Phone 클래스 추상메소드 사용하려면 오버라이드 해줘야함
		System.out.println("문자기능");		
	}
	
	@Override 
	public void game() { // computer 클래스 추상메소드 사용하려면 오버라이드 해줘야함
		System.out.println("게임기능");
	}
	
    @Override
    public void internet() { // computer 클래스 추상메소드 사용하려면 오버라이드 해줘야함
    	System.out.println("인터넷기능");    	
    }
	
}
