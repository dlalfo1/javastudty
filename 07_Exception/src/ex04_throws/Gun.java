package ex04_throws;

public class Gun {
	
	
	
	/*
		예외 발생지점(return;)에 throw new RuntimeException 선언
		예외가 발생하면 메소드 옆에 만들어준 throws RuntimeException로 이동하고
		메소드 호출부분으로 예외가 던져진다.
		catch가 잡아서 catch문 안에 있는게 실행된다.
	 */
	
	private int bullet;
	public static final int MAX_BULLET = 10; // final로 막아놓으면 어차피 안전하니까 public해버리고 여러개 만들 필요 없으니 static 처리한다.  
											 // 상수로 두는 이유는 값이 변하지 않게 하기 위하여
	// 총알 넣기
	public void reload(int bullet) throws RuntimeException { // reload 메소드를 호출하는 곳으로 예외를 던지겠다.
															 // 여기서 던진 예외가 메인메소드에서 reldad 메소드를 호출하는 곳으로 가짐.
		if(this.bullet + bullet > MAX_BULLET) {
			throw new RuntimeException("장전 불가능");
		}
		
		this.bullet += bullet;
		System.out.println(this.bullet + "발 장전 완료");
	}
	
	// 총 쏘기
	public void shoot() throws RuntimeException { // 무조건 throws! 메소드에 명시할 땐 s 붙여줘야함.
		if(bullet == 0) {
			throw new RuntimeException("총알 부족");
		}
		bullet--;
		System.out.println("빵! " + bullet + "발 남았음");
	}

	public int getBullet() {
		return bullet;
	}
 
	public void setBullet(int bullet) {
		this.bullet = bullet;
	}

}
