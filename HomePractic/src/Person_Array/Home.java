package Person_Array;

public class Home {
	
	// 필드
	
	private Person[] arr; // 집에 한명만 살고 있진 않으니 배열로...
	private int count; // 몇명이냐..
	
	// 생성자
	
	
	public Home(int count) {
		arr = new Person[count];
		this.count = count;
		
		
	}
	

}
