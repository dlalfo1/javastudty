package ex03_method;

public class CoffeeMachine {
	
	// 필드
	int moneyPot; // 자판기 돈통
	String[] menu = {"아메리카노", "카페라떼", "마키야또"};
	int[] prices = {900, 1500, 2000};
	
	
	// 메소드
	CoffeeAndChange buyCoffee(int money, int choice) { // 돈이 들어오고 1번을 선택했다
		
		// 돈이 모자르면 돈을 돌려주겠다..
		
	    int price = prices[choice -1];
	    if(money < price) {
	    	CoffeeAndChange cnc = new CoffeeAndChange();
	    	cnc.change = money;
	    	return cnc;
			
		}
		
		String coffee = menu[choice -1];
		moneyPot += price; // money가 아님 왜냐면 머니는 사람이 넣은 돈이고 그게 다 내돈은 아니니까 커피의 가격만큼만 돈통에 남아있음.
		
		CoffeeAndChange cnc = new CoffeeAndChange();
		cnc.coffee = coffee;
		cnc.change = money - price;
		
		return cnc;
		
		// 리턴 끝나고 어떠한 코드도 넣으면 안된다.
		
	}
	

}
