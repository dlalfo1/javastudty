package service;



// 사용자의 요청(request)에 대해 어떤 처리를 할지 결정하는 클래스
// interface는 사용자 친화적인 이름으로 만들어준다.
public interface CarService { // 추상메소드를 하나라도 가지고 있을시 추상클래스가 된다
									   //  abstract 키워드가 붙은 class를 interface라고 하는것.

	public void addCar(); // interface는 메소드에 abstract키워드를 적지 않아도 된다.
	public void removeCar();
	public void findAllCar();
	
	
	
	
	
	
}
