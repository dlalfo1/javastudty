package practice07_Coffee;

public class MainClass {

	public static void main(String[] args) {
		
		// 브라질 원두
		CoffeeBean coffeeBean = new CoffeeBean("브라질");
		
		// 브라질 원두에 물 50ml를 사용한 에스프레소 2샷
		Espresso espresso1 = new Espresso(coffeeBean, 50);
		Espresso espresso2 = new Espresso(coffeeBean, 50);
	 // Espresso espresso3 = new Espresso(coffeeBean, 50); -> 만약 에스프레소 샷추가를 한다면?
		
		// 에스프레소 2샷에 물 100ml를 사용한 아메리카노
		Americano americano = new Americano(2, 100);  // 에스프레소 2샷에 물 100ml를 사용하는 아메리카노
		americano.addEspresso(espresso1);  // 1번째 샷 추가
		americano.addEspresso(espresso2);  // 2번째 샷 추가
		
		// americano.addEspresso(espresso3); 3번째 샷 추가
		
		// 이미 아메리카노를 만들 때 2샷을 넣어 cups[]배열의 길이를 2로 만들어 줬으니
		// 에스프레소를 2샷 넣고 나면 더 이상 샷을 추가 할 수 없다는 안내 문이 나온다.

		// 조회
		americano.info();  // 커피 원두 원산지, 에스프레소 샷 정보 등 조회
		
	}
	
}
