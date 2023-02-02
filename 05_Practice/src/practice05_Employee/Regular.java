package practice05_Employee;

// 정규직

public class Regular extends Employee { // 고용주를 상속하는 정규직(자식클래스)
									
	// 필드
	private int salary;  // 기본급

	// 생성자
	public Regular(int empNo, String name, int salary) {
		super(empNo, name);
		this.salary = salary;
	}
	
	// 메소드
	public int getSalary() { // 월급 가져오기
		return salary;
	}
	
	public void setSalary(int salary) { // 월급 정하기
		this.salary = salary;
	}
	
	@Override
	public void info() {
		super.info();  // Employee의 info 메소드 호출
					   // [사원번호: + empNo + 사원명 + name + ] 출력
					   //  super 키워드는 자식 클래스에서 부모 클래스의 메소드를 사용하고자 할 때 사용한다.
		System.out.print("[기본급:" + salary + "원]");
		
		/*
		   - 오버라이드 - 
		   
		   부모 클래스의 메소드와 동일한 메소드 형식으로 자식 클래스가 새로운 메소드를 만드는 것이다.
		   부모 클래스의 메소드를 사용할 수 없기 때문에, 새로운 메소드를 다시 만드는 것이다.
		   자식 클래스가 메소드를 다시 만들 때는 애너테이션(Annotation) 중 @Override를 추가한다.
		 */
	}

	@Override
	public int getPay() { // 부모클래스의 추상메소드를 오버라이드로 재정의 하여 사용한다.
		return salary;    // 정규직은 salary가 월급이다. -> 기본급이 월급임
	}
	
}
