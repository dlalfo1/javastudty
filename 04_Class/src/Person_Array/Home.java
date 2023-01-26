package Person_Array;

public class Home {
	
	private Person[] arr;
	private int count; // 가족 구성원수
	
	
	// Person에 있는 name,age에 값을 넣어줄거니까 Home에선 쓸일이 없음. arr 생성자는 안만들어도됨.
	public Home(int count) {
		super();
		arr = new Person[count]; // count값을 받으면 arr에 저장되고 자동으로 배열의 길이가 정해짐.
		this.count = count;
	}

	// Home에 있는 arr와 count 반복문 돌릴 때 쓸거니까 게터세터 만들어줌.
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
