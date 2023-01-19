package Person_Array;

public class Person { 
	
	// Person 사람을 만들어 주기 위해 설계도를 작성한다고 생각하자
	
	// 필드 (사람이 가지고 있는 요소)
	// 필드값이니 private로 외부에서 접근 못하게 해주기.
	
	private String name; // 이름
	private int age; // 나이
	
	// 생성자 (객체 만들 때 호출하기 위해 만들어주기)
	// Person 클래스 말고 메인클래스에서 객체 만들 때 쓸꺼니까 public
	
	public Person() { // 기본생성자 먼저 만들어주고
			
	}

	public Person(String name, int age) { // 메인에서 객체 만들 때 인수값 넣어서 바로 매개변수로 받아와서 필드에 저장할 수 있도록 생성함
		super(); // object 클래스겠지
		this.name = name; // 인수에 넣은 값 = 매개변수 이게 필드값에 저장된다
		this.age = age;
	} // 필드에 값을 왜 저장하겠어 객체 만들 때 사용하려 하지 사람만들때 빈껍데기면 뭐해 기능도 있고 특징이 있어야지 아니면 걍 찰흙임

	
	// 필드가 private로 관리되기 때문에 외부에서 바로 값을 저장 할 수 없음
	// 그럴 때 게터랑 세터를 이용하기
	// 세터 : 메인클래스에서 호출해서 필드에 값 넣어주는 용도
	// 게터 : 메인클래스에서 호출해서 필드에 넣은 값 확인하는 용도
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
	
	

}
