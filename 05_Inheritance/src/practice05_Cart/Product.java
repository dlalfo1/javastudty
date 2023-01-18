package practice05_Cart;

public class Product {
	
	// 제품을 만들기 위한 요소들은 필드에 변수로 선언해준다.
	private int prodNo;			
	private String prodName;
	private int prodPrice;
	
	
	// 객체를 생성하기 위한 생성자 만들기
	
	public Product(int prodNo, String prodName, int prodPrice) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}

	// 필드에서 선언한 변수의 값들을 채워주기 위한 게터,세터 메소드 만들기
	// 부모가 만든거 자식들이 갖다 쓸 수 있으니까 부모 클래스에 만들어주는 것.
	
	public int getProdNo() {
		return prodNo;
	}

	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}

	public String getProdName() {
		return prodName;
	}

	public void setProdName(String prodName) {
		this.prodName = prodName;
	}

	public int getProdPrice() {
		return prodPrice;
	}

	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	
}