package service;

import java.util.List;
import java.util.Scanner;

import dao.CarDAO;
import dto.CarDTO;

// ContactService 인터페이스를 구현한 ContactServiceImpl 클래스
public class CarServiceImpl implements CarService {

	/************ 1. field **************/
	
	// 사용자에게 정보를 입력받을 스캐너 객체 선언
	private Scanner sc;
	
	// DB와 연동하여 연락처 정보를 저장하고 관리할 객체 선언 (getInstance 메소드를 통해 생성)
	private CarDAO dao; 

	private String name; // 주차장 이름
	private CarDTO[] cars;	// 주차장의 차들
	private int idx; // 배열의 인덱스
	
	

	
	/************ 2. constructor  **************/
	public CarServiceImpl(String name) {
		super();
		this.name = name;
		cars = new CarDTO[10]; 
		sc = new Scanner(System.in);
		dao = CarDAO.getInstance();
	}
	

	/************ 3. method  **************/

	@Override
	public void addCar() {
		
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if(cars.length == idx) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		System.out.println("===== 차량 추가하기 =====");
		
		System.out.print("신규 차량 이름 >>>");
		String carNo = sc.next();
		System.out.print("신규 차량 모델명 >>>");
		String model = sc.next();
	
		
		// 디폴트로 객체 생성 => 세터게터로 초기화 하겠다.
		CarDTO car = new CarDTO(); 
		
		cars[idx++] = car;
		// 스캐너로 입력받은걸 contact에 넣어준다.
		car.setCarNo(carNo);
		car.setModel(model);
	

		// 필드에 ContactDAO클래의 dao를 선언해줬으니 insertContact메소드를 가져다 쓸 수 있다.
		int addResult = dao.insertCar(car); 
		
		/*
			addContact 메소드에서 dao 변수를 사용할 수 있는이유
			ContactServiceImpl 클래스에서 생성자에서  ContactDAO 객체를 생성하고 dao 멤버 변수에 할당하였다.
			이렇게 생성된 dao 멤버 변수는 ContactServiceImpl 클래스 내의 다른 메소드에서도 접근이 가능하다.
			즉, private으로 정보은닉된 dao 멤버변수는 같은 클래스내의 다른 메소드에서도 가능하기 때문에
			동일클래스의 다른메소드에서도 dao변수를사용하여 ContactDAO 객체의 메소드를 호출 할 수있다.
		*/
		
		// ContactServiceImpl 클래스가 ContactService 인터페이스를 구현함.
		// ContactService 인터페이스엔 public void addContact(); 추상메소드가 있음.
		// 그러니까 ContactServiceImpl 클래스에서 저 추상메소드를 재정의 해주는거임.
		// ContactDTO contact = new ContactDTO(); 이렇게 ContactDTO객체를 생성함.
		// ContactDTO 클래스의 필드를 스캐너 객체로 입력받은 내용을 통해 set 메소드로 초기화시켜준다.
				
		System.out.println(addResult + "대의 차량이 등록되었습니다.");	
		
	}
	
	@Override
	public void removeCar() {

		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		
		System.out.println("==== 주차된 차량 삭제하기====");
		
		System.out.println("제거할 차량 정보 >>> ");
		String carNo = sc.next();
		
		List<CarDTO> carList = dao.selectCarByName(carNo);
		
		System.out.println("<<< 조회된 연락처 목록 >>>");
		for(CarDTO car : carList) {
			System.out.println(car);
		}
		
		System.out.println("삭제할 차량 No >>> ");
		String carNum = sc.next();
		
		int removeResult = dao.deleteCar(carNum);
		
		System.out.println(removeResult + "대의 차량이 삭제되었습니다.");
		
		// 위 코드는 트랜잭션 대상이 아니다
		// SELECT는 트랜잭션 대상이 아니고 DELETE도 하나만 있기 때문에!
	
	}
	
	
	@Override
	public void findAllCar() {
		
		if(idx == 0) {
			System.out.println("등록된 차량이 없습니다");
			return;
		}
		System.out.println("==== 전체 차량 목록 ====");
		int i =0;
		for(CarDTO carlist : dao.selectAllCar()) { 
			 CarDTO car = cars[i];
			System.out.println(car);
			
		
		}
	}
}
