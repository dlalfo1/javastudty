package practice02_Person_Array;

public class MainCalss {
	
	public static void ex01() {
		
		String[] nameList = {"정숙", "상철", "미희"};
		int[] ageList = {20, 30, 40};
		
		Person[] arr = new Person[3]; // 사람이 세명 들어갈 집을 만들은거임. 배열의 인덱스 번호는 0 1 2
		
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Person(); // 각각의 집에 사람을 넣는거. arr[i] 자꾸 헷갈리는데 배열 요소 중 각각이라고 보면 된다.
			// 디폴트 타입이기 때문에 이름이랑 나이는 없음.
			arr[i].setName(nameList[i]);
			arr[i].setAge(ageList[i]);
			
			System.out.println("이름 : " + arr[i].getName() + ", 나이 : " + arr[i].getAge());
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