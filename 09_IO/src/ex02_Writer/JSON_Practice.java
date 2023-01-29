package ex02_Writer;

import java.io.IOError;
import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON_Practice {

	
	
	public static void ex01() {

		// 목표.
		/*
		 	{
		 		"model": "세탁기",
		 		"maker": "삼성",
		 		"price": 100
		
			}
		*/

		JSONObject product = new JSONObject();
		product.put("model", "세탁기");
		product.put("maker", "삼성");
		product.put("price", 100);
		
		System.out.println(product.toString());
		
	}
	public static void ex02() {
		
		// 목표. 아래 JSON 만들기
		/*
			[
				{
					"model": "세탁기",
					"maker": "삼성",			객체1
					"price": 100
				},

				{
					"model": "냉장고",
					"maker": "LG",			    객체2
					"price": 200
				}	
					]
	 */		

	JSONObject product1 = new JSONObject();
	product1.put("model", "세탁기");
	product1.put("maker", "삼성");
	product1.put("price", "100");
	
	JSONObject product2 = new JSONObject();
	product2.put("model", "냉장고");
	product2.put("maker", "LG");
	product2.put("price", "200");
	
	JSONArray products = new JSONArray();
	products.put(product1);
	products.put(product2);
	
	
	System.out.println(products);
	
	}
	
	public static void ex03() {
		
	// String 형식의 JSON 데이터	
	String str = "{\"name\":\"james\",\"age\":30,\"height\":180.5,\"isAlive\":true}";
		
	// JSONObject 객체 생성
	JSONObject obj = new JSONObject(str);
	
	// JSONObject 객체를 구성하는 프로퍼티 값 가져오기	
	String name = obj.getString("name"); // JSON 라이브러리에 있는 메소드 기능
	int age = obj.getInt("age");
	double height = obj.getDouble("height");
	boolean isAlive = obj.getBoolean("isAlive");
	
	System.out.println(name);
	System.out.println(age);
	System.out.println(height);
	System.out.println(isAlive);

	}
	
	public static void ex04() { 

	// String 형식의 JSON 데이터
	String str = "[{\"model\":\"세탁기\",\"maker\":\"삼성\",\"price\":100},{\"model\":\"냉장고\",\"maker\":\"LG\",\"price\":200}]";
	
	// JSONArray를 사용하여 배열에 str을 담아준다.
	JSONArray products = new JSONArray(str);
	
	
		
		for(int i = 0; i < products.length(); i++) {
			JSONObject obj = products.getJSONObject(i);
			String model = obj.getString("model"); // 그 객체에서 String값을 가져온다.
			String maker = obj.getString("maker");
			int price = obj.getInt("price");
			System.out.println(model + "," + maker + "," + price);
		}
		
	}
			
			
			
	public static void main(String[] args) {
		ex04();
	}

}
