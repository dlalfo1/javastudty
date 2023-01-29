package ex02_Writer;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class CSV_Practice {

	public static void main(String[] args) {
		
		/*
		 * 목표
		  1. 경로
		  	C:\storage\product.csv
		  2. 내용
		  	세탁기,삼성,100
		  	냉장고,LG,200
		  	TV,삼성,300
	 */
	
	 /*
		1. 맵 3개 만들기
		2. put으로 key, value 값 넣어주기. ex)product1.put("model", "세탁기");  
		3. ArrayList에 맵 저장하기(add기능)
		4. sotorage 파일 없으면 만들어주기
		5. PrintWriter 객체 생성
		6. Map 하나 더 만들어서 ArrayList에 있는거 하나씩 꺼내오기(for문 돌리기)
	 */
	
		Map<String, Object> product1 = new HashMap<String, Object>();
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
		
		List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
		products.add(product1);
		products.add(product2);
		products.add(product3);
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdir();
		}
		
		File file = new File(dir, "product.csv");
	
		
		try (PrintWriter out = new PrintWriter(file);){
			for(int i = 0; i < products.size(); i++) {
				Map<String, Object> product = products.get(i);
				out.println(product.get("model") + "," + product.get("maker") + "," + product.get("price"));
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
