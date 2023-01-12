package ClassAndMathod;

public class MainClass {

	public static void main(String[] args) {
		
		// 객체 생성
		// 클래스 이름 + 참조 변수명 = new 클래스 이름();
		// Tv타입의 참조변수 t1을 생성하고, 거기에 객체를 저장한다.(객체의 번지수값을 t1에 저장한다.)
		
		Tv t1 = new Tv();	// 0x100번지
		Tv t2 = new Tv();	// 0x200번지		

		// 이렇게 객체를 생성해주면 이제 참조 변수 t1, t2는 Tv 클래수의 변수와 메서드를 사용할 수 있다.
		
		t1.channel = 7; // t1 참조변수가 참조하는 Tv 객채의 주소 멤버 중 channel 변수에 7이라는 값을 저장한다.
		System.out.println("t1의 채널값을 7로 변경하였습니다");
		
		System.out.println("t1의 채널값은 " + t1.channel + "입니다"); // 7
		System.out.println("t2의 채널값은 " + t2.channel + "입니다"); // 0
		
		t2 = t1; // 참조변수 t1의 주소값을 t2에 저장하겠다, 즉 t2의 주소값도 0x100번지가 된다.
		
		System.out.println("t2의 채널값은 " + t2.channel + "입니다"); // 7
		System.out.println("t2의 채널값을 7로 변경하였습니다");
		
		

}
}