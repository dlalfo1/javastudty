package practice05_Exam;

public class Student {

	// 필드
	private String name; // 학생 이름
	private Exam exam; // 학생이 본 시험. 현재 null값.
	
	// 생성자
	public Student(String name) { // 학생 이름 만들어주기
		this.name = name;
	}

	// 메소드
	public String getName() { // 학생 이름 가져올 때
		return name;
	}
	
	public void setName(String name) { // 학생 이름 세팅할 때
		this.name = name;
	}
	
	public Exam getExam() { // 시험내용 가져올 때
		return exam;
	}
	
	public void setExam(Exam exam) { // 시험내용 세팅할 때
		this.exam = exam;
	}
	
	public void info() {
		System.out.println("학생명 : " + name); // 학생이름 출력
		exam.examInfo(); //  // 학새잉 본 시험 내용 출력
	}
	
}
