package ex02_field;

public class MainClass {

	public static void main(String[] args) {
		
		// School 객체 생성
		School school = new School();
		
		// School 클래스 타입의 변수 school을 선언한다
		
		
		school.name = "철산초";
		school.students = new Student[3]; // 이것만 가지곤 배열을 사용할 수 없다. 배열 생성만 해준 것 뿐
		
		for(int i = 0; i < school.students.length; i++) { // for문 시작 각각의 배열에 객체를 생성했음 3개
			
			// Student 객체 생성
			
			school.students[i] = new Student();
			
			school.students[i].name = "정숙";
			school.students[i].stuNo = "10101";
			
			// Score 객체 생성
			school.students[i].score = new Score();
			
			school.students[i].score.kor = 100;
			school.students[i].score.eng = 90;
			school.students[i].score.math = 80;
			
			System.out.println("학번 : " + school.students[i].stuNo);
			System.out.println("이름 : " + school.students[i].name);
			System.out.println("국어 : " + school.students[i].score.kor);
			System.out.println("영어 : " + school.students[i].score.eng);
			System.out.println("수학 : " + school.students[i].score.math);
			System.out.println();
		} // for문 종료

	}

}