package practice05_Exam;

public class MainClass {

	public static void main(String[] args) {
		
		Exam exam = new Exam("중간고사");
		exam.setScore();  // 국, 영, 수학 점수 0 ~ 100 사이 랜덤 생성
						  // 랜덤 생성해서 Exam 객체에 넣어주기.
		Student student = new Student("emily"); // emily라는 Student 객체 생성
		student.setExam(exam); // Student의 exam에 중간고사 시험 넣어주기.
		student.info();
		
	}

}
