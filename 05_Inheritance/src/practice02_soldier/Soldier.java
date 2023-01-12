package practice02_soldier;

public class Soldier {
	
	// 필드
	private Gun gun; // 초기값은 null
	
	// Gun 클래스의 gun변수를 선언한다.
	
	// 생성자
	public Soldier() {
		gun = new Gun();
	}
	
	// 메소드
	public void reload(int bullet) {
		gun.reload(bullet);
		
	}	
	
	public void shoot() {
		gun.shoot();
	}
}	
