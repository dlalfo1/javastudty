package ex03_method;

public class Car { // 제품 안에 
	
	// 들어갈 부품이라 생각하기
	// 필드
	int oilPot;
	int carSpeed; // pushAceel 마다 속도는 10씩 증가, 최대 속도 100, 
				  // pushBrake 마다 속도 10씩 감소.
	
	// 기름 넣기 메소드 (필드의 변수를 사용해서 얻을 기능)
	
//	void addOil(int oil) {
//		oilPot += oil;
//		if(oilPot > 50) {
//			oilPot = 50;
//		}
//	}
//	

	void addOil2(int oil) {
		if(oilPot + oil > 50) {
			oilPot = 50;
			return; // 메소드를 종료하시오. 반환타입이 없을 때만 쓸 수 있다. 반환타입잉 void인 경우에만 사용할 수 있다.
		}
		oilPot += oil;
	}


   // 달리기 메소드

   void pushAccel() {
	   
	   if(oilPot == 0 ) {
		   return;
	   }
	   oilPot--;
	   
	   if(carSpeed + 10 > 100) {
		   carSpeed = 100;
		   return;
	   }
	   carSpeed += 10;
   }
   
   // 멈추기 메소드
   void pushBrake() {
	   
	   if(carSpeed == 0) {
		   return;
	   }
	   
	   carSpeed -= 10;
	   if(carSpeed < 0) {
		   carSpeed = 0;
	   }
   }
   
}


