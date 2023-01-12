package ClassAndMathod;

public class Tv {
	
	// Tv라는 객체를 생성하기 위해 Tv클래스(설계도)를 작성해준다
	
	// 변수(속성) 선언
	
	String color;
	Boolean power;
	int channel;
	
	// 기능(메소드) 선언
	
	// 반환타입 메소드명 () { 실행할 내용}
	void power() {
		power = !power; 
	}
	
	void channelUp() {
		channel++;
	}
	
	void channelDwon() {
		channel --;
	}

}
