package ex02_Writer;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class XMLMainClass {

	/*
		XML
		1. eXtensible Markup Language
		2. HTML(표준 마크업 언어)의 확장 버전이다.
		3. 정해진 태그 외 사용자 정의의 태그의 사용이 가능하다.
	*/
	
	/*
		목표. (이러한 처리방식을 dom 처리방식이라한다. 문서를 객체화 하는 모델. document object model.)
		1. 경로
			C:\storage\product.xml -> product.xml 이걸 document라고 부른다.
		2. 내용
			<products> -> products 엘러먼트의 부모는 document이다.
				<product>
					<model>세탁기</model> -> 여기서 세탁기처럼 태그 안에 있는 텍스트를 "textContent" 라고 부른다. 제이쿼리에선 text() 텍스트 메소드라 부른다.
					<maker>삼성</maker>
					<price>100</price>
				</product>
			</products>
			<products>
				<product>
					<model>냉장고</model>
					<maker>LG</maker>
					<price>200</price>
				</product>
			</products>
			<products>
				<product>
					<model>TV</model>
					<maker>삼성</maker>
					<price>300</price>
				</product>
			</products>
	*/
	
	public static void main(String[] args) {
		
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
		
		
		List<Map<String, Object>> productList = Arrays.asList(product1, product2, product3);
		
		// 여기서부턴 사실 다 문법이라 외워야할듯.
		
		try {
			
			// Document 생성(Document는 XML문서 자체를 의미한다.)
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance(); // 문서만드는공장에서 문서만드는사람 뽑아줌.,,
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.newDocument();
			document.setXmlStandalone(true);  // standalone="no" 제거하기
			
			// <products> 태그 : Element 생성

			Element products = document.createElement("products");
			document.appendChild(products);
			
			// productList 순회
			for(Map<String, Object> map : productList) {
			
				// <product> 태그 : Element 생성
				Element product = document.createElement("product");
				products.appendChild(product);
				
				// <model> 태그 : Element 생성
				Element model = document.createElement("model");
				product.appendChild(model);
				model.setTextContent((String)map.get("model")); // get메소드로 빼는건 value임. 즉 Object가 빠지는 거임.
															    // 하지만 setTextContent 메소드는 String값을 넣어줘야하기 때문에 강제 캐스팅해야함. to String 메소드도 가능하다.
																										
				// <maker> 태그 : Element 생성
				Element maker = document.createElement("maker");
				product.appendChild(maker);
				maker.setTextContent((String)map.get("maker"));
				
				// <price> 태그 : Element 생성
				Element price = document.createElement("price");
				product.appendChild(price);
				price.setTextContent((int)map.get("price") + ""); // 메이커랑 모델처럼 걍 (String) 붙여도 됨.
			}	
			
			// XML 설정
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty("encoding", "UTF-8");
			transformer.setOutputProperty("indent", "yes"); // 들여쓰기
			transformer.setOutputProperty("indent", "yes"); // 들여쓰기
			transformer.setOutputProperty("doctype-public", "yes");  // standalone="no" 제거하기 위해서 document.setXmlStandalone(true);를 추가하면 개행(줄바꿈)이 안 되므로 추가한 코드
		
			// XML 설정
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdir();
			}
			File file = new File(dir, "product.xml");
			Source source = new DOMSource(document);
			StreamResult streamResult = new StreamResult(file);
			transformer.transform(source, streamResult);
			
					
		} catch (Exception e) {
			e.printStackTrace();
		
		}
		
		
		
		
		
		
		
	}
}