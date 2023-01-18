package practice05_Cart;

public class Cart {

	private Product[] products; // 카트 안에 저장한 제품들. 배열을 선언해줬으니 생성도 해줘야함.
	private int prodCount; // 실제로 products 배열에 저장된 Product의 개수

	// new Cart(10), new Cart(20), . . .
	public Cart(int cartSize) {
		products = new Product[cartSize]; // 배열 생성
		prodCount = 0; // 안 줘도 됨. 초기화 값이 이미 0이니까.
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}

	// 카드에 물건 담기
	// addProduct(new Meat(1, "소고기", 5000))
	// addProduct(new Pizza(2, "고구마피자", 3000))
	// addProduct(new Nodle(3, "누들면", 1500))
	
	public void addProduct(Product product) {
		
		// 카트가 가득 차면 물건을 담지 못 한다.
		if(products.length == prodCount) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		
		// 카트에 물건 담기
		products[prodCount++] = product;
		
	}
	
	// 카트에서 물건 빼기
	public void deleteProduct(int prodNo) {
		
		// 카트가 비어 있으면 뺄 물건이 없다.
		if(prodCount == 0) {
			System.out.println("카트가 비어있습니다.");
			return;
		}
		
		// 카트에서 물건 빼기
		for(int i = 0; i < prodCount; i++) {
			if(products[i].getProdNo() == prodNo) {
				products[i] = products[--prodCount]; // 마지막 물건을 뺀 물건 자리로 옮기기
				break;
			}
		}
	}
	
}
