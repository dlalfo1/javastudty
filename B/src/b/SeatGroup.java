package b;

import javax.swing.JOptionPane;

public class SeatGroup {
	
	private String seatType; // "S", "R", "A"
	private Seat[] seats; 	 // 배열의 선언 (배열이 생성된 건 아니다. 배열을 사용할거다 선언해준것이다)
	
	// new SeatGroup("S", 10) : "S석이 10개 있다.
	// Bean이 아닌 애들은 생성자를 직접 만들어준다. 단순히 값을 저장하려고 쓰는게 아니기 때문에
	
	public SeatGroup(String seatType, int length) { 
		this.seatType = seatType; // 좌석 타입 설정
		seats = new Seat[length]; // 배열의 생성
		for(int i = 0; i < length; i++) {
			seats[i] = new Seat(); // 점유되지 않은 빈 좌석을 배열의 길이만큼 만들기 
							       // 배열의 길이를 만들었으면 각 인덱스의 값도 넣어줘야 한다.
								   // 꼭 여기서 빈 좌석을 만들어줘야 하는 것은 아니다
								   // 예약할 때 매개변수 있는 생성자로 name값 받아서 그때 이름 넣으면서 빈좌석을 만들어줄 수도 있다.
								   // *** 여기서 중요한건 new Seat(); 없이는 Seat의 정보를 사용할 수 없다. **//
		} 	

	}
	
	// 예매 상황
	public void info() {
		
		System.out.println("[" + seatType + "] 타입");
		for(int i = 0; i < seats.length; i++) {
				System.out.print((i < 9 ? "0" : " ") + (i + 1) + "      "); // 인덱스는 0부터 시작하니까 1을 더해서 출력하면 1부터 시작한다.
																			// 좌석이 1~30개라면 인덱스는 0~29이다.
																			// 인덱스가 8까지라면 즉 좌석 9번까지라면 앞에 0을 붙어준다
				if(seats[i].isOccupied() == false) {
					
			} else {
				System.out.print(seats[i].getName());
			}
			
			// 인덱스의 일의 자리가 9이면 줄을 바꾸고 아니면 공백을 준다.
			// 일의 자리가 9가 나올 때까지 공백 주다가 9가 나오면 줄을 바꾼다.
			// 인덱스 9 , 19, 29에서 줄바꿈 해야되니까 10으로 나눈 나머지가 9일 때로 계산한다.
			
			if(i % 10 == 9) {
				System.out.println();
			} else {
				System.out.print(" ");
			}
		}
		
	}
	
	// 예약하기
	public boolean reserve() {
		info(); // 예매 상황 보여주기
		// 스캐너 말고 JOptionPane 클래스 사용해보기
		String strNo = JOptionPane.showInputDialog("예약할 시트번호를 입력하세요.");
		int seatNo = Integer.parseInt(strNo); // showInputDialog 메소드는 String값이기 때문에 int에 담아준다.
		if(seatNo < 1 || seatNo > seats.length) {
			JOptionPane.showMessageDialog(null, strNo + "번 좌석은 없는 좌석입니다.");
			return false; // 예약하기 실패
		}
		
		if(seats[seatNo -1].isOccupied()) { // 입력된 좌석번호가 점유된 자리라면
			JOptionPane.showMessageDialog(null,seatNo + "번 좌석은 이미 예약된 좌석입니다.");
			return false; // 예약하기 실패
		}
		
		String name = JOptionPane.showInputDialog("예약자 성함을 입력하세요");
		seats[seatNo -1].reserve(name); // 좌석번호를 올바르게 입력했으면 그 다음에 이름을 입력하고 좌석을 예약해준다.
		JOptionPane.showMessageDialog(null,seatNo + "번 좌석 예약이 성공했습니다.");
		return true; // 예약하기 성공
		
	}
	
	// 예약 취소하기
	public boolean cancel() {
		info();
		String name = JOptionPane.showInputDialog("취소자 성함을 입력하세요.");
		for(int i = 0; i < seats.length; i++) {
			if(seats[i].isOccupied() && seats[i].isMatched(name)) { // 같은 이름은 없다는 가정으로 풉니다.
				seats[i].cancel();
				JOptionPane.showMessageDialog(null, "예약자 " + name + "의 예약이 취소되었습니다.");
				return true;
				
			}
		}
		JOptionPane.showMessageDialog(null, "입력된 이름 " + name + "은 존재하지 않습낟.");
		return false;
		
	}
		
	}
	