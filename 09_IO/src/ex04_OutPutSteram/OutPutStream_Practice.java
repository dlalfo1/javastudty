package ex04_OutPutSteram;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStream_Practice {

	
	
	public static void ex01() {
		
		/*
			1. "C:" + File.separator + "storage" 디렉토리에 ex01.bin 파일 생성해준다
			2. FileOutputStream 사용해서 단어 보내주기
			3. write 기능 사용해서 만든 파일에 A (int값 이용), pple(byte 배열이용) 문장 써주기
		*/
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex01.bin");
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			
			int a = 'A';
			String str = "pple";
			byte[] b = str.getBytes();
			
			fos.write(a);
			fos.write(b);
			
			/*
			   write 메소드의 기능들(매개변수로 전달받은 값들을 외부로 출력해준다)
			   
			  .write(int b) : 매개변수로 전달받은 정수를 문자로 출력
			  .write(byte[] b) : 매개변수로 전달받은 배열의 내용을 문자로 출력
			  .write(byte[] b, int off, int len) : 배열의 'off' 인덱스부터 'len' byte 만큼 읽어서 문자로 출력	 
			 
		     */
			
			System.out.println("ex01.bin 파일 생성 후 Apple 입력 완료");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	public static void ex02() {
		
		// storage 디렉토리에 ex02.bin 파일 만들기
		// 파일에 "안녕하세요" 한글 입력하기
		// .getBytes("UTF-8") 메소드 사용해서 한글로 인코딩 필수! 
		
		File dir  = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex02.bin");
		
		FileOutputStream fos = null;
		
		try {
			
			fos = new FileOutputStream(file);
			
			String str = "안녕하세요";
			
			fos.write(str.getBytes("UTF-8"));
			
			System.out.println("ex02.bin 파일 생성 후 안녕하세요 입력 완료");
			
			System.out.println("ex02.bin 파일의 크기 : " + file.length() + "바이트");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fos != null) {
					fos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		} 
	}
		
	public static void ex03() {
		
		/*
			1. storage 디렉토리에 ex03.bin 파일 만들기
			2. 반갑습니다 (줄바꿈) 또만나요 입력하기
			3. BufferedOutputStream 보조 스트림으로 사용하기
		
		*/
		
		
		
	}
	public static void main(String[] args) {
		ex02();
	
	
	}

}
