package CoffeeAndChange;

public class CoffeeMachine {
	
	// 필드
		int moneyPot; // 자판기 돈통
		String[] menu = {"아메리카노", "카페라떼", "마키야또"}; // 인덱스 0 1 2
		int[] prices = {900, 1500, 2000}; // 인덱스 0 1 2
		
	// 메소드 만들기 (돈이 모자르면 돈을 돌려주고 선택한커피에 따라 무슨커피가 나오는지)
		
		CoffeeAndChange buycoffee(int money, int choice) { // 일단 커피를 사려면 돈과 몇번커피를 고를지가 필요하겠지
			
			int price = prices[choice -1];
			if(money < price) {
				CoffeeAndChange cnc = new CoffeeAndChange();
				cnc.change = money;
				return cnc;
			}
			
			moneyPot += price;
			
			String coffee = menu[choice -1]; // 커피는 나왔고 그다음엔? 잔돈이 나와야지 그러러면? 객체 생성을 해야하고
			CoffeeAndChange cnc = new CoffeeAndChange();
			
			cnc.coffee = coffee;				// 그럼 이제 기능도 다 만들었겠다 메인클래스에서 돈을 얼마 넣고 몇번 눌렀을때 어떤커피랑 잔돈이 얼마 나오는지 봐야겠지
			cnc.change = money - price;
			return cnc;
			
		}	
		
}

