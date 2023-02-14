package api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain {

	public static void main(String[] args) {
		
		HttpURLConnection con = null;
		URL url = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			StringBuilder urlBuilder = new StringBuilder();
			String serviceKey = "bEQBRPHjt0tZrc7EsL0T8usfsZ1+wT+5jqamBef/ErC/5ZO6N7nYdRmrwR91bh5d3I1AQeY5qdbJOF6Kv0U1CQ==";
			urlBuilder.append("http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath");
			urlBuilder.append("?serviceKey=").append(URLEncoder.encode(serviceKey, "UTF-8"));
			urlBuilder.append("&searchYear=2021");
			urlBuilder.append("&siDo=1100");
			urlBuilder.append("&guGun=1125");
			urlBuilder.append("&type=json");
			urlBuilder.append("&numOfRows=10");
			urlBuilder.append("&pageNo=1");
			
			url = new URL(urlBuilder.toString());
			con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			StringBuilder sb = new StringBuilder();
			String line = null;
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			
			reader.close();
			con.disconnect();
			
			StringBuilder fileBuilder = new StringBuilder();
			List<Accident> accidents = new ArrayList<Accident>();
			JSONObject obj = new JSONObject(sb.toString());
			JSONArray itemList = obj.getJSONObject("items").getJSONArray("item");
			
			
			/*
			 	String occrrncDt;  // 발생월일시 (2019011622)
				String occrrncDayCd;  // 발생요일코드 (4)
				int dthDnvCnt;  // 사망자수 (0)
				int injpsnCnt;  // 부상자수 (1)
			 */
			for(int i = 0; i < itemList.length(); i++) {
				JSONObject item = itemList.getJSONObject(i);
				String occrrncDt = item.getString("occrrnc_dt"); // 발생월일시 : 2021020618
				String[] week = {"", "일", "월", "화", "수", "목", "금", "토"};
				String occrrncDayCd = item.getString("occrrnc_day_cd"); // 발생요일코드 : 7
				int dthDnvCnt = item.getInt("dth_dnv_cnt"); // 사망자수 : 1
				int injpsnCnt = item.getInt("injpsn_cnt"); // 부상자수 : 1
				fileBuilder.append("발생일자 ").append(occrrncDt).append(" ").append(week[Integer.parseInt(item.getString("occrrnc_day_cd"))]).append("요일, ");
				fileBuilder.append("사망자수 ").append(dthDnvCnt).append("명, ");
				fileBuilder.append("부상자수 ").append(injpsnCnt).append("명\n");
				
				// 발생일자 2021020618 토요일, 사망자수 1명, 부상자수 1명 
				// System.out.println(fileBuilder.toString());
				// 여기까지만 해도 위 내용처럼 출력 됨. fileBuilder로 제이슨오브젝트에 있는내용 스트링으로 다 긁어 왔으니까
				// 밑에 객체 만들어서 List에 넣는건 아마 한번 그런거 해보라고 하신거 아닐까 싶음...
				
				
				Accident accident = new Accident();
				accident.setOccrrncDt(occrrncDt);
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				accidents.add(accident);
				
			}
			
		
			
			File file = new File("accident.txt");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(fileBuilder.toString());
			writer.flush(); // 스트림에 남아있는 잔여물을 털어내는건데,, 굳이 안 써도 됨..
			
			writer.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}