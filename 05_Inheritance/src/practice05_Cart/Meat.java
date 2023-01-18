package practice05_Cart;

public class Meat extends Product {
	
	// 부모의 생성자가 디폴트가 아니면 무조건 자식 클래스에서 생성해줘야한다.
	// 부모의 생성자가 디폴트라면 생략 가능하다.
	
	
	// new Meat(1, "소고기", 5000)
	
	public Meat(int prodNo, String prodName, int prodPrice) {
		super(prodNo, prodName, prodPrice); // 부모 생성자 만들어줌.
	// = super(); 
		
		// Meat생성자를 호출 해서 매개변수를 넣어주면
		// super -> Product 클래서의 생성자 매개변수로 넣어짐.
		
	}
	
}
