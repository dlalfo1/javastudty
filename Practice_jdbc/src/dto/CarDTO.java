package dto;

public class CarDTO {
	
	
	// 테이블의 칼럼명을 변수로 선언해준다.
	private String carNo;
	private String model;
	
	
	 // 디폴트 생성자
	public CarDTO() {
		
	}
	
	// 매개변수가 있는 생성자
	public CarDTO(String carNo, String model) {
		super();
		this.carNo = carNo;
		this.model = model;
	}

	
	// 게터와 세터
	public String getCarNo() {
		return carNo;
	}

	public void setCarNo(String carNo) {
		this.carNo = carNo;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	// 차 정보를 쉽게 보기 위해서 toString 메소드 추가
	@Override
	public String toString() {
		return "CarDTO [carNo=" + carNo + ", model=" + model + "]";
	}
	

	
	
	
	
	

}
