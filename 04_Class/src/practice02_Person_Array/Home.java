package practice02_Person_Array;

public class Home {
	
	// 필드
	
	private Person[] arr; // Person 클래스를 참조하는 배열 arr의 주소값이 만들어짐
	private int count; // 배열의 길이
	
	// 생성자
	
	public Home(int count) {
		arr = new Person[count];
		this.count = count;
		
		
	}

	public Person[] getArr() {
		return arr;
	}

	public void setArr(Person[] arr) {
		this.arr = arr;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	

}
