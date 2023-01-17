package CoffeeAndChange;


public class MainClass {

	public static void main(String[] args) {
		
		// 그러려면 커피머신 객체를 만들어줘야지 커피를 뽑을거니까~
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		
		CoffeeAndChange coffeeAndChange = coffeeMachine.buycoffee(3000, 3);
		
		System.out.println("내가 고른 커피는 " + coffeeAndChange.coffee + "이다");
		System.out.println("내가 받을 잔돈은 " + coffeeAndChange.change + "이다");
		
		System.out.println("자판기 돈통의 금액은" + coffeeMachine.moneyPot);
				
	
	
	}

}
