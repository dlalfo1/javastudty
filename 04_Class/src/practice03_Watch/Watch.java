package practice03_Watch;

public class Watch {

	// 필드 (변수 선언)
	private int hour;  // 0 ~ 23
	private int minute;  // 0 ~ 59
	private int second;  // 0 ~ 59
	
	// 생성자 (객체 선언)
	public Watch(int hour, int minute, int second) {
		this.hour = hour;		// 16시	
		this.minute = minute;	// 15분
		this.second = second;	// 30초	
		
		
	
	}
	
	// 메소드
	
	void addHour(int h) {
		
		
		this.hour += h;
		
	}
	
	 void addMinute(int m) {
		
		int totalMinutt = 0;
		
		this.minute += m % 60;
	}
	
     void addSecond(int s) {
		
    	int totalSecond = 0;
    	
    	this.second += s % 60; 
    	
    	
    	 
    	 
		
	}
	
	void see( ) {
		
		
	
		System.out.println(hour / (60*60) +"시 " + minute + "분 " + second + "초 ");
		
		
	}
	
	
}