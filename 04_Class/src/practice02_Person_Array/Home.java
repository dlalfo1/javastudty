package practice02_Person_Array;

public class Home {

	// 필드
	private Person[] arr; // 펄슨 담을 배열 arr사용해서 쓸거임.
	private int count; // 펄슨 수
	
	// 생성자
	public Home(int count) {
		arr = new Person[count];
		this.count = count;
	}

	// 메소드
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