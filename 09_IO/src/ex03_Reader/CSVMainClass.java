package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CSVMainClass {

	public static void main(String[] args) {

		// C:\storage\product.csv 읽기
		
		File file = new File("C:" + File.separator + "storage", "product.csv"); // (String, String)
		
		BufferedReader br = null;
		
		try {
			
			br = new BufferedReader(new FileReader(file)); // 구글 검색
			
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			
			String line = null; // readLine 메소드가 null값이냐 아니냐로 작동하기 때문에 String 초기화 또한 null로 해준것.
			while((line = br.readLine()) != null) { // 한마디로 다 읽어올 때까지 돌려라
				String[] items = line.split(","); // 콤마단위로 쪼개서 items에 넣어줄거다. (split 내부에 배열로만들어주는 기능이 있는거임)
				Map<String, Object> product = new HashMap<String, Object>();
				product.put("model", items[0]);
				product.put("maker", items[1]);
				product.put("price", Integer.parseInt(items[2]));
				products.add(product);
			}
			
			System.out.println(products);
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(br != null) {
				br.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
  	 }		
		
	}










