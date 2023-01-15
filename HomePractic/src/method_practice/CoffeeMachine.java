package method_practice;

public class CoffeeMachine { // 커피머신

	
	    // 필드
		int moneyPot; // 자판기 돈통
		String[] menu = {"아메리카노", "카페라떼", "마키야또"}; 
		int[] prices = {900, 1500, 2000};
		
		// 1번 아메리카노 900원
		// 2번 카페라떼 1500원
		// 3번 마키야또 2000원
		
		// 번호를 눌렀을 때 나오는 커피와 잔돈과 자판기 돈통에 있는 값 출력하기...
		
		CoffeeAndChange buyCoffee(int money, int choice) { // 돈과 번호를 넣었을 때 나오는 잔돈
			
			int price = prices[choice -1];
			if(money < price) {
				CoffeeAndChange cnc = new CoffeeAndChange();
				cnc.change = money;
				return cnc; 
			}
			
			String coffee = menu[choice - 1];
			
			moneyPot += price;
			
			CoffeeAndChange cnc = new CoffeeAndChange();
			
			cnc.coffee = coffee;
			cnc.change = money - price;
			
			return cnc;
			
		}
}
