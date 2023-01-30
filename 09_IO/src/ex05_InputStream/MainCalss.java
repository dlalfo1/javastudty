package ex05_InputStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.util.List;

import ex04_OutPutSteram.Person;


public class MainCalss {


	public static void ex01() {
		
		File file = new File("C:" + File.separator + "storage", "ex01.bin");
		
		FileInputStream fis = null;
		
		try {
			
			fis = new FileInputStream(file);
			
			// 입력 단위
			// 1. int    : 1개
			// 2. byte[] : 2개 이상
			
			int c = 0;
			StringBuilder sb = new StringBuilder();
			while((c = fis.read()) != -1) {
				sb.append((char)c);
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
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		FileInputStream fis = null; // try문 밖에서도 fis 변수를 사용해야 하기 때문에 밖에 선언해준다.
		 
		try {
			
			fis = new FileInputStream(file);
			
			// 한번에 4바이트 읽을것이지만  4바이트 미만의 내용이 있다면 그게 몇바이튼지 따로 기록하기.
			
			byte[] b = new byte[4]; // 한 번에 4바이트를 읽어 오시오. -> 이렇게 되면 오류가 난다
									// 한글을 한글자에 3바이튼데 4바이트씩 읽어오라했으니 당연히 글자가 깨질 수 밖에 없다.
									// 배열의 길이를 3으로 줄이면 출력은 제대로 나오겠지만 근복적인 해결책은 아니다.
									// 바이트 스트림과 한글처리의 문제를 확인하는 용도이다.
			
			int readByte = 0; // 실제로 읽은 바이트를 저장해 두시오.
			
			StringBuilder sb = new StringBuilder();
			
			while((readByte = fis.read(b)) != -1 ) {
				sb.append(new String(b, 0, readByte)); // 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
			}										  // // byte타입을 String으로 바꾸는 것 : new String
				
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
	
	public static void ex02_complete() { // ex02 해결방법
		
		// 바이트 입력 스트림을 문자 입력 스트림으로 변환하는 InPutStreamReader
		
		File file = new File("C:" + File.separator + "storage", "ex02.bin");
		
		InputStreamReader isr = null;
		
		try {
			
			isr = new InputStreamReader(new FileInputStream(file)); // 바이트 스트림을 InputStreamReader를 사용해서 read로 읽을 수 있다.
			
			
			char[] cbuf = new char[4]; // 한번에 4글자를 읽어오시오.
			int readCount = 0; // 실제로 읽은 글자수를 저장해 두시오.
			
			StringBuilder sb = new StringBuilder();
			
			while((readCount = isr.read(cbuf)) != -1 ) {
				sb.append(cbuf, 0, readCount); // 배열 cbuf의 인덱스 0부터 readCount개 데이터를 사용한다.
			}										 
				
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(isr != null) {
					isr.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
		
	}	
		
	public static void ex03() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedInputStream bis = null;
		
		try {
			
			bis = new BufferedInputStream(new FileInputStream(file));
			
			byte[]b = new byte[4];
			int readByte = 0;
			
			StringBuilder sb = new StringBuilder();
			
			while((readByte = bis.read()) != -1) {
				sb.append(new String(b, 0, readByte));
				
			}
			
			System.out.println(sb.toString());
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(bis != null) {
					bis.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	public static void ex03_complete() {
		
		File file = new File("C:" + File.separator + "storage", "ex03.bin");
		
		BufferedReader br = null;
		try {
			
			br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			
			// 버퍼기반으로 바이트기반스트림을 읽어들이는 전형적인 문법 
			
			// 바이트기반의 FileInputStream을 InputStreamReader을 사용해서 문자로 바꿔주고 BufferedReader로 속도 향상을 시켜준다.
		
			String line = null; // BufferedReader에만 있는 readLine 메소드 사용함.
			StringBuilder sb = new StringBuilder();
			
			while((line = br.readLine()) != null) { // readLine메소드는 -1과 비교하지 않는다. null값과 비교한다.
				sb.append(line + "\n");
			}
			
			System.out.println(sb.toString());
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
		
	}
	
	public static void ex04() {
		
		// String name, int age, double height, boolean isAlive 순으로 값이 저장된 ex04.dat 파일
		
		File file = new File("C:" + File.separator + "storage", "ex04.dat");
		
		DataInputStream dis = null;
		
		try {
			
			dis = new DataInputStream(new FileInputStream(file));
			
			// 입력(변수 타입에 따라서 메소드가 다름)
			String name = dis.readUTF();          // writeUTF에 대응
			int age = dis.readInt();         // writeInt에 대응
			double height = dis.readDouble();     // writeDouble에 대응
			boolean isAlive = dis.readBoolean();  // writeBoolean에 대응
			
			System.out.println(name);
			System.out.println(age);
			System.out.println(height);
			System.out.println(isAlive);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(dis != null) {
					dis.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

	public static void ex05() {
		
		// Person 객체가 3개 저장되어 있는 (List<Person> 2개, Person 1개) ex05.dat 파일
		
		File file = new File("C:" + File.separator + "storage","ex05.dat");
		
		ObjectInputStream ois = null;
		
		try {
			
			ois = new ObjectInputStream(new FileInputStream(file));
			
			// 입력
			// readObject 메소드는 Object를 반환하므로 적절하게 캐스팅 해야한다.
			
			@SuppressWarnings("unchecked")
			List<Person> people = (List<Person>)ois.readObject();
			Person person = (Person)ois.readObject();
			
			System.out.println(people);
			System.out.println(person);
			
		} catch(Exception e) { // readObject가 던지는 예외가 두개이기 때문에 Exception로 받아준다. 그렇지 않으면 catch문도 두개 써야한다.
			e.printStackTrace();
			
		} finally {
			try {
				if(ois != null) {
					ois.close();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		ex01();
	}   

}
