package b;

public class Seat {
	
	private String name; 		// 필드는 null 값으로 초기화 되어 있다.
	
	public Seat() {  			// new Seat(); + setName("홍길동")
		
	}
	
	public Seat(String name) { // new Seat("홍길동") - 좌석 주인이 정해져있을 때
		this.name = name;
	}

	// 필드값이 private로 은닉되어 있기 때문에 게터와 세터를 써준다.
		
	public String getName() { 	// name 확인용 메소드 (예약자 확인용)
		return name;
	}

	public void setName(String name) { // 실제 name 저장용 메소드 (예약 처리용)
		this.name = name;
	}
	
	public void reserve(String name) { // 예약 처리할 때 보여줄 메소드 : reserve("홍길동")을 호출하면 setName("홍길동")이 다시 호출되어서 처리된다.
		setName(name);				   // 이렇게 하나 더 만들어준 이유는 reserve 메소드 명칭을 통일하기 위함이고
									   // 세터도 살리기 위함이다.
	}
	
	public void cancel () {
		setName(null);
	}
	
	public boolean isOccupied() { // 좌석이 점유되었으면 true 반환
		if(name == null) {
			return false; // 점유되어 있지 않다.
		} else {
			return true;
		}
		// 추천하는 코드
		// return name != null;
	}
	
	public boolean isMatched(String name) { // 좌석의 this.name과 매개변수 String name이 동일하면 true 반환
		
		if(this.name.equals(name)) {
			return true;
		} else {
			return false;
		}
		// 추천하는 코드
		// return this.name.equals(name); 같으면 true, 다르면 false
	}

}
