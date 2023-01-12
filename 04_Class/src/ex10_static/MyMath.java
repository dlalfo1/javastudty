package ex10_static;

public class MyMath {
	
	/*
		static
		1. 정적 요소
		2. 객체 생성 이전에 클래스 영역에 만들어 지는 요소
		3. 객체마다 생성되지 않고 클래스별로 1개씩만 생성됨
		4. 클래스를 이용해서 호출하기 때문에 클래스 변수, 클래스 메소드라고 부름.
		5 . static 요소는 다른 static 요소만을 참조할 수 있음.(non-static 요소는 참조할 수 없음)
	*/
	
	
	// static : 모두 사용하려고 하나만 만들어뒀어~ 공유해
	// final 이거 마지막 값이야 수정 안돼 
	// 그러므로 static 앞에는 public이 붙어야함. private 붙으면 나만 사용한다는거니까!
	// PI값은 MyMath 필드에 있기 때문에 myMath, yourMath 를 통해서 확인해야 하는데 이건 권장하지 않는다.
	// 바로 MyMath 클래스에서 확인해준다. MyMate.PI
	
	// 필드
	public static final double PI = 3.141592; // static을 만들지 않으면 객체가 만들어져야 PI가 만들어짐.
									   // 그럼 밑 코드가 에러뜸 왜냐? static 써클아레아는 제일 먼저 만들어졌는데 그 안에 PI가 없으니까!
									   // static 애들은 static 애들만 갖다 쓸 수 있음!
	// 메소드
	public static double getCircleArea(double radius) { // radius 는 반지름
		return PI * radius * radius;
	}
	
	// 메소드
	public static double max(double... numbers) { // ...은 숫자 몇개가 들어올지 모르니 배열로 만들어준거임.double 타입의 numbers[] 와 같다
		double max = Double.MIN_VALUE; // Double 클래스의 MIN_VALUE 갖다 쓸게! 
			// 클래스로 불렀으니 static, 대문자니 final 상수, 갖다 쓸 수 있으니 public
		
		for(int i = 0; i < numbers.length; i++) {
			if(max < numbers[i]) {
				max = numbers[i];
			}
		}
		return max;
		
	}
	
	public static double min(double... numbers) {
		double min = Double.MAX_VALUE;
		
		for(int i = 0; i < numbers.length; i++) {
			if(min > numbers[i]) {
				min = numbers[i];
			}
		}
		return min;
	}
	
}
