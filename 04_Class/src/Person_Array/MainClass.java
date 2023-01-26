package Person_Array;

public class MainClass {

	public static void main(String[] args) {

	String[] nameList = {"지원","미래","예림"};
	int[] ageList = {20, 30, 40};
	
	Home home = new Home(3);
	
	for(int i = 0; i < home.getArr().length; i++) {
		home.getArr()[i] = new Person(nameList[i], ageList[i]);
		System.out.println("이름 :" + home.getArr()[i].getName() +", 나이 :" + home.getArr()[i].getAge());
									// 배열에 있는값을 빼서 쓸 땐 get메소드 사용후[i] 꼭..
	}
	
	}

}
