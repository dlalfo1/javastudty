package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {

	public static void main(String[] args) {
		
		// C:\storage\product.json 읽기
		
		File file = new File("C:" + File.separator + "storage","product.json"); //  [ ] 대괄호로 묶여있기 때문에 JSONArray로 받아야 함.
		

		BufferedReader br = null;
				
		try {
			
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null){
				sb.append(line);
				
			}
			
			JSONArray arr = new JSONArray(sb.toString()); // 스트링빌더 값을 스트링으로 바꿔서 JSON 배열로 처리한다.
														  // arr에 들어간 sb의 값은 제이슨오브젝트 하나하나다.
			
			System.out.println(arr); // 이렇게 출력하면 제이슨 파일 형식이 그대로 나옴.
			
			//[{price=100, maker=삼성, model=세탁기}, {price=200, maker=LG, model=냉장고}, {price=300, maker=삼성, model=TV}]
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			
			
			for(int i = 0; i < arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				obj.toMap(); // 제이슨 오브젝트를 맵으로 만들어주는 메소드.
				products.add(obj.toMap()); // JSONObject obj를 Map으로 바꿔서 List에 저장하기.
			}
			
			System.out.println(products); // 제이슨 형식을 리스트형식으로 바꿔준걸 출력해줌.
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try{
				if(br != null) {
				br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}

}
