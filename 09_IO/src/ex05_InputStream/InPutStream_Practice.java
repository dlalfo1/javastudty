package ex05_InputStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InPutStream_Practice {

	
	public static void ex01() {
		
		// FileInputStream 사용하기
		// ex01.bin 파일 읽어오기
		// while문 사용
		// int로 한글자씩 읽어와서 스트링빌더 출력할 것.
		
		File file = new File("C:" + File.separator + "storage", "ex01.bin");
		
		FileInputStream fis = null;
		
		try {
				fis = new FileInputStream(file);
				
				int a = 0;
				
				StringBuilder sb = new StringBuilder();
				
				while((a = fis.read()) != -1) {
					sb.append((char)a);
				}
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fis != null) {
					fis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() {
		
		// 바이트 스트림을 문자 스트림으로 바꾸는 InPutStreamReader 사용
		
		
		
	}
	public static void main(String[] args) {
		ex02();
	}

}
