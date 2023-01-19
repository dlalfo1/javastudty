package ex04_throws;

public class MainClass {

	public static void main(String[] args) {
	
	
	Gun gun = new Gun();
	
	try {
		gun.reload(10); // 여기로 throws에서 던진 예외게 오고
		for(int n = 0; n < 11; n++) {
			gun.shoot();
		}
	} catch(Exception e) { // 여기서 잡음
		System.out.println(e.getMessage()); // 이거 실행
	}
}	
		
}

