package ex03_method;

public class MainClass {
	
	public static void ex01() {
		
		// Calculator 객체 선언 + 생성 (모든 객체는 만들어야 쓸 수 있다.)
		
		Calculator calc = new Calculator(); 
		
		double add = calc.addition(1.5, 2.5); // addition 메소드 호출 , 1.5 랑 2.5 가 인수(argument)
		// 인수를 저장하는게 매개변수
		
		System.out.println(add);
		
		double sub = calc.subtraction(2.5, 1.3);
		
		System.out.println(sub);
	}
	
	public static void ex02() {
		
		CoffeeMachine coffeeMachine = new CoffeeMachine();
		
		CoffeeAndChange coffeeAndChange = coffeeMachine.buyCoffee(500,1);
		System.out.println(coffeeAndChange.coffee);
		System.out.println(coffeeAndChange.change);
		
		System.out.println(coffeeMachine.moneyPot);
		
	}
	public static void ex03() {
		
	
		Car car = new Car();
		
		car.addOil2(100);
		
		for(int n = 0; n < 51; n++) {
			car.pushAccel();
		}
		
		System.out.println(car.oilPot);
		System.out.println(car.carSpeed);
		
		for (int n = 0; n < 11; n++){
			car.pushBrake();
		}
		
		System.out.println(car.oilPot);
		System.out.println(car.carSpeed);

		
	}	
	
	public static void main(String[] args) {
			ex03();
		
	}

}
