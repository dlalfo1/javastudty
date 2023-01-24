package practice02_Person_Array;

public class MainClass {

	public static void ex01() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Person[] arr = new Person[3]; // 인덱스 0 1 2
		
		for(int i = 0; i < arr.length; i++) { // 그럼 총 0 1 2 세번 돈다.
			arr[i] = new Person(); // setter, getter 쓰려고 뉴 펄슨 객체 생성을 해준거임... 이미 arr[i] 자체가 Person 클래스에서 온거
			arr[i].setName(nameList[i]); // setName으로 nameList 배열을 순서대로 담고
			arr[i].setAge(ageList[i]);	 // setAge로 ageList를 순서대로 담음
			
			// 0 -> 정숙, 20
			// 1 -> 상철, 30
			// 2 -> 미희, 40
			
			System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());
			// for문 안에 출력문이 들어가있으니 arr[i]에 이름과 나이가 저장될 때마다 출력 됨
			/* 
			 	이름 : 정숙, 나이 : 20
				이름 : 상철, 나이 : 30
				이름 : 미희, 나이 : 40
			 */
		}
		
	}
	
	public static void ex02() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Person[] arr = new Person[3];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());
		}
		
	}
	
	public static void ex03() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Home home = new Home(3);
		
		for(int i = 0; i < home.getArr().length; i++) {
			home.getArr()[i] = new Person(nameList[i], ageList[i]);
			System.out.println("이름 : " + home.getArr()[i].getName() + ", 나이 : " + home.getArr()[i].getAge());
		}
		
	}
	public static void main(String[] args) {
		ex03();
	}

}