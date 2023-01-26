package ex02_Writer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	/*
		JSON
		1. JavaScript Object Notation // 자바스크립트 객체 표기법
		2. 객체는 { }로 표기하고 , 배열은 [ ]로 표기한다.
		3. 프로퍼티(property)와 값(value)으로 데이터를 구성한다.
	*/
	
	/*
		JOSN-Java (JSON in Java) 라이브러리
		1. 객체 : JSONObject 클래스 (Map 기반으로 제작된 클래스)
		2. 배열 : JSONArray 클래스
		
			
	*/
	public static void ex01() {
		
		// 목표.
		/*
		 	{
		 		"model": "세탁기",
		 		"maker": "삼성",
		 		"price": 100
		
			}
		*/
		
		JSONObject product = new JSONObject(); // Map 사용법이랑 비슷함	
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
		
		JSONObject product1 = new JSONObject(); // Map 사용법이랑 비슷함	
		product1.put("model", "세탁기");
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		JSONObject product2 = new JSONObject(); // Map 사용법이랑 비슷함	
		product2.put("model", "냉장고");
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		JSONArray products = new JSONArray();
		products.put(product1);
		products.put(product2);
		
		System.out.println(products);
		
			}
	
	public static void ex03() { // 중요
		
	// String 형식의 JSON 데이터
		String str = "{\"name\":\"james\",\"age\":30,\"height\":180.5,\"isAlive\":true}";
					
		// JSONObject 객체 생성
		JSONObject obj = new JSONObject(str);
					
		// JSONObject 객체를 구성하는 프로퍼티 값 가져오기
		String name = obj.getString("name");
		int age = obj.getInt("age");
		double height = obj.getDouble("height");
		boolean isAlive = obj.getBoolean("isAlive");
			
		System.out.println(name);
		System.out.println(age);
		System.out.println(height);
		System.out.println(isAlive);
		
	}
	
	public static void ex04() { // 중요
		
		// String 형식의 JSON 데이터
		String str = "[{\"model\":\"세탁기\",\"maker\":\"삼성\",\"price\":100},{\"model\":\"냉장고\",\"maker\":\"LG\",\"price\":200}]";
				
		// JSONArray 객체 생성
		JSONArray products = new JSONArray(str);
			
		// 1. 일반 for문
		for(int i = 0; i < products.length(); i++) {
			JSONObject obj = products.getJSONObject(i); // 제이슨 오브젝트 객체 중 하나를 가져와서 obj에 넣고
			String model = obj.getString("model"); // 그 객체에서 String값을 가져온다.
			String maker = obj.getString("maker");
			int price = obj.getInt("price");
			System.out.println(model + "," + maker + "," + price);
		}
		
		// 2. 향상 for문. JSONObject가 아니라 Object로 받아야함.
		for(Object obj : products) {
			JSONObject product = (JSONObject)obj; // 오브젝트를 제이슨 오브젝트로 강제 캐스팅
			String model = product.getString("model"); 
			String maker = product.getString("maker");
			int price = product.getInt("price");
			System.out.println(model + "," + maker + "," + price);
		}
			
			
		}
	
	public static void ex05() {
		
		Map<String, Object> product1 = new HashMap<String, Object>();
		
		// 맵에다 저장하기 (put)
		
		product1.put("model", "세탁기"); 
		product1.put("maker", "삼성");
		product1.put("price", 100);
		
		Map<String, Object> product2 = new HashMap<String, Object>();
		product2.put("model", "냉장고"); 
		product2.put("maker", "LG");
		product2.put("price", 200);
		
		Map<String, Object> product3 = new HashMap<String, Object>();
		product3.put("model", "TV"); 
		product3.put("maker", "삼성");
		product3.put("price", 300);
		
		
		List<Map<String, Object>> products = Arrays.asList(product1, product2, product3);
		
		JSONArray arr = new JSONArray(products);
		String content = arr.toString(); // 만든파일에 글자를 넣어주려면 이 작업이 꼭 필요하다. 스트링화 해주어야함
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "product.json");
	
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(file))){
			bw.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
	public static void main(String[] args) {
		ex05();
	}

}
