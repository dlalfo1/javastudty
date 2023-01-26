package practice06_Person_Array;

public class Home {

	// 필드
	private Person[] arr; // 사람이 사는 배열 선언
	private int count; // 사람이 몇 명인지. 즉 Person[] 배열의 길이 결정하는 참조변수
	
	// 생성자
	public Home(int count) {		
		arr = new Person[count];
		this.count = count;
	
		// Home 생성자 호출하며 값 넣어주면 그 값으로 필드의 count를 초기화 하고 Person[] 배열을 생성해서 길이를 정해줌
	
	}
	
	// 메소드
	public Person[] getArr() { // 배열 가져올 때
		return arr;
	}
	public void setArr(Person[] arr) { // 배열 요소 세팅할 때
		this.arr = arr;
	}
	public int getCount() { // 사람 명수 가져올 때
		return count;
	}
	public void setCount(int count) { //사람 명수 세팅할 때
		this.count = count;
	}
	
}
