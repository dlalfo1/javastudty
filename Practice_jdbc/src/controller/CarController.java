package controller;

import java.util.Scanner;

import service.CarService;
import service.CarServiceImpl;

public class CarController {
	
	// 사용자의 요청을 어떻게 처리할지 결정하는 클래스
	
	
	
	/************ 1. field **************/
	private Scanner sc;
	private CarService service;
	
	
	/************ 2. constructor  **************/
	public CarController() {
		sc = new Scanner(System.in);
		service = new CarServiceImpl("대박주차장"); // 부모타입(ContactService)의 변수에 자식객체(ContactServiceImpl)를 저장하는 것
											
	}
	
	/************ 3. method **************/
	public void play() {
		while(true) { // 무한루프문
					  // break문 필수임.
			System.out.print("1.추가 2.삭제 3.전체조회 0.종료 >>>");
			String choice = sc.next();
			switch(choice) {
			case "1":
				service.addCar();
				break;
			case "2":
				service.removeCar();
				break;
			case "3":
				service.findAllCar();
				break;
			case "0":
				System.out.println("차량 관리 프로그램이 종료되었습니다.");
				return; // 메소드 종료
			default:
				System.out.println("잘못된 입력입니다. 다시 시도하세요");
			}	
			
		}
	
	}
			
		}
	

