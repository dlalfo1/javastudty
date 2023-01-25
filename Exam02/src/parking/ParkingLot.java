package parking;

import java.util.Scanner;

public class ParkingLot {
	
	private String name; 
	private Car[] cars;
	private int idx; // 차가 저장될 인덱스의 값! 차가 들어가기전엔 null값
	private Scanner sc; 
	
	
	public ParkingLot(String name) {
		super();
		this.name = name;
		cars = new Car[10]; 
		sc = new Scanner(System.in);
	}

	public void addCar() {
		
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(cars.length == idx) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		
		System.out.println("차량 번호 >>> ");
		String carNo = sc.next();
		System.out.println("모델 >>> ");
		String model = sc.next();
		
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		
		System.out.println("차량번호 " + carNo + "차량이 등록되었습니다.");
		
		}
		
		public void deleteCar() {
	
			if(idx == 0) {
				System.out.println("등록된 차량이 없습니다.");
				return;
			}
						   
			System.out.println("제거할 차량 정보 >>> ");
			String carNo = sc.next();
			
			for(int i = 0; i < idx; i++) {
				Car car = cars[i];
				if(carNo.equals(car.getCarNo())) {
					// 방법1. 삭제할 요소의 뒤에 있는 것들을 모두 한칸씩 앞으로 옮기기
					System.arraycopy(cars, i + 1, cars, i, idx -i -1);
					cars[--idx] = null; 
					System.out.println("차량번호 " + carNo + "인 차량이 삭제되었습니다.");
					return;
					
					 /* 
					  방법2. 마지막 차량을 옮겨오기
					  제거할 차량의 위치 : i
					  마지막 차량 위치 : idx -1
					  cars[i] = cars[idx -1]; // 마지막 인덱스 값은 첫번째 인덱스값으로 옮겨줌
					  cars[--idx] = null; 
					  return;
					*/
					
				} // else로 System.out.println("대상 차량이 존재하지 않습니다"); 이거 쓰는거 아님 왜냐! 같은 차량이 없을 때 출력해야하는데 
				  // for문 안에 넣으면 게속 출력되니까.
			}
			// for문 종료 후 바깥자리 (제거할 차량정보가 아무것도 없을 때)
			System.out.println("대상 차량이 존재하지 않습니다");
			
		}	
		
		public void printAllCars() { 
			
			if(idx == 0) {
				System.out.println("등록된 차량이 없습니다");
				return;
			}
			System.out.println(name + "차량 목록");
			for(int i = 0; i < idx; i++) {
				Car car = cars[i];
				System.out.println(car); // to.String기능으로 여기에 넣어도 출력가능
				
			}
		}
/*			for(int i = 0; i < cars.length; i++) { // 아래 두가지 방법은추천 방법은 아님.
				Car car = cars[i];
				if(car != null) {
					System.out.println(car);
				}
			}
			for(Car car : cars) {
				if(car != null) {
					System.out.println(car);
				}
*/			
		
		public void manage() { 
			
			while(true) {
				
				System.out.println("1.추가 2.삭제 3.전체 0.종료 >>> ");
				String choice = sc.next();
				
				switch(choice) {
				case "1":
					addCar();
					break;
				case "2":
					deleteCar();   
					break;
				case "3" :
					printAllCars();
					return;
				case "0" :
					return;
				default :
					System.out.println("존재하지 않는 메뉴입니다.");
				}
		
			}
			
			
		}
	
}
