package ex04_OutPutSteram;

import java.io.BufferedOutputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.List;

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
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex03.bin");
		
		BufferedOutputStream bos = null;
		
		try {
			
			bos = new BufferedOutputStream(new FileOutputStream(file));
			
			
			bos.write("반갑습니다\n또만나요".getBytes("UTF-8")); // String값에 문자열 안 넣어주고 바로 써도 가능하다.
			
			System.out.println("ex03.bin 파일 생성 후 반갑습니다 또만나요 입력 완료");
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bos != null) {
					bos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	public static void ex04() {
		
		/*
		    String name = "에밀리"; // 18바이트
			int age = 30; // 1바이트
			double height = 180.5; // 1바이트
			boolean isAlive = true;
			
			ex04.dat 파일 만들기
			DataOutputStream 사용하기
			
		*/
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex04.dat");
		
		DataOutputStream dos = null;
		
		try {
			
			dos = new DataOutputStream(new FileOutputStream(file));
			
			String name = "에밀리"; 
			int age = 30;
			double height = 180.5;
			boolean isAlive = true;
			
			dos.writeUTF(name);
			dos.writeInt(age);
			dos.writeDouble(height);
			dos.writeBoolean(isAlive);
			
			System.out.println("ex04.dat 파일 생성");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dos != null) {
					dos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex05() {
		
		// 객체를 그대로 출력하는 ObjectOutPutStream
		// "ex05.dat" 파일 생성
		// Preson List로 만들어주기
		
		File dir = new File("C:" + File.separator + "storage");
		File file = new File(dir, "ex05.dat");
		
		ObjectOutputStream oos = null;
		
		
		try {
			
			oos = new ObjectOutputStream(new FileOutputStream(file));
			
			// 매개변수 있는 생성자 초기화
			List<Person> people = Arrays.asList(
					new Person("에밀리", 30, 180.5, true),
					new Person("제시카", 35, 190.5, true)
					);
			
			// 디폴트 생성자 초기화
			Person person = new Person();
			person.setName("제임스");
			person.setAge(40);
			person.setHeight(170.5);
			person.setAlive(false);
			
			// 객체 그대로 넣어준다
			
			oos.writeObject(person);
			oos.writeObject(people);
			
			System.out.println("ex05.dat 파일 생성 완료");
			
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(oos != null) {
					oos.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		ex05();
	
	
	}

}
