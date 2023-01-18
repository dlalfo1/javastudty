package practice05_Cart;

public class Pizza extends Product {

	// new Pizza(2, "고구마피자", 3000)
	// 필드가 없으니까 생성자 만들 때 from superClass 눌러줌
	
	public Pizza(int prodNo, String prodName, int prodPrice) {
		super(prodNo, prodName, prodPrice);
	}
	
}
