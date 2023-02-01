package practice07_Coffee;

// 아메리카노

public class Americano {

	// 필드
	private Espresso[] cups;  // 에스프레소 여러 잔 들어갈 수 있음
	private int shotCount;    // 아메리카노에 들어간 에스프레소 개수(샷)
	private int extraWater;   // 물
	private int idx;          // cups 배열의 인덱스 - 실제로 들어가는 에스프레소 샷의 개수(배열 길이의 -1)
	
	// 생성자
	public Americano(int shotCount, int extraWater) {
		cups = new Espresso[shotCount]; // cups 배열 생성(아직 배열의 길이만 정해준 것)
		this.shotCount = shotCount;
		this.extraWater = extraWater;
	}
	
	// 샷 추가 addEspresso 메소드
	public void addEspresso(Espresso espresso) {
		if(idx == shotCount) {
			System.out.println("더 이상 샷을 추가할 수 없습니다.");
			return;
		}
		 cups[idx++] = espresso;
	}
	
	// 조회 info 메소드
	public void info() {
		int totalWater = 0; // 커피의 총 물양
		for(int i = 0; i < cups.length; i++) { // 0~9까지 총 10번 돌림
			System.out.println("◁◁◁ " + (i + 1) + "번째 샷 정보 ▷▷▷"); // i는 인덱스값 즉, 0부터 시작하니까 1을 더해서 출력해준다.
			cups[i].info();
			totalWater += cups[i].getWater(); // 아메리카노의 물양은 에소프레소한잔에 들어간 물의 양의 합계니까 
											  // Espresso 클래스의 Water필드값을 가진 getWater를 호출한다.
		}
		totalWater += extraWater; // 커피의 총 물양에 아메리카노 물양을 넣어준다.
		System.out.println("아메리카노 총 ml : " + totalWater + "ml");
	}
	
}
