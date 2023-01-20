package parking;

import java.util.Scanner;

public class ParkingLot {

	private String name; // 주차장 이름
	private Car[] cars;	// 주차장의 차들
	private int idx; // 배열의 인덱스
	private Scanner sc;
	
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
		
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(cars.length == idx) { // if문 시작
			System.out.println("더 이상 차량 등록이 불가합니다.");
			return; // void타입에서 return문은 메소드 종료를 뜻한다.
		} // if문 종료


		System.out.println("차량번호 >>>");
		String carNo = sc.next();
		System.out.println("차량모델 >>>");
		String model = sc.next();
		
		Car car = new Car(carNo, model);
		cars[idx++] = car; // cars[0] = car; cars[1] = car; cars[2] = car; 이렇게 값 저장하고 인덱스값 하나 늘려서 또 저장하고..
		
		
		// cars[idx++] = new Car(carNo, model); // 메소드 생성후에 객체를 생성하든, 메소드 만들면서 객체를 생성하든 상관 없음..
		
		
		System.out.println("차량번호" + carNo + "차량이 등록되었습니다");
		
	}	
	
    public void deleteCar() { // 20점
    	
    	
    }
    
    public void printAllCars() { // 10점
    	
    	
    }
    
    public void manage() {
    	
    	while(true) { // 무한 반복문
    	
    		System.out.println("1.추가 2.삭제 3.전체 0.종료 >>> ");
    		
    		
    		String choice = sc.next(); // int말고 String에 저장해야 스캐너에 숫자를 입력하든 문자를 입력하든 예외가 뜨지않고 디폴트문으로 빠질수 있음
    								   // 입력한건 어차피 문자열로 저장되고 그걸 다 String으로 받을 수 있다.
    		
    		switch(choice) {
    		case "1": 
    			addCar(); // addCar 호출
    			break;
    		
    		case "2":
    			deleteCar(); // deleteCar 호출
    			break;
    		case "3":
    			printAllCars(); // printAllCars 호출
    			break;
    		case "0":
    			return; // manage 메소드 종료. break; 는 쓸 수 없다.
    					// break는 switch문만 빠져나가고 빠져나가봤자 while문에 걸리기 때문 무한루프는 계속됨.
    		default:
    			System.out.println("존재하지 않는 메뉴입니다.");
    			// 차가 계속 등록되어야 하니까 무한루프문이니 return; 하면안됨 다시 메뉴 고르는게 호출되어야함
    		}
    	}
    	
    }
    
}
    
	
	
	
	

	

