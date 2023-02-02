package practice05_Employee;

// 비정규직

public class Temporary extends Employee { // 고용주를 상속하는 계약직(자식클래스)

	// 필드
	private int hourPay;    // 시급
	
	// 생성자
	public Temporary(int empNo, String name, int hourPay) {
		super(empNo, name);
		this.hourPay = hourPay;
	}

	// 메소드
	public int getHourPay() { // 시급 가져오기
		return hourPay;
	}

	public void setHourPay(int hourPay) { // 시급 정하기
		this.hourPay = hourPay; 
	}

	@Override
	public void info() {
		super.info();  // Employee의 info 메소드 호출
					   // [사원번호: + empNo + 사원명 + name + ] 출력
					   //  super 키워드는 자식 클래스에서 부모 클래스의 메소드를 사용하고자 할 때 사용한다.
		System.out.print("[시급:" + hourPay + "원]");
	}
	
	@Override
	public int getPay() {
		return hourPay * 200;  // 비정규직은 시급 * 근무시간이 월급이다. 편의상 근무시간은 모두 200시간으로 한다.
	}
	
}
